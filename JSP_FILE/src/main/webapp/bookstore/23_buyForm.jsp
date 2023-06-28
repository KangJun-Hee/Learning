<%@page import="bookstore.CustomerDTO"%>
<%@page import="bookstore.CartDAO"%>
<%@page import="bookstore.BuyDAO"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="bookstore.CustomerDAO"%>
<%@page import="bookstore.CartDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<%
	String book_kind = request.getParameter("book_kind");
	String buyer = (String)session.getAttribute("id");
	
	List<CartDTO> cartLists = null;
	List<String> accountLists = null;
	
	CartDTO cartList = null;
	CustomerDTO member = null;
	
	int number = 0;
	int total = 0;
	
	if(buyer == null){
		response.sendRedirect("00_shopMain.jsp");
	}else{
		CartDAO cartDAO = CartDAO.getInstance();
		cartLists = cartDAO.getCart(buyer); 
		
		CustomerDAO memberDAO = CustomerDAO.getInstance();
		member = memberDAO.getMember(buyer); 

		BuyDAO buyDAO = BuyDAO.getInstance();
		accountLists = buyDAO.getAccount(); 
%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>도서 구매하기</title>
	</head>
	<body>
		<h3><b>구매 목록</b></h3>
		<table border="1">
			<tr>
				<td width="50">번호</td>
				<td width="300">책이름</td>
				<td width="100">판매가격</td>
				<td width="150">수량</td>
				<td width="150">금액</td>
			</tr>
			<%
			for(int i=0; i<cartLists.size(); i++){
				cartList = cartLists.get(i);
			%>
			<tr>
				<td width="50"><%= ++number %></td>
				<td width="300">
					<img src="imageFileSave/<%= cartList.getBook_image() %>" width="30" height="50">
					<%= cartList.getBook_title() %>
				</td>
				<td width="100">
					<%= NumberFormat.getInstance().format(cartList.getBuy_price()) %>
				</td>
				<td width="150"><%= cartList.getBuy_count()%></td>
				<td width="150">
					<%= NumberFormat.getInstance().format(cartList.getBuy_count() * cartList.getBuy_price()) %>
				</td>
			</tr>
			<%
				}
			%>
			<tr>
				<td colspan="5">
					<% total += cartList.getBuy_count() * cartList.getBuy_price(); %>
					<b>총 구매금액 : <%= NumberFormat.getInstance().format(total) %></b>
				</td>
			</tr>
		</table>
		<%} %>
		<br>
		
		<form method="post" action="24_buyFormPro.jsp">
			<table border="1">
				<tr>
					<th colspan="2">주문자정보</th>
				</tr>
				<tr>
					<th width="200">성명</th>
					<td width="400"><%= member.getName() %></td>
				</tr>
				<tr>
					<th width="200">전화번호</th>
					<td width="400"><%= member.getTel() %></td>
				</tr>
				<tr>
					<th width="200">주소</th>
					<td width="400"><%= member.getAddress() %></td>
				</tr>
				<tr>
					<th width="200">결제계좌</th>
					<td width="400">
						<select name="account">
							<%
							for(int i=0; i<accountLists.size(); i++){
								String accountList = accountLists.get(i);
							%>
							<option value="<%= accountList %>"><%= accountList %></option>
							<%} %>
						</select>
					</td>
				</tr>
			</table>
			<br>
			
			<table border="1">
				<tr>
					<th colspan="2" align="center">배송지 정보</th>
				</tr>
				<tr>
					<td width="200">성명</td>
					<td width="400">
						<input type="text" name="deliveryName" value="<%= member.getName() %>">
					</td>
				</tr>
				<tr>
					<td width="200">전화번호</td>
					<td width="400">
						<input type="text" name="deliveryTel" value="<%= member.getTel() %>">
					</td>
				</tr>
				<tr>		
					<td width="200">주소</td>
					<td width="400">
						<input type="text" name="deliveryAddress" value="<%= member.getAddress() %>">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="확인">
						<input type="button" value="취소" onclick="window.location.href='00_shopMain.jsp'">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
