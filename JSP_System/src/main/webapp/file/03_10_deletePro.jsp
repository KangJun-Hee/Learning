<%@page import="_05_User.UserDAO"%>
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
	<!-- 
		1. 한글깨짐 
		2. id,pass가져오기
		3. 체크를 이용해서 userlist에 2번에 가져온 변수값을 이용해서 정보있는지 확인
		4. 정보가 있다! deleteUserId(id);
		   세션도 삭제를 할 겁니다. log
		   alert() 탈퇴었다. userMain 페이지 이동 시키기!
		
		5. 아이디 또는 비밀번호확인 메시지를 출력하고 
		//바로 이전 페이지로 이동하는 메서드
		history.go(-1);
	
		deleteUserId(id); 실행시 리스트에서 삭제 ! 메모장에서도 삭제! 다시
		저장하는 어떤 메서드를 호출해야된다.(saveData())
	
	 -->
	<%
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	boolean check = UserDAO.getInstance().checkUserIdPw(id, passwd);
	//System.out.println(check);
	if (check == true) {
		UserDAO.getInstance().deleteUserId(id);
		session.removeAttribute("log");
	%>
	<script>
		alert("탈퇴되었습니다. ");
		location.href = "03_01_userMain.jsp";
	</script>
	<%
	} else {
	%>
	<script>
		alert("아이디나 비밀번호를 확인하세요. ");
		// 바로 이전 페이지로 이동
		history.go(-1);
	</script>
	<%
	}
	%>

</body>
</html>