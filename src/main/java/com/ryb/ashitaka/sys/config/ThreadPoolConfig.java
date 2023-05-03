package com.ryb.ashitaka.sys.config;

import com.ryb.ashitaka.sys.properties.ThreadPoolProperties;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

//开启异步
@EnableAsync
//配置类
@Configuration
/**
 * https://mp.weixin.qq.com/s?__biz=MzU2NDg0NDY1Ng==&mid=2247484388&idx=1&sn=01f6588f99a608a60b76a7c962b0b7b8&chksm=fc4582fbcb320bed233b9cfe6f80606a3f5aa7f4ade99d04e9adc53b112399e58eac52f10c72&mpshare=1&scene=23&srcid=0410I3C5M48ZXtpnFeYhcfQG&sharer_sharetime=1681128341436&sharer_shareid=99b9052784bbda32d5f662180107996e#rd
 */
public class ThreadPoolConfig implements AsyncConfigurer {
    @Resource
    private ThreadPoolProperties threadPoolProperties;

    //bean名称
    @Bean("taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(threadPoolProperties.getCorePoolSize());
        executor.setMaxPoolSize(threadPoolProperties.getMaxPoolSize());
        executor.setQueueCapacity(threadPoolProperties.getQueueCapacity());
        executor.setKeepAliveSeconds(threadPoolProperties.getKeepAliveSeconds());
        executor.setThreadNamePrefix(threadPoolProperties.getPrefixName());
        //设置线程池关闭的时候 等待所有的任务完成后再继续销毁其他的bean
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }

    @Override
    public Executor getAsyncExecutor() {
        return taskExecutor();
    }
}