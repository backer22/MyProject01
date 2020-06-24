package com.green.biz.dine.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.dine.DineVO;
import com.green.biz.dine.MenuService;
import com.green.biz.dine.MenuVO;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

	@Autowired
	MenuDAO menuDAO;
	
	@Override
	public List<MenuVO> getMenuListByDineName(String dine_name) {
		// TODO Auto-generated method stub
		return menuDAO.getMenuListByDineName(dine_name);
	}

	@Override
	public MenuVO getMenuByName(String menu_name) {
		// TODO Auto-generated method stub
		return menuDAO.getMenuByName(menu_name);
	}

}
