<%@page import="_05_User.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 처리 페이지</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	%>

	<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	// 아이디랑 패스워드를 확인하는 메서드 
	boolean check = UserDAO.getInstance().checkUserIdPw(id, pw);
	
	if(check){
		// 회원가입한 내용이 있을 경우 에는 세션을 만들어준다. 
		session.setAttribute("log",id);
		// 세션의 유효시간 설정으로 1분 후 자동 세션이 삭제 되도록 설정
		session.setMaxInactiveInterval(1 * 60); // 1분
	
	%>
	<script>
		alert("로그인 되었습니다!");
		location.href = "03_01_userMain.jsp";
	
	</script>
	<%}else { %>

	<script>
		alert("아이디 패스워드 확인해라!");
		location.href = "03_04_login.jsp";
	
	</script>
	<%}%>
</body>
</html>