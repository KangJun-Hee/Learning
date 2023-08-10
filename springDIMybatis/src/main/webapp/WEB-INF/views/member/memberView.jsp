<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>

<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<section id="content">
	<table class="table">
		<tr>
			<th scope="col">아이디</th>
			<th scope="col">비밀번호</th>
			<th scope="col">이름</th>
			<th scope="col">나이</th>
			<th scope="col">성별</th>
			<th scope="col">전화번호</th>
			<th scope="col">주소</th>
			<th scope="col">이메일</th>
			<th scope="col">취미</th>
			<th scope="col">가입일</th>
		</tr>
			<c:if test="${member != null}">
				<tr>
					<td>${member.id }</td>
					<td>${member.password }</td>
					<td>${member.name }</td>
					<td>${member.age }</td>
					<td>${member.gender }</td>
					<td>${member.phone }</td>
					<td>${member.address }</td>
					<td>${member.email }</td>
					<td>
						<c:forEach var="item" items="${member.hobby }">
							<c:out value="${item}"/>
						</c:forEach>
					</td>
					<td>${member.enrollDate}</td>
				</tr>
			</c:if>
	</table>	

</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
