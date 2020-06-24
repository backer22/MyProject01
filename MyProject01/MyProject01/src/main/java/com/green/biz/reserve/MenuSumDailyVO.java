package com.green.biz.reserve;

import java.sql.Date;


public class MenuSumDailyVO {
	private Date r_date;
	
	private String menu_name;
	
	private int quantity_sum;

	public Date getR_date() {
		return r_date;
	}

	public void setR_date(Date r_date) {
		this.r_date = r_date;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public int getQuantity_sum() {
		return quantity_sum;
	}

	public void setQuantity_sum(int quantity_sum) {
		this.quantity_sum = quantity_sum;
	}

	@Override
	public String toString() {
		return "MenuSumDailyVO [r_date=" + r_date + ", menu_name=" + menu_name + ", quantity_sum=" + quantity_sum + "]";
	}
	

}
