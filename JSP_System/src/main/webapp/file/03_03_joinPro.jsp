<%@page import="_05_User.UserDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="_05_User.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 처리</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");	
	%>
	<%
		UserDTO user = new UserDTO();
		user.setId(request.getParameter("id"));
		user.setPw(request.getParameter("pw"));
		user.setName(request.getParameter("name"));
		
		Date d = new Date();
		
		//System.out.println("현재 날짜:" + d.toString());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh-mm");
		user.setReg_date(sdf.format(d));
		
		// 아이디 중복확인 
		boolean idCheck = UserDAO.getInstance().checkUserId(user);
		
		if(idCheck){
		
	%>
	
	<script>
		alert("중복아이디입니다.");
		window.location.href ="03_02_join.jsp";
	
	</script>
	<%
		}else {
			UserDAO.getInstance().insertUser(user);
		}	
	%>
	
	<script>
		alert("회원가입 축하합니다!");
		window.location.href ="03_01_userMain.jsp";
	
	</script>
	
	
	
	
	
	
</body>
</html>