<%@page import="com.kh.PollWrite"%>
<%@page import="com.kh.PollRead"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일명: pollWrite.jsp</title>
</head>
<body>
	<!--  pollRead.jsp 에서 넘어온 투표한 항목을 받아서 득표수를 증가시켜 텍스트 파일에 저장 한다 -->

<%
	// post 방식으로 데이터가 넘어오면 한글 깨짐을 방지한다. 
	request.setCharacterEncoding("UTF-8");

	String temp = request.getParameter("poll");
	out.println(temp);
	
	// 에러체크 
	// 투표 데이터가 넘어왔니(null 또는 공백이 아닌가?) 검사한다.
	// 반드시 null하고 파일을 저장
	
	if(temp != null && temp.trim().length() != 0){
		
		
		try{	
		
		// 파일을 읽어서 투표항목의 개수를 계산한다. 
		String filepath = application.getRealPath("/")+"poll.txt";	
		ArrayList<String> poll = PollRead.pollRead(filepath);
		int itemCount = (poll.size()-1 ) / 2;
		
		int result = Integer.parseInt(temp);
		
		// 넘어온 투표 데이터가 숫자인 경우 정상적인 투표범위의 데이터 인가 검사한다.
		if(result >= 1 && result <= itemCount){
			
			// 여기까지 왔다면 정상적인 투표 데이터가 넘어왔다 투표한 항목의 득표수를 
			// 증가시켜 텍스트 파일에 저장 
			// 득표수를 1씩 증가 어디 위치에 증가시킬지 확인한다. 
			
			int index = result + itemCount;
			// 1증가된 득표수를 다시 Arraylist에 index 번째 위치에 넣어준다.
			// 득표수를 1증가 시킨다. -> poll Arraylist index번째 데이터를 1증가시킨다.
			
			result = Integer.parseInt(poll.get(index)) +1;
			
			// 숫자로 변환해서 계산을 했기 때문에 파일에 다시 저장될때는 문자열 
			// poll.set(index,String.valueOf(result));
			// poll.set(index,String.format("%s",result));
			poll.set(index,result + "");
			
			//poll => 텍스트파일에 저장할 수있도록 메서드를 실행한다.
			PollWrite.pollWrite(filepath,poll);
			
			// 투표 결과보기 페이지로 넘겨준다.
			response.sendRedirect("pollResult.jsp");
			
			// 리다이렉트랑 포워드 개념 
			
			
		}else{
			// 넘어온 투표 데이터가 정상적인 투표점위가 아니거나 숫자가 아니거나 오류메시지를
			// 출력하고 pollRead.jsp 돌려보낸다. 
			
			out.println("<script>");
			out.println("alert('투표 데이터가 정상 투표범위가 아닙니다.')");
			out.println("location.href ='pollRead.jsp'");
			out.println("</script>");		
			
		}
		}catch(NumberFormatException e){
			// 
			out.println("<script>");
			out.println("alert('투표 데이터가 숫자가 아닙니다.')");
			out.println("location.href ='pollRead.jsp'");
			out.println("</script>");		
		}		
	}else{
		out.println("<script>");
		out.println("alert('투표하세요~~~!!! 안하면 경고뜬다!')");
		out.println("location.href ='pollRead.jsp'");
		out.println("</script>");			
	}
	// 하나의 jsp파일에서 서버용 스크립트(jsp)와 클라이언트용(javascript)를 모두 사용한 경우
	// 코딩순서랑 무관하게 서버용 스크립트가 먼저 다 실행되고 난 후 클라이언트용 스크립트가 실행된다.
	

%>




</body>
</html>