<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%!class Player {
		Integer number;
		String name;
		String position;

		//생성자
		Player(Integer number, String name, String position) {
			this.number = number;
			this.name = name;
			this.position = position;
		}
	}%>
<%!int[] numbers = { 1, 2, 3, 4, 5, 6 };
	String[] name = { "조지", "호요요", "김연아", "김희진", "김연경", "에프" };
	String[] position = { "sk", "dk", "ww", "ke", "qk", "qm" };

	Player[] players = new Player[numbers.length];%>
<%
for (int i = 0; i < numbers.length; i++) {
	players[i] = new Player(numbers[i], name[i], position[i]);
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
<body class="container">

	<div class="jumbotron">
		<h1>선수</h1>
	</div>

	<!-- 행의 stripe, tbody 안 -->
	<table class="table table-striped">
		<thead class="thead-dark">
			<tr>
				<th>번호</th>
				<th>포지션</th>
				<th>이름</th>
			</tr>
		</thead>
		<tbody>
			<%
				out.println("<tr>");
				out.println("<td>" + players[0].number + "</td>");			
				out.println("<td>" +players[0].position+"</td>");
				out.println("<td>" +players[0].name+"</td>");
				out.println("</tr>");		
			%>
		</tbody>
		
	</table>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<Script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<Script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<Script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

	<!-- out.println() -->
	<%=players[0].number%>
	<%=players[0].position%>
	<%=players[0].name%>
	<br>
	<%=players[1].number%>
	<%=players[1].position%>
	<%=players[1].name%>
	<br>
	<%=players[2].number%>
	<%=players[2].position%>
	<%=players[2].name%>
	<br>
	<%=players[3].number%>
	<%=players[3].position%>
	<%=players[3].name%>
	<br>
	<%=players[4].number%>
	<%=players[4].position%>
	<%=players[4].name%>
	<br>
	<%=players[5].number%>
	<%=players[5].position%>
	<%=players[5].name%>
	<br>

	<%
	out.println(players[5].number);
	%>
	<%--
	선언부,표현식,스크립트릿 body안에 넣을 필요 없음!
	변수와 메서드가 선언되면 해당파일 어느곳이던지 사용가능!
	<%! %>클래스도 안에 정의할 수 있다.
	
	
	
	
	
	
	
 --%>
</body>
</html>