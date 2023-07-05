<%@page import="com.kh.service.InsertService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	%>
	<jsp:useBean id="vo" class="com.kh.vo.GuestbookVO">
		<jsp:setProperty property="*" name="vo" />
	</jsp:useBean>
	
	<%
		InsertService.getInatance().insert(vo);
	
		// 테이블에 글 1건을 저장했으면 테이블에 저장된 글을 브라우저에 출력하기 
		// 위해서 1페이지 분량의 글목록을 얻어오는 페이지 list.jsp로 남겨준다.
		response.sendRedirect("list.jsp");
	%>


</body>
</html>

<!-- 

	vo 클래스 => 글 1건을 기억하는 클래스
	List 클래스 => 1페이지 분량의 글목록과 페이징에 사용할 8개의 변수를저장하는 클래스
	Serice 클래스 => sql 명령을 실행전에 전처리 작업을 수행하는 클래스 ,
	DAO(Data Access Object) 데이터베이스 접속해서 sql 명령을 실행하는 클래스 
	
	insert.jsp 에서 넘어오는 데이터를 받는다.
	 이전 페이지 에서 넘어오는 데이터가 vo 클래스의 필드로 존재하면 
	 useBean액션태그를 이용해서 받는 내용 작성!
	 전처리 작업을 하기 위해서 service 클래스로 넘겨서 DAO클래스에서 sql 명령을
	 실행하기 전까지 필요한 작업 실행 한다. 
	 
	 
	 그거를 InsertService.getIntaance().insert(vo);
	 
	 list.jsp로 페이지 이동 




	ibatis란?
	 	데이터베이스에서 자바빈즈, vo객체 데이터를 쉽게 저장할 수있도록 도와주는 라이브러리
	 	sql 매퍼 + DAO 프레임워크 

	4가지의 기본 파일로 구성되어있다. 
	1. DB연동을 위한 환경설정 파일: SqlMapConfig.xml 
	2. xml문과 실제 환경설정파일을 연결해주는 역할: MyAppSqlConfig.java
	3. sql문을 Mapping하는 파일 : guestbook.xml
	4. db.properties : 데이터베이스 정보 ( password , username,url,driver)

	. iBatis의 특징

	1) 간결함, 쉬운 접근성
		sql문을 xml에 그대로 서술하기 때문에 기존 sql문처리에 
		익숙한 개발자들이 다가가기 쉽다.
		그에 따른 장점으로 개발자와 DB관리의 양쪽 모두 이해에 용이하다.
	
	2) 생산성의 향상
		JDBC의 많은 설정을 간결하게 줄여줌으로 인해 개발자의 작성분량을 줄여준다.
	
	3) 성능
		성능최적화 기법을 지원한다.
		ex)예를 들어 가장 중요한 기능이라면 페이징 처리된 데이터 리스트를 읽어와서 
		    사용할 때 불필요한 수천개의 행을 한꺼번에 데이터베이스로부터 가져오는것이 
		    아니기 때문에 어플리케이션의 성능을 향상시킬수있다. 
		
		
		

 -->