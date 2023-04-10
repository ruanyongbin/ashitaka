package com.ryb.ashitaka.sys.handler;


import cn.hutool.json.JSONUtil;
import com.ryb.ashitaka.common.enumeration.ResultCodeEnum;
import com.ryb.ashitaka.common.util.ResultUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AuthenticationExceptionHandler implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        // 直接提示前端认证错误
        out.write(JSONUtil.toJsonStr(ResultUtils.error(ResultCodeEnum.UNAUTHORIZED,"请重新登录")));
        out.flush();
        out.close();
    }
}