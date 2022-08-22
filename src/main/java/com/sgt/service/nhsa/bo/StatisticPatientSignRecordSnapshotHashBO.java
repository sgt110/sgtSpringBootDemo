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
package com.sgt.service.nhsa.bo;

import java.util.Date;

import lombok.Data;

/**
 * 用于生成hash的BO
 *
 * @author sungt
 * @version V1.0
 * @since 2022-07-15 16:21
 */
@Data
public class StatisticPatientSignRecordSnapshotHashBO {

    /**
     * 记录类型 1糖人头签约
     */
    private Integer recordType;
    /**
     * 医院编码
     */
    private String hospitalCode;
    /**
     * 医院编码
     */
    private String hospitalName;
    /**
     * 患者编码
     */
    private String patientCode;
    /**
     * 身份证号码
     */
    private String cardNo;
    /**
     * 姓名
     */
    private String patientName;
    /**
     * 性别
     */
    private Integer patientSex;
    /**
     * 年龄
     */
    private Integer patientAge;
    /**
     * 手机号码
     */
    private String patientPhone;
    /**
     * 险种
     */
    private Integer insuranceType;
    /**
     * 医生名称
     */
    private String doctName;
    /**
     * 健管师名称
     */
    private String hmdName;
    /**
     * 门特病种
     */
    private String diseaseName;
    /**
     * 登记开始日期
     */
    private Date startDate;
    /**
     * 登记结束日期
     */
    private Date endDate;
    /**
     * 签约日期
     */
    private Date signDate;
    /**
     * 签约状态（sys_dict表，type=sign_state）
     */
    private Integer signState;

    /**
     * 签约来源（sys_dict表，type=sign_source）
     */
    private Integer signSource;

    /**
     * 签约操作人
     */
    private String signOperator;

    /**
     * 院内慢病服务（sys_dict表，type=disease_service）
     */
    private Integer diseaseService;

    /**
     * 签约修改时间
     */
    private Date signModifiedTime;
    /**
     * 终止时间
     */
    private Date stopTime;
    /**
     * 终止原因 1调离、2死亡、3其他
     */
    private Integer stopReason;
}
