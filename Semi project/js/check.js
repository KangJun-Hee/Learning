function joinUser() {
    var joinBtn = document.getElementById('jbtn');
    joinBtn.addEventListener('click', function(){

        //이메일 @ 앞=아이디 
        const username = document.getElementById('userID').value;
        //이메일 @ 뒤 셀렉트 옵션들의 목록
        const email = document.querySelector('#email');
        //선택된 옵션
        const selemail = email.options[email.selectedIndex].value;
        const password = document.getElementById('userPW').value;
        const passwordc = document.getElementById('pwc').value;
        const name = document.getElementById('name').value;
        const phnum = document.getElementById('phnum').value;
        const nickname = document.getElementById('nickname').value;
        const postcode = document.getElementById('rcID_adrs_w2').value;
        const adrs1 = document.getElementById('adrs1').value;
        const adrs2 = document.getElementById('adrs2').value;
        
        const agree = document.getElementById('magree');
    
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
    
            // if(!agree.checked){//필수동의 미체크시
            //     alert('약관동의 필수항목을 체크하세요.');
            //     agree.focus();
            //     return;
            // }

            alert('회원가입을 성공적으로 마쳤습니다!');
            window.location.href = 'Login.html';
        } else {
            alert('회원 정보를 모두 입력해주세요.');
        }
    });

    
}

function logcheck() {
    var loginBtn = document.getElementById('loginbtn');
    loginBtn.addEventListener('click', function () {
      var idInput = document.getElementById('userID');
      var pwInput = document.getElementById('userPW');
  
      var storedUsers = localStorage.getItem('users');
      if (storedUsers) {
        var users = JSON.parse(storedUsers);
  
        var foundUser = users.find(function (user) {
          return user.username === idInput.value && user.password === pwInput.value;
        });
  
        if (foundUser) {
          alert('로그인 성공!');
  
          const loginUser = {
            id: foundUser.username,
            selemail: foundUser.selemail,
            password: foundUser.password,
            name: foundUser.name,
            nickname: foundUser.nickname,
            phone: foundUser.phnum,
            adrs1: foundUser.adrs1,
            adrs2: foundUser.adrs2,
          };
          sessionStorage.setItem('loginUser', JSON.stringify(loginUser));
  
          window.location.href = 'https://www.google.co.kr/?hl=ko';
        } else {
          alert('잘못된 사용자 이름 또는 비밀번호입니다.');
        }
      }
    });
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



function checkSelectAll() {
    const checkboxes = document.querySelectorAll('input[name="agree"]');
    const checked = document.querySelectorAll('input[name="agree"]:checked');
    const selectAllCheckbox = document.querySelector('input[name="selectAll"]');
  
    if (checkboxes.length === checked.length) {
      selectAllCheckbox.checked = true;
    } else {
      selectAllCheckbox.checked = false;
    }
  }
  
  function selectAll(selectAllCheckbox) {
    const checkboxes = document.getElementsByName('agree');
    checkboxes.forEach((checkbox) => {
      checkbox.checked = selectAllCheckbox.checked;
    });
    updateCheckAll(); // 체크박스 상태 갱신

  }
  
  window.addEventListener('DOMContentLoaded', () => {
    const selectAllCheckbox = document.querySelector('input[name="selectAll"]');
    selectAllCheckbox.addEventListener('click', () => {
        selectAll(selectAllCheckbox);
    });
  });
  
  


    
// 	//전체선택
// 	$('#selectAll').click(()=>{
// 		//prop('속성이름'):인수로 지정된 속성의 프로퍼티(키와값으로이루어진파일)을 얻어온다.
// 		let checked = $('#selectAll').prop('checked');
				
// 		//prop('속성이름',프로퍼티):인수로 지정된 속성의 프로퍼티를 변경한다.
// 		//만약 여러개의 데이터가 있으면 자동으로 반복해서 데이터 저장!
// 		$('input:checkbox[name=agree]').prop('checked',checked);
// 	});	
// 	});
// });


