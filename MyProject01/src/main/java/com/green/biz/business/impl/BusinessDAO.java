package com.green.biz.business.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dine.DineVO;
import com.green.biz.dine.MenuVO;
import com.green.biz.reserve.MenuSumDailyVO;
import com.green.biz.reserve.ReserveVO;

@Repository
public class BusinessDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public DineVO getDineById(String id) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("BusinessDAO.getDineById", id);
	}
	
	public List<ReserveVO> getAllReserveByDineName(DineVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectList("BusinessDAO.getAllReserveByDineName", vo);
	}
	
	public List<MenuSumDailyVO> getMenuQuantityListByDine(DineVO vo){
		return mybatis.selectList("BusinessDAO.getMenuQuantityListByDine", vo);
	}
	
	public void insertMenu(MenuVO vo) {
		mybatis.insert("BusinessDAO.insertMenu", vo);
	}
	
	public void deleteMenu(MenuVO vo) {
		mybatis.delete("BusinessDAO.deleteMenu", vo);
	}

	public void updateMenu(MenuVO vo) {
		mybatis.update("BusinessDAO.updateMenu", vo);
	}
	
	public List<MenuSumDailyVO> getMenuQuantityListByDineToday(DineVO vo){
		return mybatis.selectList("BusinessDAO.getMenuQuantityListByDineToday", vo);
	}
	

}

















