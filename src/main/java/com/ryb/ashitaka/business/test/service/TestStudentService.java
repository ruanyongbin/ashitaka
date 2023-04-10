package com.ryb.ashitaka.business.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ryb.ashitaka.business.test.entity.TestStudent;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ryb
 * @since 2023-04-10
 */
public interface TestStudentService extends IService<TestStudent> {

    void insertDS1(TestStudent student);

    void insertDS2(TestStudent student);

    TestStudent getDS1(Long id);

    TestStudent getDS2(Long id);

    void testTrans();
}
