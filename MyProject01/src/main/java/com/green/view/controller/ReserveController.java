package com.green.view.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.biz.dine.DineService;
import com.green.biz.dine.DineVO;
import com.green.biz.dine.MenuService;
import com.green.biz.dine.MenuVO;
import com.green.biz.member.MemberVO;
import com.green.biz.reserve.ReserveService;
import com.green.biz.reserve.ReserveVO;

@Controller
public class ReserveController {

	@Autowired
	DineService dineService;
	
	@Autowired
	ReserveService reserveService;
	
	@Autowired
	MenuService menuService;
	
	@RequestMapping(value="reserve_form", method = RequestMethod.GET)
	public String reserveForm(DineVO vo, Model model) {	//dine_name �� ����
		
		DineVO dine = dineService.getDine(vo.getDine_name());	// dine_name >> DineVO
		model.addAttribute("dine", dine);
		
		List<MenuVO> menuList = menuService.getMenuListByDineName(dine.getDine_name());
		model.addAttribute("menuList", menuList);
		
		return "dine/reserve";
	}
	
	
	@RequestMapping(value="reserve_detail")	// ���� �� ������
	public String viewReserveDetail(ReserveVO vo, Model model) {
		
		// r_seq �� �Ѵ� �˻�
		ReserveVO reserve = reserveService.getReserve(vo);
		List<ReserveVO> reserveDetailList = reserveService.getReserveDetailListByR_seq(vo);		// �̾ �ϱ�
		
		//System.out.println("reserve: " + reserve);
		//for (ReserveVO reserveDetail : reserveDetailList) {System.out.println("reserveDetail: " + reserveDetail);}
		
		
		model.addAttribute("reserve", reserve);
		model.addAttribute("reserveDetailList", reserveDetailList);
		
		return "dine/reserveDetail";
	}
	
	@RequestMapping(value="reserveCancel", method = RequestMethod.GET)
	public String reserveCancelForm(ReserveVO vo, Model model) {
		ReserveVO reserve = reserveService.getReserve(vo);
		model.addAttribute("reserve", reserve);
		List<ReserveVO> reserveDetailList = reserveService.getReserveDetailListByR_seq(vo);
		model.addAttribute("reserveDetailList", reserveDetailList);
		
		return "dine/reserveCancel";
	}
	
	@RequestMapping(value="reserveCancel", method = RequestMethod.POST)
	public String reserveCancelAction(ReserveVO vo) {		//r_seq ����
		//List<ReserveVO> reserveDetailList =reserveService.getReserveDetailListByR_seq(vo);
		reserveService.deleteReserveDetailByR_seq(vo);	// reserveDetail ����
		reserveService.deleteReserveByR_seq(vo);		// reserve ����
		
		
		return "redirect:/memberMain";
	}
	

	
	@RequestMapping(value="reserveUpdate", method=RequestMethod.GET)	// ������ �̵�
	public String reserveUpdateForm(ReserveVO vo, Model model) {
		ReserveVO reserve = reserveService.getReserve(vo);
		//System.out.println(vo);
		//System.out.println(reserve.getR_time());
		model.addAttribute("reserve", reserve);
		model.addAttribute("r_time", reserve.getR_time());
		
		// ordered menu list  ( does not contain menus not ordered)
		List<ReserveVO> reserveDetailList = reserveService.getReserveDetailListByR_seq(vo);
		//model.addAttribute("reserveDetailList", reserveDetailList);		
		
		// menu list
		List<MenuVO> menuList = menuService.getMenuListByDineName(reserve.getDine_name());
		model.addAttribute("menuList", menuList);//incomplete
		
		
		int count = 0;
		//System.out.println("menuList: "+menuList);
		//System.out.println("reserveDetailList: " +reserveDetailList);
		
		for(MenuVO menu : menuList) {
			count = 0;
			for(ReserveVO reserveD : reserveDetailList) {
				//System.out.println("compring " + reserveD.getMenu_name() + " vs " +menu.getMenu_name());;
				// �ֹ��� �޴� ã��
				if(reserveD.getMenu_name().equals(menu.getMenu_name()) ) {
					//System.out.println(reserveD.getMenu_name()+" is found, not adding");
					count = 1;
					break;
				}									
			}
			// �ֹ����� ���� �޴�, 0���� �߰�
			if(count == 0) {
				//System.out.println(menu.getMenu_name() + " is not found, adding");
				ReserveVO reserveAdd = new ReserveVO();	// ���� �Ҵ� �ް� �ؾ���, ���� �ޱ�ٰ� �ּҿ� �ִ� ���� �������� ���� �׻�
				reserveAdd.setMenu_name(menu.getMenu_name());
				reserveAdd.setQuantity(0);
				reserveAdd.setRd_seq(-1); 	// �������� ���� reserveDetail
				//System.out.println(reserveAdd);
				reserveDetailList.add(reserveAdd);
				//reserveDetailList.add(0, reserveAdd);
			}//ok
			
		}		
		//System.out.println(reserveDetailList);
		model.addAttribute("reserveDetailList", reserveDetailList);	
		
		return "dine/reserveUpdate";
	}
	
