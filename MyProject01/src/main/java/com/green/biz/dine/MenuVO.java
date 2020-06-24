package com.green.biz.dine;

import org.springframework.web.multipart.MultipartFile;

public class MenuVO {
	private String menu_name;
	private String dine_name;
	private int price;
	private String menu_image;
	
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public String getDine_name() {
		return dine_name;
	}
	public void setDine_name(String dine_name) {
		this.dine_name = dine_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}


	public String getMenu_image() {
		return menu_image;
	}
	public void setMenu_image(String menu_image) {
		this.menu_image = menu_image;
	}
	@Override
	public String toString() {
		return "MenuVO [menu_name=" + menu_name + ", dine_name=" + dine_name + ", price=" + price + ", menu_image="
				+ menu_image + "]";
	}
	
	
	
	

}
