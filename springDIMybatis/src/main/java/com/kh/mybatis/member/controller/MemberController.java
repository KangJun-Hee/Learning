package com.kh.mybatis.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.mybatis.member.Member;
import com.kh.mybatis.member.model.service.MemberService;

@Controller
public class MemberController {

	// 컨트롤러서 서비스로 연결해야 함
	// 연결도와주는 게 bean
	@Autowired
	private MemberService service;

	@RequestMapping("/member/index.do")
	public String index() {
		return "member/index";
	}

	// Join
	// 실제 데이터 저장하는 DB, 같은 파일안에 리스트저장
	// mybatis이용해서 데이터저장
	@RequestMapping("/member/memberEnroll.do")
	public String memberEnroll(Model model, Member m) {
		System.out.println("가입정보:" + m);
		int result = service.joinMember(m);

		// 만약 1이 온다면 모델객체에 "msg", "회원가입이 성공하였습니다"
		// return 0이다 redirect:error.do
		if(result > 0) {
			model.addAttribute("msg","회원가입성공쓰");
			return "/member/index";
		}else {
			return "redirect:error.do";
		}
	}

	// 회원목록조회
	@RequestMapping("/member/memberList.do")
	public String memberList(Model model) {
		List<Member> list = service.getMemberList();

		model.addAttribute("list", list);

		return "/member/memberList";
	}

	// 단일검색 메서드 정의하기
	@RequestMapping("/member/memberSearch.do")
	String memberSearch(Model model, String id) {

		Member m = service.searchMember(id);

		// 찾았으면 /member/memberView
		if (m != null) {
			model.addAttribute("m",m);
			return "/member/memberView";
		} else {
			// 찾은 데이터가 member의 객체가 없다면 null이다. 바로 에러페이지로 리다이렉트하기
			return "redirect:error.do";
		}

	}

	// 멤버 탈퇴
	@RequestMapping("/member/memberDel.do")
	public String memberDel(Model model,String id) {
		int result = service.deleteMember(id);
		
		if(result > 0) {
			model.addAttribute("msg","회원탈퇴에 성공쓰");
			return "/member/index";
		} else {
			return "redirect:error.do";
		}
	}

	@RequestMapping("/member/error.do")
	public String errorPage(String msp) {
		return "common/error";
	}

}
