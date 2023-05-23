// 쇼핑 메인 화면 구현
const csy_theads = document.querySelectorAll('.csy_theadMenu');
const csy_tbodies = document.querySelectorAll('.csy_tbodyMenu');

const csy_tbodyMenuOpen = document.querySelector('#csy_tbodyMenuOpen');

const csy_displayOn1 = document.querySelector('#csy_displayOn1');
const csy_displayOn2 = document.querySelector('#csy_displayOn2');
const csy_Btn1 = document.querySelector('#csy_menuClick1');
const csy_Btn2 = document.querySelector('#csy_menuClick2');

// 소메뉴 클릭시 해당 화면으로 전환
csy_Btn1.addEventListener('click', () => {
  csy_displayOn1.style.display = 'grid'; // css에서 display를 grid로 선언해놨기 때문에 grid 입력시 화면에 나타난다.
  csy_displayOn2.style.display = 'none';
});

csy_Btn2.addEventListener('click', () => {
  csy_displayOn1.style.display = 'none';
  csy_displayOn2.style.display = 'grid';
});

// 대메뉴 클릭시 토글기능
function toggleTbody() {
  const tbody = this.nextElementSibling; // nextElementSibling : 바로 다음 형제요소
  tbody.style.display = tbody.style.display === 'none' ? 'table-row-group' : 'none';
}

function hideAllTbodies() {
  for (let i = 0; i < csy_tbodies.length; i++) {
    const tbody = csy_tbodies[i];
    tbody.style.display = 'none';
  }
}

function addEventListeners() {
  for (let i = 0; i < csy_theads.length; i++) {
    const thead = csy_theads[i];
    thead.addEventListener('click', toggleTbody);
  }
}

document.addEventListener('DOMContentLoaded', () => {
  hideAllTbodies();
  addEventListeners();
  csy_tbodyMenuOpen.style.display = 'table-row-group';
  csy_displayOn2.style.display = 'none';
});

// 우영님 js
$(() => {
  $('.wy_navIN li').click(function () {
    // $('.wy_navIN li').attr('class','wy_mimosaShadow');
    $('.wy_navIN li').hide();
  });
});
