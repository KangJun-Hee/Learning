<%@page import="com.green.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>14boardReplyWritePro</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8"); 

	int num = Integer.parseInt(request.getParameter("num"));
	%>
	
	
	<!-- 1.등록하기 누르면 실제 DTO가 객체생성을 해야한다~ 액션태그 이용하기!-->
	<jsp:useBean id="board" class="com.green.board.BoardDTO">
		<jsp:setProperty name="board" property="*"/>
	</jsp:useBean>
	
	<!-- 2.글의 번호가 몇번인지 가지고 오기!-->
	
	<!-- 3.DAO가 처리하 수 있도록 boardReplyWrite(번호,board)-->
	<%
		BoardDAO.getInstance().boardReplyWrite(num,board);
		response.sendRedirect("_04boardList.jsp");
	%>
	
	
	
	
	
	 <%
		//DAO 클래스로 데이터를 전송해 처리하는 내용
		BoardDAO.getInstance().boardWrite(boardDTO);
	
		//새 글을 보여 주는 목록으로 이동시킨다
		response.sendRedirect("04_boardList.jsp");
	 %>
	
	
	<!-- 
		 4.sendRedirect(_04boardList.jsp)로 넘어갓
		 
		 답글을 저장하는 메서드 DAO안에 작성
		 
		 현재 답글을 단 게시글의 번호 가지고 온다~ 
		 그 게시글에 실제 저장을 맡고 있는 arraylist의 index를 가지고 와야 한다~
		 ref변수들을 이용해서 답글에 대해 추가하는 내용을 작성!
		 
		 새로운 답글도 list에 추가해야 한다~ idNum 증가되어야 한다~
	 -->
	 
</body>
</html>