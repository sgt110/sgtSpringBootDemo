package com.sgt.dal.nhsa.po;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * 入组记录,天津医保局入组记录(NhsaEnterGroupRecord)实体类
 *
 * @author zhouym
 * @since 2022-06-21 15:30:07
 */
@Data
public class NhsaEnterGroupRecordPO implements Serializable {
    private static final long serialVersionUID = -34418431914303674L;
    /**
     * 主键ID
     */
    @NotNull
    private Long pkId;
    /**
     * 业务主键
     */
    private String id;
    /**
     * 患者身份证号
     */
    private String cardNo;
    /**
     * 签约记录编码
     */
    private String signRecordCode;
    /**
     * 入组管理顺序号
     */
    private String groupManagementCode;
    /**
     * 状态 0：成功 1：失败 2：进行中，3：接口失败
     */
    private Integer statusCode;
    /**
     * 状态描述
     */
    private String statusDesc;
    /**
     * 入组信息JSON字符串
     */
    private String content;
    /**
     * 创建者
     */
    private String creator;
    /**
     * 操作人
     */
    private String operator;
    /**
     * 外部接口请求记录id
     */
    private String apiRecordId;
    /**
     * 入组信息的id,只有成功才会产生
     */
    private String enterGroupId;
    /**
     * 患者签约快照表ID
     */
    private String signRecordSnapshotId;
    /**
     * 创建时间
     */
    private Date gmtCreated;
    /**
     * 修改时间
     */
    private Date gmtModified;
    /**
     * 删除时间
     */
    private Date gmtDeleted;
    /**
     * 是否删除 0：未删除 1：已删除
     */
    private Integer isDeleted;
}

