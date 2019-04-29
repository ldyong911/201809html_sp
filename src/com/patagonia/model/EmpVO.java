package com.patagonia.model;

public class EmpVO {
	private String sawon_id; //vo는 변수값을 모두 소문자로해야 parameter가 넘어옴
	private String sawon_name;
	private String mobile;
	private String email;
	private String ins_date;
	private String ins_id;
	private String upd_date;
	private String upd_id;
	
	public String getSawon_id() {
		return sawon_id;
	}
	public void setSawon_id(String sawon_id) {
		this.sawon_id = sawon_id;
	}
	public String getSawon_name() {
		return sawon_name;
	}
	public void setSawon_name(String sawon_name) {
		this.sawon_name = sawon_name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIns_date() {
		return ins_date;
	}
	public void setIns_date(String ins_date) {
		this.ins_date = ins_date;
	}
	public String getIns_id() {
		return ins_id;
	}
	public void setIns_id(String ins_id) {
		this.ins_id = ins_id;
	}
	public String getUpd_date() {
		return upd_date;
	}
	public void setUpd_date(String upd_date) {
		this.upd_date = upd_date;
	}
	public String getUpd_id() {
		return upd_id;
	}
	public void setUpd_id(String upd_id) {
		this.upd_id = upd_id;
	}
}