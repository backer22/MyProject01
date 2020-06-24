package com.green.biz.dine.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.dine.DineService;
import com.green.biz.dine.DineVO;
import com.green.biz.reserve.ReserveVO;

@Service("dineService")
public class DineServiceImpl implements DineService {

	@Autowired
	DineDAO dDAO;
	
	@Override
	public List<DineVO> getAllDine() {
		// TODO Auto-generated method stub
		return dDAO.getAllDine();
	}

	@Override
	public DineVO getDine(String dine_name) {
		// TODO Auto-generated method stub
		return dDAO.getDine(dine_name);
	}

	@Override
	public void insertDine(DineVO vo) {
		// TODO Auto-generated method stub
		dDAO.insertDine(vo);
	}

	@Override
	public void updateDine(DineVO vo) {
		// TODO Auto-generated method stub
		dDAO.updateDine(vo);
	}

	@Override
	public void deleteDine(DineVO vo) {
		// TODO Auto-generated method stub
		dDAO.deleteDine(vo);
	}



}
