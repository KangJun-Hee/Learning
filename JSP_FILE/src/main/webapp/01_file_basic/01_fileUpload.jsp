<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>01_fileUpload.jsp</title>
</head>
<body>

	<%
	// 웹 어플리케이션 상의 경로
	String realFolder = "";

	// 파일이 업로드 되는 폴더를 지정한다 .
	String saveFolder = "01_file_basic/filesave";
	// 인코딩 타입 
	String encType = "utf-8";
	// 최대 업로될 파일의 크기 5Mb
	int maxSize = 5 * 1024 * 1024;
	
	// 현재 jsp페이지의 웹 어플리케이션 상의 경로를 구한다. 
	ServletContext context = getServletContext();
	realFolder = context.getRealPath(saveFolder);
	out.print("the realpath is :" + realFolder +"<br>");

	try{
		MultipartRequest multi = new MultipartRequest(
				// 1. 첫번째 인자는 폼에서 가져온 인자값을 얻기 위해 request객체를 전달한다.
				request, // 전송할 파일명을 가지고 있는 객체 
				
				// 2. 두번째 인자는 업로드 될 파일의 위치를 입력한다. 
				realFolder, // 웹 어플리케이션상의 경로
				
				// 3. 세번째 인자는 파일 업로드 최대 용량 크기를 의미하며 최대 크기가 넘는경우
				//   Exception 발생한다. 
				maxSize,   
				
				//  4. 인코딩 타입
				encType, 
				
				//  5. 다섯번째 인자는 똑같은 파일을 업로드 할 경우 중복되지 않도록 
				//   파일이름을 변환해주는 기능
				new DefaultFileRenamePolicy() // 똑같이름이면 뒤에 숫자(1) ,(2)
				);
		
	}catch(Exception e){
		System.out.println(e.getMessage());
	}
	
	%>



</body>
</html>