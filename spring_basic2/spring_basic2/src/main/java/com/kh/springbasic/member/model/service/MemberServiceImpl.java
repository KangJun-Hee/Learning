package com.kh.springbasic.member.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springbasic.member.model.dao.MemberDao;
import com.kh.springbasic.member.model.vo.Member;

@Service  // 서비스임을 알리고, Bean을 통해서 자동으로 객체 생성되는 것!
public class MemberServiceImpl implements MemberService {
	
	//기존 서블릿에서 dao를 활용하던 방법 
	// private MemberDAO dao = new MemberDaoImpl();
	
	@Autowired // 사용자가 별도로 객체를 만들지 않고 
				//BeanFactory로 부터 객체의 관리를 위임하는
				// 어노테이션이다. 
	private MemberDao dao;
				//type은 MemberDao 가 되고 실제 생성되는 
				//객체는 MemberDAOImpl가 된다.
	
	@Override
	public int joinMember(Member member) {
		return dao.insertMember(member);
	}

	@Override
	public List<Member> getAllList() {
		return dao.selectAll();
	}

	@Override
	public Member login(String id) {
		return dao.selectById(id);
	}	

}
