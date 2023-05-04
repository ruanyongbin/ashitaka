package com.ryb.ashitaka.business.test.controller;

import com.ryb.ashitaka.business.test.dto.TestStudentSaveDTO;
import com.ryb.ashitaka.business.test.entity.TestStudent;
import com.ryb.ashitaka.business.test.service.TestStudentService;
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
@RequestMapping("test/student")
@Api(value = "TestStudentController",tags = "测试学生操作")
public class TestStudentController {
    @Resource
    private TestStudentService testStudentService;

    @PostMapping("save")
    @ApiOperation("新增学生")
    @SysLog(module = "test模块",description = "测试学生新增")
    public Result<Boolean> save(@RequestBody @Valid TestStudentSaveDTO testStudentSaveDTO) {
        TestStudent testStudent = new TestStudent();
        testStudent.setName(testStudentSaveDTO.getName());
        testStudent.setAge(testStudentSaveDTO.getAge());
        return ResultUtils.success(testStudentService.save(testStudent));
    }

}
