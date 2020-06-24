package com.green.biz.worker.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.member.MemberVO;
import com.green.biz.worker.WorkerService;
import com.green.biz.worker.WorkerVO;

@Service("workerService")
public class WorkerServiceImpl implements WorkerService {

	@Autowired
	WorkerDAO wDAO; 
	
	@Override
	public WorkerVO loginWorker(WorkerVO vo) {
		//System.out.println("IMPL: loginWorker ½ÇÇà");
		return wDAO.loginWorker(vo);
	}

	@Override
	public List<MemberVO> getAllBusinessOwner() {
		// TODO Auto-generated method stub
		return wDAO.getAllBusinessOwner();
	}

	@Override
	public List<MemberVO> getAllMember() {
		// TODO Auto-generated method stub
		return wDAO.getAllMember();
	}

}
