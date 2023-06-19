<%@page import="com.green.board.BoardDAO"%>
<%@page import="com.green.board.BoardDTO"%>
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
	int num = Integer.parseInt(request.getParameter("num"));
	BoardDTO board = BoardDAO.getInstance().getBoardOfInfo(num);
	%>
	<div align="center">
		<h2>게시글 내용</h2>
		<form method="post" action="_06boardUpdate.jsp">
			<table border="1">
				<tr>
					<td>번호</td>
					<td><%=board.getNum()%></td>
					<td>조회수</td>
					<td><%=board.getReadCount()%></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><%=board.getWriter()%></td>
					<td>이메일</td>
					<td><%=board.getEmail()%></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><%=board.getSubject()%></td>
					<td>작성일</td>
					<td><%=board.getRegDate()%></td>
				</tr>
				<tr>
					<td>내용</td>
					<td colspan="3"><textarea rows="10" cols="20" readonly><%=board.getContent()%></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="4"><input type="hidden" name="num"
						value="<%=board.getNum()%>"> <input type="submit"
						value="수정하기"> <input type="button" value="삭제하기"
						onclick="window.location.href='_08boardDelete.jsp?num=<%=board.getNum()%>'">
						<input type="button" value="목록으로"
						onclick="window.location.href='_04boardList.jsp'"></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>