package com.ryb.ashitaka.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ryb.ashitaka.common.base.BaseEntity;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author ryb
 * @since 2023-05-04
 */
@Getter
@Setter
@TableName("sys_log")
@ApiModel(value = "SysLog对象", description = "")
public class SysLog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("操作人")
    @TableField("operator")
    private String operator;

    @ApiModelProperty("执行所用时间（毫秒）")
    @TableField("execution_time")
    private Long executionTime;

    @ApiModelProperty("请求方法")
    @TableField("request_method")
    private String requestMethod;

    @ApiModelProperty("入参")
    @TableField("param")
    private String param;

    @ApiModelProperty("返回结果")
    @TableField("result")
    private String result;

    @ApiModelProperty("ip")
    @TableField("ip")
    private String ip;

    @ApiModelProperty("描述")
    @TableField("description")
    private String description;

    @ApiModelProperty("模块")
    @TableField("module")
    private String module;

    @ApiModelProperty("uri")
    @TableField("request_uri")
    private String requestUri;


}
