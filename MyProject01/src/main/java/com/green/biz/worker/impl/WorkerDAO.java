package com.green.biz.worker.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.member.MemberVO;
import com.green.biz.worker.WorkerVO;

@Repository
public class WorkerDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public WorkerVO loginWorker(WorkerVO vo) {
		//System.out.println("DAO: loginWorker ½ÇÇà");
		return mybatis.selectOne("WorkerDAO.loginWorker", vo);
	}
	
	public List<MemberVO> getAllBusinessOwner(){
		return mybatis.selectList("WorkerDAO.getAllBusinessOwner");
	}
	public List<MemberVO> getAllMember(){
		return mybatis.selectList("WorkerDAO.getAllMember");
	}
	
	
}
