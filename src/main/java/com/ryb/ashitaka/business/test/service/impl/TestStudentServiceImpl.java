package com.ryb.ashitaka.business.test.service.impl;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.annotation.DSTransactional;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ryb.ashitaka.business.test.entity.TestStudent;
import com.ryb.ashitaka.business.test.mapper.TestStudentMapper;
import com.ryb.ashitaka.business.test.service.TestStudentService;
import org.springframework.aop.framework.AopContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ryb
 * @since 2023-04-10
 */
@Service
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class TestStudentServiceImpl extends ServiceImpl<TestStudentMapper, TestStudent> implements TestStudentService {

    @Override
    @DS("ds1")
    public void insertDS1(TestStudent student) {
        save(student);
    }

    @Override
    @DS("ds2")
    public void insertDS2(TestStudent student) {
        save(student);
    }

    @Override
    @DS("ds1")
    public TestStudent getDS1(Long id) {
        return getById(id);
    }

    @Override
    @DS("ds2")
    public TestStudent getDS2(Long id) {
        return getById(id);
    }

    //    手动切换数据源    DynamicDataSourceContextHolder.push("ds2");


    @Override
    @DSTransactional
    public void testTrans() {
        TestStudent student = new TestStudent();
        student.setName("ll");
        student.setAge(66);
        TestStudentService testStudentService = (TestStudentService) AopContext.currentProxy();
        testStudentService.insertDS1(student);
        int i = 1/0;
        testStudentService.insertDS2(student);
    }
}
