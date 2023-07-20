package com.kh.spring_mybaits.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.spring_mybaits.vo.MemberVO;

public interface MemberService {

	public List listMembers() throws Exception;
	public int addMember(MemberVO memberVO) throws Exception;
	public MemberVO login(MemberVO memberVO) throws Exception;
	public int removeMember(String id) throws Exception;

}
