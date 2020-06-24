package com.green.biz.dine.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dine.DineVO;
import com.green.biz.reserve.ReserveVO;

@Repository
public class DineDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<DineVO> getAllDine(){
		return mybatis.selectList("DineDAO.getAllDine");
	}
	
	public DineVO getDine(String dine_name) {
		return mybatis.selectOne("DineDAO.getDine", dine_name);
	}
	
	public void insertDine(DineVO vo) {
		mybatis.insert("DineDAO.insertDine", vo);
	}
	
	public void updateDine(DineVO vo) {
		mybatis.update("DineDAO.updateDine", vo);
	}
	
	public void deleteDine(DineVO vo) {
		mybatis.delete("DineDAO.deleteDine", vo);
	}
	

	
}







