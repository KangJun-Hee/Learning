<%@page import="com.kh.PollRead"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일명: pollRead.jsp</title>
</head>
<body>
	<!--  투표 항복이 저장된 텍스트 파일의 데이터를 읽어서 웹 브라우저에 출력한다. -->

	<%
	// 이클립스에서 프로젝트를 실행하면 프로젝트가 이클립스 내부적으로 사용하는 웹 서버에 복사하고 
	// 실행된다. 
	// "/" wbe root(홈페이지의 최초 진입 경로)를 의미한다.
	// real(실제) path(경로)
	String filepath = application.getRealPath("/") +"poll.txt";
	
	// 경로를 넘겨주고 파일의 데이터를 저장해서 Arraylist객체를 생성해서 poll에 저장한다.
	ArrayList<String> poll = PollRead.pollRead(filepath);
	
	// poll을 출력할 때 사용하는 방법 
	//	out.println(poll);
	//	for (String str : poll) {
		//		out.println(str + "<br>");
	//	}
	
	// 투표 항목의 개수 
	int itemCount = (poll.size() -1) / 2;
			// 에러가 발생 시 각 파일에서 poll.size() ->  (poll.size()-1) /2 로 변경하세요~
	%>

	<form action = "pollWrite.jsp" method="post">
	
	<!--  표 만들기 
		cellpadding ="5"  셀 안 여백, 셀을 구성하는 선과 셀 내부 문자와의 간격
	    cellspacing ="0"  셀 과 셀 사이의 간격
	-->
	<table width = "500" border="1" align = "center" cellpadding="5" cellspacing ="0">
		<tr> <!-- 줄 -->
			<th> <!-- 칸, 표의 첫줄을 구성하는 칸, 굵게 및 가운데 정렬되서 표시된다. -->
				<%=poll.get(0)%>
			</th>
		</tr>
		
	<%
	//	투표 항목의 개수만큼 반복하며 radio와 투표 항목을 출력한다.
		for (int i=1; i<=itemCount; i++) {
	%>
		<tr>
			<td> <!-- 칸, 표의 첫줄을 제외한 나머지 구성하는 칸 -->
				<input type="radio" name="poll" value="<%=i%>"><%=poll.get(i)%>
			</td>
		</tr>
	<%
		}
	%>
	 
	 <!--  투표하기 버튼과 결과보기 버튼을 만든다. -->
	 
	 <tr>
	 	<td align ="center">
	 		<input type="submit" value="투표하기">
	 		<input type="button" value="결과보기" onclick = "location.href='pollResult.jsp'">
	  	
	 	</td>
	 </tr> 
	 
	</table>
		
	</form>
</body>
</html>