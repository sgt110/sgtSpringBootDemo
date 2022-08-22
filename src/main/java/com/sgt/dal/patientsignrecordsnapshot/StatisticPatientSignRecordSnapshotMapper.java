/*
 * Project: hcare-supervise-local-web
 *
 * File Created at 2022-07-15
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
package com.sgt.dal.patientsignrecordsnapshot;

import com.sgt.dal.patientsignrecordsnapshot.po.StatisticPatientSignRecordSnapshotPO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 患者签约记录表快照表
 *
 * @author sungt
 * @version V1.0
 * @since 2022-07-15 15:43
 */
@Mapper
public interface StatisticPatientSignRecordSnapshotMapper {

    int insert(@Param("po") StatisticPatientSignRecordSnapshotPO po);

    void batchInsert(@Param("poList") List<StatisticPatientSignRecordSnapshotPO> poList);

    List<StatisticPatientSignRecordSnapshotPO> list();
}
