package com.ryb.ashitaka;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.JWTValidator;
import cn.hutool.jwt.signers.JWTSignerUtil;
import com.baomidou.dynamic.datasource.annotation.DSTransactional;
import com.ryb.ashitaka.business.test.entity.TestStudent;
import com.ryb.ashitaka.business.test.service.TestAsyncService;
import com.ryb.ashitaka.business.test.service.TestStudentService;
import com.ryb.ashitaka.common.util.HttpUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class AshitakaApplicationTests {


    @Resource
    TestAsyncService testAsyncService;

    @Resource
    TestStudentService testStudentService;

    @Test
    void contextLoads() throws Exception {
//        Map<String,Object> map = new HashMap<>();
//        map.put("xx","xx");
//        map.put(JWTPayload.EXPIRES_AT,new Date(System.currentTimeMillis()-7777));
//        String token = JWTUtil.createToken(map, JWTSignerUtil.hs512("haha".getBytes(StandardCharsets.UTF_8)));
//        System.out.println(token);
//        boolean verify = JWTUtil.verify(token, JWTSignerUtil.hs512("haha".getBytes(StandardCharsets.UTF_8)));
//        System.out.println(verify);
//        JWT jwt = JWTUtil.parseToken(token);
//        JWTPayload payload = jwt.getPayload();
//        Object xx = payload.getClaim("xx");
//        System.out.println(xx);
//        JWTValidator.of(token).validateDate();

//        String s = HttpUtils.get("http://localhost:8080/get1");
//        System.out.println(s);
        String s = HttpUtils.doGet("http://www.baidu.com");
//        HttpUtils.doPost()
        System.out.println(s);
    }



    @Test
    void testAsync() {
        for (int i = 0; i < 10; i++) {
            testAsyncService.doAsync();
        }
    }

    @Test
    void testStudent() {
//        TestStudent student = new TestStudent();
//        student.setName("zs");
//        student.setAge(11);
//
//        testStudentService.insertDS1(student);
//
//        student.setName("ls");
//        student.setAge(22);
//
//        testStudentService.insertDS2(student);
//
//        TestStudent student1 = testStudentService.getDS1(1L);
//        TestStudent student2 = testStudentService.getDS2(1L);
//        System.out.println(student1);
//        System.out.println(student2);
        testStudentService.testTrans();
    }
}
