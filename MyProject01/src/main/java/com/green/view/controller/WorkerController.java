package com.green.view.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.green.biz.business.BusinessService;
import com.green.biz.dine.DineService;
import com.green.biz.dine.DineVO;
import com.green.biz.dine.MenuService;
import com.green.biz.dine.MenuVO;
import com.green.biz.member.MemberService;
import com.green.biz.member.MemberVO;
import com.green.biz.reserve.ReserveService;
import com.green.biz.reserve.ReserveVO;
import com.green.biz.worker.WorkerService;
import com.green.biz.worker.WorkerVO;

@Controller
public class WorkerController {

	@Autowired
	WorkerService workerService;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	ReserveService reserveService;
	
	@Autowired
	DineService dineService;
	
	@Autowired
	BusinessService businessService;
	
	@Autowired
	MenuService menuService;
	
	@RequestMapping(value="login_worker_form", method=RequestMethod.GET)
	public String loginWorkerForm() {
		
		return "worker/login_worker";
	}
	
	@RequestMapping(value="login_worker", method=RequestMethod.POST)
	public String loginWorkerAction(WorkerVO vo, Model model, HttpSession session) {
		//System.out.println(vo);
		WorkerVO admin = workerService.loginWorker(vo);
		
		if(admin != null) {
			session.setAttribute("admin", admin);
			//System.out.println(admin);
			

			
			return "redirect:/worker_main";
		}else {//login fail
			return "redirect:/index";
		}
		
	}
	
	@RequestMapping(value="worker_main")
	public String workerMainView(HttpSession session, Model model) {
		
		WorkerVO admin = (WorkerVO)session.getAttribute("admin");
		
		if(admin != null) {
			
			List<MemberVO> allBusinessOwner=workerService.getAllBusinessOwner();
			model.addAttribute("allBusinessOwner", allBusinessOwner);
			//System.out.println(allBusinessOwner);
			//for(MemberVO owner : allBusinessOwner) {System.out.println(owner);}
			
			List<MemberVO> allMember = workerService.getAllMember();
			model.addAttribute("allMember", allMember);
			//System.out.println(allMember);
			//for(MemberVO member : allMember) {System.out.println(member);}			
			
			return "worker/worker_main";
		}else {
			return "redirect:/index";
		}
		
		
	}
	
	@RequestMapping(value="w_logout")
	public String logoutWorkerAction(SessionStatus status) {
		status.setComplete();
		return "redirect:/index";
	}
	
	@RequestMapping(value="admin")	// 어드민 화면으로 이동
	public String loginWorkerView() {
		return "worker/login_worker";
	}
	
	@RequestMapping(value="worker_businessDetail")
	public String workerBusinessDetail(MemberVO vo, Model model, HttpSession session) {
		// id 받음
		WorkerVO admin = (WorkerVO) session.getAttribute("admin");
		if(admin == null) {
			return "redirect:login_worker_form";
		}else {
			// 특정 회원 정보
			MemberVO member = memberService.getMemberById(vo);
			model.addAttribute("member", member);
			
			// 식당 정보
			DineVO dine = businessService.getDineById(member.getId());
			model.addAttribute("dine", dine);
			
			// 식당의 예약 정보
			List<ReserveVO> dineReserves = businessService.getAllReserveByDineName(dine);
			model.addAttribute("dineReserves", dineReserves);
			
			List<MenuVO> menuList = menuService.getMenuListByDineName(dine.getDine_name());
			model.addAttribute("menuList", menuList);
			
			return "worker/worker_businessDetail";
		}
	}
	
	@RequestMapping(value="worker_memberDetail")
	public String workerMemberDetail(MemberVO vo, HttpSession session, Model model) {
		// id 받음
		WorkerVO admin = (WorkerVO) session.getAttribute("admin");
		if(admin == null) {
			return "redirect:login_worker_form";
		}else {
			MemberVO member = memberService.getMemberById(vo);
			model.addAttribute("member", member);
			
			List<ReserveVO> reserveList = reserveService.getReserveListById(vo);
			model.addAttribute("reserveList", reserveList);
			
			//System.out.println(reserveList);
			
			return "worker/worker_memberDetail";
		}
	}
	
	@RequestMapping(value="worker_reserveDetail")
	public String workerReserveDetail(HttpSession session, ReserveVO vo, Model model) {
		// r_seq 
		WorkerVO admin = (WorkerVO) session.getAttribute("admin");
		if(admin == null) {
			return "redirect:login_worker_form";
		}else {
			ReserveVO reserve = reserveService.getReserve(vo);
			model.addAttribute("reserve", reserve);
			
			List<ReserveVO> reserveDetailList = reserveService.getReserveDetailListByR_seq(vo);
			model.addAttribute("reserveDetailList", reserveDetailList);
			
			return "worker/worker_reserveDetail";
		}
	}
	

	
	
	
	
	
	
	
	
}
