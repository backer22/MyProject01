package com.green.biz.member.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.member.MemberService;
import com.green.biz.member.MemberVO;
import com.green.biz.reserve.ReserveVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO mDAO;
	
	@Override
	public MemberVO loginMember(MemberVO vo) {
		//System.out.println("impl vo: "+vo);
		return mDAO.loginMember(vo);
	}

	@Override
	public MemberVO getMemberById(MemberVO vo) {
		// TODO Auto-generated method stub
		return mDAO.getMemberById(vo);
	}

	@Override
	public void insertMember(MemberVO vo) {
		// TODO Auto-generated method stub
		mDAO.insertMember(vo);
	}

	@Override
	public List<ReserveVO> oldReservesById(MemberVO vo) {
		// TODO Auto-generated method stub
		return mDAO.oldReservesById(vo);
	}

	@Override
	public List<ReserveVO> newReservesById(MemberVO vo) {
		// TODO Auto-generated method stub
		return mDAO.newReservesById(vo);
	}

	@Override
	public List<ReserveVO> nowReservesById(MemberVO vo) {
		// TODO Auto-generated method stub
		return mDAO.nowReservesById(vo);
	}
	


}
