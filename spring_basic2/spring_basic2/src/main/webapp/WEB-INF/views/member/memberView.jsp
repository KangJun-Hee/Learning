<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath }" />

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="title" name="demoTest"/>
</jsp:include>

<h2 class="text-center"> 회원정보 보기 </h2>

<section id="content" class="container text-center" style="width: 40%">
	<table class="table text-center">
		<tr>
			<th>아이디</th>
			<td>${member.id}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${member.name}</td>
		</tr>
		<tr>
			<th>나이</th>
			<td>${member.age}</td>
		</tr>
		<tr>
			<th >성별</th>
			<td>${member.gender}</td>
		</tr>
		<tr>
			<th >좋아하는 언어</th>
			<td>
				<c:forEach var = "lang" items="${member.devLang}" varStatus="vs">
					${lang}
					<c:if test="${not vs.last}}">
						<c:out value=", "/>
					</c:if>
				</c:forEach>			
			</td>
		</tr>
	</table>
</section>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>