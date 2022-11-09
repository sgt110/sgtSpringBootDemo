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
package com.sgt.service.aysnc;

import java.util.concurrent.ExecutionException;

/**
 * TODO
 *
 * @author sungt
 * @version V1.0
 * @since 2022-11-07 17:03
 */
public interface AsyncService2 {

    void testException() throws ExecutionException, InterruptedException;

    void testException2();

    void testException3() throws InterruptedException;
}
