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
		Integer vacant[] =  new Integer[dine.getRoom()];// ��ü ���̺�, �� 0, null�� �˰���
		//System.out.println("vacant length: " + vacant.length);
		for(int j=0; j<vacant.length;j++) {
			vacant[j]=0;//�ʱ�ȭ
			//System.out.printf("vacant %d : %d\n",j,vacant[j]);
		}		
		
		for(ReserveVO roomy : roomListByDate) {
			vacant[roomy.getRoom()] = 1;	// ����� �� ��ȣ 1��
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
		
		return vacantList;	// list <room.size> vacantList = 0(���) / 1 (�����)
	}
	
	@RequestMapping(value="/checkCountReserve", method=RequestMethod.POST)
	public int checkCountReserve(ReserveVO rvo) {
		// r_date + dine_name > count(reserve)
		System.out.println("mapping : checkCountReserve");
		//System.out.println(rvo);
		int rcount = reserveService.getReserveCountByDate(rvo);	// �׳� �� ���� ��
		System.out.println(rcount);
		
		DineVO dine = dineService.getDine(rvo.getDine_name());		
		int dineSize = dine.getRoom();		// ���� ���� ���� ��
		System.out.println(dineSize);
		
		if (rcount >= dineSize) {
			// ���� �ο� ����
			System.out.println("full");
			return 1;
		}else {
			System.out.println("has room");
			return 0;	// ���� ����
		} 
		
	} 
	
	
	
	
	
	
	
	
	
	
}























