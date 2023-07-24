package com.myspring.books.manager;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("managerDAO")
public class ManagerDAO {
	
	//mybatis에 객체를 생성 sqlsession
	@Autowired
	private SqlSession sqlSession;
	
	public int userCheck(String id,String passwd) {
		int check = -1;
		String dbpw = sqlSession.selectOne("mapper.manager.loginById,id");
		
		if(passwd.equals(dbpw)) {
			check = 1;
		}
		
		return check;
	}
}
