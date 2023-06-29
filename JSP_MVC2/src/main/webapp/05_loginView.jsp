<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
		<head>
		<meta charset="UTF-8">
		<title>로그인</title>
	</head>
	<body>
		<c:if test="${ 1 eq check }">
			<script type="text/javascript">
				alert('${sessionScope.memId}님, 환영합니다!');
				location.href='index.do';
			</script>
		</c:if>
		<c:if test="${ -1 eq check }">
			<script type="text/javascript">
				alert('아이디와 패스워드를 확인해주세요!');
				history.go(-1);
			</script>
		</c:if>
	</body>



</body>
</html>