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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

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

    @Resource
    @Qualifier(value = "taskExecutor")
    private Executor asyncExecutor;

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

    @Override
    public String testAysnc3() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        List<CompletableFuture<Void>> completableFutureList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Integer test2 = i;
            CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
                setHealthIndicator(test2);
            }, asyncExecutor);
            completableFutureList.add(completableFuture);
        }
        setHealthIndicator3();
        CompletableFuture< Void > headerFuture = CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[]{}));
        headerFuture.join();
        stopWatch.stop();
        System.out.println("请求健康档案耗时：" + stopWatch.getTotalTimeSeconds() + "秒！");
        setHealthIndicator2();
        return "";
    }

    @Override
    public String testAysnc4() {
        ExecutorService executorService = new ThreadPoolExecutor(2,3,0,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>(10)){
            @Override
            protected void afterExecute(Runnable r, Throwable t){
                if (t!=null){
                    System.out.println("afterExecute里面获取到execute提交的异常信息，处理异常"+t.getMessage());
                }
                if (r instanceof FutureTask){
                    try {
                        Future<?> future = (Future<?>) r;
                        future.get();
                    }catch (Exception e){
                        System.out.println("afterExecute里面获取到submit提交的异常信息，处理异常"+e);
                    }
                }
            }
        };
        executorService.execute(() -> {
            System.out.println("execute进入了task方法！！！");
            int i = 1 / 0;
        });
        executorService.submit(() -> {
            System.out.println("execute进入了task方法！！！");
            int i = 1 / 0;
        });
        return null;
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

    private void setHealthIndicator(Integer test2){
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){
            log.info("1111");
        }
        System.out.println(test2);
    }
    private void setHealthIndicator2(){
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){
            log.info("1111");
        }
    }
    private void setHealthIndicator3(){
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        }catch (Exception e){
            log.info("1111");
        }
    }
}
