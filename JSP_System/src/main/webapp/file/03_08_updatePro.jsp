<%@page import="_05_User.UserDTO"%>
<%@page import="_05_User.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 처리 페이지</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	%>
	
	<%=request.getParameter("id") %>
	
	<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	
	// id pw입력받아서 회원가입 당시 정보가 맞으면 내용을 변경 
	
	boolean check = UserDAO.getInstance().checkUserIdPw(id, pw);
	if(check){
		UserDTO user = UserDAO.getInstance().getUserId(id);
		user.setId(id);
		user.setPw(pw);
		user.setName(name);
		
		// 변경한 데이터를 DAO 한테 넘겨줘서 내용 변경을 실행
		// 리스트! 메모장 파일에 저장!
		UserDAO.getInstance().updateUser(user);
		
	%>
	<script>
		alert("내용이 수정 되었습니다!");
		location.href="03_01_userMain.jsp";
	
	</script>	
	<%} else { %>
	<script>
		alert("아이디와 비밀번호를 확인해주세요!");
		location.href="03_01_userMain.jsp";
	
	</script>
	<%} %>
			
	
</body>
</html>