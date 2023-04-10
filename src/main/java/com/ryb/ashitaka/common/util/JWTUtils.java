package com.ryb.ashitaka.common.util;

import cn.hutool.core.util.StrUtil;
import cn.hutool.jwt.*;
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
    private final static String SECRET_KEY = "ashitaka";
    /**
     * 签发者
     */
    private final static String ISSUER = "ashitaka";
    /**
     * 过期时间目前设置成2天，这个配置随业务需求而定
    */
    private final static Duration expiration = Duration.ofDays(2);

    /**
     * 生成JWT
     *
     * @param userName 用户名
     * @return JWT
     */
    public static String generate(String userName) {
        Date issuedDate = new Date();
        Date expiryDate = new Date(System.currentTimeMillis() + expiration.toMillis());
        Map<String,Object> payload = new HashMap<>();
        payload.put("username",userName);
        payload.put(JWTPayload.NOT_BEFORE, issuedDate);
        payload.put(JWTPayload.ISSUED_AT, issuedDate);
        payload.put(JWTPayload.EXPIRES_AT, expiryDate);
        payload.put(JWTPayload.ISSUER, ISSUER);
        return JWTUtil.createToken(payload, JWTSignerUtil.hs512(SECRET_KEY.getBytes()));
    }



    public static Boolean verify(String token) {
        try {
            JWTValidator.of(token).validateDate();
            return JWTUtil.verify(token, JWTSignerUtil.hs512(SECRET_KEY.getBytes()));
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
}