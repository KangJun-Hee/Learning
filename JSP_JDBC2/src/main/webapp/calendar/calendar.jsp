<%@page import="java.util.Calendar"%>
<%@page import="com.kh.calendar.MyCalendar"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일명: calendar.jsp</title>
<style type="text/css">
tr {
	height: 70px; /* 행 높이 */
}

th {
	font-size: 20pt;
	width: 100px;
}

th#title {
	font-size: 30pt; /* 글꼴 크기 */
	font-family: D2Coding; /* 글꼴 이름 */
	font-weight: bold; /* 굵게 */
	color: tomato; /* 글자 색 */
}

th#sunday {
	color: red;
}

th#saturday {
	color: blue;
}

td {
	text-align: right; /* 수평 정렬 */
	vertical-align: top; /* 수직 정렬 */
	border:1px,solid,red;
	border-radius: 10px;
}

td.sun {
	color: red;
}

td.sat {
	color: blue;
}

td#beforesun {
	color: red;
	font-size: 10pt;
	background-color: lavender; /* 배경색 */
}

td.before {
	font-size: 10pt;
	background-color: lavender;
}

td#aftersat {
	color: blue;
	font-size: 10pt;
	background-color: yellowgreen;
}

td.after {
	font-size: 10pt;
	background-color: yellowgreen;
}
</style>
</head>
<body>


	<%
	Calendar calendar = Calendar.getInstance();
	int year = calendar.get(Calendar.YEAR);
	int month = calendar.get(Calendar.MONTH) + 1;
	%>

	<table width="700"  align="center" cellpadding="5"
		cellspacing="0">

		<tr id="border">
			<th id="title" colspan="7"><%=year%>년 <%=month%>월</th>
		</tr>

		<tr id="border">
			<th id="sunday">일</th>
			<th>월</th>
			<th>화</th>
			<th>수</th>
			<th>목</th>
			<th>금</th>
			<th id="saturday">토</th>
		</tr>

		<!-- 달력에 날짜를 출력한다. -->
		<tr>

			<%
			// 달력을 출력할 달 1일의 요일을 계산해둔다.
			int week = MyCalendar.weekDay(year, month, 1);
		
			// 1일이 출력될 위치(요일)을 맞추기 위해 달력을 출력할 달 1일의 요일만큼
			// 반복하여 빈칸을 출력 한다. 
			//for(int i = 0; i < week; i++){
			//	out.println("<td></td>");				
			//}
			
			//빈칸에 출력할 전달 날짜의 시작일 계산한다. 
			int start = 0;
			
			if(month == 1){
				start = MyCalendar.lastDay(year -1, 12) - week; // 1월
			}else{
				start = MyCalendar.lastDay(year,month -1) - week; //2월~12월
			}
						
			// 1일이 출력될 위치(요일) 맞추기 위해 달력을 출력 할 달 1일의 요일만큼 반복하여 전달
			// 날짜를 출력한다.
			
			for(int i=0; i < MyCalendar.weekDay(year, month,1); i++){
				if(i == 0){
					out.println("<td id='beforesun'>" 
							+ (month == 1 ?  12 : month - 1) +"/"
							+ (++start) + "</td>");
				}else{
					out.println("<td class='before'>"
							+ (month == 1 ?  12 : month - 1) +"/"
							+ (++start) + "</td>");
				}
			}
			
			// 1일부터 달력을 출력할 달의 마지막 날짜까지 반복하며 날짜를 출력한다. 
			
			for(int i = 1; i<= MyCalendar.lastDay(year, month); i++){
				// <td> 태그에 요일에 따른 클래스 속성을 지정한다.
				
				switch(MyCalendar.weekDay(year, month, i)){
				case 0: //일요일
					out.println("<td class = 'sun'>"+ i + "</td>");
					break;
					
				case 6: //토요일
					out.println("<td class = 'sat'>"+ i + "</td>");
					break;
					
				default:
					out.println("<td>"+ i + "</td>");
					break;
				}
				
				// 출력한 날짜가 토요일이고 그 달의 마지막 날짜가 아니면 줄을 바꾼다.
				if(MyCalendar.weekDay(year, month, i) == 6 &&
									i != MyCalendar.lastDay(year, month)) {
					out.println("</tr><tr>");				
				}				
			}
			
			// 다음달 1일의 요일을 계산한다.
			if(month == 12){
				week = MyCalendar.weekDay(year +1, 1, 1);  // 12월
			}else{
				week = MyCalendar.weekDay(year,month +1, 1);  // 1월~11월 
			}
			
			// 다음달 1일이 일요일이면 다음달 날짜를 출력할 필요가 없다!
			if(week != 0){
				
				//날짜를 다 출력하고 남은 빈칸에 다음 달 날짜를 1일의 요일부터 토요일까지 반복하여
				// 출력한다.
				start = 0;
				for(int i= week; i <= 6; i++){
					
					if(i == 6){
						out.println("<td id='aftersat'>" 
								+ (month == 12 ?  1 : month + 1) +"/"
								+ (++start) + "</td>");
					}else{
						
						out.println("<td class ='after'>" 
								+ (month == 12 ?  1 : month + 1) +"/"
								+ (++start) + "</td>"								
								
							);				
					}
				}				
			}
			
			
			%>



		</tr>

	</table>

</body>
</html>
