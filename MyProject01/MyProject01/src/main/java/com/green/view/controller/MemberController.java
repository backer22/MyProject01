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
			}else {		// 일반 member
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
		List<DineVO> dineList = dineService.getAllDine();	// 식당 목록들 불러오기
		for(DineVO dinevo : dineList) {
			int room = dinevo.getRoom()-1;	// exclude 0(no assign)
			dinevo.setRoom(room);
		}
		
		model.addAttribute("dineList", dineList);	// 식당 목록들
		
		MemberVO vo = (MemberVO) session.getAttribute("loginUser");		// id+pwd		
		List<ReserveVO> reserveList = reserveService.getReserveListById(vo);	// 예약 목록 불러오기
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
		model.addAttribute("id", id);	// 화면 이동
		
		return "member/idcheck";
	}
	
	@RequestMapping(value="id_check_form", method=RequestMethod.POST)
	public String idCheckAction(@RequestParam(value="id", defaultValue = "", required = false) String id, Model model) {
		// 실제 id 체크
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
		
	@RequestMapping(value="id_check_confirmed")	// 아이디 확인, 액션
	public String idCheckConfirmed(MemberVO mVO, Model model) {
		
		model.addAttribute("reid", mVO.getId());
		
		return "member/join";
	}
	
	@RequestMapping(value="join", method = RequestMethod.POST )	// 회원 가입
	public String joinAction(MemberVO vo) {
		
		memberService.insertMember(vo);
		
		return "member/login";
	}
	
	
	
	// 일반 회원 메인 페이지 >> 식당 상세 페이지 이동
	@RequestMapping(value="dine_detail")
	public String viewDineDetail(DineVO vo, Model model) {
		// dine_name 으로 받음
		//System.out.println("vo: "+vo.toString());
		
		List<MenuVO> menuList = menuService.getMenuListByDineName(vo.getDine_name());
		model.addAttribute("menuList", menuList);	// 식당의 모든 메뉴 정보
		
		//for(MenuVO menu : menuList) {System.out.println("menuList: "+menu.toString());}
		
		DineVO dine = dineService.getDine(vo.getDine_name());	// 이름으로 식당 전체 검색
		model.addAttribute("dine", dine);		// 식당 정보
		//System.out.println("dineVO: " + dine);
		
		return "dine/dineDetail";
		
	}
	
	
	
	
}








