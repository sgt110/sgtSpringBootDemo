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
package com.sgt.service.junit.impl;

import com.sgt.bo.TestBO;
import com.sgt.bo.TestBO2;
import com.sgt.dal.nhsa.NhsaReportStatisticsMapper;
import com.sgt.dal.nhsa.po.NhsaEnterGroupRecordPO;
import com.sgt.dal.patientsignrecordsnapshot.StatisticPatientSignRecordSnapshotMapper;
import com.sgt.dal.patientsignrecordsnapshot.po.StatisticPatientSignRecordSnapshotPO;
import com.sgt.service.junit.JunitTestService;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author sungt
 * @version V1.0
 * @since 2022-10-08 16:58
 */
@Service
public class JunitTestServiceImpl implements JunitTestService {

    @Resource
    private StatisticPatientSignRecordSnapshotMapper mapper;
    @Resource
    private NhsaReportStatisticsMapper nhsaReportStatisticsMapper;

    @Override
    public TestBO getByBo(TestBO2 testBO2) {
        if (testBO2 != null && testBO2.getA() == 0 && testBO2.getB() == 0){
            List<StatisticPatientSignRecordSnapshotPO> poList = mapper.list();
            return new TestBO(0, poList.size(), testBO2);
        }else if (testBO2 != null && testBO2.getA() == 1 && testBO2.getB() == 0){
            List<NhsaEnterGroupRecordPO> list = nhsaReportStatisticsMapper.list();
            return new TestBO(1, list.size(), testBO2);
        }else {
            return new TestBO(0, 0, testBO2);
        }
    }
}
