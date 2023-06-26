<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>
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
	
	String realFolder = "";
	String saveFolder = "02_file2/filesave";
	String encType = "utf-8";
	int maxSize = 5 * 1024 * 1024;

	ServletContext context = getServletContext();
	realFolder = context.getRealPath(saveFolder);
	out.print("the realpath is :" + realFolder + "<br>");

	MultipartRequest multi = null;
	try {
		multi = new MultipartRequest(
				request,
				realFolder,
				maxSize,
				encType,
				new DefaultFileRenamePolicy()
			);
		
		// =---------------------------------------------------------------
		//  파일을 업로드 사용하면 request를 통해 넘어온 데이터를 저장 할 수 없다.
		// 위에서 생성한 multi객체를 통해서 데이터를 가져올 수있다.
		// multi.getParameter userName 가져올 수있다. 

		// form태그 안에 담겨있는 데이터들의 name값을 저장한다. 

			Enumeration keyList = multi.getParameterNames();

		//꺼내올 다음 데이터가 있다면
		while (keyList.hasMoreElements()) {
			String key = (String)keyList.nextElement(); 	//전송된 이름(name)
			String value = multi.getParameter(key); 		//전송된 값(value)
			
			out.print(key + " = " + value + "<br>");
		}
		
		out.print("-------------------------------------<br>");

		//전송된 파일 정보를 가져와 출력한다
		Enumeration fileKeyList = multi.getFileNames();

		//파일 정보가 있다면
		while (fileKeyList.hasMoreElements()) {
			//input 태그의 속성이 file인 태그의 name 속성값 :파라미터이름
			String key = (String) fileKeyList.nextElement();

			//해당 경로에 저장된 파일 이름
			String filename = multi.getFilesystemName(key);

			//전송전 원래의 파일 이름
			String original = multi.getOriginalFileName(key);

			//전송된 파일의 내용 타입
			String type = multi.getContentType(key);

			//전송된 파일 속성이 file인 태그의 name 속성값을 이용해 파일 객체 생성
			File file = multi.getFile(key);

			out.println("파라메터 이름 : " + key + "<br>");
			out.println("실제 파일 이름 : " + original + "<br>");
			out.println("저장된 파일 이름 : " + filename + "<br>");
			out.println("파일 타입 : " + type + "<br>");

			if (file != null) {
				out.println("크기 : " + file.length());
				out.println("<br>");
			}
			out.print("-------------------------------------<br>");
			
		}
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	
	
	%>



</body>
</html>