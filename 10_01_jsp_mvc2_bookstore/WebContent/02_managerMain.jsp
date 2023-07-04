<%-- 02_managerMain --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>관리자 메인</title>
	</head>
	<body>
		<%-- 로그아웃 상태 --%>
		<c:if test="${ empty sessionScope.mngId }">
			<p>로그인 하세요.</p>
		</c:if>
		
		<%-- 로그인 상태 --%>
		<c:if test="${ !empty sessionScope.mngId }">
			<table>
				<tr>
					<th align="right">상품관련 작업</th>
					<td>
						<button onclick="window.location.href='/10_01_jsp_mvc2_bookstore/mg/bookRegister.do'">
							상품등록
						</button>
						<button onclick="window.location.href='/10_01_jsp_mvc2_bookstore/mg/bookList.do?book_kind=all'">
							상품수정/삭제
						</button>
					</td>
				</tr>
				<tr>
					<th align="right">구매된 상품관련 작업</th>
					<td colspan="2">
						<button onclick="window.location.href='#'">
							전체구매목록 확인
						</button>
					</td>
				</tr>
			
			</table>
		</c:if>
	</body>
</html>