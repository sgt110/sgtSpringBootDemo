/*
 * Project: sgtSpringBootDemo
 *
 * File Created at 2022-01-12
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
package com.sgt.service.test.impl;

import com.alibaba.fastjson.JSON;
import com.sgt.bo.TestEvent;
import com.sgt.service.test.TestService;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author WEIYI
 * @version V1.0
 * @since 2022-01-12 15:23
 */
@Service
public class TestServiceImpl implements TestService {

    @Override
    @EventListener(classes = TestEvent.class)
    @Order(0)
    public void testEvent(TestEvent event) {
        System.out.println(JSON.toJSONString(event));
//        if (event.getTestBO().getA().equals(1)){
//            throw new RuntimeException("1111111");
//
//        }
        System.out.println("111111");
    }
}
