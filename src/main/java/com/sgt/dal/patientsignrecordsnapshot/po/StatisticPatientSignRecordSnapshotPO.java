package com.sgt.dal.patientsignrecordsnapshot.po;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * <p>
 * 患者签约记录表
 * </p>
 *
 * @author zhangjl
 * @since 2022-05-21
 */
@Data
public class StatisticPatientSignRecordSnapshotPO {

    public StatisticPatientSignRecordSnapshotPO() {
    }

    public StatisticPatientSignRecordSnapshotPO(String cardNo) {
        this.cardNo = cardNo;
    }

    /**
     * 主键ID
     */
    @NotNull
    private Long pkId;
    /**
     * id
     */
    private String id;
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
    /**
     * 哈希值（业务字段除id外的json的摘要）
     */
    private String hash;
    /**
     * 创建时间
     */
    private Date gmtCreated;
    /**
     * 修改时间
     */
    private Date gmtModified;
}
