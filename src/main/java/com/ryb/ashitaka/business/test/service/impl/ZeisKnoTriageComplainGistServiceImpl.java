package com.ryb.ashitaka.business.test.service.impl;


import cn.hutool.system.UserInfo;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ryb.ashitaka.business.test.entity.ZeisKnoTriageComplainGist;
import com.ryb.ashitaka.business.test.mapper.ZeisKnoTriageComplainGistMapper;
import com.ryb.ashitaka.business.test.service.ZeisKnoTriageComplainGistService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 分诊主诉依据 服务实现类
 * </p>
 *
 * @author ryb
 * @since 2023-05-04
 */
@Service
public class ZeisKnoTriageComplainGistServiceImpl extends ServiceImpl<ZeisKnoTriageComplainGistMapper, ZeisKnoTriageComplainGist> implements ZeisKnoTriageComplainGistService {


    @Override
    @DS("ds2")
    public List<ZeisKnoTriageComplainGist> listAll() {
        PageHelper.startPage(1,10);
        return list();
    }
}
