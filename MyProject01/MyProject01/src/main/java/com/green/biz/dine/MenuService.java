package com.green.biz.dine;

import java.util.List;

public interface MenuService {
	
	public List<MenuVO> getMenuListByDineName(String dine_name);		// input :dineVO.dine_name, output: List<MenuVO>
	
	public MenuVO getMenuByName(String menu_name);

}
