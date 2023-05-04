package com.ryb.ashitaka.business.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ryb.ashitaka.business.test.entity.ZeisKnoTriageComplainGist;

import java.util.List;


/**
 * <p>
 * 分诊主诉依据 服务类
 * </p>
 *
 * @author ryb
 * @since 2023-05-04
 */
public interface ZeisKnoTriageComplainGistService extends IService<ZeisKnoTriageComplainGist> {

    List<ZeisKnoTriageComplainGist> listAll();
}
