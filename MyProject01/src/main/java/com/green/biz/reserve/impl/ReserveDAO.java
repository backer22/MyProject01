package com.green.biz.reserve.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.member.MemberVO;
import com.green.biz.reserve.ReserveVO;


@Repository
public class ReserveDAO {
	
	@Autowired
	SqlSessionTemplate mybatis;
	
	public int insertReserve(ReserveVO vo) {	// changing
		mybatis.insert("ReserveDAO.insertReserve", vo);
		System.out.println(vo.getR_seq());
		return vo.getR_seq();	// return r_seq
	}
	
	public ReserveVO getReserve(ReserveVO vo) {
		return mybatis.selectOne("ReserveDAO.getReserve", vo);
	}
	
	public List<ReserveVO> getReserveListById(MemberVO vo){		// search by member.id
		return mybatis.selectList("ReserveDAO.getReserveListById", vo);
	}
	
	public List<ReserveVO> getReserveDetailListByR_seq(ReserveVO vo) {
		return mybatis.selectList("ReserveDAO.getReserveDetailListByR_seq", vo);
	}
	
	public void deleteReserveDetailByR_seq(ReserveVO vo) {
		mybatis.delete("ReserveDAO.deleteReserveDetailByR_seq", vo);
	}
	
	public void deleteReserveDetail(ReserveVO vo) {
		mybatis.delete("ReserveDAO.deleteReserveDetail", vo);
	}
	
	public void deleteReserveByR_seq(ReserveVO vo) {
		mybatis.delete("ReserveDAO.deleteReserveByR_seq", vo);
	}
	
	public void insertReserveDetail(ReserveVO vo) {
		mybatis.insert("ReserveDAO.insertReserveDetail", vo);
	}
	
	public void updateReserve(ReserveVO vo) {
		mybatis.update("ReserveDAO.updateReserve", vo);
	}
	
	public void updateReserveDetail(ReserveVO vo) {
		mybatis.update("ReserveDAO.updateReserveDetail", vo);
	}
	
	public List<ReserveVO> roomListByDate(ReserveVO vo){
		return mybatis.selectList("ReserveDAO.roomListByDate", vo);
	}
	
	public int getReserveCountByDate(ReserveVO vo) {
		return mybatis.selectOne("ReserveDAO.getReserveCountByDate", vo);
	}
	
	public List<ReserveVO> oldReserves(String dine_name){
		return mybatis.selectList("ReserveDAO.oldReserves", dine_name);}		
	public List<ReserveVO> newReserves(String dine_name){
			return mybatis.selectList("ReserveDAO.newReserves", dine_name);	}
	public List<ReserveVO> nowReserves(String dine_name){
		return mybatis.selectList("ReserveDAO.nowReserves", dine_name);}

}







