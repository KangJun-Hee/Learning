<%@page import="bookstore.BuyDAO"%>
<%@page import="bookstore.CartDTO"%>
<%@page import="java.util.List"%>
<%@page import="bookstore.CartDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>

<%
	String account = request.getParameter("account");
	String deliveryName = request.getParameter("deliveryName");
	String deliveryTel = request.getParameter("deliveryTel");
	String deliveryAddress = request.getParameter("deliveryAddress");
	String buyer = (String)session.getAttribute("id");

	CartDAO cartDAO = CartDAO.getInstance();
	List<CartDTO> cartLists = cartDAO.getCart(buyer);
	
	// 결제를 도와주는 insertBuy() 메서드를 이용해서 구매 목록을 채워준다.
	// 데이터베이스에 저장하면 25파일로 넘어간다.

	BuyDAO buyDAO = BuyDAO.getInstance();
	buyDAO.insertBuy(cartLists,buyer,account,deliveryName
									,deliveryTel,deliveryAddress);
	
	
	response.sendRedirect("25_buyList.jsp");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  구매한 데이터를 buyDAO이용해서 저장! -->
</body>
</html>