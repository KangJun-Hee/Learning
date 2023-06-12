<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>

<%
Connection conn = null;
String url = "jdbc:oracle:thin:@localhost:1521:orcl";
String user = "system";
String password = "1234";
PreparedStatement ppst = null;
ResultSet rs = null;

try {
	Class.forName("oracle.jdbc.driver.OracleDriver");

	conn = DriverManager.getConnection(url, user, password);
	if (conn != null) {
		out.println("db연결 오키~");
	}

	String sql = "insert into Enrolment values(?,?,?,?,?,?,?)";
	ppst = conn.prepareStatement(sql);

	ppst.setString(1, request.getParameter("name"));
	ppst.setInt(2, Integer.parseInt(request.getParameter("hakbun")));
	ppst.setString(1, request.getParameter("depart"));
	ppst.setInt(2, Integer.parseInt(request.getParameter("grade")));
	ppst.setInt(2, Integer.parseInt(request.getParameter("min_En")));
	ppst.setInt(2, Integer.parseInt(request.getParameter("min_En")));
	ppst.setString(1, request.getParameter("pw"));

	rs = ppst.executeQuery();

} catch (Exception e) {
	e.getStackTrace();
} 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>subject Pro</title>
</head>
<body>
	<table border=1>
		<thead>
			<tr>
				<td>2020년 2학기 수강신청</td>
			</tr>
			<tr>
				<td>이름</td>
				<td></td>
			</tr>
			<tr>
				<td>학번</td>
				<td></td>
			</tr>
			<tr>
				<td>학부(과)</td>
				<td></td>
			</tr>
			<tr>
				<td>학년</td>
				<td></td>
			</tr>
			<tr>
				<td>최소신청학점</td>
				<td></td>
			</tr>
			<tr>
				<td>최소신청학점</td>
				<td></td>
			</tr>
			<tr>
				<td><button>로그아웃</button></td>
			</tr>
		</thead>
		<tbody>
			<%
			try{
				while (rs.next()) {
					out.println("<tr>");
					out.println("<td>" + rs.getString("name") + "</td>");
					out.println("</tr>");
	
					out.println("<tr>");
					out.println("<td>" + rs.getInt("hakbun") + "</td>");
					out.println("</tr>");
	
					out.println("<tr>");
					out.println("<td>" + rs.getString("depart") + "</td>");
					out.println("</tr>");
					
					out.println("<tr>");
					out.println("<td>" + rs.getInt("grade") + "</td>");
					out.println("</tr>");
	
					
					out.println("<tr>");
					out.println("<td>" + rs.getInt("min_En") + "</td>");
					out.println("</tr>");
	
					
					out.println("<tr>");
					out.println("<td>" + rs.getInt("max_En") + "</td>");
					out.println("</tr>");
	
	
					out.println("<tr>");
					out.println("<td>" + rs.getString("pw") + "</td>");
					out.println("</tr>");
				}
				
			}catch(NullPointerException e){
				e.getStackTrace();
			}
			%>
		</tbody>
	</table>
</body>
</html>
























