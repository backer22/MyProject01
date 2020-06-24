package com.green.biz.worker;

public class WorkerVO {
	private String w_id;
	private String w_pwd;
	private String w_name;
	private String w_phone;
	
	public String getW_id() {
		return w_id;
	}
	public void setW_id(String w_id) {
		this.w_id = w_id;
	}
	public String getW_pwd() {
		return w_pwd;
	}
	public void setW_pwd(String w_pwd) {
		this.w_pwd = w_pwd;
	}
	public String getW_name() {
		return w_name;
	}
	public void setW_name(String w_name) {
		this.w_name = w_name;
	}
	public String getW_phone() {
		return w_phone;
	}
	public void setW_phone(String w_phone) {
		this.w_phone = w_phone;
	}
	@Override
	public String toString() {
		return "WorkerVO [w_id=" + w_id + ", w_pwd=" + w_pwd + ", w_name=" + w_name + ", w_phone=" + w_phone + "]";
	}
	
	
}
