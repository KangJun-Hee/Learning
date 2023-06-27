<%@page import="bookstore.BookDAO"%>
<%@page import="bookstore.BookDTO"%>
<%@ page import="java.text.NumberFormat"%>

<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%
	String book_kind = request.getParameter("book_kind");

	List<BookDTO> bookLists = null;
	BookDTO bookList = null;
	String book_kindName = "";
	
	BookDAO dao = BookDAO.getInstance();
	bookLists = dao.getBooks(book_kind);
	
	if(book_kind.equals("100")){
		book_kindName = "문학";
	}else if(book_kind.equals("200")){
		book_kindName = "외국어";
	}else if(book_kind.equals("300")){
		book_kindName = "컴퓨터";
	}else if(book_kind.equals("all")){
		book_kindName = "전체";
	}
%>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>쇼핑몰 도서목록</title>
	</head>
	<body>
		<h3><b><%= book_kindName %> 분류의 목록</b></h3>
		<a href="00_shopMain.jsp">메인으로</a>
		
		<%
		for(int i=0; i<bookLists.size(); i++){
			bookList = (BookDTO)bookLists.get(i);
		%>
		<table border="1">
			<tr height="30">
				<td width="100" rowspan="4" align="center">
					<a href="17_bookContent.jsp?book_id=<%= bookList.getBook_id() %>&book_kind=<%= book_kind %>">
						<img src="imageFileSave/<%= bookList.getBook_image() %>" width="90" height="120">
					</a>
				</td>
				<td width="350">
					<b>
						<a href="17_bookContent.jsp?book_id=<%= bookList.getBook_id() %>&book_kind=<%= book_kind %>">
							<%= bookList.getBook_title() %>
						</a>
					</b>
				</td>
				<td width="100" rowspan="4" align="center">
				<% if(bookList.getBook_count() == 0) { %>
					<b>일시품절</b>
				<% } else {%>
					&nbsp;
				<% } %>
				</td>
			</tr>
			<tr height="30">
				<td width="350">출판사 : <%= bookList.getPublishing_com() %></td>
			</tr>
			<tr height="30">
				<td width="350">저자 : <%= bookList.getAuthor() %></td>
			</tr>
			<tr height="30">
				<td width="350">
					정가 : <%= NumberFormat.getInstance().format(bookList.getBook_price()) %>원<br>
					<%
						double discount = (100-bookList.getDiscount_rate())/100.0;
						int price = (int)(bookList.getBook_price() * discount);
					%>
					판매가 : <b><font color="red"><%= NumberFormat.getInstance().format(price) %></font>원</b>
				</td>
			</tr>
		</table>		
		<%
		}
		%>
	</body>
</html>
