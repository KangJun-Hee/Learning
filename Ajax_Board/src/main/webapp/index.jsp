<%@page import="com.kh.ajax.AjaxDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="icon" href="./images/logo.png" />
<link rel="stylesheet" href="./css/bootstrap.css" />
<script type="text/javascript" src="./js/jquery-3.6.1.js"></script>
<script type="text/javascript" src="./js/bootstrap.js"></script>
<script type="text/javascript" src="./js/ajax.js"></script>
<!--  ajax를 구현! -->
<title></title>
</head>
<body>
	
	<%
	// 함수호출 Syso출력확인
	
	AjaxDAO.getAjaxDAO().getConnection();
	%>

	<!-- 회원 가입 양식 -->
	<div class="container" style="margin-top: 20px;">
		<table class="table">
			<thead>
				<tr class="success">
					<th colspan="2" style="text-align: center; font-size: 25px;">회원가입</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th style="background-color: hotpink; vertical-align: middle;">이름</th>
					<td><input id="name" class="form-control" type="text"
						autocomplete="off" placeholder="이름을 입력하세요" /></td>
				</tr>
				<tr>
					<th style="background-color: tomato; vertical-align: middle;">나이</th>
					<td><input id="age" class="form-control" type="text"
						autocomplete="off" placeholder="나이를 입력하세요" /></td>
				</tr>

				<tr>
					<th style="background-color: dodgerblue; vertical-align: middle;">성별</th>
					<td>
						<div class="form-group"
							style="text-align: center; margin: 0px auto;">
							<div class="btn-group" data-toggle="buttons">
								<label class="btn btn-primary"> <input type="radio"
									name="gender" value="남자">&nbsp;&nbsp;남자
								</label> &nbsp;&nbsp;&nbsp; <label class="btn btn-primary active">
									<input type="radio" name="gender" value="여자">&nbsp;&nbsp;여자
								</label>
							</div>
						</div>
					</td>
				</tr>

				<tr>
					<th style="background-color: yellowgreen; vertical-align: middle;">이메일</th>
					<td><input id="email" class="form-control" type="text"
						autocomplete="off" placeholder="이메일을 입력하세요" /></td>
				</tr>
				<tr class="warning">
					<td colspan="2"><input class="btn btn-danger pull-right"
						type="button" value="입력하기" onclick="insertFunction()"></td>
				</tr>
			</tbody>
		</table>
	</div>

	<!-- 회원 출력 양식 -->
	<div class="container" style="margin-top: 20px;">
		<div class="form-group row pull-right">
			<div class="col-xs-8">
				<input id="username" class="form-control" type="text" size="20"
					autocomplete="off" onkeyup="searchFunction()">
			</div>
			<div class="col-xs-2">
				<input class="btn btn-primary" type="button" value="검색"
					onclick="searchFunction()" />
			</div>
		</div>
	</div>

	<div class="container">
		<table class="table table-hover">
			<thead>
				<tr class="info">
					<th style="text-align: center;">번호</th>
					<th style="text-align: center;">이름</th>
					<th style="text-align: center;">나이</th>
					<th style="text-align: center;">성별</th>
					<th style="text-align: center;">이메일</th>
				</tr>
			</thead>
			<tbody id="ajaxTable">
				<tr></tr>
			</tbody>
		</table>
	</div>

</body>
</html>


<!-- 
	ajax동작하는 원리 
	1.버튼을 누르거나 마우스로 드래그하거나 클릭하거나 이벤트가 발생 
	2.자바스크립트 호출 
	3.XMLHttpRequest 객체 생성 
	4.Ajax요청 처리 
	5.응답생성 
	6. html, xml , json 데이터 
	7. html 및 css 
	8. 일부분 다시 로딩을 해준다. 
	
	XMLHttpRequest 객체
	  - 웹 브라우저가 서버와 데이터를 교환할 때 사용 

	new XMLhttpRequest();

	// 2. onreadystatechange 등록
	httpRequest.onreadystatechange = function() {};
	
	 onreadystatechange로 서버로 부터 응답이 오게 되어 XMLhttpRequest객체의 값이 
	 변경이 된다. 감지해 자동으로 호출되는 함수를 설정한다. 

	서버로 보낼 AJAX 요청하는 형식 
	httpRequest.open(전달방식,url주소,동기부여) 메서드를등록한다. 
	
	전달방식은 요청 전달할 방식으로 post, get 기본적으로 get
	url주는 요청을 처리할 서버의 파일 주소를 전달한다. 
	동기부여 (false 동기식으로 결과를 가지고 올 것 / true  비동기식으로 결과를 가지고 올 것 ) 
	

 -->






