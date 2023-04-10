package com.ryb.ashitaka.business.test.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ryb.ashitaka.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
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
@TableName("test_student")
@ApiModel(value = "TestStudent对象", description = "")
public class TestStudent extends BaseEntity {


    private static final long serialVersionUID = 1267221512305155011L;
    @TableField("name")
    private String name;

    @TableField("age")
    private Integer age;


}
