/*
 * Project: sgtSpringBootDemo
 *
 * File Created at 2022-07-11
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
package com.sgt.service.aysnc.impl;

import com.sgt.service.aysnc.AysncService;
import com.sgt.service.aysnc.thread.AskThread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 *
 * @author sungt
 * @version V1.0
 * @since 2022-07-11 14:11
 */
@Slf4j
@Service
public class AysncServiceImpl implements AysncService {

    @Override
    public void testAysnc() {
        final CompletableFuture<Integer> future = new CompletableFuture<>();
        new Thread(new AskThread(future)).start();
        //模拟长时间的计算过程
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("", e);
        }
        //告知完成结果
        future.complete(60);
    }
    @Override
    public void testAysnc2() {
        final CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> calc(50))
            .thenApply((i) -> Integer.toString(i))
            .thenApply((str) -> "\"" + str + "\"")
            .thenAccept(System.out::println);
        System.out.println("测试");
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            log.error("", e);
        }
    }

    @Override
    public String sayHello() {
        return "hello";
    }

    public static Integer calc(Integer para) {
        try {
            //模拟一个长时间的执行
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return para * para;
    }
}
