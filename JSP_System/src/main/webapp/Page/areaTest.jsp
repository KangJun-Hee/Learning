<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String var = "일반 변수";
	out.println("일반 변수: " + var + "<br/>");

	//	시스템 영역 변수 사용하기
	//	영역이름.setAttribute("영역 변수 이름", 영역 변수에 저장할 데이터);
	//	영역 변수가 저장되는 기억 공간은 영역 변수 이름을 key로 하고 영역 변수에 저장되는 데이터를 value로 한
	//	Map<String, Object> 형태의 구조로 value의 자료형이 Object인 이유는 개발자가 어떤 타입의 데이터를
	//	영역 변수에 저장할지 모르기 때문이다.
	pageContext.setAttribute("pageContextVar", "areaTest.jsp의 pageContext 영역 변수");

	//	영역 변수에 저장된 데이터는 영역이름.getAttribute("영역 변수 이름")와 같이 얻어온다.
	out.println("pageContext 영역 변수: " + pageContext.getAttribute("pageContextVar") + "<br/>");

	request.setAttribute("requestVar", "areaTest.jsp의 request 영역 변수");
	session.setAttribute("sessionVar", "areaTest.jsp의 session 영역 변수");
	application.setAttribute("applicationVar", "areaTest.jsp의 application 영역 변수");

	out.println("request 영역 변수: " + request.getAttribute("requestVar") + "<br/>");
	out.println("session 영역 변수: " + session.getAttribute("sessionVar") + "<br/>");
	out.println("application 영역 변수: " + application.getAttribute("applicationVar") + "<br/>");

	//	영역 변수와 영역 변수에 저장하는 데이터가 기억되는 공간은 Map<String, Object> 형태이므로 
	//	getAttribute() 메소드로 영역 변수에 저장된 데이터를 얻어오면 Object 타입으로 얻어오기 때문에 영역 변수에
	//	저장된 데이터는 저장할 데이터 타입으로 반드시 형변환시켜서 사용해야 한다.
	String pageContextVar = (String) pageContext.getAttribute("pageContextVar");
	out.println("pageContext 영역 변수: " + pageContextVar + "<br/>");
	
	//sendRedirect() : 인수로 지정된 페이지로 넘겨 준다.
	//				   request영역의 데이터를 가지지 않고 인수로 지정된 페이지로 넘어간다.
	//				   주소창에 표시되는 페이지이름이 인수로 지정된 페이지 이름으로 변경된다.
	//				   현재페이지와 sendRedirect()메서드의 인수로 지정한 페이지가 완전히 분리됨.
	//				   새로고침하면 주소창에 표시된 페이지만 다시 실행된다.
	response.sendRedirect("requestTest.jsp");
	
	//forward() : 인수로 지정된 페이지로 넘겨 준다.
	//			  request영역의 데이터를 가지고 인수로 지정된 페이지로 넘어간다.
	//			  메서드는 주소창에 표시되는 페이지 이름이 
	//            forward()메서드가 실행된 페이지이름을 그대로 유지한다.
	//            현재페이지와 forward()메서드의 인수로 지정한 페이지가 연결된 상태!
	//	          새로고침하면 주소창에 표시된 forward메서드가 입력된 페이지부터
	//            현재화면에 보이는 페이지까지 실행이 된다.
	pageContext.forward("requestTest.jsp");
	%>
</body>
</html>















