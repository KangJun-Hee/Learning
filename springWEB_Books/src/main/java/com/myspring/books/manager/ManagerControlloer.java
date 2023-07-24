package com.myspring.books.manager;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManagerControlloer {
	@Autowired
	ManagerDAO managerPro;
	
	
	@RequestMapping("/")
	public String index(HttpServletRequest req) {
		return "redirect:/managerMain.do";
	}
	
	@RequestMapping("/managerMain.do")
	public String managerMain(Model model) {
		model.addAttribute("type",new Integer(0));
		model.addAttribute("cont","01_02_managerMain.jsp");
		
		return "00_index";
	}
	
	@RequestMapping("/managerLoginPro.do")
	public String managerLoginPro(Model model,HttpServletRequest req) {
		//넘어온데이터 꺼내기!
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		
		//DB랑 연동해 사용자의 인증을 처리
		int check = managerPro.userCheck(id,passwd);
				
		//해당뷰(응답페이지)로 보낼 내용을 req속성에 지정
		req.setAttribute("check", new Integer(check));
		req.setAttribute("id", id);
		
		model.addAttribute("cont","01_03_managerLoginPro.jsp");
		
		return "00_index";
	}
}
