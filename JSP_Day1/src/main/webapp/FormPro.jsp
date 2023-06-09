<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!
	class hmm{
	Integer num;
	String email;
	String pw;
	
	hmm(Integer num,String email,String pw){
		this.num = num;
		this.email = email;
		this.pw = pw;
	}
}
%>
<%!
	int[] num = {1,2,3,4,5,6};
	String[] email = {"dkw@naver.com","wk23@naver.com","hgrt@naver.com","wwww@naver.com","wetqh@naver.com","wgwdgs@naver.com"};
	String[] pw = {"soeir1311","soel111","xmc111","woww11","c,c11","203dkd"};
	
	hmm[] total = new hmm[num.length];
%>
<%
	for(int i=0; i<num.length; i++){
		total[i] = new hmm(num[i],email[i],pw[i]);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<Script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<Script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<Script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>



	<div class="jumbotron">
		<h1>Form 정보</h1>
	</div>
	
	<table class="table table-striped">
		<thead class="thead-dark">
			<tr>
				<th>번호</th>
				<th>이메일</th>
				<th>비밀번호</th>
			</tr>
		</thead>
		<tbody>
			<%
				out.println("<tr>");
				out.println("<td>"+total[0].num);
				out.println("<td>"+total[0].email);
				out.println("<td>"+total[0].pw);
				out.println("</tr>");			
			%>
		</tbody>
	</table>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>