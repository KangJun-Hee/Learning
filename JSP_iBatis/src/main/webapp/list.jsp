<%@page import="com.kh.service.SelectService"%>
<%@page import="com.kh.vo.GuestbookList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  
		이전 페이지에서 넘겨받은 글목록을 데이베이스 테이블에서 얻어와서 
		request 영역에 저장한 후 1페이지 분량의 글을 출력하는 페이지 
	
	 -->
	 <%
	 	// 이전 페이지에서 넘어오는 화면에 표시할 페이지 번호(currentPage)를 받는다.
	 	// 게시판이 최초로 실행 될때는 insertOk.jsp에서 호출될 때 list.jsp로 
	 	// currentPage넘어오지 않기 때문에 null 페이지번호를 숫자로 변경하는 
	 	// 과정에서 exception 발생할 수 있기 때문에 예외처리를 해야된다. 
	 	// 
	 	
	 	int currentPage = 1;
	 	
	 	try{
	 		currentPage = Integer.parseInt(request.getParameter("currentPage"));
	 		
	 	}catch(NumberFormatException e){}	
	 	
	 	//카테고리와 검색어를 받는다
	 	String category = request.getParameter("category");
	 	String item = request.getParameter("item");
	 	
	 	//넘어온 검색어가 있으면 카테고리와 검색어를 세션에 저장하고 넘어온 검색어가 
	 	//세션에 저장된 객체서 카테고리랑 검색어를 읽어온다~
	 	if(item != null){
	 		session.setAttribute("category", category);
	 		item = item.trim().length() == 0?"" : item;
	 		
	 		session.setAttribute("item", item);
	 	}else{
	 		category = (String)session.getAttribute("category");
	 		item = (String)session.getAttribute("item");
	 	}
	 		 	
	 	// 브러우저 화면에 표시할 한 페이지 분량의 글 목록을 얻어온다.
	 	//검색어가 넘어온 경우와 안넘어온 경우 메서드실행을 각각 해야함
	 	SelectService service = SelectService.getInatance();
	 	GuestbookList guestbookList = null;
	 	
	 	if(item == null || item.trim().length() == 0){
	 		//검색어X
	 		guestbookList = service.selectList(currentPage);
	 	}else{
	 		//검색어O
	 		guestbookList = service.selectListMulti(currentPage,category,item);
	 	}
	 	//GuestbookList guestbookList = SelectService.getInatance()
			//				 						.selectList(currentPage);
	 	
	 	// 페이징 정보와 글 목록을 다음 페이지로 데이터 유지해서 이동을 시켜야된다.
	 	request.setAttribute("guestbookList", guestbookList);
	 	// 글을 입력 할 때 엔터를 눌러 줄을 바꿔 입력한 경우 브라우저에 <br />태그로 
	 	// 바꿔서 출력하기 위해 request 영역에 "\r\n" 
	 	
	 	request.setAttribute("enter","\r\n");
	 	
	 	// request 영역에 저장된 글 목록으로 브라우저에 출력하는 페이지(listView.jsp)
	 	// 로 넘겨준다. 
	 	pageContext.forward("listView.jsp");
	 %>


</body>
</html>