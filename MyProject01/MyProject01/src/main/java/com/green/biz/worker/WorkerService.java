package com.green.biz.worker;

import java.util.List;

import com.green.biz.member.MemberVO;

public interface WorkerService {
	
	public WorkerVO loginWorker(WorkerVO vo);
	
	public List<MemberVO> getAllBusinessOwner();
	public List<MemberVO> getAllMember();	// non-business
	
	

}
