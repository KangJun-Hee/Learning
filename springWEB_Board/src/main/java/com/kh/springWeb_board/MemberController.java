package com.kh.springWeb_board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {

	@Autowired
	MemberDAO dao;

//	@ModelAttribute("cp")
//	public String getContextPath(HttpServletRequest request,Model model) {
//		
//		// Model 객체는 Controller에서 생성된 데이터를 담아서 
//		// view 전달할 때 사용하는 객체이다.
//		
//		// @ModelAttribute("cp") 자동으로 매핑시켜준다. 
//		//String cp = request.getContextPath();
//		//model.addAttribute("cp",cp);
//		// view 전달
//		
//		return request.getContextPath(); //value
//	}
	@ModelAttribute("cp")
	public String getContextPath(HttpServletRequest request) {
		
//		String cp = request.getContextPath();
//		model.addAttribute("cp", cp);
		
		return request.getContextPath();
	}

	@RequestMapping(value = "/member/index")
	public String index() {
		System.out.println("====index()====");

		return "member/index";
	}

	@RequestMapping(value = "/member/userMenu")
	public String userMenu() {
		System.out.println("====userMenu()====");

		return "member/userMenu"; // 뷰 페이지 연결
	}

	@RequestMapping(value = "/member/joinForm")
	public String joinForm() {
		System.out.println("====joinForm()====");

		return "member/joinForm"; // 뷰 페이지 연결
	}

	// 회원가입을 하면 처리하는 내용
	// 새로운 페이지로 요청을 하면 된다. list화면으로 넘어갈 것!
	@RequestMapping(value = "/member/joinPro", method = RequestMethod.POST)
	public String joinPro(Member member) {
		System.out.println("====joinPro()====");

		// 입력한 멤버의 정보를 받아와서 실제 데이터베이스에 저장하는 메서드
		// dao가서 member을 저장하는 내용 실행하는 메서드() 호출
		dao.memberJoin(member);

		return "redirect:/member/list"; // 새로운 페이지 즉 새로운 컨트롤러 요청을 해야된다.
	}

	@RequestMapping(value = "/member/loginForm")
	public String loginForm() {
		System.out.println("====loginForm()====");

		return "member/loginForm"; // 뷰 페이지 연결
	}

	@RequestMapping(value = "/member/loginPro", method = RequestMethod.POST)
	public String loginPro(Member member, Model model) {
		System.out.println("====loginPro()====");

		int check = dao.checkMember(member);

		model.addAttribute("id", member.getId());
		model.addAttribute("check", check);

		return "member/loginPro"; // 뷰 페이지 연결
	}

	@RequestMapping(value = "/member/logout")
	public String logout(HttpServletRequest request, HttpSession session) {
		System.out.println("====logout()====");

		session.removeAttribute("log");

		return "member/logoutPro";
	}
	
	@RequestMapping(value = "/member/list")
	public String list(Model model) {
		System.out.println("====list()====");

		ArrayList<Member> memberList = dao.getMemberList();
			
		model.addAttribute("memberList",memberList);
		
		return "member/list";
	}
	@RequestMapping(value = "/member/modifyForm")
	public String modifyForm(HttpServletRequest req,Model model,HttpSession session) {
		System.out.println("====modifyForm()====");
		
		if(session.getAttribute("log") != null){
			String id = (String)session.getAttribute("log");
			
			Member member = dao.getOneMember(id);
			model.addAttribute("member",member);			
		}				
		return "member/modifyForm";
	}
	@RequestMapping(value = "/member/modifyPro", method = RequestMethod.POST)
	public String modifyPro(Member member,HttpServletRequest req
													,HttpSession session) {
		System.out.println("====modifyPro()====");
		
		if(session.getAttribute("log") != null){
			String id = (String)session.getAttribute("log");
			
			Member bean = dao.getOneMember(id);
			bean.setPw(member.getPw());
			bean.setEmail(member.getEmail());
			
			dao.updateMember(bean);
		}
				
		return "redirect:/member/userMenu";
	}
	
	
	
	

}
