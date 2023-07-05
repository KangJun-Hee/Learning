<%@page import="com.kh.service.SelectService"%>
<%@page import="com.kh.vo.GuestbookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8");
	//delete.jsp에서 넘어오는 데이터 받는다~
	
	int currentPage = Integer.parseInt(request.getParameter("currentPage"));
%>
	
	<jsp:useBean id="vo" class="com.kh.vo.GuestbookVO">
		<jsp:setProperty property ="*" name="vo">
	</jsp:useBean>
<%
		//삭제할 글의 비번과 삭제하기 위해 입력한 비번이 맞는지 비교
		//삭제할 글 얻어온다~
		GuestbookVO original = SelectService.getInatance().selectByIdx(vo.getIdx());
	
		//오라클을 필드선언시 데이터타입을 char로 선언하면 
		//필드의 크기보다 입력된 문자크기가 작으면
		//남는 자리는 모두 공백으로 리턴한다~
		//테이블 설계시 char대신 varchar2로 선언한다~
		//이미 선언된 테이블이라면 trim() 양쪽의 공백을 제거한 후 비교한다
		
		out.println("<script>");
		if(original.getPassword().trim().equals(vo.getPassword())){
			UpdateService.getInstance().Update(vo);
			out.println("alert('수정되었습니다~')");
		}else{
			//불일치, 없다!
			out.println("alert('비번이 불일치합니다~~~~')");
		}
		out.println("location.href='list.jsp?currentPage="+currentPage+"'");
		out.println("</script>");
	%>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>