package com.ryb.ashitaka.sys.handler;


import com.ryb.ashitaka.common.exception.ApiException;
import com.ryb.ashitaka.common.base.Result;
import com.ryb.ashitaka.common.enumeration.ResultCodeEnum;
import com.ryb.ashitaka.common.exception.BusinessException;
import com.ryb.ashitaka.common.util.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @author RuanYongBin
 * @since 2023/1/30 22:58
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public Result<String> apiExceptionHandler(BusinessException e) {
        log.error(e.getMessage(),e);
        return ResultUtils.error(ResultCodeEnum.BUSINESS_ERROR, e.getMessage());
    }

    @ExceptionHandler(ApiException.class)
    public Result<String> apiExceptionHandler(ApiException e) {
        log.error(e.getMessage(),e);
        return ResultUtils.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result<String> exceptionHandler(Exception e) {
        log.error(e.getMessage(),e);
        return ResultUtils.error(ResultCodeEnum.INTERNAL_SERVER_ERROR, e.getMessage());
    }
}
