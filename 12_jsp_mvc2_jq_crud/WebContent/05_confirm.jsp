<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<% request.setCharacterEncoding("utf-8");%>

<% 
	//id는 사용자가 회원가입을 하기위해서 입력한 아이디
	String id = request.getParameter("id");
	
	MemberDAO manager = MemberDAO.getInstance();
	
	//사용자가 입력한 id값을 가지고 LogonDBBean클래스의 confirmId()메소드 호출
	//중복아이디 체크  confirmId()메소드의 실행결과로 check에는 1또는 -1값이 리턴됨
	int check= manager.confirmId(id);
	
	out.print(check);	//처리 결과를 register.js로 리턴
 %>
