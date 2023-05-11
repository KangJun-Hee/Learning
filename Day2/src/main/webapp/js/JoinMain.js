/**
 * 
 */
function check() {
	let fieldset = document.forms[0];
	let values = [fieldset.id.value, fieldset.pw.value, fieldset.pwc.value, fieldset.name.value, fieldset.email.value, fieldset.nick.value, fieldset.ph.value];
	for (let i = 0; i < values.length; i++) {
		let value = values[i];
		if (value == null || value == '' || value == undefined) {
			switch (i) {
				case 0:
					alert('아이디를 입력하세요');
					break;
				case 1:
					alert('비밀번호를 입력하세요');
				case 2:
					alert('비밀번호 확인을 입력하세요');
					break;
				case 3:
					alert('이름을 입력하세요');
					break;
				case 4:
					alert('이메일을 입력하세요');
					break;
				case 5:
					alert('닉네임을 입력하세요');
					break;
				case 6:
					alert('전화번호를 입력하세요');
					break;
			}
			return;
		} else {
			window.location.href = 'homepage.html';
		}

		let idPattern = /[a-zA-Z0-9~!@#$%^&*()_+|<>?:{}]{8,16}/;
		if (!idPattern.test(fieldset.id.value)) {

			//	error[0].innerHTML("8~20자의 아이디를 작성하세요.");
			//	error[0].style.display="block";
			alert("울랄라");
		}
	}
}