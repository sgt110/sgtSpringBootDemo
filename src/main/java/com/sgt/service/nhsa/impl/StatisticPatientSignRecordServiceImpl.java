/*
 * Project: sgtSpringBootDemo
 *
 * File Created at 2022-08-19
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
package com.sgt.service.nhsa.impl;

import com.alibaba.fastjson.JSON;
import com.sgt.dal.nhsa.NhsaReportStatisticsMapper;
import com.sgt.dal.nhsa.po.NhsaEnterGroupRecordPO;
import com.sgt.dal.patientsignrecordsnapshot.StatisticPatientSignRecordSnapshotMapper;
import com.sgt.dal.patientsignrecordsnapshot.po.StatisticPatientSignRecordSnapshotPO;
import com.sgt.service.nhsa.StatisticPatientSignRecordService;
import com.sgt.service.nhsa.bo.StatisticPatientSignRecordSnapshotHashBO;
import com.sgt.service.nhsa.transform.StatisticPatientSignRecordSnapshotTransform;
import com.sgt.util.DigestUtil;
import com.sgt.util.IdGeneratorUtil;
import com.sgt.util.MyDateUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 *
 * @author sungt
 * @version V1.0
 * @since 2022-08-19 15:06
 */
@Service
@Slf4j
public class StatisticPatientSignRecordServiceImpl implements StatisticPatientSignRecordService {

    @Resource
    private StatisticPatientSignRecordSnapshotMapper mapper;
    @Resource
    private NhsaReportStatisticsMapper nhsaReportStatisticsMapper;

    @Override
    public void initStatisticPatientSignRecordData() {
        List<StatisticPatientSignRecordSnapshotPO> poList = mapper.list();
        for (StatisticPatientSignRecordSnapshotPO list : poList) {
            List<StatisticPatientSignRecordSnapshotPO> initDataList = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                StatisticPatientSignRecordSnapshotPO initData = new StatisticPatientSignRecordSnapshotPO();
                BeanUtils.copyProperties(list, initData);
                initData.setId(IdGeneratorUtil.getUuid());
                initData.setPatientName(initData.getPatientName() + i);

                StatisticPatientSignRecordSnapshotHashBO hashBO = StatisticPatientSignRecordSnapshotTransform
                    .transPo2HashBo(initData);
                String jsonStr = JSON.toJSONString(hashBO);
                String hash = DigestUtil.encryptDigest(jsonStr, DigestUtil.SHA256);
                initData.setHash(hash);
                initDataList.add(initData);
            }
            mapper.batchInsert(initDataList);
        }
    }

    @Override
    public void initNhsaEnterGroupRecordData() {
        Random random = new Random();
        List<StatisticPatientSignRecordSnapshotPO> poList = mapper.list();
        List<NhsaEnterGroupRecordPO> list = nhsaReportStatisticsMapper.list();
        for (NhsaEnterGroupRecordPO po : list){
            List<NhsaEnterGroupRecordPO> initDataList = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                NhsaEnterGroupRecordPO initData = new NhsaEnterGroupRecordPO();
                StatisticPatientSignRecordSnapshotPO snapshotPO = poList.get(random.nextInt(10102));
                BeanUtils.copyProperties(po, initData);
                initData.setId(IdGeneratorUtil.getUuid());
                initData.setCardNo(snapshotPO.getCardNo());
                initData.setSignRecordSnapshotId(snapshotPO.getId());
                initData.setGmtModified(
                    MyDateUtils.parse("2022-07-" + random.nextInt(31) + " 00:00:00", MyDateUtils.FORMAT_YMDHMS_SHORT));
                initDataList.add(initData);
            }
            System.out.println(initDataList.size());
            nhsaReportStatisticsMapper.insert(initDataList);
        }
    }
}
