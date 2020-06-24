package com.green.biz.reserve;

import java.sql.Date;
import java.sql.Timestamp;

public class ReserveVO {
	// reserve
	private int r_seq;
	private String dine_name;	// 예약한 식당
	private String id;		// 예약한 회원
	private int people;		// 예약 인원수
	private Timestamp r_time;		// 2400
	private Date r_date;	// 예약한 날짜
	private int room;
	// reserve_detail
	private int rd_seq;
	private String menu_name;	// 예약한 메뉴
	private int quantity;	// 메뉴 양
	public int getR_seq() {
		return r_seq;
	}
	public void setR_seq(int r_seq) {
		this.r_seq = r_seq;
	}
	public String getDine_name() {
		return dine_name;
	}
	public void setDine_name(String dine_name) {
		this.dine_name = dine_name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}

	public Timestamp getR_time() {
		return r_time;
	}
	public void setR_time(Timestamp r_time) {
		this.r_time = r_time;
	}
	public Date getR_date() {
		return r_date;
	}
	public void setR_date(Date r_date) {
		this.r_date = r_date;
	}
	public int getRd_seq() {
		return rd_seq;
	}
	public void setRd_seq(int rd_seq) {
		this.rd_seq = rd_seq;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	@Override
	public String toString() {
		return "ReserveVO [r_seq=" + r_seq + ", dine_name=" + dine_name + ", id=" + id + ", people=" + people
				+ ", r_time=" + r_time + ", r_date=" + r_date + ", room=" + room + ", rd_seq=" + rd_seq + ", menu_name="
				+ menu_name + ", quantity=" + quantity + "]";
	}
	
	
	
	
}
