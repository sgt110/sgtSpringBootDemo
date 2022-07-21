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
package com.sgt.service.aysnc.thread;

import java.util.concurrent.CompletableFuture;

import lombok.AllArgsConstructor;

/**
 * TODO
 *
 * @author sungt
 * @version V1.0
 * @since 2022-07-11 14:13
 */
@AllArgsConstructor
public class AskThread implements Runnable{
    private CompletableFuture<Integer> re = null;

    @Override
    public void run() {
        int myRe = 0;
        System.out.println(System.currentTimeMillis());
        try {
            myRe = re.get() * re.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(myRe);
        System.out.println(System.currentTimeMillis());
    }

    public static void main(String[] args) throws InterruptedException {
        final CompletableFuture<Integer> future = new CompletableFuture<>();
        new Thread(new AskThread(future)).start();
        //模拟长时间的计算过程
        Thread.sleep(1000);
        //告知完成结果
        future.complete(60);
    }
}
