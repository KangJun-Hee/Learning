<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--  수정하기 (수량) 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	21파일로 넘어와서 간단하게 입력 받아서 수정
	
	삭제는 페이지에서 내용을 삭제하기 그런다음 장바구니 목록 다시 보여주기 
	
	전체 비우기를 하면 19번 파일로 가서 캡처본 참조하기 
	
	
	
</body>
</html>
	 -->
<%
String cart_id = request.getParameter("cart_id");
String buy_count = request.getParameter("buy_count");
String book_kind = request.getParameter("book_kind");

if (session.getAttribute("id") == null) {
	response.sendRedirect("00_shopMain.jsp");
} else {
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>장바구니 수정</title>
</head>
<body>
	<form method="post" action="22_updateCartPro.jsp">
		변경할 수량 : <input type="text" name="buy_count" size="5"
			value="<%=buy_count%>"> <input type="hidden" name="cart_id"
			value="<%=cart_id%>"> <input type="hidden" name="book_kind"
			value="<%=book_kind%>"> <input type="submit" value="변경하기">
	</form>
</body>
</html>
<%
}
%>



