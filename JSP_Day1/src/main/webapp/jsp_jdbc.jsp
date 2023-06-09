<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user 정보 </title>
	    <!-- Bootstrap CSS -->
    		    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	<%
		Connection con = null;
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "system";
		String password = "1234";
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		con = DriverManager.getConnection(url,user,password);
			if(con != null){
				out.println("디비 연결 OK!");
			}
			// 현재 데이터베이스 선택해서 가져오기 cafe
			String sql = "select * from userTbl";
			pstm = con.prepareStatement(sql); //sql 문으로 컴파일
			rs = pstm. executeQuery(); //쿼리문을 보내서 실행하면 rs로 반환 
			
	
		}catch(Exception e){
			out.println(e.toString());
		} 
		
 %>
 
 			<table class="table table-striped">
    		        <thead class="thead-dark">
    		            <tr>
    		                <th>번호</th>
    		                <th>이름</th>
    		                <th>생년월일</th>
    		                <th>주소</th>
    		            </tr>
    		        </thead>
    		        <tbody>
    		        <% 
    		        	while(rs.next()){ //rs에서 한 행의 목록을 가지고 온다.
	
    		                    out.println("<tr>");
    		                    out.println("<td>" +rs.getString("userid") + "</td>");
    		                    out.println("<td>" +rs.getString("username") + "</td>");
    		                    out.println("<td>" + rs.getString("birthyear")+ "</td>");
    		                    out.println("<td>" + rs.getString("addr") + "</td>");
    		                    out.println("</tr>");

					}
    		        %>

	    		</tbody>
	    	</table>
			    <!-- Optional JavaScript -->
    		    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    		    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    		    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    		    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>
