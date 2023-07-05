package com.kh.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.kh.vo.GuestbookVO;
import com.kh.vo.Param;

public class GuestbookDAO {

	private static GuestbookDAO instance = new GuestbookDAO();

	private GuestbookDAO() {
	}

	public static GuestbookDAO getInatance() {
		return instance;
	}

//	InsertService 클래스에서 호출되는 mapper와 테이블에 저장할 데이터가 저장된 객체를 넘겨받고 guestbook.xml 파일의
//	insert sql 명열을 실행하는 메소드
	public void insert(SqlMapClient mapper, GuestbookVO vo) throws SQLException {
		System.out.println("GuestbookDAO의 insert() 메소드 실행");
		// System.out.println(vo);
		// insert("실행할 sql 명령의 id", sql 명령으로 전달할 데이터)
		mapper.insert("insert", vo);
	}

	// 전체 글 개수 확인 메서드
	// SelectService 클래스에서 호출되는 mapper를 넘겨받고 guestbook.xml
	// 파일의 테이블에 저장된 전체 글의 개수를 얻어 오는 select sql 명령을
	// 실행하는 메서드
	public int selectCount(SqlMapClient mapper) throws SQLException {

		System.out.println("GuestbookDAO의 selectCount() 메서드 실행");

		// queryForObject(): select sql 명령 실행 후 결과가 1건 일때 사용
		// queryForList(): select sql 명령 실행 후 결과가 여러 건 일때 사용

		return (int) mapper.queryForObject("selectCount");

	}

	// 페이지 처리하는 메서드
	// SelectService 클래스에서 호출되는 mapper를 넘겨받고 화면에 표시할
	// 페이지의 시작 인덱스 번호와 끝 인덱스 번호가 저장된 hashMap객체를 넘겨받고
	// guestbook.xml 1페이지 분량의 글 목록을 얻어 오는 select sql 명령을
	// 실행하는 메서드

	public ArrayList<GuestbookVO> selectList(SqlMapClient mapper, HashMap<String, Integer> hamp) throws SQLException {
		System.out.println("GuestbookDAO의 selectList() 메서드 실행");

		return (ArrayList<GuestbookVO>) mapper.queryForList("selectList", hamp);
	}

	public GuestbookVO selectByIdx(SqlMapClient mapper, int idx) throws SQLException {
		System.out.println("GuestbookDAO의 selectByIdx() 메서드 실행");

		return (GuestbookVO) mapper.queryForObject("selectByIdx", idx);
	}

	// 검색어와 카테고리가 저장된 param을 넘겨받고
	// guestbook.xml에서 파일의 카테고리별로
	// 1페이지 분량의 글목록을 얻어오는 select sql명령 실행하는 메서드
	// selectListMulti
	// queryForList()
//	SelectService 클래스에서 호출되는 mapper와 카테고리 및 검색어가 저장된 Param 클래스 객체를 넘겨받고 
//	guestbook.xml 파일의 테이블에 저장된 전체 글 중에서 해당 카테고리에 검색어를 포함하는 글의 개수를 얻어오는
//	select sql 명령을 실행하는 메소드 
	public int selectCountMulti(SqlMapClient mapper, Param param) throws SQLException {
		System.out.println("GuestbookDAO의 selectCountMulti() 메소드 실행");
		return (int) mapper.queryForObject("selectCountMulti", param);
	}

//	SelectService 클래스에서 호출되는 mapper와 화면에 출력할 페이지의 시작 인덱스와 끝 인덱스, 카테고리, 검색어가
//	저장된 Param 클래스 객체를 넘겨받고 guestbook.xml 파일의 카테고리별 	검색어를 포함하는 1페이지 분량의 글 목록을
//	얻어오는 select sql 명령을 실행하는 메소드	
	public ArrayList<GuestbookVO> selectListMulti(SqlMapClient mapper, Param param) throws SQLException {
		System.out.println("GuestbookDAO의 selectListMulti() 메소드 실행");
		return (ArrayList<GuestbookVO>) mapper.queryForList("selectListMulti", param);
	}

//	DeleteService 클래스에서 호출되는 mapper와 삭제할 글번호를 넘겨받고 guestbook.xml 파일의 글 1건을
//	삭제하는 delete sql 명령을 실행하는 메소드
	public void delete(SqlMapClient mapper, int idx) throws SQLException {
		System.out.println("GuestbookDAO의 delete() 메소드 실행");
		mapper.delete("delete", idx);
	}

//	UpdateService 클래스에서 호출되는 mapper와 수정할 정보가 저장된 객체를 넘겨받아 guestbook.xml 파일의
//	글 1건을 수정하는 update sql 명령을 실행하는 메소드
	public void update(SqlMapClient mapper, GuestbookVO vo) throws SQLException {
		System.out.println("GuestbookDAO의 update() 메소드 실행");
		mapper.update("update", vo);
	}

	// 전체글 중 검색어를 포함한 글의 개수 얻어오는 select sql실행하는 메서드
	// selectCountMulti
	// queryForObject()

}
