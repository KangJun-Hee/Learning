
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="cp"  value="${pageContext.request.contextPath}"  /> 
<script src="${cp}/resources/jq/jquery-1.11.0.min.js"></script> 
<script src="${cp}/resources/js/01_01_managerlogin.js"></script>


<c:if test="${empty sessionScope.id}">
		<label for="id">아이디</label>
            <input id="id" name="id" type="email" size="20" 
              maxlength="50" placeholder="example@kings.com">
         <label for="passwd">비밀번호</label>
            <input id="passwd" name="passwd" type="password" 
              size="20" placeholder="6~16자 숫자/문자" maxlength="16">
            <button id="login">로그인</button>

</c:if>

<c:if test="${!empty sessionScope.id}">
	
   		관리자 로그인 성공!!. 작업중...
    	<button id="logout">로그아웃</button>   
  	
</c:if> 