package com.ryb.ashitaka.sys.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.ryb.ashitaka.common.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@TableName("sys_user")
public class SysUser extends BaseEntity {
    private static final long serialVersionUID = -1218804238936106184L;
    private String username;
    private String password;

}
