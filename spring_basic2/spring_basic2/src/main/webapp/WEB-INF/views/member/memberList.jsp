<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>


<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value="demoTest"/>
</jsp:include>

<section id="content" class="container text-center" style="width: 90%">
	<table class="table text-center">
		<tr>
			<td scope="col">아이디</td>
			<td scope="col">이름</td>
			<td scope="col">나이</td>
			<td scope="col">성별</td>
			<td scope="col">좋아하는 언어</td>
		</tr>
		
		<c:forEach var="member" items="${list}" >
			<tr>
				<td>${member.id}</td>
				<td>${member.name}</td>
				<td>${member.age}</td>
				<td>${member.gender}</td>
				<td>
					<c:forEach var="lang" items="${member.devLang}">
						<c:out value="${lang}"/>, 				
					</c:forEach>
				</td>
			</tr>
		</c:forEach>
	</table>
</section>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>