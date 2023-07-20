package com.kh.spring_mybaits.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.kh.spring_mybaits.vo.MemberVO;

public interface MemberDAO {

	public List selectAllMemberList() throws DataAccessException;
	public int insertMember(MemberVO memberVO) throws DataAccessException;
	
	public MemberVO loginById(MemberVO memberVO) throws DataAccessException;
	public int deleteMember(String id) throws DataAccessException;
		
}
