<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String managerId = (String)session.getAttribute("managerId");
	if(managerId == null){
		response.sendRedirect("00_shopMain.jsp");
	}else {
%>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>관리자 상품등록</title>		
	</head>
	<body>
		<p>책 등록</p>
		<br>
		<form method="post" name="writeform" action="09_bookRegisterPro.jsp" enctype="multipart/form-data">
			<table border="1">
				<tr>
					<td colspan="2" align="right">
						<a href="06_managerMain.jsp">관리자 메인으로</a>
					</td>
				</tr>
				<tr>
					<td width="100">분류 선택</td>
					<td width="400">
						<select name="book_kind">
							<option value="100">문학</option>
							<option value="200">외국어</option>
							<option value="300">컴퓨터</option>
						</select>
					</td>
				</tr>
				<tr>
					<td width="100">제 목</td>
					<td width="400">
						<input type="text" size="50" maxlength="50" name="book_title">
					</td>
				</tr>
				<tr>
					<td width="100">가 격</td>
					<td width="400">
						<input type="text" size="10" maxlength="9" name="book_price">원
					</td>
				</tr>
				<tr>
					<td width="100">수 량</td>
					<td width="400">
						<input type="text" size="10" maxlength="5" name="book_count">권
					</td>
				</tr>
				<tr>
					<td width="100">저 자</td>
					<td width="400">
						<input type="text" size="20" maxlength="30" name="author">
					</td>
				</tr>
				<tr>
					<td width="100">출판사</td>
					<td width="400">
						<input type="text" size="20" maxlength="30" name="publishing_com">
					</td>
				</tr>
				<tr>
					<td width="100">출판일</td>
					<td width="400">
						<select name="publishing_year">
						<%
						Timestamp nowTime = new Timestamp(System.currentTimeMillis());
						int lastYear = Integer.parseInt(nowTime.toString().substring(0, 4));
						for(int i=lastYear; i>=2010; i--){
						%>
							<option value="<%= i %>"><%= i %></option>
						<%} %>
						</select>년
						
						<select name="publishing_month">
						<%
						for(int i=1; i<=12; i++){
						%>
							<option value="<%= i %>"><%= i %></option>
						<%
						}
						%>
						</select>월
						
						<select name="publishing_day">
						<%
						for(int i=1; i<=31; i++){
						%>
							<option value="<%= i %>"><%= i %></option>
						<%
						}
						%>
						</select>일
					</td>
				</tr>
				<tr>
					<td width="100">이미지</td>
					<td width="400">
						<input type="file" name="book_image">
					</td>
				</tr>
				<tr>
					<td width="100">내 용</td>
					<td width="400">
						<textarea rows="13" cols="40" name="book_content"></textarea>
					</td>
				</tr>
				<tr>
					<td width="100">할인율</td>
					<td width="400">
						<input type="text" size="5" maxlength="2" name="discount_rate">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="책등록" >
						<input type="reset" value="다시작성">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
<%
	}
%>