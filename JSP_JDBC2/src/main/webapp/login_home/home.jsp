<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">


<title>파일명: home.jsp</title>
</head>
<body class="container">

	<div class="jumbotron">
		<h1>Form 태그</h1>
		<p>form을 이용해서 정보를 보낸다.</p>
	</div>

	<form action ="login.jsp" method="post">
		
		<h1 class="h3 mb-3 fw-normal">Please sign in</h1>

		<div class="form-floating">
			<input type="text" class="form-control" id="floatingInput"
				placeholder="아이디" name = "dbid"> <label for="floatingInput">아이디</label>
		</div>
		<div class="form-floating">
			<input type="text" class="form-control" id="floatingPassword"
				placeholder="비밀번호" name ="dbpw"> <label for="floatingPassword">Password</label>
		</div>

		<div class="checkbox mb-3">
			<label> <input type="checkbox" value="remember-me">
				Remember me
			</label>
		</div>
		<button class="w-100 btn btn-lg btn-primary" type="submit">Sign
			in</button>
		<p class="mt-5 mb-3 text-muted">© 2017–2023</p>
	</form>




	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<Script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<Script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<Script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</body>
</html>