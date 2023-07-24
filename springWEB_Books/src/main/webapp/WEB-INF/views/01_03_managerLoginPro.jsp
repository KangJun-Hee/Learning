
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp"  value="${pageContext.request.contextPath}"  /> 
<script src="${cp}/resources/jq/jquery-1.11.0.min.js"></script> 

<c:if test="${check == 1}">
	<c:set var="id" value="${id}" scope="session"/>
</c:if>