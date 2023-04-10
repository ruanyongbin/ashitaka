package com.ryb.ashitaka.common.base;

import com.ryb.ashitaka.common.enumeration.ResultCodeEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -834651179088381881L;
    private Integer code;
    private String message;
    private T data;

    public Result(ResultCodeEnum resultCodeEnum,String message, T data) {
        this.code = resultCodeEnum.getCode();
        this.message = message;
        this.data = data;
    }

    public Result(ResultCodeEnum resultCodeEnum,String message) {
        this.code = resultCodeEnum.getCode();
        this.message = message;
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
