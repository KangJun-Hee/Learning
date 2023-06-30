<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%response.sendRedirect("BoardListAction"); %>
	
	<table>
		<tr>
			<td>
				<input type="button" value="글쓰기">
			</td>
		</tr>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>조회수</td>
		</tr>
		<tbody>
			<tr>
				<td><%=dto.getNum()%></td>
				<td><%=dto.getNum()%></td>
				<td><%=dto.getNum()%></td>
				<td><%=dto.getNum()%></td>
				<td><%=dto.getNum()%></td>
			</tr>
		</tbody>
	</table>
</body>
</html>