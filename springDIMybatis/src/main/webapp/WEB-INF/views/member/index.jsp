<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>    

<jsp:include page="/WEB-INF/views/common/header.jsp"/>

<c:if test="${not empty msg}">
	<script>
		alert('${msg}');
	</script>
	<c:remove var="msg"/>
</c:if>


<section id="container">
	<h2 style="text-align: center;">회원가입</h2>
	<div id="demo-container">
		<form id="devFrm" method="post">
			<input type="text" class="form-control" placeholder="아이디 (4글자이상)" name="id" id="id" required>
			<input type="text" class="form-control" placeholder="비밀번호" name=password id="password" required>
			<input type="text" class="form-control" placeholder="이름" name="name" id="name" required>
			<input type="number" class="form-control" placeholder="나이" name="age" id="age">
			<input type="email" class="form-control" placeholder="이메일" name="email" id="email" required>
			<input type="tel" class="form-control" placeholder="전화번호 (예:01012345678)" name="phone" id="phone" maxlength="11" required>
			<input type="text" class="form-control" placeholder="주소" name="address" id="address">
			<select class="form-control" name="gender" required>
				<option value="" disabled selected>성별</option>
				<option value="M">남</option>
				<option value="F">여</option>
			</select>
			<div class="form-check-inline form-check">
				취미 : &nbsp; 
				<input type="checkbox" class="form-check-input" name="hobby" id="hobby0" value="운동"><label for="hobby0" class="form-check-label">운동</label>&nbsp;
				<input type="checkbox" class="form-check-input" name="hobby" id="hobby1" value="등산"><label for="hobby1" class="form-check-label">등산</label>&nbsp;
				<input type="checkbox" class="form-check-input" name="hobby" id="hobby2" value="독서"><label for="hobby2" class="form-check-label">독서</label>&nbsp;
				<input type="checkbox" class="form-check-input" name="hobby" id="hobby3" value="게임"><label for="hobby3" class="form-check-label">게임</label>&nbsp;
				<input type="checkbox" class="form-check-input" name="hobby" id="hobby4" value="여행"><label for="hobby4" class="form-check-label">여행</label>&nbsp;
			</div>
			<br/>
			<input type="reset" class="btn btn-outline-success" value="취소">
		</form>
		
		<div class="list-group">
			<button type="button" onclick="demo('memberEnroll.do');" 
			class="list-group-item list-group-item-action">
				가입하기</button>
		</div>
		<hr><br>
		
		<h4>조회 하기</h4>
		<form action="${path}/member/memberSearch.do" method="get">
			<input type="text" class="form-control" placeholder="아이디 (4글자이상)" name="id" id="id" required>
			<br>
			<input type="submit" class="btn btn-outline-success" value="조회" >
		</form>
		<hr><br>
		
		<h4>탈퇴 하기</h4>
		<form action="${path}/member/memberDel.do" method="post">
			<input type="text" class="form-control" placeholder="아이디 (4글자이상)" name="id" id="id" required>
			<br>
			<input type="submit" class="btn btn-outline-success" value="탈퇴" >
		</form>
		
	</div>
</section>

<script>
	function demo(url) {
		$("#devFrm").attr("action", "${path}/member/" + url);
		$("#devFrm").submit();
	}
</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
