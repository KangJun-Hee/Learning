<%@page import="java.util.Arrays"%>
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
	out.println(name + "님 안녕하세요~~~ <br>");

	String id = request.getParameter("id");
	out.println(name + "님의 " + "id는 " + id + "입니다~~.<br>");

	String password = request.getParameter("password");
	out.println(name + "님의 " + "비번은 " + password + "입니다~~.<br>");

	try {
		int age = Integer.parseInt(request.getParameter("age"));
		out.println(name + "님의 " + "올해 나이는 " + age + "살입니다~~.<br>");
		out.println(name + "님의 " + "내년 나이는 " + (age + 1) + "입니다~~.<br>");
	} catch (NumberFormatException e) {
		out.println("잘못된 나이가 입력되었습니다<br>");
		out.println("<script>");
		out.println("alert('잘못된 나이가 입력되었습니다!')");
		out.println("</script>");
	}
	//out.println() : 웹페이지에 출력
	//System.out.println() : 이클립스 콘솔 출력

	//현재 나이에 올해는 20살 내년은 21살입니다.

	//여성인지 request객체 이용
	//Boolean 래퍼클래스를 이용해서 객체로 생성 -> auto unboxing이용
	//기본자료형으로 저장
	boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
	//삼항연산자 참       거짓
	out.println(name + "님은 " + (gender ? "남자" : "여자") + "입니다.<br>");

	//체크박스에 있는 값들을 가지고 오기!
	//getParameter(name) 넘어온 데이터를 받으면 맨 처음 선택한 값 1개만 받을 수 있음
	//getParameterValues() 배열로 받아 옴! 여러개 받아올 수 있음

	String[] hobbies = request.getParameterValues("hobbies");
	//out.println(name + "취미는" + hobbies + "입니다.<br>");
	//out.println(name + "취미는" + Arrays.toString(hobbies) + "입니다.<br>");

	out.println(name + "취미는");

	//만약에 아무것도 데이터를 선택하지 않을 경우 에러발생 가능!
	//예외적 처리해 줘야 함~

	try {
		for (int i = 0; i < hobbies.length; i++) {
			out.println(hobbies[i] + "");
		}
		out.println("입니다. <br>");
		
	} catch (NullPointerException e) {
		out.println("암것도 없습니다.<br>");
		
	}
	
	//콤보상자,목록상자 내용들 확인
	String trip = request.getParameter("trip");
	out.println(name+"님은 "+trip+"에 가고 싶다네요<br>");
	
	String[] travel = request.getParameterValues("travel");
	out.println(name+"님이 가고 싶은 여행지는 "+travel+"입니다~<br>");
	out.println(name+"님이 가고 싶은 여행지는 "+Arrays.toString(travel)+"입니다~<br>");
	
	try {
		for (int i = 0; i < hobbies.length; i++) {
			out.println(travel[i] + "");
		}
		out.println("입니다. <br>");
		
	} catch (NullPointerException e) {
		out.println("여행지가 암것도 없습니다.<br>");
		
	}
	
	//메모(textarea)
	String content = request.getParameter("content");
		//out.println() : 태그사용 가능, 줄바꿈 불가능
		out.println(name+"님이 남긴 글"+content+"<br>");
		
		//out.println( .replace("\r\n","<br>"));
		//				태그사용 가능, 줄바꿈 가능!
		out.println(name+"님이 남긴 글"+content.replace("\r\n","<br>")+"<br>");
	%>



</body>
</html>