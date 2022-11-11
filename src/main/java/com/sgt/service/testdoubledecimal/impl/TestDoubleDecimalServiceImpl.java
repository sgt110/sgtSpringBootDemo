/*
 * Project: sgtSpringBootDemo
 *
 * File Created at 2022-11-11
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
package com.sgt.service.testdoubledecimal.impl;

import com.sgt.dal.testdoubledecimal.TestDoubleDecimalMapper;
import com.sgt.dal.testdoubledecimal.po.TestDoubleDecimalPO;
import com.sgt.service.testdoubledecimal.TestDoubleDecimalService;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author sungt
 * @version V1.0
 * @since 2022-11-11 15:03
 */
@Service
public class TestDoubleDecimalServiceImpl implements TestDoubleDecimalService {

    @Resource
    private TestDoubleDecimalMapper testDoubleDecimalMapper;

    @Override
    public void insert() {
        List<TestDoubleDecimalPO> list = new ArrayList<>();
        TestDoubleDecimalPO po = new TestDoubleDecimalPO();
        po.setTest1(1);
        po.setTest2(2);
        list.add(po);
        testDoubleDecimalMapper.insert(list);
    }

    @Override
    public void list() {
        List<TestDoubleDecimalPO> poList = testDoubleDecimalMapper.list();
        System.out.println(poList);
    }
}
