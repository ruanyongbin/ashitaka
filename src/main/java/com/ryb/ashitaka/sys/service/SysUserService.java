package com.ryb.ashitaka.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ryb.ashitaka.sys.dto.SysUserLoginDTO;
import com.ryb.ashitaka.sys.dto.SysUserRegisterDTO;
import com.ryb.ashitaka.sys.entity.SysUser;

public interface SysUserService extends IService<SysUser> {
    SysUser getSysUserByUsername(String username);

    String login(SysUserLoginDTO sysUserLoginDTO);

    Boolean register(SysUserRegisterDTO sysUserRegisterDTO);
}
