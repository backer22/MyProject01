package com.green.biz.member.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.member.MemberVO;
import com.green.biz.reserve.ReserveVO;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public MemberVO loginMember(MemberVO vo) {
		//System.out.println("DAO vo: "+vo);
		return mybatis.selectOne("MemberDAO.loginMember", vo);
	}
	
	public MemberVO getMemberById(MemberVO vo) {
		return mybatis.selectOne("MemberDAO.getMemberById", vo);
	}
	
	public void insertMember(MemberVO vo) {
		mybatis.insert("MemberDAO.insertMember", vo);
	}
	
	public List<ReserveVO> oldReservesById(MemberVO vo){
		return mybatis.selectList("MemberDAO.oldReservesById", vo);
	}
	public List<ReserveVO> newReservesById(MemberVO vo){
		return mybatis.selectList("MemberDAO.newReservesById", vo);
	}
	public List<ReserveVO> nowReservesById(MemberVO vo){
		return mybatis.selectList("MemberDAO.nowReservesById", vo);
	}
	
	
}












