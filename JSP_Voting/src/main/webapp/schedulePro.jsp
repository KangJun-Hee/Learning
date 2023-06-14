<%@page import="com.kh.MyCalendarTen"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Schedule(받아온 내용을 달력에 표시)</title>
<style type="text/css">
td#beforesun,td#before,td#aftersat,td.after{
	color: gray;
	font-size:x-small;
}
td.holiday {
	background-color: aliceblue;
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
	<%
	Calendar calendar = Calendar.getInstance();
	int year = calendar.get(Calendar.YEAR);
	int month = calendar.get(Calendar.MONTH) + 1;

	try {
		year = Integer.parseInt(request.getParameter("year"));
		month = Integer.parseInt(request.getParameter("month"));

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

	<table width="700" border="1" align="center" cellpadding="5"
		cellspacing="0">
		<tr>
			<th id="title" colspan="6"><%=month%> <%=year%></th>
			<th><input class="button button1" type="button"
				value="<"
					onclick="
				location.href='?month=<%=month - 1%>&year=<%=year%>'"> <input
				class="button button1" type="button" value=">"
				onclick="location.href='?month=<%=month + 1%>&year=<%=year%>'">
			</th>
		</tr>
		<tr>
			<th id="sunday">Sunday</th>
			<th>Monday</th>
			<th>Tuesday</th>
			<th>Wednesday</th>
			<th>Thursday</th>
			<th>Friday</th>
			<th id="satday">Saturday</th>
		</tr>
		<tr>
			<%
			int week = MyCalendarTen.weekDay(year, month, 1);

			int start = 0;
			if (month == 1) {
				start = MyCalendarTen.lastDay(year - 1, 12) - week;
			} else {
				start = MyCalendarTen.lastDay(year, month - 1) - week;
			}

			for (int i = 0; i < MyCalendarTen.weekDay(year, month, 1); i++) {
				if (i == 0) {
					out.println("<td id='beforesun'>" + (month == 1 ? 12 : month - 1) + "/" + ++start + "</td>");
				} else {
					out.println("<td id='before'>" + (month == 1 ? 12 : month - 1) + "/" + ++start + "</td>");
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
	</table>
</body>
</html>























