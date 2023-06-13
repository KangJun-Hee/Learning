<%@page import="com.kh.MyCalendarTen"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>만년달력</title>
<style type="text/css">
table {
	/* border: 선두께 선종류 선색상 */
	border: 0px solid tomato;
}

tr {
	height: 70px; /* 행 높이 */
	border-width: 0px;
}

th {
	font-size: 20pt;
	width: 100px;
	border-width: 0px;
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
	border: 1px solid black;
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

td#choice {
	text-align: left;
	vertical-align: middle;
}

td.holiday {
	background-color: aliceblue;
	color: red;
	font-weight: bold;
}

span {
	font-size: 8pt;
}

a {
	color: black;
	text-decoration: none; /* 밑줄 */
}

a:hover {
	color: lime;
	text-decoration: overline;
}

a:active {
	color: DodgerBlue;
	text-decoration: underline;
}

.button {
	background-color: #4CAF50; /* Green */
	border: none;
	color: white;
	padding: 5px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 0;
	transition-duration: 0.4s;
	cursor: pointer;
}

.button1 {
	background-color: white;
	color: black;
	border: 2px solid #4CAF50;
}

.button1:hover {
	background-color: #4CAF50;
	color: white;
}

.select {
	width: 100px;
	height: 30px;
}

fieldset {
	width: 105px;
	height: 50px;
	display: inline;
	border: none;
}
</style>
</head>
<body>
	<%
	//캘린더클래스 객체 생성하고 년,월 가지고 오기! 현재
	Calendar calendar = Calendar.getInstance();
	int year = calendar.get(Calendar.YEAR);
	int month = calendar.get(Calendar.MONTH) + 1;

	//이전달,다음달 하이퍼링크or버튼이 클릭되면
	//get방식으로 넘어오는 달력을 출력할 년,월을 받는다.

	try {
		year = Integer.parseInt(request.getParameter("year"));
		month = Integer.parseInt(request.getParameter("month"));

		//마이너스가 나오거나 12를 초과하면 안 된다.
		//1월달에서 이전누르면 12월로 이동
		//12월에서 다음 누르면 1월로 이동
		if (month >= 13) {
			year++;
			month = 1;
		} else if (month <= 0) {
			year--;
			month = 12;
		}
	} catch (NumberFormatException e) {
	}
	%>



	<table width="700" border=1 align="center" cellpadding="5"
		cellspacing="0">
		<tr>
			<th>
				<!-- <a>태그 href 속성에 지정된 곳으로 이동한다. 
				href 속성에 "#" 뒤에 id(해시)를 지정하면 현재
				문서에서 id가 지정된 요소로 이동(책갈피)하고
				url(주소)가 지정되면 url페이지로 이동한다.
				
				"?"뒤에 이동하는 페이지로 전달할 데이터를 넘겨 주는데
				넘겨 줄 데이터 2건 이상 구분할 때 "&"을 넣어 구별함.
				"?"뒤에는 절대로 띄어쓰기를 하면 안 된다.--> <input class="button button1"
				type="button" value="이전달"
				onclick="location.href='?year=<%=year%>&month=<%=month - 1%>'">
				<!-- 
				버튼으로 할 거면
				<Button class="button button1" type="button"
					onclick="location.href='?year=<%=year%>&month=<%=month - 1%>'">
					이전달
				</Button>
				 -->
			</th>
			<th id="title" colspan="5"><%=year%>년 <%=month%>월</th>
			<th><input class="button button1" type="button" value="다음달	"
				onclick="location.href='?year=<%=year%>&month=<%=month + 1%>'">
			</th>
		</tr>

		<tr>
			<th id="sunday">일</th>
			<th>월</th>
			<th>화</th>
			<th>수</th>
			<th>목</th>
			<th>금</th>
			<th id="satday">토</th>
		</tr>

		<!-- 달력에 날짜를 출력한다 -->
		<tr>
			<%
			//달력을 출력할 달 1일의 요일을 계산!
			int week = MyCalendarTen.weekDay(year, month, 1);

			//빈 칸에 출력할 전달 날짜의 시작일을 계산한다.
			int start = 0;
			if (month == 1) {
				start = MyCalendarTen.lastDay(year - 1, 12) - week;//1월
			} else {
				start = MyCalendarTen.lastDay(year, month - 1) - week;//2~12월
			}

			//1일이 출력될 위치(요일)을 맞추기 위해 
			//달력을 출력할 1일의 요일 만큼 반복해 전달날짜 출력
			//빈칸에 데이터 출력하는 부분 ex:(5/28)라고 표현하는 부분
			for (int i = 0; i < MyCalendarTen.weekDay(year, month, 1); i++) {
				if (i == 0) {
					out.println("<td id='beforesun'>" + (month == 1 ? 12 : month - 1) + "/" + ++start + "</td>");
				} else {
					out.println("<td id='beforesun'>" + (month == 1 ? 12 : month - 1) + "/" + ++start + "</td>");
				}
			}

			//1일부터 달력을 출력할 달의 마지막 날짜까지 반복해 날짜를 출력
			for (int i = 1; i <= MyCalendarTen.lastDay(year, month); i++) {
				//대체공휴일
				//삼일절,어린이날 등이 토욜일욜하고 겹치면
				//그 다음 첫 번째 공휴일을 대체 공휴일로 지정

				boolean flag0301 = false;
				int subHoliday0301 = 0;
				if (MyCalendarTen.weekDay(year, 3, 1) == 6) {
					flag0301 = true;
					subHoliday0301 = 3;
				} else if (MyCalendarTen.weekDay(year, 3, 1) == 0) {
					flag0301 = true;
					subHoliday0301 = 2;
				}

				boolean flag0505 = false;
				int subHoliday0505 = 0;
				if (MyCalendarTen.weekDay(year, 5, 5) == 6) {
					flag0505 = true;
					subHoliday0505 = 7;
				} else if (MyCalendarTen.weekDay(year, 5, 5) == 0) {
					flag0505 = true;
					subHoliday0505 = 6;
				}

				boolean flag0815 = false;
				int subHoliday0815 = 0;
				if (MyCalendarTen.weekDay(year, 8, 15) == 6) {
					flag0815 = true;
					subHoliday0815 = 17;
				} else if (MyCalendarTen.weekDay(year, 8, 15) == 0) {
					flag0815 = true;
					subHoliday0815 = 16;
				}

				boolean flag1003 = false;
				int subHoliday1003 = 0;
				if (MyCalendarTen.weekDay(year, 10, 3) == 6) {
					flag1003 = true;
					subHoliday1003 = 5;
				} else if (MyCalendarTen.weekDay(year, 10, 3) == 0) {
					flag1003 = true;
					subHoliday1003 = 4;
				}

				boolean flag1009 = false;
				int subHoliday1009 = 0;
				if (MyCalendarTen.weekDay(year, 10, 9) == 6) {
					flag1009 = true;
					subHoliday1009 = 11;
				} else if (MyCalendarTen.weekDay(year, 10, 9) == 0) {
					flag1009 = true;
					subHoliday1009 = 10;
				}
				if (month == 1 && i == 1) {
					out.println("<td class='holiday'>" + i + "<br><span>신정</span></td>");
				} else if (month == 3 && i == 1) {
					out.println("<td class='holiday'>" + i + "<br><span>삼일절</span></td>");
				} else if (month == 5 && i == 1) {
					out.println("<td class='holiday'>" + i + "<br><span>근로자의날</span></td>");
				} else if (month == 5 && i == 5) {
					out.println("<td class='holiday'>" + i + "<br><span>어린이날</span></td>");
				} else if (month == 6 && i == 6) {
					out.println("<td class='holiday'>" + i + "<br><span>현충일</span></td>");
				} else if (month == 8 && i == 15) {
					out.println("<td class='holiday'>" + i + "<br><span>광복절</span></td>");
				} else if (month == 10 && i == 3) {
					out.println("<td class='holiday'>" + i + "<br><span>개천절</span></td>");
				} else if (month == 10 && i == 9) {
					out.println("<td class='holiday'>" + i + "<br><span>한글날</span></td>");
				} else if (month == 12 && i == 25) {
					out.println("<td class='holiday'>" + i + "<br><span>크리스마스</span></td>");
				}

				// 대체 공휴일
				else if (flag0301 && month == 3 && i == subHoliday0301) {
					out.println("<td class='holiday'>" + i + "<br><span>대체공휴일</span></td>");
				} else if (flag0505 && month == 5 && i == subHoliday0505) {
					out.println("<td class='holiday'>" + i + "<br><span>대체공휴일</span></td>");
				} else if (flag0815 && month == 8 && i == subHoliday0815) {
					out.println("<td class='holiday'>" + i + "<br><span>대체공휴일</span></td>");
				} else if (flag1003 && month == 10 && i == subHoliday1003) {
					out.println("<td class='holiday'>" + i + "<br><span>대체공휴일</span></td>");
				} else if (flag1009 && month == 10 && i == subHoliday1009) {
					out.println("<td class='holiday'>" + i + "<br><span>대체공휴일</span></td>");
				}

				else {
					//토욜이면 파란색, 일욜이면 빨간색
					switch (MyCalendarTen.weekDay(year, month, i)) {
					case 0://일욜
				out.println("<td class='sun'>" + i + "</td>");
				break;
					case 6://토욜
				out.println("<td class='sat'>" + i + "</td>");
				break;
					default:
				out.println("<td>" + i + "</td>");
				break;
					}
				}
				//출력한 날짜가 토욜이고 그 달의 막날이 아니면 줄을 바꾼다.
				if (MyCalendarTen.weekDay(year, month, i) == 6 && i != MyCalendarTen.lastDay(year, month)) {

					out.println("</td><tr>");
				}
			} //for문의 끝~

			//			다음달 1일의 요일을 계산한다.
			if (month == 12) {
				week = MyCalendarTen.weekDay(year + 1, 1, 1); // 12월
			} else {
				week = MyCalendarTen.weekDay(year, month + 1, 1); // 1 ~ 11월
			}

			//			다음달 1일이 일요일이면 다음달 날짜를 출력할 필요없다.
			if (week != 0) {
				// 날짜를 다 출력하고 남은 빈 칸에 다음달 날짜를 다음달 1일의 요일부터 토요일까지 반복하며 
				// 출력한다.
				start = 0;
				for (int i = week; i <= 6; i++) {
					if (i == 6) {
				out.println("<td id='aftersat'>" + (month == 12 ? 1 : month + 1) + "/" + ++start + "</td>");
					} else {
				out.println("<td class='after'>" + (month == 12 ? 1 : month + 1) + "/" + ++start + "</td>");
					}
				}
			}
			%>
		</tr>

		<!-- 년,월 선택하고 보기버튼 클릭하면 선택된 달의 달력으로 한 번에 넘어가게 한다. -->
		<tr>
			<td id="choice" solspan="7">
				<form action="?" method="post">
					<fieldset>
						<legend>년</legend>
						<select class="select" name="year">
							<!-- 1900~2100 -->
							<%
							for (int i = 1900; i <= 2100; i++) {
								if (i == calendar.get(Calendar.YEAR)) {
									out.println("<option selected='selected'>" + i + "</option>");
								} else {
									out.println("<option>" + i + "</option>");
								}
							}
							%>
						</select>
					</fieldset>
					<fieldset>
						<legend>월</legend>
						<select class="select" name="month">
							<!-- 1 ~ 12 -->

							<%
							for (int i = 1; i <= 12; i++) {
								if (i == calendar.get(Calendar.MONTH) + 1) {
									out.println("<option selected='selected'>" + i + "</option>");
								} else {
									out.println("<option>" + i + "</option>");
								}
							}
							%>

						</select>
					</fieldset>

					<input class="select" type="submit" value="보기">

				</form>
			</td>
		</tr>





	</table>
</body>
</html>