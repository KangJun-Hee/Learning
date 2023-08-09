package com.kh.springbasic.member.model.service;

import java.util.List;

import com.kh.springbasic.member.model.vo.Member;

public interface MemberService {

	int joinMember(Member member);
	List<Member> getAllList();
	Member login(String id);
}
