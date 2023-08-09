package com.ncs.test.login.controller;

import java.io.Writer;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ncs.test.login.model.service.MemberService;
import com.ncs.test.login.model.vo.Member;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;

	@RequestMapping("/home/login.do")
	public String login() {
		return "home/login";
	}

	@RequestMapping("/home/loginMember.do")
	public ModelAndView loginMember(ModelAndView model, Member member) {

		int result = service.loginMember(member);
		System.out.println(result);
		if (result > 0) {
			model.addObject("msg", "로그인 성공~");
			model.setViewName("home/success");
		} else {
			model.setViewName("redirect:error.do");
		}
		return model;
	}
}
