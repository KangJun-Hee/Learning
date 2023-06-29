
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>로그인</title>
	
	</head>
<body>
	<div align="center">
		<h1>로그인</h1>
		<p>입사지원을 위해서는 로그인이 필요합니다.</p>
		<hr>
		
		<form action="loginPro.do" method="post">
			
					<p >아이디
					<input type="text" id="id" name="id" autofocus>
					</p>
					<p>패스워드
					<input type="password" id="pw" name="pw">
					</p>
				
			<div>
				<input type="submit" title="로그인" value="로그인">
			</div>
		</form>
	</div>
</body>
</html>