package com.kh.service;

import java.sql.SQLException;
import java.util.HashMap;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.kh.dao.GuestbookDAO;
import com.kh.ibatis.MyAppSqlConfig;
import com.kh.vo.GuestbookList;
import com.kh.vo.GuestbookVO;
import com.kh.vo.Param;

public class SelectService {

	private static SelectService instance = new SelectService();

	private SelectService() { }

	public static SelectService getInatance() {
		return instance;
	}

	// list.jsp에서 호출되는 화면에 표시할 페이지 번호를 넘겨 받고 
	// mapper를 얻어온 후 guestbookDAO 클래스의 한페이지 분량의 글 목록을 
	// 얻어오는 select sql명령문을 실행하는 메서드를 만들기
	
	public GuestbookList selectList(int currentPage) {
		
		System.out.println("SelectService() 메서드 실행");
		SqlMapClient mapper = MyAppSqlConfig.getSqlMapInstance();
		
		// 1페이지 분량의 글 목록과 페이징 작업에 사용할 8개의 변수를 저장해서 
		// 리턴시킬 객체를 선언한다. 
		GuestbookList guestbookList = null;
		
//		GuestbookDAO 클래스에 2번 접근 접근해서 sql 명령을 실행해야 하므로 
		// GuestbookDAO 미리 얻어둔다.
		
		GuestbookDAO dao = GuestbookDAO.getInatance();
		
		try {
		// 1페이지당 표시할 글의 개수를 정한다.
		int pageSize = 10;
		
		// 테이블에 저장된 전체 글의 개수를 얻어온다. 
		int totalCount = dao.selectCount(mapper);
		
		// pageSize ,totalCount, currentPage  이용해서 guestbooklist객체를
		// 생성한다. 
		
		guestbookList = new GuestbookList(pageSize,totalCount,currentPage);
				
		
		HashMap<String, Integer> hmap = new HashMap<>();
		hmap.put("startNo",guestbookList.getStartNo());
		hmap.put("endNo",guestbookList.getEndNo());
		
		// put("pageSize",guestbookList.getPageSize())
		
		// 1페이지 분량의 글 목록을 얻어와서 guestbookList클래스 객체 
		// 생성했으니 Arraylist에 저장 
		guestbookList.setList(dao.selectList(mapper,hmap));
		
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
		return guestbookList;
	}	
	
	//호출되는 수정또는삭제 글번호를 넘겨받고
	//mapper를 얻어온 후 DAO클래스로 가서 글1건을 얻어오는 select sql명령을
	//실행하는 메서드를 호출한다~
	public GuestbookVO selectByIdx(int idx) {
		System.out.println("SelectService의 selectByIdx() 메서드 실행!");
		SqlMapClient mapper = MyAppSqlConfig.getSqlMapInstance();
		
		//글 1건 갖고오면 저장(객체저장후 리턴)
		GuestbookVO vo = null;
		
		try {
			vo = GuestbookDAO.getInatance().selectByIdx(mapper,idx);
		} catch (SQLException e) {
			e.printStackTrace();//에러 어디서 났나 보고 싶다~
		}
		return vo;
	}
	
	//list.jsp에서 호출되는 화면에 표시할 페이지번호와 검색어(내용+이름)을 넘겨받아
	//mapper를 얻어온 후 DAO클래스 1페이지 분량의 검색어를 포함하는 글목록을
	//얻어오는 selectSql명령 실행하는 메서드를 호출하는 메서드
	public GuestbookList selectListMulti(int currentPage,String category,String item) {
		System.out.println("SelectService의 selecListMulti() 메서드 실행!");
		SqlMapClient mapper = MyAppSqlConfig.getSqlMapInstance();
		
		GuestbookDAO dao = GuestbookDAO.getInatance();
		GuestbookList guestbookList = null;
		
		try {
			//검색어가 포함된 글의개수 얻어온다~
			int pageSize = 5;
			
			//카테고리에 따른 검색어가 포함됐는지 조건을 세워야하기에
			//Param클래스 객체를 이용한다
			Param param = new Param();
			param.setItem(item);
			param.setCategory(category);
			
			int totalCount = dao.selectCountMulti(mapper,param);
			guestbookList = new GuestbookList(pageSize,totalCount,currentPage);
			param.setStartNo(guestbookList.getStartNo());
			param.setEndNo(guestbookList.getEndNo());
			
			//실제 북리스트에 저장하는 내용 검색된개수 가지고
			//실제 내용들(글목록들)을 가져오는 메서드 만들어 리턴받기~
			guestbookList.setList(dao.selectListMulti(mapper,param));
			System.out.println(guestbookList);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return guestbookList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
