package com.green.biz.reserve.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.member.MemberVO;
import com.green.biz.reserve.ReserveService;
import com.green.biz.reserve.ReserveVO;

@Service("reserveService")
public class ReserveServiceImpl implements ReserveService {

	@Autowired
	ReserveDAO rDAO;
	
	@Override
	public int insertReserve(ReserveVO vo) {
		// TODO Auto-generated method stub
		return rDAO.insertReserve(vo);
	}

	@Override
	public ReserveVO getReserve(ReserveVO vo) {
		// TODO Auto-generated method stub
		return rDAO.getReserve(vo);
	}

	@Override
	public List<ReserveVO> getReserveListById(MemberVO vo) {
		// TODO Auto-generated method stub
		return rDAO.getReserveListById(vo);
	}

	@Override
	public List<ReserveVO> getReserveDetailListByR_seq(ReserveVO vo) {
		// TODO Auto-generated method stub
		return rDAO.getReserveDetailListByR_seq(vo);
	}

	@Override
	public void deleteReserveDetailByR_seq(ReserveVO vo) {
		// TODO Auto-generated method stub
		rDAO.deleteReserveDetailByR_seq(vo);
	}

	@Override
	public void deleteReserveByR_seq(ReserveVO vo) {
		rDAO.deleteReserveByR_seq(vo);
		
	}

	@Override
	public void insertReserveDetail(ReserveVO vo) {
		// TODO Auto-generated method stub
		rDAO.insertReserveDetail(vo);	
	}

	@Override
	public void updateReserve(ReserveVO vo) {
		// TODO Auto-generated method stub
		rDAO.updateReserve(vo);
	}

	@Override
	public void updateReserveDetail(ReserveVO vo) {
		// TODO Auto-generated method stub
		rDAO.updateReserveDetail(vo);
	}

	@Override
	public List<ReserveVO> roomListByDate(ReserveVO vo) {
		// TODO Auto-generated method stub
		return rDAO.roomListByDate(vo);
	}

	@Override
	public int getReserveCountByDate(ReserveVO vo) {
		// TODO Auto-generated method stub
		return rDAO.getReserveCountByDate(vo);
	}

	@Override
	public List<ReserveVO> oldReserves(String dine_name) {
		// TODO Auto-generated method stub
		return rDAO.oldReserves(dine_name);
	}

	@Override
	public List<ReserveVO> newReserves(String dine_name) {
		// TODO Auto-generated method stub
		return rDAO.newReserves(dine_name);
	}

	@Override
	public List<ReserveVO> nowReserves(String dine_name) {
		// TODO Auto-generated method stub
		return rDAO.nowReserves(dine_name);
	}

	@Override
	public void deleteReserveDetail(ReserveVO vo) {
		// TODO Auto-generated method stub
		rDAO.deleteReserveDetail(vo);
	}

}
