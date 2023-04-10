package com.ryb.ashitaka.common.handler;

//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.ryb.ashitaka.common.base.Result;
//import com.ryb.ashitaka.common.util.ResultUtils;
//import lombok.SneakyThrows;
//import org.springframework.core.MethodParameter;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.server.ServerHttpRequest;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
//
//@RestControllerAdvice(basePackages = {"com.ryb.ashitaka.base.controller"}) // 注意哦，这里要加上需要扫描的包
//public class ResponseResultHandler implements ResponseBodyAdvice<Object> {
//    @Override
//    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> aClass) {
//        // 如果接口返回的类型本身就是ResultVO那就没有必要进行额外的操作，返回false
//        return !returnType.getParameterType().equals(Result.class);
//    }
//
//
//    @SneakyThrows
//    @Override
//    public Object beforeBodyWrite(Object data, MethodParameter returnType, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest request, ServerHttpResponse response) {
//        // String类型不能直接包装，所以要进行些特别的处理
//        if (returnType.getGenericParameterType().equals(String.class)) {
//            ObjectMapper objectMapper = new ObjectMapper();
//            // 将数据包装在ResultVO里后，再转换为json字符串响应给前端
//            return objectMapper.writeValueAsString(ResultUtils.success(data));
//        }
//        // 将原本的数据包装在ResultVO里
//        return ResultUtils.success(data);
//    }
//}