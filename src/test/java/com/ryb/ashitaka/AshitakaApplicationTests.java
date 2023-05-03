package com.ryb.ashitaka;

import com.ryb.ashitaka.business.test.service.TestAsyncService;
import com.ryb.ashitaka.business.test.service.TestStudentService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;

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
//        String s = HttpUtils.doGet("http://www.baidu.com");
////        HttpUtils.doPost()
//        System.out.println(s);
    }



    @Test
    void testAsync() {
        for (int i = 0; i < 10; i++) {
            testAsyncService.doAsync();
        }
    }

    @Test
    void testStudent() throws IOException {
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
        //testStudentService.testTrans();




//        OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//        Request request = new Request.Builder()
//                .url("www.baidu.com")
//                .method("GET", null)
//                .addHeader("Cookie", "BAIDUID=8FA8E96A1C13614E1EFD0561B75C72C3:FG=1; BIDUPSID=8FA8E96A1C13614EA6AFA208E7C22DF6; H_PS_PSSID=38515_36545_38529_38470_38468_38375_38486_37929_38519_26350_38542; PSTM=1682671922; BDSVRTM=0; BD_HOME=1")
//                .build();
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                ResponseBody body = response.body();
//
//            }
//        });
//



    }
}
