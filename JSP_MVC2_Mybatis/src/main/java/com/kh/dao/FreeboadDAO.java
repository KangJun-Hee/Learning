package com.kh.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.vo.FreeboardVO;

public class FreeboadDAO {

	// 싱글톤을 이용하기 위해서 객체 생성하고 주소값 반환하는 명령문
	private static FreeboadDAO instance = new FreeboadDAO();
	private FreeboadDAO() { }
	public static FreeboadDAO getInatance() {
		return instance;
	}
	
	// FreeboardService 클래스에서 호출되는 mapper와 메인글이 
	// 저장된 객체를 넘겨받고 freeboard.xml로 insert sql명령을
	// 실행하는 메서드 
	public void insert(SqlSession mapper,FreeboardVO vo) {
		System.out.println("FreeboadDAO의 insert() 실행");
		mapper.insert("insert",vo);
		
	}
	
	
	
	
}






