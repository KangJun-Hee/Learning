package com.kh.mybatis.member.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.mybatis.member.Member;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao{

	@Override
	public int insertMember(SqlSessionTemplate session, Member member) {
		return session.insert("memberMapper.insertMember");
	}

	@Override
	public List<Member> selectMemberAll(SqlSessionTemplate session) {
		//selectList():여러개의 객체를 리스트로 반환해 주는 메서드
		return session.selectList("memberMapper.selectMemberAll");
	}

	@Override
	public Member selectMemberById(SqlSessionTemplate session, String id) {
		
		return session.selectOne("memberMapper.selectMemberById",id);
	}

	@Override
	public int deleteMember(SqlSessionTemplate session, String id) {
		return session.delete("memberMapper.deleteMember",id);
	}

}