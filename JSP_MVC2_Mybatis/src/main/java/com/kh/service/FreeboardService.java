package com.kh.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.dao.FreeboadDAO;
import com.kh.mybatis.MySession;
import com.kh.vo.FreeboardVO;

public class FreeboardService {
	
	// 싱글톤을 이용하기 위해서 객체 생성하고 주소값 반환하는 명령문
		private static FreeboardService instance = new FreeboardService();
		private FreeboardService() { }
		public static FreeboardService getInatance() {
			return instance;
		}
		
	// insertOK.jsp에서 호출되는 메인글이 저장된 객체를 넘겨받고 mapper
	// 를 얻어온 후 메인글에 저장하는 FreeboardDAO 클래스의 insert sql명령문을
		//실행 할 수 있도록 DAO안에 있는 메서드를 호출한다. 
		
		public void insert(FreeboardVO vo) {
			System.out.println("FreeboardService 의 메서드 insert()");
			//데이터베이스 정보 획득
			SqlSession mapper = MySession.getSession();
			
			// 실제 데이터베이스를 처리하는 DAO 부른다.
			FreeboadDAO.getInatance().insert(mapper, vo);;
			
			// 오라클은 저장 !
			mapper.commit();
			mapper.close();
		}		
}
