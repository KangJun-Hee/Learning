<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모델 앤 뷰!</title>
</head>
<body>
		
	modelAndView.jsp	
	<!--  컨트롤러에서 Model 인터페이스 객체에 저장됭서 넘어오는 데이터는 EL을 사용해서 얻어오면 된다.  -->	
	id: ${id} <br/>
	pw: ${pw} <br/>
	name : ${name} 
		
</body>
</html>