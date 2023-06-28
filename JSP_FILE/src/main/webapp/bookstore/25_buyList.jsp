<%@page import="bookstore.BuyDAO"%>
<%@page import="bookstore.BuyDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String buyer = (String)session.getAttribute("id");
	
	List<BuyDTO> buyLists = null;
	BuyDTO buyList = null;
	
	int count = 0;
	int number = 0;
	int total = 0;
	int compareId = 0;
	int preId = 0;
	
	if(buyer == null){
		response.sendRedirect("00_shopMain.jsp");
	}else{
		BuyDAO buyDAO = BuyDAO.getInstance();
		count = buyDAO.getListCount(buyer);
%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>도서 구매목록</title>
	</head>
	<body>
	<h3><b>구매목록</b></h3>
<%		
		if(count == 0) {
%>
	<table>
		<tr>
			<td align="center">구매 목록이 없습니다.</td>
		</tr>
		<tr>
			<td>
				<input type="button" value="메인으로" 
					onclick="window.location.href='00_shopMain.jsp'">
			</td>
		</tr>
	</table>	
<%		
		}else{
			buyLists = buyDAO.getBuyList(buyer);
%>
	<table border="1">
		<tr>
			<td width="150">번호</td>
			<td width="300">책이름</td>
			<td width="100">판매가격</td>
			<td width="50">수량</td>
			<td width="150">금액</td>
		</tr>
		<%
		for(int i=0; i<buyLists.size(); i++){
			buyList = buyLists.get(i);
		%>
		<tr>
			<td width="150"><%= ++number %></td>
			<td width="300"><%= buyList.getBook_title() %></td>
			<td width="100"><%= buyList.getBuy_price() %></td>
			<td width="50"><%= buyList.getBuy_count() %></td>
			<td width="150"><%= buyList.getBuy_price() %></td>
		</tr>
		<%} %>
	</table>	
<%			
		}
	}
%>
	</body>

</html>