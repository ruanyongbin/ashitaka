package com.ryb.ashitaka.sys.service.impl;

import cn.hutool.core.util.ObjUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ryb.ashitaka.common.exception.ApiException;
import com.ryb.ashitaka.common.enumeration.ResultCodeEnum;
import com.ryb.ashitaka.common.util.JWTUtils;
import com.ryb.ashitaka.sys.dto.SysUserLoginDTO;
import com.ryb.ashitaka.sys.dto.SysUserRegisterDTO;
import com.ryb.ashitaka.sys.entity.SysUser;
import com.ryb.ashitaka.sys.mapper.SysUserMapper;
import com.ryb.ashitaka.sys.service.SysUserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService, UserDetailsService {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = getSysUserByUsername(username);
        if(ObjUtil.isNull(sysUser)) {
            throw new ApiException(ResultCodeEnum.UNAUTHORIZED,"用户不存在");
        }
        return new User(sysUser.getUsername(), sysUser.getPassword(), Collections.emptyList());
    }

    @Override
    public SysUser getSysUserByUsername(String username) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getUsername,username);
        return getOne(queryWrapper);
    }

    @Override
    public String login(SysUserLoginDTO sysUserLoginDTO) {
        String username = sysUserLoginDTO.getUsername();
        SysUser sysUser = getSysUserByUsername(username);
        if(ObjUtil.isNull(sysUser)) {
            throw new ApiException(ResultCodeEnum.UNAUTHORIZED,"用户不存在");
        }
        if(!passwordEncoder.matches(sysUserLoginDTO.getPassword(), sysUser.getPassword())){
            throw new ApiException(ResultCodeEnum.UNAUTHORIZED,"密码错误");
        }
        return JWTUtils.generate(sysUser.getUsername());
    }

    @Override
    public Boolean register(SysUserRegisterDTO sysUserRegisterDTO) {
        SysUser sysUser = new SysUser();
        sysUser.setUsername(sysUserRegisterDTO.getUsername());
        sysUser.setPassword(passwordEncoder.encode(sysUserRegisterDTO.getPassword()));
        return save(sysUser);
    }
}
