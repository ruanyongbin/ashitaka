package com.ryb.ashitaka.common.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * https://blog.csdn.net/baidu_24545901/article/details/78869089
 */
@AllArgsConstructor
@Getter
public enum ResultCodeEnum {
    /**
     * 请求成功
     */
    OK(2000),

    /**
     * 4开头代表前端错误
     */
    BAD_REQUEST(4000),
    UNAUTHORIZED(4001),
    FORBIDDEN(4003),
    NOT_FOUND(4004),

    /**
     * 5开头代表后端错误
     */
    INTERNAL_SERVER_ERROR(5000),

    /**
     * 6开头代表业务错误
     */
    BUSINESS_ERROR(6000),


    ;

    private Integer code;

}