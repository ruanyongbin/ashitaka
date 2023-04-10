package com.ryb.ashitaka.business.test.service.impl;

import com.ryb.ashitaka.business.test.service.TestAsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestAsyncServiceImpl implements TestAsyncService {
    @Override
    //使用@Async，并将前面的注册的bean，填写到Async的value中
    @Async("taskExecutor")
    public void doAsync() {
        log.info("== async start==");
        log.info("线程{}执行代码逻辑",Thread.currentThread().getName());
        log.info("== async end==");
    }
}
