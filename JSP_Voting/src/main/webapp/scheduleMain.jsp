<%@page import="java.io.FileNotFoundException"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scheduleMain</title>
</head>
<body>
	<%
	String filepath = application.getRealPath("/") + "";

	ArrayList<String> input = null;
	Scanner scanner = null;

	try {
		scanner = new Scanner(new File(filepath));
		input = new ArrayList<>();

		while (scanner.hasNextLine()) {
			String str = scanner.nextLine().trim();

			if (str.length() > 0) {
		input.add(str);
			}
		}
	} catch (NullPointerException e) {
		out.println("내용을 입력하세요~");
	}
	%>

	<table width="500" border=1 align="center" cellpadding="5"
		cellspacing="0">
		<tr>
			<th><%=input.get(0) %></th>
		</tr>
	</table>
</body>
</html>