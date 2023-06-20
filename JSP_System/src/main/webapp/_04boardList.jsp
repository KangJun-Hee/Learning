<%@page import="com.green.board.BoardDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.green.board.BoardDTO"%>
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
	int nowPage;
	%>
	<div align="center">
		<h2>
			게시글 목록(<%=count%>개)
		</h2>
		<table border="1">
			<tr>
				<td colspan="5">한 페이지에 보여줄 게시글 수 <select name="page" id="page">
						<option value="5">5개씩</option>
						<option value="10">10개씩</option>
						<option value="10">20개씩</option>
						<option value="10">30개씩</option>
						<option value="10">40개씩</option>
						<option value="10">50개씩</option>
				</select> <input type="button" value="수정하기"
					onclick="window.location.href='_04boardList.jsp'"></td>
			</tr>
			<tr>
				<td colspan="5"><a href="_01index.jsp">메인으로</a></td>
			</tr>
			<tr>
				<td colspan="5"><a href="_10dummySave.jsp">dummy 10개 추가하기</a></td>
			</tr>
			<tr>
				<td colspan="5"><a href="_11boardClear.jsp">전체 게시글 삭제</a></td>
			</tr>
			<tr>
				<td colspan="5"><a href="_02boardWrite.jsp">새 글쓰기</a></td>
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