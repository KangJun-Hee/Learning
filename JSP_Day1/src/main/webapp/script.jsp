<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		정적 웹페이지
			- 언제 접속해도 같은 응답을 보내 준다.
			- css, html, javascript 등이 업로드되면
				개발자가 수정하기 전까지 매번 같은 파일을
				브라우저가 건네 줌
			- 즉, 정적 웹페이지에 대한 요청을 받은 경우
				서버는 추가적인 처리과정 없이 클라이언트에게
				응답 보낸다.
				
		동적 웹페이지
			- 웹서버가 동적 웹페이지에 대한 요청을 받은 경우
				서버는 추가적인 처리과정 이후 클라이언트에게
				응답을 보낸다.
			- 동적 페이지는 방문자와 상호작용하기 때문에
				페이지 내용은 때마다 다르다.
			- 댓글, 날씨,주가 등 정보변경이 잦은 곳에서 사용됨!
	 -->
	 
	 
	 
	 <h1>1. 출력</h1>
	 
	 <!-- 자바코드 구역 -->
	 <% 
	 	String name="김철수";
	 	System.out.println(name);//콘솔에 데이터를 출력
	 	out.println(name);	//html에서 데이터를 출력하는 자바의 메서드
	 %>
	 
	 <!-- html 코드 -->
	 출력 결과 : name
	 <br><br>
	 
	 <!-- html 코드 뒤에 jsp 문법으로 출력 -->
	 출력 결과 : <%=name%>
	 
	 
	 
	 
	 <h1>조건문</h1>
	 <%
	 	String name2 = "ㅇㅇ수";
	 %>
	 <br><br>
	 
	 <!-- 이렇게 쓰면 불편하니까 out.println()쓴다. -->
	 <%if(name2.equals("이만수")){%>
	 	이만수입니다. 
	 <%}else{%>
	 	이만수 아닙니다.
	 <%} %>
	 
	 
	 
	 <h2>import 속성</h2>
	<%
		Random ran = new Random();
	
	//배열의 초기화 블럭을 사용하면 배열의 선언,메모리할당,초기값설정을 한 번에 할 수 있다.
	String[] str = {"jsp","JAVA","Spring","HTML5"};
	int i = ran.nextInt(4);//0~3사이
	out.println(str[i]);
	%> 
	<br>
	<%= str[i]%>가 재미있다.
	 
	 
	 
	 
	 
	 <!-- java.sql.timestamp
	 	  sql의 timestamp타입에 대응하기 위해 만들어짐.
	 	  timestamp 클래스로 날짜,시간과 관련한 데이터의 조작을 행하는 경우에 이용함.
	 	  포함
	  -->

	
	<%
		//Timestamp now = new Timestamp(System.currentTimeMillis());
		//out.println(now.getHours()+"시 ");

		Timestamp now2 = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String strdate = format.format(now2);
		out.println(strdate);
		
		Timestamp cur = new Timestamp(System.currentTimeMillis());
		out.println(cur);
		
		//String currentTimestampToString = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
  		//		.format(currentTimestamp);
  		//System.out.println(currentTimestampToString);	
  	%>
	 
	
	<h2>반복문</h2>
	<%
		int i2 = 0;
		while(i2<10){
			out.println(i2);
			i2++;
		}
	%><br>
	
	<!--
	2차 반복문 이용해서 밑의 내용 출력! 
	*
	**
	***
	****
	*****
	
	123A
	45BC
	6DEF
	
	 -->

	
	<%
	
	//답안 입니다. 반복문!

	int num = 1;
	char ch = 'A';
	
	for(int i4 = 0; i4<4; i++){
		
		for(int j = 0; j < 4-i4; j++){
			out.println(num++);								
		}
		for(int z = 0; z < i4+1; z++){
			out.println(ch++);
		}	
		out.println("<br>");
	}
	
	
	out.println("<br><br>");
	
		for(int i5 = 0; i5 < 5; i5++){
			
			for(int j = 0; j <= i5; j++){
				out.println("*");	
			}
			out.println("<br>");			
		}	
	%>



	
	
	
	 
	 
	 
	 
	 
	 
	 
</body>
</html>