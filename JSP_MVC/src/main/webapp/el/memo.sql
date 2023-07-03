<!-- 
		EL(Experssion Language)
		 - 값을 간편하고 간결하게 출력할 수 있도록 해주는 표현언어다!
		 - 페이지 가독성이 좋아진다. 
		 - ${출력값들을 안에 집어넣는다!}
		 - 값을 찾을 떄 작은 범위부터 큰범위로 찾는다.
		   scope 란? 변수를 사용할 수있는 범위 
		   
		   
		 - 출력할 때 사용을 하는 것이 때문에 jstl과 연동   
		 		 
		 ${requestScope.키값}
		 ${paraml.네임값}
		 ${영역값.key or 구별할수있는 변수명}
		 	 -->
		 
		 
		 ${"one" + 2}
		 el 3.0 버전부터는 된다! 문자열을 숫자로 변경해서 연산이 가능할 수있도록 한다
		 
		 	${2 + 5}	 
	${2 - 5}	 
	${2 * 5}	 
	${2 / 5}	
	${2 mod 5} 
	${null +2}
	
	<!--  혹시라도 산술연산을 하다가 null 내부적으로 long 타입 0으로 변경해서 
	연산한다. 
	
	자바는 문자열로 인식을 해서 연결을 하는데 el 문자열을 숫자로 바꾸어서 연산합니다.
	
	-->
	${"1" +2}
	
	${ 10 == 10 && 9 == 9}
	${ 10 == 10 || 9 == 8}
	${ !(10 == 10)}
	
	<br><br>
	<!--  비교연산자를 위에처럼 작성도 가능하지만   문자열 연산에 == != 
		문자열 비교를 할 떄 자동으로 compareTo() 메서드가 동작한다. 
		and or not 
	 -->
	${10 eq 10 }    <!--  같니? eq -->
	${"이서희" eq "이서희"}
	<br>
	${10 ne 10}     <!--  다르니? ne -->
	${"이서희" ne "이지희"}
	
	${10 < 10}  <!--  lt -->
	${10 lt 10} 
	
	${10 > 10}  <!--  gt -->
	${10 gt 10}  
	
	${10 <= 10}  <!--  le -->
	${10 le 10}  
	
	${10 >= 10}  <!--  le -->
	${10 ge 10}  
	
	
		<!--  value ="출력값"  
	value 값에 null이면 기본값이 출력되고 기본값이
	없으면 빈 문자열 출력된다.
	
	-->
	<c:out value="hello World"></c:out><br>
	<c:out value="${null}">jsp</c:out><br>
	<c:out value="hello">world</c:out> <br>
	<c:out value="${null}" /><br>
	
	<!--  변수를 다룰 때 set
		jsp의 로컬변수가 아니라 서블릿 보관소에 4가지
		영역 있는데 그곳에 내가 범위를 설정해서 저장 
		
	 <c:set var="변수명" value="값" scope="기본값"></c:set>
	
	 scope의 기본값은 page 
	 -->
	