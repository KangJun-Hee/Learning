<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>

</head>
<body>
	<div align="center">
		<h1>회원정보 수정</h1>
		<p>개인정보와 입사지원 내용을 확인해주세요.</p>
		<hr>

		<form action="updatePro.do" method="post">

			<h4>개인 정보</h4>

			<label>아이디</label> <input type="text" id="id" name="id"
				value="${ bean.id }" readonly> <br>
			<br> <label>패스워드</label> <input type="password" id="pw"
				name="pw" value="${ bean.pw }"> <br>
			<br> <label>이름</label> <input type="text" id="name" name="name"
				value="${ bean.name }"> <br>
			<br> <label for="tel">연락처</label> <input type="text" id="tel"
				name="tel1" value="${ tel1 }" size="3"> - <input type="text"
				id="tel" name="tel2" value="${ tel2 }" size="4"> - <input
				type="text" id="tel" name="tel3" value="${ tel3 }" size="4">
			<br>
			<br> <label for="email">이메일</label> <input type="email"
				id="email" name="email" value="${ bean.email }">


			<h4>지원 분야</h4>

			<label> <input type="radio" name="field" value="publishing"
				<c:if test="${ bean.field eq 'publishing' }"> checked </c:if>>웹
				퍼블리싱
			</label> <label> <input type="radio" name="field" value="frontend"
				<c:if test="${ bean.field eq 'frontend' }" > checked </c:if>>프론트앤드
			</label> <label> <input type="radio" name="field" value="application"
				<c:if test="${ bean.field eq 'application' }" > checked </c:if>>웹
				애플리케이션 개발
			</label>

			<h4>기술 능력</h4>

			<label> <input type="checkbox" name="skill" value="html">HTML
			</label> <label> <input type="checkbox" name="skill" value="css">CSS
			</label> <label> <input type="checkbox" name="skill"
				value="javascript">JavaScript
			</label> <label> <input type="checkbox" name="skill" value="java">Java
			</label> <label> <input type="checkbox" name="skill" value="jsp">JSP
			</label> <label> <input type="checkbox" name="skill" value="spring">Spring
			</label>


			<h4>전공 분야</h4>

			<label for="major">학과</label> <select id="major" name="major">
				<option value="computer"
					<c:if test="${ bean.major eq 'computer' }">selected</c:if>>컴퓨터공학과</option>
				<option value="elec"
					<c:if test="${ bean.major eq 'elec' }">selected</c:if>>전기전자공학과</option>
				<option value="mechanic"
					<c:if test="${ bean.major eq 'mechanic' }">selected</c:if>>기계공학과</option>
				<option value="indust"
					<c:if test="${ bean.major eq 'indust' }">selected</c:if>>산업공학과</option>
			</select> <br>
			<br>
			<div>
				<input type="submit" value="수정하기"> <input type="reset"
					value="다시 쓰기">
			</div>
		</form>
	</div>
</body>