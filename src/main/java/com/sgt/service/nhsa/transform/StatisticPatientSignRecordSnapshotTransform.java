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
package com.sgt.service.nhsa.transform;

import com.sgt.dal.patientsignrecordsnapshot.po.StatisticPatientSignRecordSnapshotPO;
import com.sgt.service.nhsa.bo.StatisticPatientSignRecordSnapshotHashBO;

/**
 * 转化类
 *
 * @author sungt
 * @version V1.0
 * @since 2022-07-15 16:25
 */
public class StatisticPatientSignRecordSnapshotTransform {

    public static StatisticPatientSignRecordSnapshotHashBO transPo2HashBo(StatisticPatientSignRecordSnapshotPO from) {
        if (from == null){
            return null;
        }
        StatisticPatientSignRecordSnapshotHashBO to = new StatisticPatientSignRecordSnapshotHashBO();
        to.setHospitalName(from.getHospitalName());
        to.setRecordType(from.getRecordType());
        to.setHospitalCode(from.getHospitalCode());
        to.setEndDate(from.getEndDate());
        to.setPatientCode(from.getPatientCode());
        to.setSignOperator(from.getSignOperator());
        to.setCardNo(from.getCardNo());
        to.setStartDate(from.getStartDate());
        to.setPatientName(from.getPatientName());
        to.setPatientSex(from.getPatientSex());
        to.setDiseaseService(from.getDiseaseService());
        to.setStopReason(from.getStopReason());
        to.setPatientAge(from.getPatientAge());
        to.setSignSource(from.getSignSource());
        to.setPatientPhone(from.getPatientPhone());
        to.setInsuranceType(from.getInsuranceType());
        to.setSignModifiedTime(from.getSignModifiedTime());
        to.setDiseaseName(from.getDiseaseName());
        to.setSignState(from.getSignState());
        to.setSignDate(from.getSignDate());
        to.setDoctName(from.getDoctName());
        to.setStopTime(from.getStopTime());
        to.setHmdName(from.getHmdName());
        return to;
    }
}
