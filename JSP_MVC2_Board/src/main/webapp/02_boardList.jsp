<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!--   숫자를 양식에 맞춰 문자열로 변환해주는 라이브러리 
	value ="숫자값"
	type= "값타입"
	pattern="패턴" 
	integerOnly = ""  정수 부분만 파싱할 것인지 여부 기본적으로 false 
	var = "파싱한 결과저장하는 변수명"
	scope = "변수를 저장할 영역을 지정한다." 기본적page

-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div align="center">
	
		<h2>전체 게시글 보기</h2>
	
		<table width="700" border="1">
			<tr height="40">
				<td colspan="5" align="right">
					<button onclick="location.href='01_write.jsp'">글쓰기</button>
				</td>
			</tr>
			<tr height="40" align="right">
				<td width="50" align="center">번호</td>
				<td width="320" align="center">제목</td>
				<td width="100" align="center">작성자</td>
				<td width="150" align="center">작성일</td>
				<td width="80" align="center">조회수</td>
			</tr>

			<c:set var="number" value="${number}" />
			<c:forEach var="bean" items="${list}">
				<tr height ="40">
					<td width="50" align="center">${number}</td>
					<td width="320" align="center">
						<c:if test="${bean.re_step > 1}">
							<c:forEach var ="j" begin="1" end="">
							&nbsp;
							<!-- 댓글이면 한칸 , 대댓글이다. 두칸 세간 까지 들여쓰기 -->
							</c:forEach>
						</c:if>
					<a href="InfoAction?num=${bean.num}">${bean.subject}</a>
					</td>
					<td width="100" align="center">${bean.writer}</td>
					<td width="150" align="center">${bean.reg_date}</td>
					<td width="80" align="center">${bean.readcount}</td>
					
				</tr>
				<c:set var ="number" value ="${number -1}"/>
			</c:forEach>

		</table>
	<c:if test="${ count> 0}">
	<c:set var="pageCount" value="${ count / pageSize + (count % pageSize == 0 ? 0 : 1)}"/>
	<fmt:parseNumber var="pageCount" value="${pageCount} " integerOnly="true"></fmt:parseNumber>
	<fmt:parseNumber var="result" value="${currentPage/10} " integerOnly="true"></fmt:parseNumber>
	
		
		
		<c:if test="${ currentPage % 10  ne 0 }">
			<c:set var="startPage" value="${(result) * 10 + 1 }"></c:set> 
		</c:if>
			
		<c:if test="${currentPage % 10 eq 0}">				
			 	<c:set var="startPage" value="${(result-1) * 10 + 1 }"></c:set> 
				
		</c:if> 
	
		<!-- 화면에 보여질 페이지 숫자를 표현 -->	
		<c:set var="endPage" value="${ startPage + 10 - 1 }"></c:set>
		<c:if test="${ endPage >  pageCount}">
			<c:set var="endPage" value="${ pageCount }"></c:set>
		</c:if>
		
		<!--  이전 링크를 갈지 파악 -->
		<c:if test="${startPage >10 }">
			<a href="BoardListAction?pageNum=${startPage-10 }">[이전]</a>
		</c:if>
		 
		 <!-- 페이징 처리 -->
		 <c:forEach var="i" begin="${startPage }" end="${endPage}">
			<a href="BoardListAction?pageNum=${i }">[${i}]</a>
		</c:forEach> 
		 
		<!-- 다음 -->
		<c:if test="${endPage < pageCount }">
			<a href="BoardListAction?pageNum=${startPage+10 }">[다음]</a>
		</c:if>  
		 
	</c:if>
	</div>




</body>
</html>