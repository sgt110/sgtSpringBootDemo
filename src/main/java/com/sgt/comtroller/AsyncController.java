/*
 * Project: sgtSpringBootDemo
 *
 * File Created at 2022-11-07
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
package com.sgt.comtroller;

import com.sgt.service.aysnc.AsyncService2;

import java.util.concurrent.ExecutionException;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 *
 * @author sungt
 * @version V1.0
 * @since 2022-11-07 17:08
 */
@RestController
@RequestMapping("/async")
@Slf4j
public class AsyncController {

    @Resource
    private AsyncService2 asyncService2;


    @RequestMapping("/test1")
    public void test() {
        try {
            asyncService2.testException();
        } catch (ExecutionException | InterruptedException e) {
            log.error("", e);
        }
    }
    @RequestMapping("/test2")
    public void test2() {
        asyncService2.testException2();
    }

    @RequestMapping("/test3")
    public void test3() throws InterruptedException {
        asyncService2.testException3();
    }
}
