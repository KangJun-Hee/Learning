<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>from에서 넘어온 데이터를 jsp로 처리하는 내용!</title>
</head>
<body>
	<%
	//form에서 입력된 한글데이터가 post방식으로 전송될 때,
	//깨지는 현상을 방지하기 위해 
	//sumit : 클릭을 하면 request객체에 form이 가진 정보가
	//		  모두 담겨 객체로 반환된다.
	//getParameter() :메서드 실행전 맨첨에 인코딩 내용을 작성함.
	request.setCharacterEncoding("UTF-8");
	
	//getParameter() 모든 정보는 문자열 형태로 넘어옴~	
	
	String name = request.getParameter("name");
	out.println(name+"님 안녕하세요~~~ <br>");
	
	String id = request.getParameter("id");
	out.println(name+"님의 "+"id는 "+id+"입니다~~.<br>");
	
	String password = request.getParameter("password");
	out.println(name+"님의 "+"비번은 "+password+"입니다~~.<br>");
	
	try{
	int age = Integer.parseInt(request.getParameter("age"));
	out.println(name+"님의 "+"올해 나이는 "+age+"살입니다~~.<br>");
	out.println(name+"님의 "+"내년 나이는 "+(age+1)+"입니다~~.<br>");
	}catch(NumberFormatException e){
		out.println("잘못된 나이가 입력되었습니다<br>");
		out.println("<script>");
		out.println("alert('잘못된 나이가 입력되었습니다!')");
		out.println("</script>");
	}
	//현재 나이에 올해는 20살 내년은 21살입니다.
	
	%>
	
	
	
</body>
</html>