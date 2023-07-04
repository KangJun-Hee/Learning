<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
<!-- 
	insert.jsp에서 넘어오는 데이터를 받는다
	이전페이지서 넘어오는 데이터가 vo클래스의 필드로 존재하면
	useBean액션태그를 이용해 받는 내용을 작성하면 된다!
	
	그것을 InsertService.getInstance().insert(vo);
	
	list.jsp로 페이지이동하는 redirect해줄 것임~      

	ibatis란?
		DB에서 자바빈즈,vo객체 데이터를 쉽게 저장할 수 있도록 도와 주는 라이브러리
		sql매퍼+DAO프레임워크
		
	4가지의 기본파일로 구성돼 있다~
	1.DB연동 위한 환경설정 파일 : SqlMapConfig.xml
	2.xml문과 실제 환경설정파일을 연결하는 역할 : MyAppSqlConfig.java
	3.sql문을 mapping하는 파일 : guestbook.xml
	4.DB정보(비번,유저명,url,driver)가 들어가 있는 : db.properties
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 -->