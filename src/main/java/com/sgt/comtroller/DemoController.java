/*
 * Project: sgtSpringBootDemo
 *
 * File Created at 2022-07-19
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

import com.sgt.service.testdoubledecimal.TestDoubleDecimalService;
import com.sgt.service.nhsa.StatisticPatientSignRecordService;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author sungt
 * @version V1.0
 * @since 2022-07-19 17:20
 */

@RestController
@RequestMapping("/demo2")
public class DemoController {

    @Resource
    private StatisticPatientSignRecordService statisticPatientSignRecordService;

    @Resource
    private TestDoubleDecimalService testDoubleDecimalService;

    @RequestMapping("/test")
    public void test() throws InterruptedException {
        System.out.println("start");
        Thread.sleep(30000);
        System.out.println("end");
    }

    @GetMapping("/initstatisticpatientsignrecord")
    public void initStatisticPatientSignRecord() {
        statisticPatientSignRecordService.initStatisticPatientSignRecordData();
    }
    @GetMapping("/initnhsaentergrouprecorddata")
    public void initNhsaEnterGroupRecordData() {
        statisticPatientSignRecordService.initNhsaEnterGroupRecordData();
    }


    @GetMapping("/testdoubledecimal")
    public void testDoubleDecimal() {
        testDoubleDecimalService.insert();
        testDoubleDecimalService.list();
    }
}
