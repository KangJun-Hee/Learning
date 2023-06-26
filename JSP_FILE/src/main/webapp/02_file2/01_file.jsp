<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일명: 01_file.jsp</title>
</head>
<body>
	
	 <form name ="fileForm" method="post" enctype="multipart/form-data"
	 	action ="01_fileUpload.jsp">
	 
	 작성자: <input type ="text" name = "user"><br>
	 제목  : <input type ="text" name = "title"><br>
	 파일명1: <input type = "file" name ="uploadfile1"><br>
	 파일명2: <input type = "file" name ="uploadfile2"><br>
	 
	 	<input type = "submit" value ="파일올리기"><br>

	 </form>
	 
</body>
</html>