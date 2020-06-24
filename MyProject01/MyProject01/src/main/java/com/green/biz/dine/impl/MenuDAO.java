package com.green.biz.dine.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dine.DineVO;
import com.green.biz.dine.MenuVO;

@Repository
public class MenuDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<MenuVO> getMenuListByDineName(String dine_name){
		return mybatis.selectList("MenuDAO.getMenuListByDineName", dine_name);
	}
	
	public MenuVO getMenuByName(String menu_name) {
		return mybatis.selectOne("MenuDAO.getMenuByName", menu_name);
	}
	
	
}















