package com.ryb.ashitaka.sys.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SysUserRegisterDTO {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
