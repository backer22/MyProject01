package com.green.biz.dine;

public class DineVO {	// ½Ä´ç
	private String dine_name;
	private String location;
	private String category;
	private int room;
	private String id;
	private String seat_image;
	
	public String getDine_name() {
		return dine_name;
	}
	public void setDine_name(String dine_name) {
		this.dine_name = dine_name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "DineVO [dine_name=" + dine_name + ", location=" + location + ", category=" + category + ", room=" + room
				+ ", id=" + id + ", seat_image=" + seat_image + "]";
	}
	public String getSeat_image() {
		return seat_image;
	}
	public void setSeat_image(String seat_image) {
		this.seat_image = seat_image;
	}
	
	
	

}
