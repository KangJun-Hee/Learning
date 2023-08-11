package com.kh.mvc.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.mvc.member.model.vo.Member;
import com.kh.mvc.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j 
@SessionAttributes("loginMember") // loginMember를 model에서 처리할 때 세션으로 처리할 수있도록 도와주는 어노테이션 
@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	@PostMapping("/login")
	String login(Model model,String userId,String userPwd) {
		
		log.info("id:" + userId + ",pwd : "+userPwd);
		
		Member loginMember = service.login(userId,userPwd);
		
		if(loginMember != null) {
			// 성공 
			model.addAttribute("loginMember",loginMember); //세션에 저장되는 코드  @SessionAttributes
			return "redirect:/";
		}else {
			//실패 
			model.addAttribute("msg","아이디 패스워드가 잘못되었습니다.");
			model.addAttribute("location","/");
			return "common/msg";
		}
	}
	// 로그아웃 
	
	
	
	// 가입 페이지 요청 
	@GetMapping("/member/enroll")
	public String enrollPage() {
		log.info("가입 페이지 요청");
		return "member/enroll";
	}
	
	//중복확인 Ajax 회원아이디 확인
	@GetMapping("/member/idCheck")
	public ResponseEntity<Map<String,Object>> idCheck(String id) {
		log.info("아이디 중복 확인: "+ id);
		boolean result = service.validate(id);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("validate",result);
		
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		
	}
	@PostMapping("/member/update")
	public String update(Model model,
					@ModelAttribute Member updateMember,
					@SessionAttribute(name = "loginMember",required =false)Member loginMember) {
		
		// 무조건 바로 데이터베이스로 처리하는 service부르지 말고 
		// 예외! 
		log.info("update 요청 , updateMember :" + updateMember);
		if(loginMember == null || loginMember.getId().equals(updateMember.getId())== false) {
			
			model.addAttribute("msg","잘못된 접근입니다.!");
			model.addAttribute("location","/");
			return "common/msg";
		}
		
		updateMember.setNo(loginMember.getNo());
		int result = service.sava(updateMember);
		
		if(result > 0) {
			model.addAttribute("loginMember",service.findById(loginMember.getId()));
			model.addAttribute("msg","회원 정보를 수정하였습니다.");
			model.addAttribute("location","/member/view");
			
		}else {
			model.addAttribute("msg","회원 정보 수정에 실패하였습니다.");
			model.addAttribute("location","/member/view");
		}
		
		return "common/msg";
	}
	
	@GetMapping("/member/view")
	public String memberView() {
		log.info("회원 정보 페이지 요청");
		return "member/view";
	}
	
	@GetMapping("/member/updatePwd")
	public String updatePwdPage() {

		return "/member/updatePwd";
	}
	
	
	
	
	
	
}
