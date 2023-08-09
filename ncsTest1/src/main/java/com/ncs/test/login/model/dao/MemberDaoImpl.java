package com.ncs.test.login.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ncs.test.login.model.vo.Member;

@Repository
public class MemberDaoImpl implements MemberDao {
	private List<Member> list = new ArrayList<Member>();

	@Override
	public int loginMember(Member member) {
		if (member.getId() == "kjh") {
			return 0;
		}
		return 1;
	}

	@Override
	public List<Member> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
