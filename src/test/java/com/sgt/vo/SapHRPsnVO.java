package com.sgt.vo;

import com.google.gson.annotations.SerializedName;
/** ***************************************
 * 		                                  *
 *  @Description: TODO[class] sap ��Աvo
 * 								          							
 *  @Create Wanghz at 2020��11��7��
 * 								         
 *  @modify [*** v999]							  	  		
 *										  *		
 ** ***************************************/
public class SapHRPsnVO {
	
	public static String TAB = "ET_TAB";
	/**   
	 * @Fields serialVersionUID : 
	 */ 
	private static final long serialVersionUID = 1L;
	
	//Ա�������
	@SerializedName("PERNR")
	private String jobglbdef2;
	//��ͥ��ַ
	@SerializedName("LOCAT")
	private String addr;
	//��������
	@SerializedName("GBDAT")
	private String birthdate;
	//����
	@SerializedName("ZEMAIL")
	private String email;
	//��ͥ�绰
	@SerializedName("ZHOMETEL")
	private String homephone;
	
	@SerializedName("ICNUM")
	private String id;
	
	@SerializedName("ICTYP")
	private String idtype;
	
	@SerializedName("ZSJH")
	private String mobile;
	
	@SerializedName("ENAME")
	private String name;
	
	@SerializedName("BUKRS") 
	private String pk_org;
	
	@SerializedName("GESCH")
	private String sex;
	//������
	@SerializedName("INITS")
	private String usedname;

	private String def1;
	
	//������ò
	@SerializedName("ZPCODE")
	private String def2;
	
	//�μӹ�������
	@SerializedName("ZCJGZSJ")
	private String joinworkdate;
	//�����������
	@SerializedName("ZJRWCSJ")
	private String glbdef2;
	//���빫˾����
	@SerializedName("ZJRGSSJ")
	private String glbdef3;

	private String def6;
	private String def7;
	
	//������
	@SerializedName("ZHKSZD")
	private String censusaddr;
	
	//����״��
	@SerializedName("ZJKZK")
	private String glbdef7;
	
	//����ʡ��
	@SerializedName("ZZGSF")
	private String glbdef8;
	
	//�����
	@SerializedName("ZJGD")
	private String glbdef9;
	
	//����״��
	@SerializedName("ZFAMS")
	private String glbdef10;

	private String def13;
	private String def14;
	
	private String def21;
	
	//Ա����ʶ��
	@SerializedName("PERSONID_EXT")
	private String code;
	
	//Ա��״̬
	@SerializedName("ZZZX")
	private String def23;
	
	//ְ�����
	@SerializedName("ZZHIWWU")
	private String jobglbdef7;
	
	//ְ��
	@SerializedName("ZZZMC")
	private String jobglbdef9;
	
	//��λ����
	@SerializedName("ZXULIE")
	private String jobglbdef6;
	 
	//��λ(ְλȫ��)
	@SerializedName("ZPLANS")
	private String jobglbdef4;
	
	@SerializedName("ORGEH")
	private String pk_dept;

	//��н����
	@SerializedName("ZQXRQ")
	private String jobglbdef5;
	
	//ͣн����
	@SerializedName("ZTXRQ")
	private String jobglbdef8;
	
	//ְλ
	@SerializedName("PLANS")
	private String jobglbdef3;
	
	//��ְ��ʼ����
	@SerializedName("ZRZKS")
	private String begindate;
	
	//��ְ��������
	@SerializedName("ZRZJS")
	private String enddate;

	//�����Ǳ�������ģ�������Ļ�����Ϣ
	//�˲�֤����
	@SerializedName("DISID")
	private String glbdef23;

	//רҵר��
	@SerializedName("ZGRTC")
	private String glbdef24;

	//����
	@SerializedName("RACKY")
	private String nationality;

	//�˲з���
	@SerializedName("DISCL")
	private String glbdef26;

	//�˲еȼ�
	@SerializedName("DISGR")
	private String glbdef27;

	//�������
	@SerializedName("ZHKLB")
	private String characterrpr;

	//��������
	@SerializedName("ZJZLX")
	private String glbdef28;

	//��������
	@SerializedName("ZXUEXING")
	private String bloodtype;

	//�ؿ���
	@SerializedName("WAUSW")
	private String glbdef25;

	//�����ж�����
	@SerializedName("ZGLZDNS")
	private String glbdef29;

	//�����ж�����
	@SerializedName("ZGLZDYS")
	private String glbdef30;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setAddr(String newAddr) {
		this.addr = newAddr;
	}

	public void setBirthdate(String newBirthdate) {
		this.birthdate = newBirthdate;
	}

	public void setDef2(String newDef2) {
		this.def2 = newDef2;
	}

	public void setEmail(String newEmail) {
		this.email = newEmail;
	}

	public void setHomephone(String newHomephone) {
		this.homephone = newHomephone;
	}

	public void setId(String newId) {
		this.id = newId;
	}

	public void setIdtype(String newIdtype) {
		this.idtype = newIdtype;
	}

