package com.app.OA.domain;

public class BookPatient {

	//数据库编号
	public Integer id;
	
	//预约院区
	public String hospt;
	
	//科室
	public String dept;
	
	//医生
	public String doc;
	
	//费用
	public String cost;
	
	//时间
	public String time;
	
	//就诊人识别ID
	public String patientID;
	
	//就诊人姓名
	public String patientName;
	
	//就诊人身份证
	public String identityCard;
	
	//就诊人手机号
	public String patientPhone;
	
	//预约ID
	public String bookingID;
	
	//是否需要付款
	public String needPay;
	
	//预约或者挂号的编号 （请不要含特殊字符， 如 / # ?）
	public String resourceID;
	
	//预约时间
	public String createTime;
	
	//预约人微信识别码
	public String openID;
	
	//预约状态
	public String bookingStatus;

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getPatientPhone() {
		return patientPhone;
	}

	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHospt() {
		return hospt;
	}

	public void setHospt(String hospt) {
		this.hospt = hospt;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPatientID() {
		return patientID;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}

	public String getBookingID() {
		return bookingID;
	}

	public void setBookingID(String bookingID) {
		this.bookingID = bookingID;
	}

	public String getNeedPay() {
		return needPay;
	}

	public void setNeedPay(String needPay) {
		this.needPay = needPay;
	}

	public String getResourceID() {
		return resourceID;
	}

	public void setResourceID(String resourceID) {
		this.resourceID = resourceID;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	
}
