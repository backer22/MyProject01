package com.green.view.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.green.biz.dine.DineService;
import com.green.biz.dine.DineVO;
import com.green.biz.reserve.ReserveService;
import com.green.biz.reserve.ReserveVO;

@RestController
public class ReserveDateRoomController {

	@Autowired
	ReserveService reserveService;
	
	@Autowired
	DineService dineService;
	
	@RequestMapping(value="/searchDateRoom", method=RequestMethod.POST)
	public List<Integer> searchDateRoom(ReserveVO vo, Model model) {
		System.out.println("RequestMapping : searchDateRoom");
		//System.out.println(vo);		
		
		List<ReserveVO> roomListByDate = reserveService.roomListByDate(vo); // List<> = taken room
		//System.out.println("printing roomListByDate");
		//System.out.println(roomListByDate); 
		
		//for(int k=0;k<roomListByDate.size(); k++) {System.out.println(roomListByDate.get(k));}
		
		//for(ReserveVO room : roomListByDate) {System.out.println(room.getRoom());}
		
		
		DineVO dine = dineService.getDine(vo.getDine_name());
		//System.out.println("dine: "+dine);
		//System.out.println("dine room: "+dine.getRoom());
		Integer vacant[] =  new Integer[dine.getRoom()];// 전체 테이블, 값 0, null임 알고보니
		//System.out.println("vacant length: " + vacant.length);
		for(int j=0; j<vacant.length;j++) {
			vacant[j]=0;//초기화
			//System.out.printf("vacant %d : %d\n",j,vacant[j]);
		}		
		
		for(ReserveVO roomy : roomListByDate) {
			vacant[roomy.getRoom()] = 1;	// 예약된 방 번호 1로
			//System.out.println(roomy.getRoom()+ " : " + vacant[roomy.getRoom()]);
		}
				
		/*
		for(Integer k=0;k<vacant.length;k++) {
			System.out.println(k + " : " + vacant[k]);
		}
		*/
		
		List<Integer> vacantList = Arrays.asList(vacant);// array >> list
		//System.out.println(vacantList);
		//System.out.println("vacant as array: "+ vacant);
		
		//for(Integer v=0; v<vacantList.size(); v++) {
		//	System.out.println(v +" : "+vacantList);}
		
		return vacantList;	// list <room.size> vacantList = 0(빈방) / 1 (예약됨)
	}
	
	@RequestMapping(value="/checkCountReserve", method=RequestMethod.POST)
	public int checkCountReserve(ReserveVO rvo) {
		// r_date + dine_name > count(reserve)
		System.out.println("mapping : checkCountReserve");
		//System.out.println(rvo);
		int rcount = reserveService.getReserveCountByDate(rvo);	// 그날 총 예약 수
		System.out.println(rcount);
		
		DineVO dine = dineService.getDine(rvo.getDine_name());		
		int dineSize = dine.getRoom();		// 예약 수용 가능 수
		System.out.println(dineSize);
		
		if (rcount >= dineSize) {
			// 예약 인원 꽉참
			System.out.println("full");
			return 1;
		}else {
			System.out.println("has room");
			return 0;	// 예약 가능
		} 
		
	} 
	
	
	
	
	
	
	
	
	
	
}























