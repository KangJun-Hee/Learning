<%@page import="java.util.List"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="bookstore.BookDTO"%>
<%@page import="bookstore.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("utf-8");
    %>
    
    <%
    String book_kind = request.getParameter("book_kind");
    String book_id = request.getParameter("book_id");
    
    String id = (String)session.getAttribute("id");
    if(id==null){
    	id="not";
    	
    }
    
    BookDAO dao = BookDAO.getInstance();
    BookDTO bookList = dao.getBook(Integer.parseInt(book_id));
    
	List<BookDTO> bookLists = null;
	
	String book_kindName = "";
    
	
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
<html>
<head>
		<meta charset="UTF-8">
		<title>도서 상세정보</title>
	</head>
	<body>
		<form method="post" action="18_cartInsert.jsp">
			<table border="1">
				<tr height="30">
					<td width="150" rowspan="6">
						<img src="imageFileSave/<%= bookList.getBook_image() %>" width="150" height="200">
					</td>
					<td width="500">
						<b><%= bookList.getBook_title() %></b>
					</td>
				</tr>
				<tr>
					<td width="500">저자 : <%= bookList.getAuthor() %></td>
				</tr>
				<tr>
					<td width="500">출판사 : <%= bookList.getPublishing_com() %></td>
				</tr>
				<tr>
					<td width="500">
						정가 : <%= NumberFormat.getInstance().format(bookList.getBook_price()) %>원<br>
						<%
							double discount = (100-bookList.getDiscount_rate())/100.0;
							int buyPrice = (int)(bookList.getBook_price() * discount);
						%>
						판매가 : <b><font color="red"><%= NumberFormat.getInstance().format(buyPrice) %></font>원</b>
					</td>
				</tr>
				<tr>
					<td width="500">
						수량 : <input type="text" size="5" name="buy_count" value="1">개
						<% 
						if(id.equals("not")){ 
							if(bookList.getBook_count() == 0){
						%>
							<b>일시품절</b>
						<% 
							} 
						}else {
							if(bookList.getBook_count() == 0){
						%>
							<b>일시품절</b>
						<%
							}else {
						%>
							<input type="hidden" name="book_id" value="<%= book_id %>">
							<input type="hidden" name="book_image" value="<%= bookList.getBook_image() %>">
							<input type="hidden" name="book_title" value="<%= bookList.getBook_title() %>">
							<input type="hidden" name="buy_price" value="<%= buyPrice %>">
							<input type="hidden" name="book_kind" value="<%= book_kind %>">
							<input type="submit" value="장바구니에 담기">
						<%
								
							}
						}
						%>
						<input type="button" value="목록으로" onclick="window.location.href='16_list.jsp?book_kind=<%= book_kind %>'">
						<input type="button" value="메인으로" onclick="window.location.href='00_shopMain.jsp'">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<br><%= bookList.getBook_content() %>
					</td>
				</tr>
			</table>
		</form>	
	</body>
</html>