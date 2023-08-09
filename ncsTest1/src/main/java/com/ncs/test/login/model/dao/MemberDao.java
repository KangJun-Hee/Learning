package com.ncs.test.login.model.dao;

import java.util.List;

import com.ncs.test.login.model.vo.Member;

public interface MemberDao {
	int loginMember(Member member);
	List<Member> selectAll();
	Member selectById(String id);
}