	@RequestMapping(value="reserveUpdate", method=RequestMethod.POST)	// update action
	public String reserveUpdateAction(
			@RequestParam(value="quantity", defaultValue = "0") int[] quantity,  
			@RequestParam(value="menu_name") String menu_name[],
			@RequestParam(value="rd_seq") int[] rd_seq, ReserveVO vo, HttpSession session) {
	// menu_name�� quantity�� 0�̸� rd_seq�� -1 (�׷��� ���� �س���, ����: DB�� -1 rd_seq ����)
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		System.out.println("vo: "+vo); // r_seq, people, r_time, r_date, rd_seq, menu_name, quantity
		if(loginUser == null) {//���� ����
			return "redirect:/login_form";
		}else {
			reserveService.updateReserve(vo); 	// people, r_date, r_time, r_seq
			
			ReserveVO reserveDetail = new ReserveVO();
			//int r_seq = vo.getR_seq();
			for(int i=0; i<quantity.length;i++) {//������ quantity, menu_name, rd_seq ���̴� �� ����
				reserveDetail.setR_seq(vo.getR_seq());//�θ� ����
				reserveDetail.setRd_seq(rd_seq[i]);
				reserveDetail.setMenu_name(menu_name[i]);	//insertReserveDetail
				reserveDetail.setQuantity(quantity[i]);
				System.out.println("reserveDetail: " + reserveDetail);
				// r_seq, rd_seq=-1(or else), menu_name, quantity=0(or more)
				if(reserveDetail.getQuantity()<=0 ) {		// 0���� ���࿡�� �޴� ����
					System.out.println(" detail deleted");
					reserveService.deleteReserveDetail(reserveDetail);
				}else if(reserveDetail.getRd_seq() == -1 && reserveDetail.getQuantity() >0){
					// reserveDetail �������� �����Ƿ� �߰��ؾ���
					System.out.println(" detail added");
					reserveService.insertReserveDetail(reserveDetail);
				}else {	// ������Ʈ
					System.out.println(" detail updated");
					reserveService.updateReserveDetail(reserveDetail);
				}
				
			}//for
			
			return "redirect:/reserve_detail?r_seq="+vo.getR_seq();
		}//else
	}
	

	
	@RequestMapping(value="menuAdd", method=RequestMethod.GET)		// �޴� �߰�
	public String menuAddView(ReserveVO rvo, DineVO dvo, Model model) {	// reserveDetail.jsp >> menuList.jsp
		List<MenuVO> menuList =menuService.getMenuListByDineName(dvo.getDine_name());
		model.addAttribute("menuList", menuList);
		DineVO dine = dineService.getDine(dvo.getDine_name());
		model.addAttribute("dine", dine);
		
		return "dine/menuAdd";	//incomplete 2
	}
	
	
	@RequestMapping(value="reserveAction", method=RequestMethod.POST)
	public String reserveAction(@RequestParam(value="menu_name") String menu_name[],
			@RequestParam(value="quantity") int[] quantity,			
			ReserveVO vo, HttpSession session) {
		//System.out.println("mapping: reserveAction");
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		if(loginUser==null) {
			return "redirect:/login_form";
		}else {
			//System.out.println("���� ����");
			vo.setId(loginUser.getId());		// r_date, r_time, people, dine_name(hidden)
			int r_seq = reserveService.insertReserve(vo);
			//System.out.println("r_seq: " + r_seq);
			
			ReserveVO reserveDetail = new ReserveVO();
			reserveDetail.setR_seq(r_seq);
			for(int i=0; i<menu_name.length; i++) {
				reserveDetail.setMenu_name(menu_name[i]);
				reserveDetail.setQuantity(quantity[i]);
				
				if(reserveDetail.getQuantity()!=0) {	// ���� ������ �߰�
					reserveService.insertReserveDetail(reserveDetail);
				}
			}
			//vo.setR_seq(r_seq);
			//model.addAttribute("reserve", vo);
			return "redirect:/memberMain";
		}
	}//public
	
	

	
	
	
	
	
	
	
	
	
}















