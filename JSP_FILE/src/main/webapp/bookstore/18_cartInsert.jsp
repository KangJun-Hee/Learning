<%@page import="bookstore.CartDTO"%>
<%@page import="bookstore.CartDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    
    request.setCharacterEncoding("utf-8");
   
    %>
    
   
   <%
   
   String book_kind = request.getParameter("book_kind");
   String buy_count = request.getParameter("buy_count");
   String book_id = request.getParameter("book_id");
   String book_title = request.getParameter("book_title");
   String book_image = request.getParameter("book_image");
   String buy_price = request.getParameter("buy_price");

   String buyer = (String)session.getAttribute("id");


   CartDTO cart = new CartDTO();
   cart.setBook_id(Integer.parseInt(book_id));
   cart.setBook_image(book_image);
   cart.setBook_title(book_title);
   cart.setBuy_count(Byte.parseByte(buy_count));
   cart.setBuy_price(Integer.parseInt(buy_price));
   cart.setBuyer(buyer);

   CartDAO bookProcess = CartDAO.getInstance();
   bookProcess.insertCart(cart);

   System.out.println("18");
   
   response.sendRedirect("19_cartList.jsp?book_kind="+book_kind);
   
   %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>