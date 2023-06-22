<%@page import="com.rentcar.RentcarDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>06</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	%>

	<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	//회원아이디,비번이 일치하는지 비교
	//해당회원 있는지 여부를 숫자로 표현
	
	int result = RentcarDAO.instance.getMember(id,pw);
		
	if(result == 0){
	%>
	
	<script>
	alert("회원아이디 또는 비번을 확인하세요~");
	location.href="01_main.jsp?center=05_memberLogin.jsp";
	</script>
	
	<%
	}else{
	  //로그인처리가 되면 세션 만들기
	  session.setAttribute("id",id);
	  response.sendRedirect("01_main.jsp");
	}
	%>
</body>
</html>






















