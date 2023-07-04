<%-- 06_bookList.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>관리자 상품등록</title>
	</head>
	<body>
		<%-- 로그아웃 상태 --%>
		<c:if test="${ empty sessionScope.mngId }">
			<script type="text/javascript">
				location.href='/10_01_jsp_mvc2_bookstore/mg/main.do';
			</script>
		</c:if>
		<%-- 로그인 상태 --%>
		<p>등록된 상품 목록(전체 상품 : ${ count }개)</p>
		<button onclick="window.location.href='/10_01_jsp_mvc2_bookstore/mg/bookRegister.do'"> 
			책 등록
		</button>
		<button onclick="window.location.href='/10_01_jsp_mvc2_bookstore/mg/main.do'">
			관리자 메인으로
		</button>
		<br><br>
		
		<c:if test="${ count == 0 }">
			등록된 상품이 없습니다.
		</c:if>
		
		<c:if test="${ count > 0 }">
			<table border="1">
				<tr>
					<th width="30">번호</th> 
					<th width="30">책분류</th> 
					<th width="200">제목</th>
					<th width="70">가격</th> 
					<th width="40">수량</th> 
					<th width="100">저자</th>
					<th width="100">출판사</th>
					<th width="90">출판일</th>
					<th width="50">책이미지</th>
					<th width="50">할인율</th>
					<th width=120>등록일</th>
					<th width="50">수정</th>
					<th width="50">삭제</th> 					
				</tr>
				
				<c:set var="number" value="${ 0 }" />
				<c:forEach var="book" items="${ bookList }">
					<tr>
						<td align="center" width="30">${ number = number + 1 }</td>
						<td width="30">${ book.book_kind }</td>
						<td width="200">${ book.book_title }</td>
						<td width="70">
						 <fmt:formatNumber pattern="#,###" value="${ book.book_price }" />원
						</td>
						<td width="40">
							<c:if test="${ book.book_count == 0 }">
								<font color="red">일시품절</font>
							</c:if>
							<c:if test="${ book.book_count > 0 }">
								${ book.book_count }개
							</c:if>
						</td>
						<td width="100">${ book.author }</td>
						<td width="100">${ book.publishing_com }</td>
						<td width="90">
							${ book.publishing_date }
						</td>
						<td width="50">${ book.book_image }</td>
						<td width="50">${ book.discount_rate }%</td>
						<td width="120">${ book.reg_date }</td>
						<td width="50">
							<button onclick="window.location.href='/10_01_jsp_mvc2_bookstore/mg/bookUpdate.do?book_id=${ book.book_id}&book_kind=${ book.book_kind}'">
								수정
							</button>
						</td>
						<td width="50">
							<button onclick="window.location.href='/10_01_jsp_mvc2_bookstore/mg/bookDeletePro.do?book_id=${ book.book_id}&book_kind=${ book.book_kind}'">
								삭제
							</button>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</body>
</html>

















