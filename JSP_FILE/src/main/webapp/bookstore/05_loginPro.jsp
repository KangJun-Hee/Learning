<%@page import="bookstore.CustomerDAO"%>
<%@page import="bookstore.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>05_loginPro.jsp</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	
	BookDAO bdao = BookDAO.getInstance();
	int check = bdao.managerCheck(id, passwd);
	if(check == 1){
		session.setAttribute("managerId", id);
		response.sendRedirect("06_managerMain.jsp");
	}
	//--매니저가 아니면 아래 검사 ---------------------------------------- 	
	//--매니저가 아니면 아래 검사 ---------------------------------------- 	
	
	CustomerDAO cdao = CustomerDAO.getInstance();
	check = cdao.userCheck(id, passwd); 

	if(check == 1){
		session.setAttribute("id", id);
		response.sendRedirect("00_shopMain.jsp");
%>
<%	} else if(check == 0){ %>
	<script type="text/javascript">
		alert('비밀번호가 맞지 않습니다.');
		history.go(-1);
	</script>
<%	} else {%>
	<script type="text/javascript">
		alert('아이디가 맞지 않습니다.');
		history.go(-1);
	</script>
<%	} %>
</body>
</html>