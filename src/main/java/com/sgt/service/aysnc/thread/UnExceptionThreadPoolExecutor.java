/*
 * Project: sgtSpringBootDemo
 *
 * File Created at 2022-07-19
 *
 * Copyright 2012-2015 Greenline.com Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Greenline Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Greenline.com.
 */
package com.sgt.service.aysnc.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * TODO
 *
 * @author sungt
 * @version V1.0
 * @since 2022-07-19 14:34
 */
@EnableAsync
@ConditionalOnClass(ThreadPoolTaskExecutor.class)
@Configuration
public class UnExceptionThreadPoolExecutor {

    @Bean("taskExecutor2")
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadFactory factory = (Runnable r) -> {
            //创建一个线程
            Thread t = new Thread(r);
            //给创建的线程设置UncaughtExceptionHandler对象 里面实现异常的默认逻辑
            Thread.setDefaultUncaughtExceptionHandler((Thread thread1, Throwable e) -> {
                System.out.println("线程工厂设置的exceptionHandler" + e.getMessage());
            });
            return t;
        };

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(8);
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(1000);
        executor.setKeepAliveSeconds(60);
        executor.setThreadFactory(factory);
        executor.setThreadNamePrefix("taskExecutor2--");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }
}
