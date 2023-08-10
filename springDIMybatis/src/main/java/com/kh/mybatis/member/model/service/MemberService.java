package com.kh.mybatis.member.model.service;

import java.util.List;

import com.kh.mybatis.member.Member;

public interface MemberService {
	int joinMember(Member member);
	Member searchMember(String id);
	List<Member> getMemberList();
	int deleteMember(String id);
	
	
}
