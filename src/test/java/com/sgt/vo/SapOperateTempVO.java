package com.sgt.vo;

/**
 * @author �����
 * @description TODO
 * @date 2023/10/12 16:24
 */
public class SapOperateTempVO {
    private static final String _TABLE_NAME = "hi_operate_temp";

    private String pk_sappsndoc_temp;

    private String pk_operate_temp;

    //Ա�������
    private String jobglbdef2;

    //��������
    private String enddate;

    //��������
    private String begindate;

    //��������
    private String operatetype;

    //����ԭ��
    private String operatereason;

    //��Ӷ״̬
    private String state;

    //�����ĵ�����
    private String lastdate;

    //GUID���
    private String sapid;

    public static String getDefaultTableName()
    {
        return _TABLE_NAME;
    }

    public String getJobglbdef2() {
        return jobglbdef2;
    }

    public void setJobglbdef2(String jobglbdef2) {
        this.jobglbdef2 = jobglbdef2;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getBegindate() {
        return begindate;
    }

    public void setBegindate(String begindate) {
        this.begindate = begindate;
    }

    public String getOperatetype() {
        return operatetype;
    }

    public void setOperatetype(String operatetype) {
        this.operatetype = operatetype;
    }

    public String getOperatereason() {
        return operatereason;
    }

    public void setOperatereason(String operatereason) {
        this.operatereason = operatereason;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLastdate() {
        return lastdate;
    }

    public void setLastdate(String lastdate) {
        this.lastdate = lastdate;
    }

    public String getSapid() {
        return sapid;
    }

    public void setSapid(String sapid) {
        this.sapid = sapid;
    }

    public String getPk_sappsndoc_temp() {
        return pk_sappsndoc_temp;
    }

    public void setPk_sappsndoc_temp(String pk_sappsndoc_temp) {
        this.pk_sappsndoc_temp = pk_sappsndoc_temp;
    }

    public String getPk_operate_temp() {
        return pk_operate_temp;
    }

    public void setPk_operate_temp(String pk_operate_temp) {
        this.pk_operate_temp = pk_operate_temp;
    }
}
