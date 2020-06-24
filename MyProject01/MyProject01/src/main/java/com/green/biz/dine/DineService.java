package com.green.biz.dine;

import java.util.List;

import com.green.biz.reserve.ReserveVO;

public interface DineService {
	
	public List<DineVO> getAllDine();
	
	public DineVO getDine(String dine_name);

	public void insertDine(DineVO vo);
	
	public void updateDine(DineVO vo);
	
	public void deleteDine(DineVO vo);

	

}

