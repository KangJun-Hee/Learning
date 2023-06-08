<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>hoyoyo</title>
</head>
<body>
	안녕
	you must~ save~ your file. Always~
	
	<!-- html 안에 java 코드를 넣어
		동적 웹페이지를 생성하는
		웹 어플리케이션 도구! 
		
		JSP가 실행되면 java 서블릿(Servlet)으로
		변환되며 웹 어플리케이션 서버에서 동작되며
		필요한 기능을 수행한다.
		
		생성된 데이터를 웹페이지와 함께
		클라이언트로 응답해 준다
		
		웹 어플리케이션
			- 웹에서 실행되는 응용프로그램
			ex:인터넷뱅킹,쇼핑,검색 등등
			- 사용자가 필요한 요청(request)을
			  하고, 서버에서는 요청을 수행하고
			  응답(response)를 함.
			  
		웹 서버(Web Server)
			- 클라이언트로부터 요청받아 
			서버에 저장된 리소스를
			클라이언트에게 전달함.
			
		웹 어플리케이션 서버(Web Application Server)WAS라고 부름
			- 서버단에서 필요한 기능을 수행하고
			결과를 웹서버에 전달함.
			
		자바 서블릿(Java Servlet)
			- 웹페이지를 동적으로 생성하기 위해
			서버측 프로그램을 말한다.
			
			
			
			
			
			  -->



		<%--
			jsp를 주석처리할 수 있는 것. 퍼센트~
			
			<%@ ~ %>   <-디렉티브 : 자동으로 입력된다.
								import같이 설정에 관련된
								정보들
			<%! ~ %>   <-선언부 : 프로그램에서 사용할 변수나
								메서드를 정의한다.
								java파일로 뽑아내 사용함.
			<%= ~ %>   <-표현식 : 변수에 저장된 결과나
								연산 결과를 출력한다.
								EL(${변수명})대체해서 사용.
			<% ~ %>	   <-스크립트 릿 : 일반적인 jsp코드를 적음.
									jstl로 대체해서 사용.
		
		 --%>
</body>
</html>