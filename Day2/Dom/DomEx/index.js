/*//document 객체 둘러보기
//웹프로그램이 실행하면서 자바스크립트에 문서객체 생성
console.log(document);
console.log(document.title);
console.log(document.URL);

//웹페이지 title변경
document.title = "동적 웹페이지 만들기";

//문서 갖고 와서 h1 변경
const h1 = document.querySelector("#heading");
// console.warn(h1);
// h1.innerText = "진짜 안 갖고 왔나!";

const h2 = document.getElementById("heading");
h2.innerText = "진짜 변경 됐남?";
*/


//버튼 클릭하면 팝업창에 "띵동~"이라고 해보겟음!
//1) DOM 객체 가져오기
const orderBtn = document.querySelector("#order-bell");
//2) 감시를 시작 addEventListener(이벤트명, 처리하는 함수명);
orderBtn.addEventListener("click", function(event){
    //3) 처리를 한다.
    alert("띵동~!");
})