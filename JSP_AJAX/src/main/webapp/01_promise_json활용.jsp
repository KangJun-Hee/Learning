<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>json활용</title>
<script type="text/javascript" src="./js/promise01.js"></script>
</head>
<body>
<!-- 
	Ajax(Asynchronous JavaScript and XML)
		- 데이터를 이동하고 화면구성하는데 있어 웹화면을 갱신하지 않고 필요한 데이터
		  서버로 보내고 가져오는 방식~
		  화면갱신없이 사용자입장에서 매우편리하고빠르게 작업을 처리하는 것처럼
		  느낄 수 있도록 동적화면 구성하는 것!
		  
		  동기->일을 실행했을 때 그 일 다끝날때까지 기다렸다가 다음일 실행
		  	(결과 기다림)
		  비동기->	"시켜 놓고 다른 일들을 한다
		  	(결과 안기다리고 딴거함)
		  	
		  실제데이터들을 처리하는(전송시 데이터의 형식)
		  CSV 콤마, 형태로 데이터를 구별함(용량이 적다,가독성떨어짐)
		  XML 태그형식으로 데이터,속성 구별함
		  	  가독성좋음, 용량큼, 데이터많으면 분석속도떨어짐.
		  	  
		  JSON {key,value}가독성좋고 용량적다
		  	a={
		  		"이서희":20,
		  		"과일":"사과"
		  	}
		  
		  데이터 전송시 많이 사용하는 방식 json
		  
		  json으로 통신하려면 사용법 알아야함
		  웹에서 js로 생성하는 데이터는 주로 배열,객체
		  걔네를 문자열로 반환시 json
 -->
</body>
</html>