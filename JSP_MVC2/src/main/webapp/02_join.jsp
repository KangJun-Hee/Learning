<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	
		<h1>회원 가입</h1>
		<p>kh 아카데미를 찾아주셔서 감사합니다.</p>
		<hr>
		
		<form action="joinPro.do" method="post">
			<h4>로그인 정보</h4>
			
					<label >아이디</label>
					<input type="text" id="id" name="id">
				<br><br>
					<label >패스워드</label>
					<input type="password" id="pw" name="pw">
				<br>
			<h4>개인 정보</h4>
			
					<label >이름</label>
					<input type="text" id="name" name="name" autofocus placeholder="공백없이 입력하세요">
				<br><br>
					<label >연락처</label>
					<input type="text" id="number" name="tel1" size="3"> - 
					<input type="text" id="number" name="tel2" size="4"> - 
					<input type="text" id="number" name="tel3" size="4">
				<br><br>
					<label >이메일</label>
					<input type="email" id="email" name="email">
				
			<br><br><br>
			<div>
				<input type="submit" value="회원가입">
				<input type="reset" value="다시 쓰기">
			</div>
		</form>		

	</div>
</body>
</html>