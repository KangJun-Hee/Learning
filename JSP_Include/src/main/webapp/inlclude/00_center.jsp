<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션태그 include</title>
</head>
<body>

	<h2>include 액 션 태 그</h2>
	<!-- top -->
	<jsp:include page="01_top.jsp"></jsp:include>
	
	<!--  center -->
	<hr>
	<h1>바나나</h1>
	<p>바나나는 바나나는 파초과 바나나 속에 속하는 숙근성 영년생 열대과수를 총칭한다.</p>

	<h2>다이어트 식품</h2>
	<p>바나나는 탄수화물이 약 27%이고 비타민 A와 C가 풍부하며, 100g당 87kcal의 열량을 갖는다.</p>


	<h2>다양한 섭취법</h2>
	<p>바나나는 열매를 주식으로 이용할 뿐 아니라 미성숙한 열매는 채소로 다양한 요리에 응용된다.</p>

	<hr>
	
	<!--  bottom -->
	<jsp:include page="02_bottom.jsp"></jsp:include>
	
</body>
</html>