package com.ryb.ashitaka.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ryb.ashitaka.common.base.BaseEntity;
import java.io.Serializable;
import java.time.LocalDateTime;
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
 * @since 2023-04-10
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

    @ApiModelProperty("执行时间（毫秒）")
    @TableField("execution_time")
    private Long executionTime;

    @ApiModelProperty("方法名")
    @TableField("method")
    private String method;

    @ApiModelProperty("请求类型")
    @TableField("request_type")
    private String requestType;

    @ApiModelProperty("入参")
    @TableField("param")
    private String param;

    @ApiModelProperty("返回结果")
    @TableField("result")
    private String result;

    @TableField("ip")
    private String ip;

    @TableField("description")
    private String description;

    @TableField("module")
    private String module;


}
