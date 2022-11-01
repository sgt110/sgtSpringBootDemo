/*
 * Project: sgtSpringBootDemo
 *
 * File Created at 2022-08-08
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
package com.sgt;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;

/**
 * TODO
 *
 * @author sungt
 * @version V1.0
 * @since 2022-08-08 16:53
 */
public class AysncTest {

    private static AtomicInteger num = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 1000000000; i++) {
                num.getAndAdd(1);
            }
            System.out.println(Thread.currentThread().getName() + "执行结束!");
        };

        Thread t1 = new Thread(runnable);
        t1.start();

        Thread.sleep(1000);
        System.out.println("324234234234");
    }
}
