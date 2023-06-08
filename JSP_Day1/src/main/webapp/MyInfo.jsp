<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- html 체크폼을 이용해 입력받는 창! 
	
	현재 페이지에 입력한 데이터를 특정 페이지로 전송하려면 전송할 데이터를 입력하는 코드를
	<form> ~ </form> 사이에 작성해야 한다.
	action 속성은 전송(type="submit") 버튼이 클릭되면 form에 
	입력한 데이터를 가지고 넘어갈 jsp 페이지
	이름을 쓴다. => "?"만 입력하면 현재 페이지를 의미한다.
	method 속성은 action 페이지로 데이터가 전송될 때 정보가
	 url(주소) 창에 표시되는 여부를 지정한다.
	action 속성의 기본값은 "get"이고 "get"은 
	전송되는 데이터가 url 창에 표시되고 "post"로 변경하면
	url 창에 표시되지 않는다.
	
	
	-->
	
	<!--   액션:어떤파일로갈거냐 -->
	<form action="MyInfoOK.jsp" method="post">
		<label>이름: <input type="text" name="name"></label><br> <label>아이디:
			<input type="text" name="id">
		</label><br>
		<!-- type="password"일 경우 한글을 타이핑해서 넣을 수 없다. -->
		<label>비밀번호 <input type="password" name="password"></label><br>
		<label>나이: <input type="text" name="age"></label><br>

		<fieldset style="width: 120px;">
			<legend>성별</legend>
			<input type="radio" name="gender" value="true">남자 <input
				type="radio" name="gender" value="false">여자
		</fieldset>
		<br>

		<fieldset style="width: 200px;">
			<legend>취미</legend>
			<input type="checkbox" name="hobbies" value="등산">등산 <input
				type="checkbox" name="hobbies" value="바둑">바둑 <input
				type="checkbox" name="hobbies" value="낚시">낚시
		</fieldset>
		<br>



		<!-- 콤보상자 만들기 -->
		<select name="trip" style="width: 200px; height: 30px;">
			<option>괌</option>
			<option selected="selected">코타키나발루</option>
			<option>다낭</option>
			<option>나트랑</option>
			<option>대만</option>
			<option>보라카이</option>
			<option>푸꾸옥</option>
		</select><br>

		<!-- 목록상자 만들기 -->

		<select name="travel" style="width: 200px;" multiple="multiple"
			size="6">
			<option>괌</option>
			<option>코타키나발루</option>
			<option>다낭</option>
			<option>나트랑</option>
			<option>대만</option>
			<option>보라카이</option>
			<option>푸꾸옥</option>
		</select><br> 메모<br>
		<textarea rows="10" cols="60" name="content" style="resize: none;"></textarea>
		<br>
		<br> <input type="submit" value="정보보기"> <input
			type="reset" value="다시쓰기"> <input type="button" value="그냥버튼">
		<button type="submit">정보보기</button>
		<button type="reset">다시쓰기</button>
		<button type="button">그냥버튼</button>
	</form>

</body>
</html>