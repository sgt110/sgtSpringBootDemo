/*
 * Project: sgtSpringBootDemo
 *
 * File Created at 2022-01-04
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

import lombok.Data;

/**
 * TODO
 *
 * @author WEIYI
 * @version V1.0
 * @since 2022-01-04 13:56
 */
@Data
public class TestBO2 {

    private Integer a;

    private Integer b;

    public TestBO2() {
    }

    public TestBO2(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }
}
