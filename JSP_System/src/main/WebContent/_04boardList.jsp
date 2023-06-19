<%@page import="com.green.board.BoardDAO"%>
<%@page import="com.green.board.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
	<%
	ArrayList<BoardDTO> boardList = BoardDAO.getInstance().getBoardList();
	int count = BoardDAO.getInstance().getAllCount();
	%>
	<div align="center">
		<h2>
			게시글 목록(<%=count%>개)
		</h2>
		<table border="1">
			<tr>
				<td colspan="5"><a href="_02boardWrite.jsp">글쓰기</a></td>
			</tr>
			<tr>
				<td>번호</td>
				<td>작성자</td>
				<td>제목</td>
				<td>작성일</td>
				<td>조회수</td>
			</tr>
			<%
			for (int i = 0; i < boardList.size(); i++) {
				BoardDTO board = boardList.get(i);
			%>
			<tr>
				<td><%=board.getNum()%></td>
				<td><%=board.getWriter()%></td>
				<td><a href="_05boardInfo.jsp?num=<%=board.getNum()%>"><%=board.getSubject()%></a></td>
				<td><%=board.getRegDate()%></td>
				<td><%=board.getReadCount()%></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>

</body>
</html>