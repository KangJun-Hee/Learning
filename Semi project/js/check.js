function joinUser() {
    var joinBtn = document.getElementById('jbtn');
    joinBtn.addEventListener('click', function(){

        const username = document.getElementById('userID').value;
        const email = document.querySelector('#email');
        const selemail = email.options[email.selectedIndex].value;
        const password = document.getElementById('userPW').value;
        const passwordc = document.getElementById('pwc').value;
        const name = document.getElementById('name').value;
        const phnum = document.getElementById('phnum').value;
        const nickname = document.getElementById('nickname').value;
        const postcode = document.getElementById('rcID_adrs_w2').value;
        const adrs1 = document.getElementById('adrs1').value;
        const adrs2 = document.getElementById('adrs2').value;
        
        if()
    
        if (username && selemail && password && passwordc && name && phnum && nickname && postcode && adrs1 && adrs2) {
            if (password !== passwordc) {
                alert('비밀번호가 일치하지 않습니다.');
                return;
            }

            var user = {
                username: username,
                selemail: selemail,
                password: password,
                name: name,
                phnum: phnum,
                nickname: nickname,
                postcode: postcode,
                adrs1: adrs1,
                adrs2: adrs2
            };
            var users = JSON.parse(localStorage.getItem('users')) || [];
            users.push(user);
            localStorage.setItem('users', JSON.stringify(users));
    
            window.location.href = 'Login.html';
        } else {
            alert('회원 정보를 모두 입력해주세요.');
        }
    });

    
}

function logcheck() {
    var loginBtn = document.getElementById('loginbtn');
    loginBtn.addEventListener('click', function(){

        var idInput = document.getElementById('userID');
        var pwInput = document.getElementById('userPW');
        
        var storedUsers = localStorage.getItem('users');
        if(storedUsers){
            var users = JSON.parse(storedUsers);
    
            var foundUser = users.find(function(user) {
                return user.username === idInput.value && user.password === pwInput.value;
            });
    
            if (foundUser) {
                alert('로그인 성공!');            
                window.location.href = 'https://www.google.co.kr/?hl=ko';
            } else {
                alert('잘못된 사용자 이름 또는 비밀번호입니다.');
            }
        }   
    })
}


function ordercheck(){
    var oname = document.getElementById('oname');
    var onumber = document.getElementById('onumber');

    if(oname.value === ''){
        alert('주문자명을 입력해주세요.');
    }else if(onumber.value === ''){
        alert('주문번호를 입력해주세요.');
    }else{
        window.location.href = 'https://www.google.co.kr/?hl=ko';
    }
}

function emailcheck() {
    var email = document.getElementById('userID');

    if (email.value === '') {
        alert('이메일을 입력해주세요.');
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
    const checkboxes = document.getElementsByName('selectAll');

    checkboxes.forEach((checkbox)=>{
        checkbox.checked = selectAll.checked;
    })
}
function checkSelectAll()  {
    const checkboxes = document.querySelectorAll('input[name="agree"]');
    const checked = document.querySelectorAll('input[name="agree"]:checked');
    const selectAllCheckbox = document.querySelector('input[name="selectAll"]');

    if(checkboxes.length === checked.length){
        selectAllCheckbox.checked = true;
    }else{
        selectAllCheckbox.checked = false;
    } 
}