<%@page import="bookstore.BookDAO"%>
<%@page import="bookstore.BookDTO"%>
<%@page import="java.text.NumberFormat"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04_introList.jsp</title>
</head>
<body>
	<%
	BookDTO[] bookLists = null;
	int number = 0;
	String book_kindName = "";
	
	BookDAO dao = BookDAO.getInstance();

	for(int i=1; i<=3; i++){
	
		bookLists = dao.getBooks(i + "00", 3); 	
		if(bookLists!=null){
			if(bookLists[0].getBook_kind().equals("100")){
				book_kindName = "문학";
			}else if(bookLists[0].getBook_kind().equals("200")){
				book_kindName = "외국어";
			}else if(bookLists[0].getBook_kind().equals("300")){
				book_kindName = "컴퓨터";
			}
		}
%>
	<h3>신간소개</h3>
		<br>
		<b>
			<%= book_kindName %> 분류의 신간목록 : 
			<a href="16_list.jsp?book_kind=<%= bookLists[0].getBook_kind() %>">더보기</a>
		</b> 
		<%
		for(int j=0; j<bookLists.length; j++){
		%>
		<table border="1">
			<tr height="30">
				<td width="100" rowspan="4" align="center">
					<a href="17_bookContent.jsp?book_id=<%= bookLists[j].getBook_id() %>&book_kind=<%= bookLists[0].getBook_kind() %>">
						<img width="90" height="120" src="imageFileSave/<%= bookLists[j].getBook_image() %>">
					</a>
				</td>
				<td width="250">
					<a href="17_bookContent.jsp?book_id=<%= bookLists[j].getBook_id() %>&book_kind=<%= bookLists[0].getBook_kind() %>">
						<b><%= bookLists[j].getBook_title() %></b>		
					</a>
				</td>
				<td width="100" rowspan="4" align="center">
					<% if(bookLists[j].getBook_count() == 0) { %>
						<b>일시 품절</b>
					<% } else { %>
						&nbsp;
					<% } %>
				</td>
			</tr>
			<tr height="30">
				<td width="350">출판사 : <%= bookLists[j].getPublishing_com() %></td>
			</tr>
			<tr height="30">
				<td width="350">저자 : <%= bookLists[j].getAuthor() %></td>
			</tr>
			<tr height="30">
				<td width="350">
					정가 : <%= NumberFormat.getInstance().format(bookLists[j].getBook_price()) %>원<br>
					<%
						double discount = (100-bookLists[j].getDiscount_rate())/100.0;
						int price = (int)(bookLists[j].getBook_price() * discount);
						// (int)(bookLists[j].getBook_price()*((double)(100-bookLists[j].getDiscount_rate())/100))
					%>
					판매가 : <b><font color="red"><%= NumberFormat.getInstance().format(price)%>원</font></b>
				</td>
			</tr>
		</table>
		<%}}%>
</body>
</html>