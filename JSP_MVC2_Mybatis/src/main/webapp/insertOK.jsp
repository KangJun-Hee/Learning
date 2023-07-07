<%@page import="com.kh.service.FreeboardService"%>
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


	// . 현재 폴더를 기준으로 
	// / 톰캣의 root폴더 
	
	// vo 
	// dao
	// dto
	
	// mvc 구조 
	// Model
	//  - 어플리케이션의 정보, 데이터를 나타냄
	//  - 데이터베이스 상수, 초기화, 변수 등 
	//  - 사용자가 편집하길 원하는 모든 데이터를 가지고 있어야된다. 
	
	// View
	//  - input텍스트, 체크박스, 항목 등등 사용자 인터페이스 
	//  - 모델 데이터 및 객체의 입력 그리고 보여주는 출력을담당 
	
	// Controller
	//  - model을 통해서 데이터를 가지고 오고 그 정보를 바탕으로 시각적인 표현을 담당
	//    하는 view제어해서 사용자에게 전달된다. 
	
	// 데이터베이스명과 VO 클래스의 필드명이 같아야된다.
%>

<jsp:useBean id="vo" class="com.kh.vo.FreeboardVO">
	<jsp:setProperty property ="*"  name="vo"/>

</jsp:useBean>

<%
	// insert.jsp에서 넘어온 데이터를 메인글 테이블에 저장하는 메서드를 실행한다.
	// 데이터베이스에 가기전에 준비과정(전처러) -> Service
	FreeboardService.getInatance().insert(vo);
	
	// 메인글 1페이지 분량의 글 목록을 얻어오는 페이지 list.jsp로 넘겨준다.
	response.sendRedirect("list.jsp");
%>




</body>
</html>