package com.green.biz.member;

import java.util.List;

import com.green.biz.reserve.ReserveVO;

public interface MemberService {
	
	public MemberVO loginMember(MemberVO vo);

	public MemberVO getMemberById(MemberVO vo);
	
	public void insertMember(MemberVO vo);
	
	//getting reserves for member
	public List<ReserveVO> oldReservesById(MemberVO vo);	//need id
	public List<ReserveVO> newReservesById(MemberVO vo);
	public List<ReserveVO> nowReservesById(MemberVO vo);
	
	
	

}
