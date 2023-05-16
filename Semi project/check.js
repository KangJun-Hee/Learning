function logcheck() {
    var id = document.getElementById('userID');
    var pw = document.getElementById('userPW');
    var loginBtn = document.getElementById('loginbtn');
    var joinBtn = document.getElementById('joinbtn');


	if (id.value == '') {
			alert('아이디를 입력해 주세요.');
            id.focus();
			return false;
	}else if (pw.value == ''){
            alert('비밀번호를 입력해 주세요.');
            pw.focus();
            return false;
    }else{
        location.href='join.html';
        return true;
    }
}

function emailcheck(){
    var email = document.getElementById('inputw');

    if (email.value == ''){
        alert('이메일을 입력해 주세요.');
        email.focus();
        return false;
    }else{
        alert('사용가능한 이메일입니다!');
        return true;
    }
}

function rcIDsrchf(){
    var rcID = document.getElementById('rcID_adrs_w');

    if(rcID.value == ''){
        alert('추천인 아이디를 입력해 주세요.');
        rcID.focus();
        return false;
    }else{
        alert('확인 완료되었습니다. 적립금 5,000p를 지급해 드렸습니다!');
        return true;
    }
}
}