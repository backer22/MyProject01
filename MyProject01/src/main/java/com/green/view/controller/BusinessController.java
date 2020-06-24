package com.green.view.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.green.biz.business.BusinessService;
import com.green.biz.dine.DineService;
import com.green.biz.dine.DineVO;
import com.green.biz.dine.MenuService;
import com.green.biz.dine.MenuVO;
import com.green.biz.member.MemberService;
import com.green.biz.member.MemberVO;
import com.green.biz.reserve.MenuSumDailyVO;
import com.green.biz.reserve.ReserveService;
import com.green.biz.reserve.ReserveVO;

@Controller
public class BusinessController {

	@Autowired
	MemberService memberService;
	
	@Autowired
	DineService dineService;
	
	@Autowired
	BusinessService businessService;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	ReserveService reserveService;
	
	@RequestMapping(value="login_business")
	public String loginBusiness(Model model, HttpSession session) {
		
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		//System.out.println(loginUser);	// no problem
		if(loginUser == null) {
			return "redirect:login_form";
		}else {
			model.addAttribute("loginUser", loginUser);	// 회원 정보
			
			//식당 정보
			DineVO dine = new DineVO();
			dine = businessService.getDineById(loginUser.getId());

			
			//System.out.println(dine); //no problem
			model.addAttribute("dine", dine);	// 식당 정보
			
			if(!session.getAttribute("businessyn").equals("Y")) {
				return "redirect:/memberMain";
			}
			
			if(dine != null) {
			// 식당의 모든 예약
			List<ReserveVO> reserveList =businessService.getAllReserveByDineName(dine);
			//for(ReserveVO res : reserveList) {System.out.println(res);}
			model.addAttribute("reserveList", reserveList);	// 내 식당의 총 예약
			//이전 예약 정보
			List<ReserveVO> oldReserves = reserveService.oldReserves(dine.getDine_name());
			model.addAttribute("oldReserves", oldReserves);
			// 오늘 예약 정보
			List<ReserveVO> nowReserves =  reserveService.nowReserves(dine.getDine_name());
			model.addAttribute("nowReserves", nowReserves);
			// 새 예약 정보
			List<ReserveVO> newReserves =  reserveService.newReserves(dine.getDine_name());
			model.addAttribute("newReserves", newReserves);			
			
			// 날짜별 메뉴별 총 주문량
			List<MenuSumDailyVO> menuQuantityList = businessService.getMenuQuantityListByDine(dine);
			//for(MenuSumDailyVO msd : menuQuantityList) {System.out.println(msd);}
			model.addAttribute("menuQuantityList", menuQuantityList);
			// 오늘 메뉴별 총 주문량
			List<MenuSumDailyVO> menuQuantityListToday = businessService.getMenuQuantityListByDineToday(dine);
			model.addAttribute("menuQuantityListToday", menuQuantityListToday);
			}
			
		}
		return "business/business_main";
	}
	@RequestMapping(value="business_dine_join", method = RequestMethod.GET)
	public String businessDineJoinView() {
		return "business/business_dine_join";
	}
	
	@RequestMapping(value="business_dine_join", method = RequestMethod.POST)
	public String businessDineJoin(@RequestParam(value="uploadFile") MultipartFile uploadFile,
			HttpSession session, DineVO dine) {
		
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if(loginUser==null) {
			return "redirect:login_form";
		}else {
			dine.setId(loginUser.getId());
			DineVO dineTest = dineService.getDine(dine.getDine_name());
			if(dineTest !=null) {	// 식당 이미 존재
				System.out.println("you have dine!");
				return "redirect:/business_main";
			}else {	// 식당 등록
				// uploadFile 
				String fileName="";
				
				//file upload
				if(!uploadFile.isEmpty()) {
					String root_path = session.getServletContext().getRealPath("WEB-INF/resources/dine_image/");
					System.out.println("ROOT 경로: "+root_path);
					// uploaded file's name
					fileName = uploadFile.getOriginalFilename();
					
					try {
						File file = new File(root_path + fileName);
						uploadFile.transferTo(file);
					}catch(IllegalStateException e) {
						e.printStackTrace();
					}catch(IOException e) {
						e.printStackTrace();
					}
				}
				dine.setSeat_image(fileName);
				
				dineService.insertDine(dine);
				return "redirect:/login_business";
			}
		}
		
	}
	
