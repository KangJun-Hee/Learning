<%@page import="com.green.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03 새 게시글 작성하기</title>
</head>
<body>
	<%request.setCharacterEncoding("utf-8"); %>
	
	<!-- 액션태그 이용해 객체생성 -->
	<jsp:useBean id="boardDTO" class="com.green.board.BoardDTO">
		<jsp:setProperty name="boardDTO" property="*"/>
	</jsp:useBean>
	
	<%
		//DAO 클래스로 데이터를 전송해 처리하는 내용
		BoardDAO.getInstance().boardWrite(boardDTO);
	
		//새 글을 보여 주는 목록으로 이동시킨다
		response.sendRedirect("04_boardList.jsp");
	%>
</body>
</html>