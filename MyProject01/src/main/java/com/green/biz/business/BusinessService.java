package com.green.biz.business;

import java.util.List;

import com.green.biz.dine.DineVO;
import com.green.biz.dine.MenuVO;
import com.green.biz.reserve.MenuSumDailyVO;
import com.green.biz.reserve.ReserveVO;

public interface BusinessService {
	
	public DineVO getDineById(String id);
	
	public List<ReserveVO> getAllReserveByDineName(DineVO vo);
	
	public List<MenuSumDailyVO> getMenuQuantityListByDine(DineVO vo);
	
	public List<MenuSumDailyVO> getMenuQuantityListByDineToday(DineVO vo);

	public void insertMenu(MenuVO vo);

	public void deleteMenu(MenuVO vo);
	
	public void updateMenu(MenuVO vo);
	
	
	
}
