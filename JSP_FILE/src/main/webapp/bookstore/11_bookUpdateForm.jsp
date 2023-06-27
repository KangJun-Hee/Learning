<%@page import="bookstore.BookDAO"%>
<%@page import="bookstore.BookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String managerId = (String)session.getAttribute("managerId");
	if(managerId == null){
		response.sendRedirect("00_shopMain.jsp");
	}else {
		ArrayList<BookDTO> bookList = null;
    	
    	int book_id = Integer.parseInt(request.getParameter("book_id"));
    	String book_kind = request.getParameter("book_kind");
    	BookDAO dao = BookDAO.getInstance();
    	BookDTO dto = dao.getBook(book_id); 
    	
    	
    	%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>관리자 상품등록</title>		
	</head>
	<body>
		<p>책 수정</p>
		<br>

		<form method="post" name="writeform" action="12_bookUpdatePro.jsp" enctype="multipart/form-data">
			<table border="1">
				<tr>
					<td align="right" colspan="2"><a href="06_managerMain.jsp">관리자
							메인으로</a>&nbsp; <a href="10_bookList.jsp?book_kind=<%= book_kind %>">목록으로</a>
					</td>
				</tr>
				<tr>
					<td width="100">분류 선택</td>
					<td width="400"><select name="book_kind">
							<option value="100" <% if(dto.getBook_kind().equals("100")) { %>
								selected <% }%>>문학</option>
							<option value="200" <% if(dto.getBook_kind().equals("200")) { %>
								selected <% }%>>외국어</option>
							<option value="300" <% if(dto.getBook_kind().equals("300")) { %>
								selected <% }%>>컴퓨터</option>
					</select></td>
				</tr>
				<tr>
					<td width="100">제 목</td>
					<td width="400"><input type="text" size="50" maxlength="50"
						name="book_title" value="<%= dto.getBook_title() %>"> 
						<input type="hidden" name="book_id" value="<%= book_id %>">
					</td>
				</tr>
				<tr>
					<td width="100">가 격</td>
					<td width="400">
						<input type="text" size="10" maxlength="9" name="book_price" value="<%= dto.getBook_price() %>">원
					</td>
				</tr>
				<tr>
					<td width="100">수량</td>
					<td width="400">
						<input type="text" size="10" maxlength="5" name="book_count" value="<%= dto.getBook_count() %>">권
					</td>
				</tr>
				<tr>
					<td width="100">저자</td>
					<td width="400">
						<input type="text" size="10" maxlength="50" name="author" value="<%= dto.getAuthor()%>">
					</td>
				</tr>
				<tr>
					<td width="100">출판사</td>
					<td width="400" align="left">
						<input type="text" size="20" maxlength="30" name="publishing_com" value="<%= dto.getPublishing_com() %>">
					</td>
				</tr>
				<tr>
					<td width="100">출판일</td>
					<td width="400">
						<select name="publishing_year">
							<% Timestamp nowTime  = new Timestamp(System.currentTimeMillis());
	        					int lastYear = Integer.parseInt(nowTime.toString().substring(0,4));
								for(int i=lastYear; i>=2010; i--){
	     					%>
							<option value="<%= i %>"
							<%	if (Integer.parseInt(dto.getPublishing_date().substring(0,4))==i) {%>selected <%} %>>
								<%= i %>
							</option>
							<%} %>
						</select>년 
						<select name="publishing_month">
							<% for(int i=1; i<=12; i++){ %>
							<option value="<%=i %>"
								<%if (Integer.parseInt(dto.getPublishing_date().substring(5,7))==i) {%>selected <%} %>>
								<%=i %>
							</option>
							<%} %>
						</select>월 
						<select name="publishing_day">
							<% for(int i=1; i<=31; i++){%>
							<option value="<%= i %>"
							<%if (Integer.parseInt(dto.getPublishing_date().substring(8))==i) {%>selected <%} %>>
								<%=i %>
							</option>
							<%} %>
						</select>일
					</td>
				</tr>
				<tr>
					<td width="100">이미지</td>
					<td width="400">
						<input type="file" name="book_image"><%= dto.getBook_image() %></td>
				</tr>
				<tr>
					<td width="100">내 용</td>
					<td width="400">
						<textarea name="book_content" rows="13" cols="40"><%=dto.getBook_content() %>123</textarea>
					</td>
				</tr>
				<tr>
					<td width="100">할인율</td>
					<td width="400" align="left">
						<input type="text" size="5" maxlength="2" name="discount_rate" value="<%= dto.getDiscount_rate() %>">%</td>
				</tr>
				<tr>
					<td colspan=2 align="center">
						<input type="submit" value="책수정" ">
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