	@RequestMapping(value="business_dine_update_form")
	public String businessUpdateDineForm(DineVO vo, Model model, HttpSession session ) {
		
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "redirect:login_form";
		}else {
		DineVO dine = dineService.getDine(vo.getDine_name());	// DineVO.dine_name	// just in case
		model.addAttribute("dine", dine);
		model.addAttribute("loginUser", loginUser);
		
		return "business/business_dine_update";
		}
	}
	
	@RequestMapping(value="business_dine_update_action", method = RequestMethod.POST)
	public String businessUpdateDineAction(@RequestParam(value="uploadFile") MultipartFile uploadFile,
			DineVO dine, HttpSession session) {
		
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if(loginUser == null) {
			return "redirect:login_form";
		}else {
			String fileName ="";
			
			if(!uploadFile.isEmpty()) {
				String root_path = session.getServletContext().getRealPath("WEB-INF/resources/dine_image/");
				System.out.println("ROOT PATH: "+ root_path);
				
				fileName = uploadFile.getOriginalFilename();
				
				try {
					File file= new File(root_path + fileName);
					uploadFile.transferTo(file);
				}catch(IllegalStateException e){
					e.printStackTrace();
				}catch(IOException e) {
					e.printStackTrace();
				}
				
			}
			dine.setSeat_image(fileName);
			
			dine.setId(loginUser.getId());
			
			int room = dine.getRoom()+1;	//update
			dine.setRoom(room); 	// 0 + room.length
			
			dineService.updateDine(dine);	// dine_name, location, category, room, where id 
						
			return "redirect:/login_business";
		}
	}
	
	@RequestMapping(value="business_menuList_form")
	public String businessMenuListForm(HttpSession session, Model model) {
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		if(loginUser == null) {
			return "redirect:login_form";
		}else {
			DineVO dine = businessService.getDineById(loginUser.getId());
			
			List<MenuVO> menuList = menuService.getMenuListByDineName(dine.getDine_name());
			model.addAttribute("menuList", menuList);
			
			return "business/business_menuList";
		}		
	}
	
	@RequestMapping(value="business_addmenu_form")
	public String businessAddMenuForm() {
		
		return "business/business_addmenu";
	}
	
	@RequestMapping(value="addMenuAction")
	public String addMenuAction(@RequestParam(value="uploadFile") MultipartFile uploadFile,
			MenuVO vo, HttpSession session, Model model) {
		
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if(loginUser == null) {
			return "redirect:login_form";
		}else {
			// file upload
			String fileName="";
			
			//file upload
			if(!uploadFile.isEmpty()) {
				String root_path = session.getServletContext().getRealPath("WEB-INF/resources/menu_image/");
				System.out.println("ROOT 경로: "+root_path);
				// uploaded file's name
				fileName = uploadFile.getOriginalFilename();
				
				try {
					File file = new File(root_path + fileName);
					uploadFile.transferTo(file);
				}catch(IllegalStateException e) {
					e.printStackTrace();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
			vo.setMenu_image(fileName);
			
			DineVO dine=businessService.getDineById(loginUser.getId());
			vo.setDine_name(dine.getDine_name());
			System.out.println(vo);//ok
			model.addAttribute("dine", dine);
			businessService.insertMenu(vo);//????
			
			return "redirect:business_menuList_form";
		}
		
	}
	
	@RequestMapping(value="deleteMenuAction")
	public String deleteMenuAction(MenuVO menu) {
		// receive menu_name
		//menu = menuService.getMenuByName(menu);
		businessService.deleteMenu(menu);
		
		return "redirect:business_menuList_form";
	}
	
	@RequestMapping(value="updateMenuForm")//need file update
	public String updateMenu(MenuVO vo, Model model) {
		// vo > menu_name
		MenuVO menu = menuService.getMenuByName(vo.getMenu_name());
		model.addAttribute("menu", menu);
		
		return "business/business_menu_update";
	}
	
	@RequestMapping(value="updateMenu")
	public String updateMenuAction(@RequestParam(value="uploadFile") MultipartFile uploadFile,
			MenuVO vo, HttpSession session) {
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if(loginUser == null) {
			return "redirect:login_form";
		}else {
			String fileName="";
			
			if(!uploadFile.isEmpty()) {
				String root_path = session.getServletContext().getRealPath("WEB-INF/resources/menu_image/");
				System.out.println("Root Path: "+root_path);
				
				fileName = uploadFile.getOriginalFilename();
				
				try {
					File file = new File(root_path + fileName);
					uploadFile.transferTo(file);
				}catch(IllegalStateException e) {
					e.printStackTrace();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
			vo.setMenu_image(fileName);
						
			businessService.updateMenu(vo);
			
			return "redirect:business_menuList_form";
		}

		
	}
	
	@RequestMapping(value="business_reserveDetail")
	public String businessReserveDetailView(ReserveVO rVO, Model model) {
		
		ReserveVO reserve = reserveService.getReserve(rVO);	//r_seq로 reserve검색
		model.addAttribute("reserve", reserve);
		
		List<ReserveVO> reserveDetailList = reserveService.getReserveDetailListByR_seq(rVO);
		model.addAttribute("reserveDetailList", reserveDetailList);
		
		return "business/business_reserveDetail";
	}
	
	@RequestMapping(value="reserveCancelByB", method=RequestMethod.POST)
	public String reserveCancelActionByB(ReserveVO vo) {
		// hidden r_seq
		reserveService.deleteReserveDetailByR_seq(vo);
		reserveService.deleteReserveByR_seq(vo);
		
		return "redirect:/login_business";
	}
	
		
	
	
	
}
















