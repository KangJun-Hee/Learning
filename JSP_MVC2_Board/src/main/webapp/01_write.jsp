<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h2> 게시글 쓰기 </h2>
		<form action="BoardWriteAction" method="post">
			<table border="1">
				<tr height="40">
					<td align="center" width="150"> 작성자 </td>
					<td width="450"> <input type="text" name="writer" size="60" /></td>
				</tr>
				<tr height="40">
					<td align="center" width="150"> 제목 </td>
					<td width="450"> <input type="text" name="subject" size="60" /></td>
				</tr>
				<tr height="40">
					<td align="center" width="150"> 이메일 </td>
					<td width="450"> <input type="email" name="email" size="60" /></td>
				</tr>
				<tr height="40">
					<td align="center" width="150"> 비밀번호 </td>
					<td width="450"> <input type="password" name="password" size="60" /></td>
				</tr>
				<tr height="40">
					<td align="center" width="150"> 글내용 </td>
					<td width="450"> <textarea rows="10" cols="50" name="content"></textarea> </td>
				</tr>
				<tr height="40">
					<td align="center" colspan="2">
						<input type="submit" value="글쓰기" /> &nbsp;&nbsp;
						<input type="reset" value="다시작성" /> &nbsp;&nbsp;
						
					</td>				
				</tr>
			</table>
		</form>
		<p></p>
		<button onclick="location.href='BoardListAction'"> 전체 게시글 보기</button>
	</div>
</body>
	
	
	

</html>