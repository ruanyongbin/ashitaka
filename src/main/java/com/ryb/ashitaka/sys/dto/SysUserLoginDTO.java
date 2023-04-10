package com.ryb.ashitaka.sys.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SysUserLoginDTO {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
