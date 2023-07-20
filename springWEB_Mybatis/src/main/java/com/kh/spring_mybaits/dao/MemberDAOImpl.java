package com.kh.spring_mybaits.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.kh.spring_mybaits.vo.MemberVO;



@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession sqlSession;

	
	@Override
	public List selectAllMemberList() throws DataAccessException {
		
		List<MemberVO> memberList = null;
		memberList = sqlSession.selectList("mapper.member.selectAllMemberList");
		
		return memberList;
	}

	@Override
	public int insertMember(MemberVO memberVO) throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberVO loginById(MemberVO memberVO) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteMember(String id) throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
