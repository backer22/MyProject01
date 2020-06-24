package com.green.view.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.green.biz.dine.DineService;
import com.green.biz.dine.DineVO;
import com.green.biz.dine.MenuService;
import com.green.biz.dine.MenuVO;
import com.green.biz.member.MemberService;
import com.green.biz.member.MemberVO;
import com.green.biz.reserve.ReserveService;
import com.green.biz.reserve.ReserveVO;

@Controller
@SessionAttributes("loginUser")
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@Autowired
	DineService dineService;
	
	@Autowired
	ReserveService reserveService;
	
	@Autowired
	MenuService menuService;
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String loginMember(MemberVO vo, Model model, HttpSession session) {
		//System.out.println("mapping vo: "+vo);
		MemberVO loginUser = memberService.loginMember(vo);
		
		//System.out.println(loginUser);
		
		//System.out.println("businessyn: "+loginUser.getBusinessyn());
		model.addAttribute("loginUser", loginUser);
		
		if(loginUser != null) {
			//System.out.println("login yes");
			String businessyn = loginUser.getBusinessyn();
			session.setAttribute("loginUser", loginUser);
			if(businessyn.equals("Y")) {	//business
				session.setAttribute("businessyn", "Y");
				return "redirect:login_business";
			}else {		// �Ϲ� member
				session.setAttribute("businessyn", "N");
				return "redirect:/memberMain";
			}
		}else {
			//System.out.println("login no");
			return "member/loginFail";
		}
	}

	
	
	@RequestMapping(value="memberMain")
	public String memberMain(Model model, HttpSession session) {
		
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		if(loginUser !=null) {
		List<DineVO> dineList = dineService.getAllDine();	// �Ĵ� ��ϵ� �ҷ�����
		for(DineVO dinevo : dineList) {
			int room = dinevo.getRoom()-1;	// exclude 0(no assign)
			dinevo.setRoom(room);
		}
		
		model.addAttribute("dineList", dineList);	// �Ĵ� ��ϵ�
		
		MemberVO vo = (MemberVO) session.getAttribute("loginUser");		// id+pwd		
		List<ReserveVO> reserveList = reserveService.getReserveListById(vo);	// ���� ��� �ҷ�����
		model.addAttribute("reserveList", reserveList);
		
		// today reserves
		List<ReserveVO> nowReservesById = memberService.nowReservesById(loginUser);
		model.addAttribute("nowReserveList", nowReservesById);
		// new/upcoming reserves
		List<ReserveVO> newReserveListById = memberService.newReservesById(loginUser);
		model.addAttribute("newReserveList", newReserveListById);
		// old reserves
		List<ReserveVO> oldReserveListById = memberService.oldReservesById(loginUser);
		model.addAttribute("oldReserveList", oldReserveListById);
		
		if(session.getAttribute("businessyn").equals("Y")) {
			return "redirect:login_business";
		}
		
		return "member/member_main";
		}else {
			return "redirect:/login_form";
		}
		
		
	}
	
	
	@RequestMapping(value="login_form")
	public String loginForm() {
		
		return "member/login";
	}
	
	@RequestMapping(value="logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:/index";
	}
	
	@RequestMapping(value="join_form")
	public String joinForm() {
		return "member/join";
	}
	
	
	@RequestMapping(value="id_check_form", method=RequestMethod.GET)
	public String idCheckForm(@RequestParam(value="id", defaultValue = "", required = false) String id, Model model) {
		model.addAttribute("id", id);	// ȭ�� �̵�
		
		return "member/idcheck";
	}
	
	@RequestMapping(value="id_check_form", method=RequestMethod.POST)
	public String idCheckAction(@RequestParam(value="id", defaultValue = "", required = false) String id, Model model) {
		// ���� id üũ
		MemberVO vo = new MemberVO();
		vo.setId(id);
		
		MemberVO user = memberService.getMemberById(vo);
		
		if(user !=null) {
			model.addAttribute("message", 1);
		}else {
			model.addAttribute("message", -1);
		}
		
		model.addAttribute("id", id);
		
		return "member/idcheck";
	}
		
	@RequestMapping(value="id_check_confirmed")	// ���̵� Ȯ��, �׼�
	public String idCheckConfirmed(MemberVO mVO, Model model) {
		
		model.addAttribute("reid", mVO.getId());
		
		return "member/join";
	}
	
	@RequestMapping(value="join", method = RequestMethod.POST )	// ȸ�� ����
	public String joinAction(MemberVO vo) {
		
		memberService.insertMember(vo);
		
		return "member/login";
	}
	
	
	
	// �Ϲ� ȸ�� ���� ������ >> �Ĵ� �� ������ �̵�
	@RequestMapping(value="dine_detail")
	public String viewDineDetail(DineVO vo, Model model) {
		// dine_name ���� ����
		//System.out.println("vo: "+vo.toString());
		
		List<MenuVO> menuList = menuService.getMenuListByDineName(vo.getDine_name());
		model.addAttribute("menuList", menuList);	// �Ĵ��� ��� �޴� ����
		
		//for(MenuVO menu : menuList) {System.out.println("menuList: "+menu.toString());}
		
		DineVO dine = dineService.getDine(vo.getDine_name());	// �̸����� �Ĵ� ��ü �˻�
		model.addAttribute("dine", dine);		// �Ĵ� ����
		//System.out.println("dineVO: " + dine);
		
		return "dine/dineDetail";
		
	}
	
	
	
	
}








