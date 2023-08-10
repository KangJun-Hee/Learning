package com.kh.mybatis.member.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.mybatis.member.Member;

public interface MemberDao {
	//실제 DB로 전송!
	int insertMember(SqlSessionTemplate session,Member member);
	List<Member> selectMemberAll(SqlSessionTemplate session);
	Member selectMemberById(SqlSessionTemplate session,String id);
	int deleteMember(SqlSessionTemplate session,String id);
}
