/*
 * Project: sgtSpringBootDemo
 *
 * File Created at 2022-10-08
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
package com.sgt.service.junit;

import com.sgt.bo.TestBO;
import com.sgt.bo.TestBO2;

/**
 * TODO
 *
 * @author sungt
 * @version V1.0
 * @since 2022-10-08 16:56
 */
public interface JunitTestService {

    TestBO getByBo(TestBO2 testBO2);
}
