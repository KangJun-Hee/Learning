package com.kh.spring_mybaits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring_mybaits.dao.MemberDAO;
import com.kh.spring_mybaits.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public List listMembers() throws Exception {
		
		List memberList = null;
		memberList = memberDAO.selectAllMemberList();
		
		return memberList;
	}

	@Override
	public int addMember(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberVO login(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int removeMember(String id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
