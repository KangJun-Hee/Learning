<%@page import="bookstore.CartDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
// 19번에 버튼을 클릭하면 넘어오는 데이터를 저장 
String list = request.getParameter("list");
String book_kind = request.getParameter("book_kind");

String buyer = (String)session.getAttribute("id");

if (buyer == null) {
	response.sendRedirect("00_shopMain.jsp");
} else {
	
	// 1. 카드에서 처리하는 메서드를 호출 CartDAO 
	CartDAO bookDAO = CartDAO.getInstance();
	
	if(list.equals("all")){
		
		bookDAO.deleteAll(buyer);
		
		
	}else{
		bookDAO.deleteList(Integer.parseInt(list));
		
	}		
	response.sendRedirect("19_cartList.jsp?book_kind=" + book_kind);
}
%>    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>20_cartListDel.jsp</title>
</head>
<body>
	<!-- 삭제를 진행하는 파일 
	전체 비우기를 선택할 지 하나씩 목록에서 제거할 지 구별 
	
	
	 -->
</body>
</html>