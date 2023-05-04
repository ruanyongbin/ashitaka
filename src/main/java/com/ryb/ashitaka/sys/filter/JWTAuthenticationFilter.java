package com.ryb.ashitaka.sys.filter;

import cn.hutool.core.util.StrUtil;
import cn.hutool.jwt.JWTPayload;
import com.ryb.ashitaka.common.util.JWTUtils;
import com.ryb.ashitaka.sys.service.impl.SysUserServiceImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {



    public static final String HEADER_NAME = "Authorization";

    @Resource
    private SysUserServiceImpl userServiceImpl;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        // 从请求头中获取token字符串并解析（JwtManager之前文章有详解，这里不多说了）
        String tokenWithPrefix = request.getHeader(HEADER_NAME);
        if(StrUtil.isNotBlank(tokenWithPrefix)) {
            // 从`JWT`中提取出之前存储好的用户名
//            String token = StrUtil.removePrefix(tokenWithPrefix, JWTUtils.TOKEN_PREFIX);
            String username = JWTUtils.getUsername(tokenWithPrefix);
            // 查询出用户对象
            UserDetails user = userServiceImpl.loadUserByUsername(username);
            // 手动组装一个认证对象
            Authentication authentication = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
            // 将认证对象放到上下文中
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        chain.doFilter(request, response);
    }

}