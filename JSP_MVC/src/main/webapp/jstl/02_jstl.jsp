<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	반복작업을 할 때 사용한다.
	var1 = "변수명" items="목록데이터"
	컬렉션 List, Set , Map, 배열, 콤마(,) 구분자로 나열된 문자열 
	var1는 반복문을 돌면서 items에서 꺼낸 항목 값을 가리키는 참조 변수이다!	
	
	<h3> 문제1  1~10출력 </h3>
	<c:forEach var="i" begin="1" end="10">
		${i} &nbsp;	
	</c:forEach><br>
	
	<h3>문제2  1~10 짝수 출력 </h3>
	<c:forEach var="i" begin="1" end="10">
		<c:if test="${i % 2 == 0}">
			${i} &nbsp;	
		</c:if>
	</c:forEach><br>
	
	
	<h3>문제2  1~10의 합 출력 </h3>
	<c:forEach var="i" begin="1" end="10">
		<c:set var ="sum" value ="${ sum = sum + i }"/>
	</c:forEach><br>
	${ sum }
	
	
	<h3>문제2  1~100의 홀수의 개수 출력 </h3>
	<c:forEach var="i" begin="1" end="100">
		<c:set var ="sum" value ="${ sum = sum + i }"/>
	</c:forEach><br>
	${ sum }
	
	
		1. 구구단 출력 2단! 된다.
		   2~9단 출력하는 jstl 문법을 이용해서 데이터
		   출력하기 !
	
	
			#### 
			#### 
			#### 
			#### 
			#### 
			
			
			#
			##
			###
			####
			#####
		 	
		    #
		   ##
		  ###
		 ####
		#####
		
		
		#
	   ###
	  #####
	 #######
	#########
			
	--%>
	
	 -->
	
	<h3>구구단 출력</h3>
	<c:forEach var="i" begin="2" end="9">
	----${ i }단 ----<br>
		<c:forEach var ="j" begin="1" end ="9">
			${ i } *  ${ j } = ${ i * j} <br> 			
		</c:forEach>
	</c:forEach>
	<!-- 
			#### 
			#### 
			#### 
			#### 
			#### 
	
	 -->
	 
	<c:forEach var="i" begin="1" end="5">
		<c:forEach var ="j" begin="1" end ="4">
			#		
		</c:forEach>
		<br>
	</c:forEach>
	<br>
	<!-- 
			#
			##
			###
			####
			#####	
	 -->
	<c:forEach var="i" begin="1" end="5">
		<c:forEach var ="j" begin="1" end ="${ i }">
			#		
		</c:forEach>
		<br>
	</c:forEach>
	<br>
	
	<!--    #
		   ##
		  ###
		 ####
		#####
	 -->
	<%
		for(int i=1; i<=5; i++){
			for(int j=4; j>=i; j--){
				System.out.print(" ");
			}
			for(int j=1; j<=i; j++){
				System.out.print("#");
			}
			System.out.println();
		}
	%>
	<c:forEach var="i" begin="1" end="5">
		<c:forEach var ="j" begin="${ i }" end ="4">
			+		
		</c:forEach>
		
		<c:forEach var ="j" begin="1" end ="${ i }">
			#		
		</c:forEach>
		<br>
		
	</c:forEach>
	<br>
	
	
	
</body>
</html>