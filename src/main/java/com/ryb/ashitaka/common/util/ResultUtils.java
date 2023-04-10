package com.ryb.ashitaka.common.util;

import com.ryb.ashitaka.common.base.Result;
import com.ryb.ashitaka.common.enumeration.ResultCodeEnum;


public final class ResultUtils {

    public static <T> Result<T> success(T data) {
        return new Result<>(ResultCodeEnum.OK,"success",data);
    }

    public static Result<String> error(ResultCodeEnum resultCodeEnum, String message) {
        return new Result<>(resultCodeEnum, message);
    }

    public static Result<String> error(Integer code, String message) {
        return new Result<>(code, message);
    }
}