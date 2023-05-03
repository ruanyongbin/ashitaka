package com.ryb.ashitaka.sys.controller;

import com.ryb.ashitaka.common.base.Result;
import com.ryb.ashitaka.common.util.ResultUtils;
import com.ryb.ashitaka.sys.annotation.SysLog;
import com.ryb.ashitaka.sys.dto.SysUserLoginDTO;
import com.ryb.ashitaka.sys.dto.SysUserRegisterDTO;
import com.ryb.ashitaka.sys.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("sys/user")
@Api(value = "SysUserController",tags = "用户操作")
public class SysUserController {
    @Resource
    private SysUserService userService;

    @PostMapping("register")
    @ApiOperation("用户注册")
    @SysLog(module = "sys模块",description = "用户注册")
    public Result<Boolean> register(@RequestBody @Valid SysUserRegisterDTO sysUserRegisterDTO) {
        return ResultUtils.success(userService.register(sysUserRegisterDTO));
    }

    @PostMapping("login")
    @ApiOperation("用户登录")
    @SysLog(module = "sys模块",description = "用户登录")
    public Result<String> login(@RequestBody @Valid SysUserLoginDTO userLoginDTO) {
        return  ResultUtils.success(userService.login(userLoginDTO));
    }

}
