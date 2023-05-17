function joinUser() {
    var joinBtn = document.getElementById('jbtn');
    joinBtn.addEventListener('click', function(){

        const username = document.getElementById('userID').value;
        const password = document.getElementById('userPW').value;
        const passwordc = document.getElementById('pwc').value;
        const nickname = document.getElementById('nickname').value;
        const postcode = document.getElementById('rcID_adrs_w2').value;
        const adrs1 = document.getElementById('adrs1').value;
        const adrs2 = document.getElementById('adrs2').value;
    
    
        if (username && password && passwordc && nickname && postcode && adrs1 && adrs2) {
            if (password !== passwordc) {
                alert('비밀번호가 일치하지 않습니다.');
                return;
            }
    
            var user = {
                username: username,
                password: password,
                nickname: nickname,
                postcode: postcode,
                adrs1: adrs1,
                adrs2: adrs2
            };
    
            localStorage.setItem('user', JSON.stringify(user));
    
            window.location.href = 'Login.html';
        } else {
            alert('회원 정보를 모두 입력해주세요.');
        }
    });

    
}

document.addEventListener('DOMContentLoaded', () => {
    function logcheck() {
        alert('dd');
    //     var idInput = document.getElementById('userID');
    //     var pwInput = document.getElementById('userPW');
    
    //    // var id = idInput.value.trim();
    //     //var pw = pwInput.value.trim();
    
    //     var storedUser = localStorage.getItem('user');
    //     if(storedUser){
    //         var user = JSON.parse(storedUser);
    
    //         if (idInput === user.username && pwInput === user.password) {
    //             alert('로그인 성공!');            
    //             window.location.href = 'https://www.google.co.kr/?hl=ko';
    //         } else {
    //             alert('잘못된 사용자 이름 또는 비밀번호입니다.');
    //         }
    //     }   
     }
})







function emailcheck() {
    var email = document.getElementById('id');

    if (email.value === '') {
        alert('이메일을 입력해 주세요.');
        email.focus();
        return false;
    } else {
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

function selectAll(selectAll){
    const checkboxes = document.getElementsByName("agree");
    checkboxes.forEach((checkbox)=>{
        checkbox.checked = selectAll.checked;
    })
}