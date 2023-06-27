<%@page import="bookstore.CartDAO"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="bookstore.CartDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String book_kind = request.getParameter("book_kind");
String buyer = (String) session.getAttribute("id");

//장바구니에 저장되는 데이터를 저장하는 vo클래스 cartDTO
List<CartDTO> cartLists = null;
CartDTO cartList = null;

int number = 0;
int count = 0;
int total = 0;
%>


<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>장바구니 목록</title>
</head>
<body>
	<h3>
		<b>장바구니</b>
	</h3>
	<%
	if (buyer == null) {
		response.sendRedirect("00_shopMain.jsp");

	} else {
		CartDAO bookDAO = CartDAO.getInstance();
		count = bookDAO.getListCount(buyer);

		if (count == 0) {
	%>
	<table border="1">
		<tr>
			<td>장바구니에 담긴 물품이 없습니다.</td>
		</tr>
		<tr>
			<td><input type="button" value="쇼핑계속"
				onclick="window.location.href='16_list.jsp?book_kind=<%=book_kind%>'">
			</td>
		</tr>
	</table>
	<%
	} else {
	cartLists = bookDAO.getCart(buyer);
	%>
	<form method="post" action="23_buyForm.jsp">
		<table border="1">
			<tr>
				<td width="50">번호</td>
				<td width="300">책이름</td>
				<td width="100">판매가격</td>
				<td width="150">수량</td>
				<td width="150">금액</td>
			</tr>
			<%
			for (int i = 0; i < cartLists.size(); i++) {
				cartList = (CartDTO) cartLists.get(i);
			%>
			<tr>
				<td width="50"><%=++number%></td>
				<td width="300"><img
					src="imageFileSave/<%=cartList.getBook_image()%>" width="30"
					height="50"> <%=cartList.getBook_title()%></td>
				<td width="100"><%=NumberFormat.getInstance().format(cartList.getBuy_price())%>
				</td>
				<td width="150"><input type="text" name="buy_count" size="5"
					value="<%=cartList.getBuy_count()%>"> <%
 String url = "21_updateCartForm.jsp?cart_id=" + cartList.getCart_id() + "&book_kind=" + book_kind + "&buy_count="
 		+ cartList.getBuy_count();
 %> <input type="button" value="수정"
					onclick="window.location.href='<%=url%>'"></td>
				<td width="150">
					<%
					total += cartList.getBuy_count() * cartList.getBuy_price();
					%> <%=NumberFormat.getInstance().format(cartList.getBuy_count() * cartList.getBuy_price())%>
					<input type="button" value="삭제"
					onclick="window.location.href='20_cartListDel.jsp?list=<%=cartList.getCart_id()%>&book_kind=<%=book_kind%>'">
				</td>
			</tr>
			<%
			}
			%>
			<tr>
				<td colspan="5"><b>총 금액 : <%=NumberFormat.getInstance().format(total)%></b>
				</td>
			</tr>
			<tr>
				<td colspan="5"><input type="submit" value="구매하기"> <input
					type="button" value="쇼핑계속"
					onclick="window.location.href='16_list.jsp?book_kind=<%=book_kind%>'">
					<input type="button" value="장바구니비우기"
					onclick="window.location.href='20_cartListDel.jsp?list=all&book_kind=<%=book_kind%>'">
				</td>
			</tr>
		</table>
	</form>
	<%
	}
	}
	%>
</body>

</html>