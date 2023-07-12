/**
 * 
 */

// 비밀번호가 일치하는지 확인하는 함수 
function paswordCheckFunction() {
	// 코드를 작성하세요~
	// 1. 입력한 패스워드가지고 오기
	// 2. 가지고 온 값을 비교해서 작성하기
	//  비밀번호가 다르면 빨간색으로 비밀번호가 다릅니다.
	//  비밀번호가 같으면 빈공간으로 출력 
	let userPassword1 = $('#userPassword1').val();
	let userPassword2 = $('#userPassword2').val();
	console.log('userPassword1: ' + userPassword1 + ', userPassword2: ' + userPassword2);

	if (userPassword1 != userPassword2) {
		$('#passwordCheckMessage').html('비밀번호가 일치하지 않습니다.');
	} else {
		$('#passwordCheckMessage').html('');
	}

}

// Jquery ajax 

// 회원 가입을 실행하는 함수 

function userRegister() {

	// index.jsp 에서 테이블에 저장할 데이터를 얻어온다.
	let userID = $('#userID').val();
	let userPassword1 = $('#userPassword1').val();
	let userPassword2 = $('#userPassword2').val();
	let userName = $('#userName').val();
	let userAge = $('#userAge').val();
	let userGender = $('input[name=userGender]:checked').val();
	let userEmail = $('#userEmail').val();

	// 위에 데이터가 잘 나오는지 콘솔로 확인 
	//console.log(userID,userPassword1,userPassword2,userName
	//				,userAge,userGender,userEmail);

	// 제이쿼리이용해서 ajax함수 사용!
	$.ajax({
		type: 'POST', // 요청 방식
		url: './UserRegister', // 요청할 서블릿
		data: { // 서블릿으로 전송할 데이터
			// 변수명: 값
			userID: userID,
			userPassword1: userPassword1,
			userPassword2: userPassword2,
			userName: userName,
			userAge: userAge,
			userGender: userGender,
			userEmail: userEmail
		},
		// ajax 요청이 성공하면 response.getWriter().write(문자열)의 문자열이 
		//콜백 함수의 인수로 넘어온다.
		success: res => { // ajax 요청이 성공하면 실행할 콜백 함수
			// console.log('요청 성공: ', res);

			// 다음 데이터 입력을 받기 위해 텍스트 상자의 내용을 지운다.
			$('#userID').val('');
			$('#userPassword1').val('');
			$('#userPassword2').val('');
			$('#userName').val('');
			$('#userAge').val('');
			$('#userEmail').val('');

			// 서블릿 응답에 따른 작업을 실행한다.
			switch (res) {
				case '1':
					$('#messageType').html('에러 메시지');
					$('#messageContent').html('모든 내용을 입력하세요.');
					$('#messageCheck').attr('class', 'modal-content panel-warning');
					break;
				case '2':
					$('#messageType').html('에러 메시지');
					$('#messageContent').html('비밀번호가 일치하지 않습니다.');
					$('#messageCheck').attr('class', 'modal-content panel-info');
					break;
				case '3':
					$('#messageType').html('성공 메시지');
					$('#messageContent').html('회원 가입에 성공했습니다.');
					$('#messageCheck').attr('class', 'modal-content panel-success');
					break;
				case '4':
					$('#messageType').html('에러 메시지');
					$('#messageContent').html('이미 존재하는 회원입니다.');
					$('#messageCheck').attr('class', 'modal-content panel-danger');
					break;
			}

			// 회원 가입 상태 모달창을 띄운다.
			$('#messageModal').modal('show');
		},
		// ajax 요청이 실패하면 에러 정보가 콜백 함수의 인수로 넘어온다.
		error: e => { // ajax 요청이 실패하면 실행할 콜백 함수
			console.log('요청 실패: ', e.status);
		}
	});
}
// 아이디 중복 검사를 실행하는 함수 
function registerCheckFunction() {

	let userID = $('#userID').val();//값갖고오기
	console.log(userID);

	//서버로 데이터 보내야 함~
	//POST:데이터를 서버로 제출해 추가,수정을 하기 위함
	//url에 변수(데이터를) 노출하지 않고 요청함~
	//데이터를 body에 포함해 보낸다~
	//문자열 뿐만 아니라 라디오버튼,버튼,텍스트박스 등의 객체들의
	//값을 전송 가능 

	// 아이디를 서버로 전송 > DB 유효성 검사 > 결과 반환받기
	$.ajax({

		type: 'POST',//전송방식 필수
		url: './UserRegisterCheck',//전송할서버 선택!서블릿선택함~
		data: {
			userID: userID
		},
		success: res => {
			console.log('요청성공~:', res);
			// 서블릿 응답에 따른 작업을 실행한다.
			switch (res) {
				case '1':
					$('#idCheckMessage').html('아이디입력하고 중복체크버튼을 누르세요!');
					$('#checkmessage').html('아이디입력하고 중복체크버튼을 누르세요!');
					$('#idCheck').attr('class', 'modal-content panel-warning');

					//('태그')attr('태그') 데이터를 가져온다~
					//('태그')attr('태그',value) 데이터를 수정한다~
					break;
				case '2':
					$('#idCheckMessage').html('사용중 아이디입니다!');
					$('#checkMessage').html('사용중 아이디입니다!');
					$('#idCheck').attr('class', 'modal-content panel-info');
					break;
				case '3':
					$('#idCheckMessage').html('아이디입력하고 중복체크버튼을 누르세요!');
					$('#checkmessage').html('아이디입력하고 중복체크버튼을 누르세요!');
					$('#idCheck').attr('class', 'modal-content panel-success');
					break;
			}
			// 회원 가입 상태 모달창을 띄운다.
			$('#idModal').modal('show');
		},
		error:e=>{
			console.log('요청실패!~',e.status);
		}
	})
	}