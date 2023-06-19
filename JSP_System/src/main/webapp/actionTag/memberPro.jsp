<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberpro</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	//Date d = new Date();
	%>

	<jsp:useBean id="date" class="java.util.Date" />
	${date}
	<br />
	<!-- 
	useBean 액션태그로 new를 사용하지 않고 객체 만들기
	id 속성에는 만들려는 객체의 이름 쓴다.
	class 속성에는 객체를 만들려하는 클래스의 이름을 만드시 풀패키지 이름과 같이 써야 한다.
	액션태그는 xml문법을 따르기 때문에 <tag></tag>사이에 아무런 내용이 코딩되지 않으면
	</tag>는 생략가능. 그냥지우면 에러나니 <tag />만들면 된다. 
	-->



	<!-- MemberVo vo = new MemberVO();랑 같은 거임! -->
	<jsp:useBean id="vo" class="members.MemberVO">
		<!-- 
	setProperty 액션태그 : 지정필드에 setter메서드 호출
		Property 속성에는 setter메서드를 실행할 필드이름을 쓴다.
		name 속성에는 setter 메서드를 실행할 필드가 정의된 객체 이름을 쓴다.
		
		form에서 전송되는 request 객체에서 꺼내는 작업을 하지 않아도 자동으로 처리해준다.
		<jsp:setProperty property="id" name="vo" />
		<jsp:setProperty property="name" name="vo" />
		<jsp:setProperty property="password" name="vo" />
		<jsp:setProperty property="age" name="vo" />
		<jsp:setProperty property="gender" name="vo" />
		<jsp:setProperty property="ip" name="vo" />

		
		"*" : 모든 피드의 setter메서드가 실행된다.
		단! form에서 넘어온 name속성하고 필드의 이름이 같은 것만 setter메서드가 실행된다.
	-->
		<jsp:setProperty property="*" name="vo"/>
		
	</jsp:useBean>
</body>
</html>