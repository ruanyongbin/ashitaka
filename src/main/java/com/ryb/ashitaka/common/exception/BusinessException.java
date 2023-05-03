package com.ryb.ashitaka.common.exception;


import com.ryb.ashitaka.common.enumeration.ResultCodeEnum;
import lombok.Getter;


@Getter
public class BusinessException extends RuntimeException{

    private static final long serialVersionUID = -5144654109852083553L;
    private final Integer code;

    public BusinessException(String message) {
        super(message);
        this.code = ResultCodeEnum.BUSINESS_ERROR.getCode();
    }

}
