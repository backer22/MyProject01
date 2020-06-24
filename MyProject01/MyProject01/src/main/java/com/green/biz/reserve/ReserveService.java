package com.green.biz.reserve;

import java.util.List;

import com.green.biz.member.MemberVO;

public interface ReserveService {
	
	public int insertReserve(ReserveVO vo);
		
	public ReserveVO getReserve(ReserveVO vo); // r_seq 로 검색
	
	public List<ReserveVO> getReserveListById(MemberVO vo);
	
	public List<ReserveVO> getReserveDetailListByR_seq(ReserveVO vo);	// vo.r_seq 로 reserveDetail 검색
	
	public void deleteReserveDetailByR_seq(ReserveVO vo);
	
	public void deleteReserveDetail(ReserveVO vo);//delete by rd_seq
	
	public void deleteReserveByR_seq(ReserveVO vo);

	public void insertReserveDetail(ReserveVO vo);
	
	public void updateReserve(ReserveVO vo);
	
	public void updateReserveDetail(ReserveVO vo);
	
	public List<ReserveVO> roomListByDate(ReserveVO vo);	// r_date + dine_name >> List<int> room
	
	public int getReserveCountByDate(ReserveVO vo);	// r_date + dine_name = count()
	
	//search by dine_name, compare to sysdate
	public List<ReserveVO> oldReserves(String dine_name);
	public List<ReserveVO> newReserves(String dine_name);
	public List<ReserveVO> nowReserves(String dine_name);
	
	
}






