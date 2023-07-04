<%-- 08_bookRegisterPro.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>관리자 책등록</title>
	</head>
	<body>
	<%-- 책 정보가 중복되지 않는다면 --%>
	<c:if test="${ check == 1 }">
		<script type="text/javascript">
			alert('책이 등록되었습니다.');
			location.href='/10_01_jsp_mvc2_bookstore/mg/bookList.do?book_kind=${ book_kind }';
		</script>
	</c:if>
	<%-- 책 정보가 중복된다면 --%>
	<c:if test="${ check == -1 }">
		<script type="text/javascript">
			alert('이미 등록된 책입니다.');
			history.go(-1);
		</script>
	</c:if>
	</body>
</html>