package com.ryb.ashitaka.business.test.controller;


import com.ryb.ashitaka.business.test.dto.TestStudentSaveDTO;
import com.ryb.ashitaka.business.test.entity.TestStudent;
import com.ryb.ashitaka.business.test.entity.ZeisKnoTriageComplainGist;
import com.ryb.ashitaka.business.test.service.ZeisKnoTriageComplainGistService;
import com.ryb.ashitaka.common.base.Result;
import com.ryb.ashitaka.common.util.ResultUtils;
import com.ryb.ashitaka.sys.annotation.SysLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 分诊主诉依据 前端控制器
 * </p>
 *
 * @author ryb
 * @since 2023-05-04
 */
@RestController
@RequestMapping("/ashitaka/zeis-kno-triage-complain-gist")
@Api(value = "ZeisKnoTriageComplainGistController",tags = "主诉依据")
public class ZeisKnoTriageComplainGistController {

    @Resource
    ZeisKnoTriageComplainGistService zeisKnoTriageComplainGistService;

    @GetMapping
    @ApiOperation("查询数据")
    public Result<List<ZeisKnoTriageComplainGist>> list() {
        return ResultUtils.success(zeisKnoTriageComplainGistService.listAll());
    }
}

