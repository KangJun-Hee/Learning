<%@page import="com.kh.vo.GuestbookVO"%>
<%@page import="com.kh.service.SelectService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 수정 또는 삭제할 글 1건 얻어와 
		request영역에 저장후 
		수정 또는 삭제할 글을 
		브라우저에 표시하는 페이지(delete.jsp,update.jsp)로 넘겨 준다~ -->
		
	<%//listView.jsp에서 수정 또는 삭제버튼 클릭시 넘어오는 데이터를 받는다~
		request.setCharacterEncoding("utf-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		String job = request.getParameter("job");
		
		//수정 또는 삭제할 글 1건 얻어온다~
		GuestbookVO vo = SelectService.getInatance().selectByIdx(idx);
		
		//만약에 vo객체가 없다 null일 경우
		if(vo == null){
			//수정 또는 삭제할 글이 테이블에 존재하니 않으니 에러메시지를 출력하고
			//list.jsp로 보낸다~
			out.println("<script>");
			out.println("alert('테이블에 글이 존재하지 않습니다~')");
			out.println("alert('"+idx+"번 테이블에 글이 존재하지 않습니다~')");
			out.println("location.href='list.jsp'");
			out.println("</script>");
		}else{
			//수정 또는 삭제할 글 존재하면 수정버튼 클릭된 경우 수정글 보여주는
			//브라우저 페이지로 이동~(삭제할 거면 삭제할 페이지로 넘기기~)
			
			// 페이징 정보와 글 목록을 다음 페이지로 데이터 유지해서 이동을 시켜야된다.
		 	request.setAttribute("vo", vo);
		 	// 글을 입력 할 때 엔터를 눌러 줄을 바꿔 입력한 경우 브라우저에 <br />태그로 
		 	// 바꿔서 출력하기 위해 request 영역에 "\r\n" 
		 	request.setAttribute("currentPage", currentPage);
		 	request.setAttribute("enter","\r\n");
		 	// request 영역에 저장된 글 목록으로 브라우저에 출력하는 페이지로 넘겨준다. 
		 	pageContext.forward(job+"listView.jsp");
		}
		%>
</body>
</html>
























