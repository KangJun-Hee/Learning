<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>쇼핑몰 메인</title>
	</head>
	<body>
		<table border="1">
			<tr>
				<td colspan="3" align="center">
					<a href="#">문학</a>&nbsp;&nbsp;&nbsp;
					<a href="#">외국어</a>&nbsp;&nbsp;&nbsp;
					<a href="#">컴퓨터</a>&nbsp;&nbsp;&nbsp;
					<a href="#">전체</a>
				</td>
			</tr>
			<c:forEach var="bookList" items="${ bookLists }">
				<c:set var="book_kind" value="${ bookList[0].book_kind }" />
				<c:if test="${ book_kind == '100' }">
					<c:set var="book_kindName" value="문학" />
				</c:if>				
				<c:if test="${ book_kind == '200' }">
					<c:set var="book_kindName" value="외국어" />
				</c:if>				
				<c:if test="${ book_kind == '300' }">
					<c:set var="book_kindName" value="컴퓨터" />
				</c:if>				
				<tr>
					<td colspan="3" align="center">
						<p><b>[ ${ book_kindName } ] 분류의 신간목록 : 
							<a href="#">더보기</a></b>
						</p>
					</td>
				</tr>
				<c:forEach var="book" items="${ bookList }">
				<tr height="30">
					<td rowspan="4" width="100">
						<a href="#">
							<img src="/10_01_jsp_mvc2_bookstore/bookImage/${ book.book_image }" width="100">
						</a>
					</td>
					<td width="350">
						<a href="#">
							${ book.book_title }
						</a>
					</td>
					<td rowspan="4" width="100">
						<c:if test="${ book.book_count == 0 }">
							<font color="red">일시품절</font>
						</c:if>
						<c:if test="${ book.book_count != 0 }">
							구매가능
						</c:if>
					</td>
				</tr>
				<tr height="30">
					<td width="350">출판사 : ${ book.publishing_com }</td>
				</tr>
				<tr height="30">
					<td width="350">저자 : ${ book.author }</td>
				</tr>
				<tr height="30">
					<td width="350">
						<c:set var="price" value="${ book.book_price }" />
						정가 : <fmt:formatNumber value="${price}" type="number" pattern="#,##0"/>원<br>
						<strong>판매가 : <fmt:formatNumber value="${price*((100.0-book.discount_rate)/100)}" type="number" pattern="#,##0"/>원</strong>
					</td>
				</tr>
				</c:forEach>
			</c:forEach>
		</table>
	</body>
</html>














