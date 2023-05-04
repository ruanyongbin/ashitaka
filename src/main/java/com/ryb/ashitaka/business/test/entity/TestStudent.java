package com.ryb.ashitaka.business.test.entity;

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
@TableName("test_student")
@ApiModel(value = "TestStudent对象", description = "")
public class TestStudent extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty("年龄")
    @TableField("age")
    private Integer age;


}
