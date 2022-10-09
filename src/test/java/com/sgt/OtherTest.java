/*
 * Project: sgtSpringBootDemo
 *
 * File Created at 2022-09-22
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

import org.junit.jupiter.api.Test;

/**
 * TODO
 *
 * @author sungt
 * @version V1.0
 * @since 2022-09-22 14:59
 */
public class OtherTest {

    @Test
    public void test1(){
        int md = 1;
        int count = 0 ;
        for (int i =0 ;i<1000;i++){
            int num = (int)(Math.random()*100+1);
            if (md ==num){
//                System.out.println(i);
                count++;
            }
        }
        System.out.println(count);

    }

}
