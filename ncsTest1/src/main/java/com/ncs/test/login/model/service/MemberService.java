package com.ncs.test.login.model.service;

import java.util.List;

import com.ncs.test.login.model.vo.Member;

public interface MemberService {
	int loginMember(Member member);
	List<Member> getAllList();
	Member login(String id);
}
