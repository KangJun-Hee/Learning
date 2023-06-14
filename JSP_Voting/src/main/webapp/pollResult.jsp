<%@page import="java.text.DecimalFormat"%>
<%@page import="com.kh.PollRead"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--  일정 시간이 경과되면 특정 웹 사이트로 이동하기  -->
<!-- <meta http-equiv="refresh" content="5; url='https://www.naver.com'"> -->
<!-- 일정 시간이 경과되면 현재 페이지를 다시 호출한다. => 새로고침 한다. 
	"refresh" 새로고침 될것이다!
	content="1  1초만에 url 속성으로 지정한 사이트로 이동한다.
-->
<meta http-equiv="refresh" content="1; url='?'">

<title>파일명: pollResult.jsp</title>
</head>
<body>
	<%
		String filepath = application.getRealPath("/")+"poll.txt";	
		ArrayList<String> poll = PollRead.pollRead(filepath);
		int itemCount = (poll.size() -1) / 2;
	
	// 득표율을 계산하기 위해서 전체 투표수를 계산한다.
	// itemCount 변수는 7몫까지는 타이틀(제목)들 
	// 그 이후 부터는 투표수를 저장하는 항복들 
	
	int sum = 0;
	for(int i = itemCount + 1; i <poll.size(); i++){
		sum += Integer.parseInt(poll.get(i));		
	}
	
	// 숫자 데이터 서식을 설정한다.
	DecimalFormat df1 = new DecimalFormat("#,##0표"); // 득표수 서식
	DecimalFormat df2 = new DecimalFormat("0.00%"); // 득표율 서식
	
	
	%>

	<table width="500" border="1" align="center" cellpadding="5"
		cellspacing="0">
		<tr>
			<th colspan="2"><%=poll.get(0)%></th>
		</tr>
		<tr>
			<td colspan="2" align="right"><%=df1.format(sum)%></td>
		</tr>
		<!--  득표수 랑 특표율 계산하는 자바코드  -->
		<%
		for (int i=1; i<=itemCount; i++) {
			int pyo = Integer.parseInt(poll.get(i + itemCount)); // 득표수
			double per = (double) pyo / sum; // 득표율	
		%>

		<!--  계산한걸 이용해서 서식하고 테이블로 출력 
		 막대그래프의 색상  -->
		<tr>
			<td width="150"><%=poll.get(i)%>(<%=df1.format(pyo)%>) <!-- 득표수 서식 지정 -->
				<%-- <%=poll.get(i)%>(<%=df2.format(per)%>) --%> <!-- 득표율 서식 지정 -->
			</td>
			<td width="350">
				<hr color="#12a2f6" size="10" width="<%=350 * per%>" align="left">
			</td>
		</tr>
		<%
		}
		%>
		<tr>
			<td colspan="2" align="center"><input type="button"
				value="투표하기로 가기" onclick="location.href='pollRead.jsp'"></td>
		</tr>
	</table>
</body>
</html>