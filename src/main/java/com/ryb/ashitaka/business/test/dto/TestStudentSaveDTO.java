package com.ryb.ashitaka.business.test.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TestStudentSaveDTO {
    @NotBlank
    private String name;
    private Integer age;
}
