<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
    
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${param.title}</title>
	<link rel="stylesheet" href="${path}/resources/css/main.css" >
	<script src="${path}/resources/js/jquery-3.6.0.min.js"></script>
</head>

<body>
	<header>
		<h2>${param.title}</h2>
		<div class="login-container">
		<c:if test="${loginMember == null}">
			<form id="loginFrm" action="${path}/login" method="post">
				<table>
					<tr>
						<td>
							<input type="text" name="userId" id="userId" placeholder="아이디" required="required">
						</td>
						<td>
						</td>
					</tr>				
					<tr>
						<td>
							<input type="password" name="userPwd" id="userPwd" placeholder="비밀번호" required="required">
						</td>
						<td>
							<input type="submit" value="로그인">
						</td>
					</tr>			
					<tr>
						<td colspan="2">
							<input type="button" value="회원가입" onclick="location.href='${path}/member/enroll';"/>
						</td>
					</tr>	
				</table>
			</form>
		</c:if>
		<%--일반 로그인 폼 영역 종료--%>
		
		<c:if test="${ loginMember != null }">
		<%--로그인 된 사용자 정보 보여주는 폼 영역 시작--%>
			<table>
				<tr>
					<td colspan="2">
						${loginMember.name} 님 안녕하세요?
					</td>
				</tr>
				<tr>
					<td>	
						<button onclick="location.href = '${path}/member/view';">내정보</button>
					</td>
					<td>
						<button onclick="location.replace('${path}/logout')">로그아웃</button>
					</td>
				</tr>
			</table>
		</c:if>
		<%--로그인 된 사용자 정보 보여주는 폼 영역 종료--%>
		</div>
		<nav>
			<ul class="main-nav">
				<li class="home"><a href="${path}">Home</a></li>		
				<li class="notice"><a>공지사항</a></li>
				<li class="board"><a href="${path}/board/list">게시판</a></li>
				<c:if test="${ loginMember.role == 'ROLE_ADMIN' }">
					<li class="admin-member">
						<a href="${path}/admin/member"> 회원관리</a>
					</li>	
				</c:if>
			</ul>
		</nav>
	</header>
		
