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

    @Test
    public void test2(){
        try {
            testThrow();
        }finally {
            System.out.println("11111");
        }
        System.out.println("22222");
    }

    @Test
    public void test3(){
        final int COUNT_BITS = Integer.SIZE - 3;
        final int CAPACITY   = (1 << COUNT_BITS) - 1;

        // runState is stored in the high-order bits
         final int RUNNING    = -1 << COUNT_BITS;
        final int SHUTDOWN   =  0 << COUNT_BITS;
        final int STOP       =  1 << COUNT_BITS;
        final int TIDYING    =  2 << COUNT_BITS;
        final int TERMINATED =  3 << COUNT_BITS;

        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(RUNNING));
        System.out.println(Integer.toBinaryString(STOP));
        System.out.println(Integer.toBinaryString(TIDYING));
        System.out.println(Integer.toBinaryString(TERMINATED));
    }

    private void testThrow(){
        throw new RuntimeException("cscs");
    }

}
