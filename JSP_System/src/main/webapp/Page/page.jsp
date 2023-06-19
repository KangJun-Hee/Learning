<%@page import="common.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일명: page.jsp</title>
</head>
<body>
	<!--   내장 객체의 영역 
	      각 객체가 저장되는 메모리의 유효기간 
	      
	      4가지 영역으로 나뉜다. 
	      pageContext => 현재 보고있는 페이지
		  request => 현재 보고있는 페이지와 현재 보고있는 페이지의 다음 페이지 까지
		  session => 브라우저가 실행되면 생성되고 브라우저가 종료되면 소멸되는 영역
		  application => 서버가 실행되면 생성되고 서버가 종료되면 소멸되는 영역
		  
		  시스템 영역변수 사용하기 
		  영역이름.setAttribute("영역 변수 이름",저장될 데이터) (저장)
		  영역이름.getAttribute("영역 변수 이름") (꺼내기)
		  영역이름.removeAttribute("영역 변수 이름") (삭제)
		    - 영역 안에 없는 변수 에러발생 X 
		  
		  영역변수가 저장되는 기억 공간은 영역 변수 이름을 key로 하고 영역변수 저장되는 데이터를 
		  value로 한 Map<String,Object> 형태의 구조로 value 자료형이 Object인 개발자가 어떤
		  타입의 데이터를 영역 변수에 저장할 지 모르기때문에!
		  
		  데이터 전송 객체 (DTO) 준비 
		   - 데이터를 저장하거나 전송하는데 쓰이는 객체로 순수하게 데이터만 담고 있으며 
		    값 객체(Value Objcet)
		    
		  자바 빈즈(javaBeans)
		    1. 자바빈즈는 기본(default) 패키지 이외의 패키지에 속해야 함
			2. 멤버 변수(속성)의 접근 지정자는 private으로 선언
			3. 기본 생성자가 있어야 함
			4. 멤버 변수에 접근할 수 있는 게터(getter)/세터(setter) 메서드가 필요
			5. 게터/세터 메서드의 접근 지정자는 public으로 선언
	 
	      
	 -->
	 
	 
	 <%
	 // 속성 저장
	 pageContext.setAttribute("pageInteger", 1000);
	 pageContext.setAttribute("pageString", "페이지 영역의 문자열");
	 pageContext.setAttribute("pagePerson",new Person("이서희",20));
	 
	 // 속성 읽기 
	 int pInteger = (Integer)pageContext.getAttribute("pageInteger");
	 Person pPerson = (Person)pageContext.getAttribute("pagePerson");
	 
	 %>
	 <ul>
	 	<li> integer 객체 : <%=pInteger%></li>
	 	
	 	<!--  저장한 객체가 문자열이거나 기본 타입의 래퍼 클래스 라면 별도의 형변환이 없다! -->
	 	<li> String 객체 : <%=pageContext.getAttribute("pageString") %></li>
	 	<li> Person 객체 :  <%=pPerson.getName()%>,<%=pPerson.getAge()%></li>
	 </ul>
	 
	 <!--  include : 다른 jsp파일을 포함 / 포함관계이므로 같은 페이지로!  -->
	 <h2> include 된 파일에서 page 영역 읽어오기 </h2>
	 <%@ include file = "PageInclude.jsp" %>
	 
	 
	 <!-- 페이지 이동 후 page영역 읽어오기  -->
	 <h2> href 페이지 이동 후 page 영역 읽어오기! </h2>
	 <a href ="PageLocation.jsp">PageLocation.jsp 바로가기</a>
	 
	 
	 	 

</body>
</html>