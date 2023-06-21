<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>01_top</title>
</head>
<body>
	<form method="post" action="#">
		아이디 : <input type="text" name="name" placeholder="아이디를 입력하세요.">
		비밀번호 : <input type="text" name="pageName" placeholder="비밀번호를 입력하세요.">
		<input type="submit" value="입력완료">
	</form>
</body>
</html>
<!-- 
	액션태그:독립된 모듈 구성할 때 사용
		   컴파일시 클래스파일이 별도로 생성되며 
		   포함되는 페이지, 포함하는 페이지와 별개취급한다~
		   jsp페이지 내에서 어떤동작을 하도록 지시하는 태그!
		   <jsp:_______>를 취하고 _____의 내용에 따라 역할 달라짐!
		   
		   <jsp:forward>:현페이지를 다른페이지로 전환할 때 사용한다
		   <jsp:include>:jsp페이지 내에 다른 페이지를 삽입한다
		   
		   <jsp:include page="01_top.jsp">
		   		<jsp:param name="변수명" value="변수값"></jsp:param>
		   </jsp:include>
		   
		   디렉티브:jsp페이지를 어떻게 처리할 건지 설정하는 태그		   
		   <%--    <%@ include file = "***.jsp"%>  --%>
		   		  코드를 복붙하는 기능이다~
		   		  include위치에 코드복사하고 
		   		  복사한파일이랑 한꺼번에 컴파일 실행한다!
		   		  클래스파일을 별도생성하지 않고 포함된 페이지에 
		   		  텍스트코드만 삽입되어 컴파일 된다.
		   		  
		   디렉티브 액션태그 차이점:컴파일시점,포함시점
		   액션태그include:레이아웃의 한구성요소를 모듈화하기 위해 사용
		   디렉티브include:jsp내에 변수나 메서드를 사용할 수 있기에
		   				 반복적으로 사용되는 변수나메서드 사용할 때
		   				 많이 씀!  
 -->
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 