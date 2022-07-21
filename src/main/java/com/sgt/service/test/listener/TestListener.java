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
package com.sgt.service.test.listener;

import com.sgt.bo.TestEvent;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author WEIYI
 * @version V1.0
 * @since 2022-01-12 15:24
 */
@Component
public class TestListener {

    @EventListener(classes = TestEvent.class)
    @Order(1)
    public void testEvent2() {
        System.out.println("2222222");
    }
}
