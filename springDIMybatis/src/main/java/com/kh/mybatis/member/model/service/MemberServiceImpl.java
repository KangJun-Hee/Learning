package com.kh.mybatis.member.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kh.mybatis.member.Member;
import com.kh.mybatis.member.model.dao.MemberDao;

@Service("memberService")//서비스임을 알리고, Bean을 통해 자동으로 객체생성되는 것
public class MemberServiceImpl implements MemberService {
	
	@Qualifier("memberDao") // 없어도 되는 문장
	@Autowired//사용자가 별도로 객체 만들지 않고 BeanFactory로부터 객체의 관리를 위임하는@. 
	private MemberDao dao;//타입은 memberdao되고 실제생성객체는 memberdaoImpl가 됨
	
	//mybatis연결위해 sqlSession객체를 생성해야 함
	//root-context.xml에서 정의한 bean
	@Qualifier("sqlSession")
	@Autowired
	private SqlSessionTemplate session;

	@Override
	public int joinMember(Member member) {
		//service서 dao요청
		return dao.insertMember(session, member);
	}

	@Override
	public Member searchMember(String id) {
		return dao.selectMemberById(session, id);
	}

	@Override
	public List<Member> getMemberList() {
		return dao.selectMemberAll(session);
	}

	@Override
	public int deleteMember(String id) {
		return dao.deleteMember(session, id);
	}
	
}
