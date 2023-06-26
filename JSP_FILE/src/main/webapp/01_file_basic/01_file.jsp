<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일명: 01_file.jsp</title>
</head>
<body>
	<!--  파일을 업로드 하고 다운로드 할 때 cos.jar파일을 web_inf -> lib 파일을 추가해한다.
		파일을 업로드 할 때에는 enctype을 추가해야된다. 
		input태그에서 type을 file로 설정하여 파일을 업로드 할 수 있다.
		form으로 파일을 웹 서버로 넘기게 되면 파일은 서버에 지정된 디렉토리에 저장된다.
		실제 파일은 별도의 파일 서버의 디렉토리에 저장하고 데이텅베이스에는 실제 파일을 저장하는 것이 
		아닌 파일의 이름 및 관련 정보들만 저장한다. 
		
		파일을 업로드 하고 다운로드할 때 사용하는 클래스 
		 enctype = post방식에서만 존재하기 때문에 get 방식으로는 파일을 전송할 수 없다!
		 
		 파일업로드
		 1) 파일의 저장 경로 지정 : 웹서비스의 접근 경로가 아닌 물리적 (실제 경로를 적어준다.)
		 2) 파일의 최대 용량 지정 : '한번에' 업로드 될 최대 용량 지정  
		 3) MultipartRequest클래스 
		 	1
		 
		 
	 -->
	 <form name ="fileForm" method="post" enctype="multipart/form-data"
	 	action ="01_fileUpload.jsp">
	 
	 작성자: <input type ="text" name = "user"><br>
	 제목  : <input type ="text" name = "title"><br>
	 파일명1: <input type = "file" name ="uploadfile"><br>
	 파일명2: <input type = "file" name ="uploadfile"><br>
	 
	 	<input type = "submit" value ="파일올리기"><br>

	 </form>
	 
</body>
</html>