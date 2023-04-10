package com.ryb.ashitaka.common.exception;


import com.ryb.ashitaka.common.enumeration.ResultCodeEnum;
import lombok.Getter;


@Getter
public class ApiException extends RuntimeException{
    private static final long serialVersionUID = -256479237379515909L;
    private Integer code;

    public ApiException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    public ApiException(ResultCodeEnum resultCodeEnum, String message) {
        super(message);
        this.code = resultCodeEnum.getCode();
    }
}
