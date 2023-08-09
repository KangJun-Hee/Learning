package com.ncs.test.login.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.test.login.model.dao.MemberDao;
import com.ncs.test.login.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao dao;

	@Override
	public List<Member> getAllList() {
		return null;
	}

	@Override
	public int loginMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Member login(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
