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
package com.sgt.bo;

import org.springframework.context.ApplicationEvent;

import lombok.Data;

/**
 * TODO
 *
 * @author WEIYI
 * @version V1.0
 * @since 2022-01-12 14:53
 */
@Data
public class TestEvent {
    /**
     * 本次请求事件id(广播前产生)
     */
    private String eventId;

    private TestBO testBO;

}