	public void setMobile(String newMobile) {
		this.mobile = newMobile;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public void setPk_org(String newPk_org) {
		this.pk_org = newPk_org;
	}

	public void setSex(String newSex) {
		this.sex = newSex;
	}

	public void setUsedname(String newUsedname) {
		this.usedname = newUsedname;
	}

	public void setDef21(String def21) {
		this.def21 = def21;
	}

	public void setDef23(String def23) {
		this.def23 = def23;
	}
	
	public void setPk_dept(String pk_dept) {
		this.pk_dept = pk_dept;
	}

	public String getDef1() {
		return def1;
	}

	public void setDef1(String def1) {
		this.def1 = def1;
	}

	public String getDef6() {
		return def6;
	}

	public void setDef6(String def6) {
		this.def6 = def6;
	}

	public String getDef7() {
		return def7;
	}

	public void setDef7(String def7) {
		this.def7 = def7;
	}

	public String getDef13() {
		return def13;
	}

	public void setDef13(String def13) {
		this.def13 = def13;
	}

	public String getDef14() {
		return def14;
	}

	public void setDef14(String def14) {
		this.def14 = def14;
	}

	public String getAddr() {
		return addr;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public String getEmail() {
		return email;
	}

	public String getHomephone() {
		return homephone;
	}

	public String getId() {
		return id;
	}

	public String getIdtype() {
		return idtype;
	}

	public String getMobile() {
		return mobile;
	}

	public String getName() {
		return name;
	}

	public String getPk_org() {
		return pk_org;
	}

	public String getSex() {
		return sex;
	}

	public String getUsedname() {
		return usedname;
	}

	public String getDef2() {
		return def2;
	}

	public String getJoinworkdate() {
		return joinworkdate;
	}

	public void setJoinworkdate(String joinworkdate) {
		this.joinworkdate = joinworkdate;
	}

	public String getGlbdef2() {
		return glbdef2;
	}

	public void setGlbdef2(String glbdef2) {
		this.glbdef2 = glbdef2;
	}

	public String getGlbdef3() {
		return glbdef3;
	}

	public void setGlbdef3(String glbdef3) {
		this.glbdef3 = glbdef3;
	}

	public String getDef21() {
		return def21;
	}

	public String getJobglbdef2() {
		return jobglbdef2;
	}

	public void setJobglbdef2(String jobglbdef2) {
		this.jobglbdef2 = jobglbdef2;
	}

	public String getCensusaddr() {
		return censusaddr;
	}

	public void setCensusaddr(String censusaddr) {
		this.censusaddr = censusaddr;
	}

	public String getGlbdef9() {
		return glbdef9;
	}

	public void setGlbdef9(String glbdef9) {
		this.glbdef9 = glbdef9;
	}

	public String getDef23() {
		return def23;
	}

	public String getJobglbdef9() {
		return jobglbdef9;
	}

	public void setJobglbdef9(String jobglbdef9) {
		this.jobglbdef9 = jobglbdef9;
	}

	public String getJobglbdef4() {
		return jobglbdef4;
	}

	public void setJobglbdef4(String jobglbdef4) {
		this.jobglbdef4 = jobglbdef4;
	}

	public String getGlbdef7() {
		return glbdef7;
	}

	public void setGlbdef7(String glbdef7) {
		this.glbdef7 = glbdef7;
	}

	public String getGlbdef8() {
		return glbdef8;
	}

	public void setGlbdef8(String glbdef8) {
		this.glbdef8 = glbdef8;
	}

	public String getGlbdef10() {
		return glbdef10;
	}

	public void setGlbdef10(String glbdef10) {
		this.glbdef10 = glbdef10;
	}

	public String getJobglbdef6() {
		return jobglbdef6;
	}

	public void setJobglbdef6(String jobglbdef6) {
		this.jobglbdef6 = jobglbdef6;
	}

	public String getJobglbdef7() {
		return jobglbdef7;
	}

	public void setJobglbdef7(String jobglbdef7) {
		this.jobglbdef7 = jobglbdef7;
	}

	public String getJobglbdef5() {
		return jobglbdef5;
	}

	public void setJobglbdef5(String jobglbdef5) {
		this.jobglbdef5 = jobglbdef5;
	}

	public String getJobglbdef8() {
		return jobglbdef8;
	}

	public void setJobglbdef8(String jobglbdef8) {
		this.jobglbdef8 = jobglbdef8;
	}

	public String getJobglbdef3() {
		return jobglbdef3;
	}

	public void setJobglbdef3(String jobglbdef3) {
		this.jobglbdef3 = jobglbdef3;
	}

	public String getBegindate() {
		return begindate;
	}

	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getPk_dept() {
		return pk_dept;
	}

	public String getGlbdef23() {
		return glbdef23;
	}

	public void setGlbdef23(String glbdef23) {
		this.glbdef23 = glbdef23;
	}

	public String getGlbdef24() {
		return glbdef24;
	}

	public void setGlbdef24(String glbdef24) {
		this.glbdef24 = glbdef24;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getGlbdef26() {
		return glbdef26;
	}

	public void setGlbdef26(String glbdef26) {
		this.glbdef26 = glbdef26;
	}

	public String getGlbdef27() {
		return glbdef27;
	}

	public void setGlbdef27(String glbdef27) {
		this.glbdef27 = glbdef27;
	}

	public String getCharacterrpr() {
		return characterrpr;
	}

	public void setCharacterrpr(String characterrpr) {
		this.characterrpr = characterrpr;
	}

	public String getGlbdef28() {
		return glbdef28;
	}

	public void setGlbdef28(String glbdef28) {
		this.glbdef28 = glbdef28;
	}

	public String getBloodtype() {
		return bloodtype;
	}

	public void setBloodtype(String bloodtype) {
		this.bloodtype = bloodtype;
	}

	public String getGlbdef25() {
		return glbdef25;
	}

	public void setGlbdef25(String glbdef25) {
		this.glbdef25 = glbdef25;
	}

	public String getGlbdef29() {
		return glbdef29;
	}

	public void setGlbdef29(String glbdef29) {
		this.glbdef29 = glbdef29;
	}

	public String getGlbdef30() {
		return glbdef30;
	}

	public void setGlbdef30(String glbdef30) {
		this.glbdef30 = glbdef30;
	}
}
