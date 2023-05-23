const csy_orderBtn = document.querySelector('#csy_orderBtn');

const csy_orderName = document.querySelector('#csy_orderName');
const csy_orderPhone = document.querySelector('#csy_orderPhone');
const csy_orderEmail = document.querySelector('#csy_orderEmail');
const csy_orderAddress1 = document.querySelector('#csy_orderAddress1');
const csy_orderAddress2 = document.querySelector('#csy_orderAddress2');

const csy_chk = document.querySelector('#csy_chk');

csy_orderBtn.addEventListener('click', (event) => {
  // 이벤트값을 초기화시키면 버튼에 기본으로 지정되어있는 reset을 비활성화 시킬 수 있다.
  // 버튼 누를 때 마다 입력된 값 초기화 시키는걸 방지함.
  event.preventDefault();

  if (
    csy_orderName.value.length > 0 &&
    csy_orderPhone.value.length > 0 &&
    csy_orderEmail.value.length > 0 &&
    csy_orderAddress1.value.length > 0 &&
    csy_orderAddress2.value.length > 0
  ) {
    if (csy_chk.checked) {
      alert('주문이 완료되었습니다.');
    } else {
      alert('필수 항목에 동의하세요.');
    }
  } else {
    alert('빈칸을 모두 입력하세요.');
  }
});

document.addEventListener('DOMContentLoaded', () => {
  const loginUser = JSON.parse(sessionStorage.getItem('loginUser'));
  csy_orderName.value = loginUser.name;
  csy_orderPhone.value = loginUser.phone;
  csy_orderEmail.value = loginUser.id + '@' + loginUser.selemail;
  csy_orderAddress1.value = loginUser.adrs1;
  csy_orderAddress2.value = loginUser.adrs2;
});
