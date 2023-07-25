<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>jQuery 테스트 페이지</title>
<script src="js/jquery-1.11.0.min.js"></script>
<script>
  $(document).ready(function(){
	  $("button").click(function(){
	    $("#displayArea").html("<img src='ansi_main2s.png' />");
	  });
  });
</script>
</head>
<body>
  <div id="displayArea">이곳의 내용이 변경 </div>
  <button>표시</button>
</body>
</html>