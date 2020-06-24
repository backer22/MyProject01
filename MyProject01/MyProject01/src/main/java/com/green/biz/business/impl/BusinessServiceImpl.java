package com.green.biz.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.business.BusinessService;
import com.green.biz.dine.DineVO;
import com.green.biz.dine.MenuVO;
import com.green.biz.reserve.MenuSumDailyVO;
import com.green.biz.reserve.ReserveVO;

@Service("businessService")
public class BusinessServiceImpl implements BusinessService {

	@Autowired
	BusinessDAO bDAO;
	
	
	@Override
	public DineVO getDineById(String id) {
		// TODO Auto-generated method stub
		return bDAO.getDineById(id);
	}

	@Override
	public List<ReserveVO> getAllReserveByDineName(DineVO vo) {
		// TODO Auto-generated method stub
		return bDAO.getAllReserveByDineName(vo);
	}

	@Override
	public List<MenuSumDailyVO> getMenuQuantityListByDine(DineVO vo) {
		// TODO Auto-generated method stub
		return bDAO.getMenuQuantityListByDine(vo);
	}

	@Override
	public void insertMenu(MenuVO vo) {
		// TODO Auto-generated method stub
		bDAO.insertMenu(vo);
	}

	@Override
	public void deleteMenu(MenuVO vo) {
		// TODO Auto-generated method stub
		bDAO.deleteMenu(vo);
	}

	@Override
	public void updateMenu(MenuVO vo) {
		// TODO Auto-generated method stub
		bDAO.updateMenu(vo);
	}

	@Override
	public List<MenuSumDailyVO> getMenuQuantityListByDineToday(DineVO vo) {
		// TODO Auto-generated method stub
		return bDAO.getMenuQuantityListByDineToday(vo);
	}


}
