<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style type="text/css">
.input {
	width: 96%;
	background-color: hotpink;
	padding: 5px;
}
</style>
</head>
<body>
	<!-- 
		onsubmit 이벤트는 form의 submit버튼이 클릭되면 실행되는 이벤트
		form check는 submit버튼이 클릭되면 실행되는 onsubmit이벤트에서 javascript
		함수를 실행해서 form에 입력된 데이터가 정상적인지 유효서검사해서 결과가
		정상 true,비정상 false 리턴
		
		true : action속성으로 지정한 페이지 넘겨 주고
		false : 현재페이지 그대로 머물게 한다~
		
			onkeypress=>키보드를 누르고 있을 때 실행되는 이벤트
			onkeydown=>키보드 누르는 순간 실행되는 이벤트
			onkeyup=>
	 -->
	<form action="?" method="post" onsubmit="return passwordCheck(this)">
		<table width="500" border="1" align="center" cellpadding="5"
			cellspacing="0">

			<tr>
				<th colspan="2">회원 가입</th>
			</tr>

			<tr>
				<th width="150">아이디</th>
				<td width="350"><input class="input" type="text" name="id"
					placeholder="아이디를 입력하세요" /></td>
			</tr>

			<tr>
				<th>이름</th>
				<td><input class="input" type="text" name="name"
					placeholder="이름을 입력하세요" /></td>
			</tr>

			<tr>
				<th>비밀번호</th>
				<td><input class="input" type="text" name="password"
					placeholder="비밀번호를 입력하세요" /></td>
			</tr>

			<tr>
				<th>비밀번호 확인</th>
				<td><input class="input" type="password" name="repassword"
					placeholder="비밀번호를 한번더 입력하세요" /></td>
			</tr>

			<tr>
				<th>나이</th>
				<td><input class="input" type="text" name="age"
					placeholder="나이를 입력하세요" /></td>
			</tr>

			<tr>
				<th>성별</th>
				<td><input type="radio" name="gender" value="true"
					checked="checked" />남자 <input type="radio" name="gender"
					value="false" />여자</td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="회원가입" /> <input type="reset" value="다시쓰기" /></td>
			</tr>

		</table>
		<!-- getRemoteAddr()메서드로 접속자 ip주소 얻어올 수 있다~ -->
		<input type="hidden" name="ip" value="<%=request.getRemoteAddr()%>" />
	</form>

</body>
</html>