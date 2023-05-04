package com.ryb.ashitaka.common.util;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.jwt.*;
import cn.hutool.jwt.signers.JWTSigner;
import cn.hutool.jwt.signers.JWTSignerUtil;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public final class JWTUtils {
    /**
     * 这个秘钥是防止JWT被篡改的关键，随便写什么都好，但决不能泄露
     */
    public static final String  SECRET_KEY = "ashitaka";
    /**
     * 签发者
     */
    public static final String  ISSUER = "ashitaka";
    /**
     * 过期时间目前设置成2天，这个配置随业务需求而定
    */
    public static final Duration EXPIRATION = Duration.ofDays(2);


    public static final String  PAYLOAD = "username";


    public static final JWTSigner JWT_SIGNER = JWTSignerUtil.hs256(SECRET_KEY.getBytes());

    public static final String TOKEN_PREFIX = "Bearer ";

    /**
     * 生成JWT
     *
     * @param username 用户名
     * @return JWT
     */
    public static String generate(String username) {
        Date issuedDate = new Date();
        Date expiryDate = new Date(System.currentTimeMillis() + EXPIRATION.toMillis());
        Map<String,Object> payload = new HashMap<>();
        payload.put(PAYLOAD,username);
        payload.put(JWTPayload.NOT_BEFORE, issuedDate);
        payload.put(JWTPayload.ISSUED_AT, issuedDate);
        payload.put(JWTPayload.EXPIRES_AT, expiryDate);
        payload.put(JWTPayload.ISSUER, ISSUER);
        return StrUtil.addPrefixIfNot(JWTUtil.createToken(payload, JWT_SIGNER),TOKEN_PREFIX);
    }



    public static Boolean verify(String token) {
        try {
            JWTValidator.of(token).validateDate();
            return JWTUtil.verify(token, JWT_SIGNER);
        }catch (Exception e) {
            log.error(e.getMessage(),e);
        }
        return false;
    }

    /**
     * 解析JWT
     *
     */
    public static JWTPayload parse(String token) {
        // 如果是空字符串直接返回null
        if (StrUtil.isBlank(token)) {
            return null;
        }
        JWTPayload payload = null;
        // 解析失败了会抛出异常，所以我们要捕捉一下。token过期、token非法都会导致解析失败
        try {
            if(verify(token)) {
                payload = JWTUtil.parseToken(token).getPayload();
            }
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
        return payload;
    }

    public static String getUsername(String tokenWithPrefix) {
        String token = StrUtil.removePrefix(tokenWithPrefix, TOKEN_PREFIX);
        JWTPayload payload = parse(token);
        if(ObjUtil.isNull(payload)) {
            return null;
        }
        return  payload.getClaim(PAYLOAD).toString();
    }
}