package com.green.biz.member;

public class MemberVO {

	private String id;
	private String pwd;
	private String email;
	private String name;
	private String phone;
	private String businessyn;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBusinessyn() {
		return businessyn;
	}
	public void setBusinessyn(String businessyn) {
		this.businessyn = businessyn;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pwd=" + pwd + ", email=" + email + ", name=" + name + ", phone=" + phone
				+ ", businessyn=" + businessyn + "]";
	}
	
	
}
