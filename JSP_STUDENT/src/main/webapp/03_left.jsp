<%@page import="enrolment.StudentDTO"%>
<%@page import="enrolment.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	//세션에서 학번 가지고 온다
	String hakbun = (String)session.getAttribute("hakbun");
	//DAO주소값을 저장한다~
	StudentDAO sdo = StudentDAO.getInstance();
	//학생객체를 생성
	StudentDTO sto = new StudentDTO();
	sto = sdo.getStudent(hakbun);
	//getStudent()메서드 생성, 학번을 넘긴다.
	//데이터베이스에서 학생의 내용을 조회해서 학생객체에 저장한다.
	String major = sto.getMajor();
	String temp = "";
	
	if(major.equals("1")){
		temp = "컴퓨터공학";
	} else if(major.equals("2")){
		temp = "전자공학과";
	} else if(major.equals("3")){
		temp = "응용수학과";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03_left</title>
</head>
<body>
	<table border="1">
		<tr>
			<td colspan="2" bgcolor="#00FFFF">2020년 2학기 수강신청</td>
		</tr>
		<tr>
			<td bgcolor="#00FFFF">이름</td>
			<td><%=sto.getName()%></td>
		</tr>
		<tr>
			<td bgcolor="#00FFFF">학번</td>
			<td><%=sto.getHakbun()%></td>
		</tr>
		<tr>
			<td bgcolor="#00FFFF">학부(과)</td>
			<td><%=temp%></td>
		</tr>
		<tr>
			<td bgcolor="#00FFFF">학년</td>
			<td><%=sto.getGrade()%></td>
		</tr>
		<tr>
			<td bgcolor="#00FFFF">최소신청학점</td>
			<%
			if (sto.getGrade() == 4) {
			%>
			<td>9</td>
			<%
			} else {
			%>
			<td>12</td>
			<%
			}
			%>
		</tr>

		<tr>
			<td bgcolor="#00FFFF">최대신청학점</td>
			<td>19</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="button" value="로그아웃"
				onclick="window.location.href='06_logout.jsp'"></td>
		</tr>
	</table>

</body>
</html>