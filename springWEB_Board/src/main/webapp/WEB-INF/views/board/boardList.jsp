<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
		<h2>전체게시글보기</h2>
		<table border="1">
			<tr height="40">
				<td colspan="5" align="right">
					<button onclick="location.href='${cp}/board/boardWriteForm'">글쓰기</button>
				</td>
			</tr>
			<tr height="40" align="right">
				<td width="50" align="center">번호</td>
				<td width="320" align="center">제목</td>
				<td width="100" align="center">작성자</td>
				<td width="150" align="center">작성일</td>
				<td width="80" align="center">조회수</td>
			</tr>
			
			<c:forEach var="bean" items="${boardList}">
				<tr height="40">
					<td width="50" align="center">${number}</td>
					<td width="320" align="left">
						<c:if test="${bean.re_step > 1 }">
							<c:forEach var="j" begin="1" end="${(bean.re_step - 1) * 5}">
							&nbsp;
							</c:forEach>
						</c:if> 
						<a href="${cp}/board/boardInfo?num=${bean.num}"> ${bean.subject}</a>
					</td>
					<td width="100" align="center">${bean.writer}</td>
					<td width="150" align="center">${bean.reg_date}</td>
					<td width="80" align="center">${bean.readcount}</td>
				</tr>
				<c:set var="number" value="${number - 1}" />
			</c:forEach>
		</table>
		<br>

		<!--  페이지 카운터링 소스를 작성 -->
		<c:if test="${count > 0}">
			<c:if test="${startPage > clickablePageCount }">
				<a href="${cp}/board/boardList?pageNum=${startPage - clickablePageCount}">[이전]</a>
			</c:if>

			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<a href="${cp}/board/boardList?pageNum=${i}">[${i}]</a>
			</c:forEach>

			<c:if test="${endPage < pageCount }">
				<a href="${cp}/board/boardList?pageNum=${startPage + clickablePageCount}">[다음]</a>
			</c:if>
		</c:if>
	</div>

</body>
</html>