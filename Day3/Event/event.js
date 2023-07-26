// 입력창에 있는 데이터가 가지고와서 글자 수 확인
// 출력 

// const button = document.querySelector("#bttn");

// 1.버튼을 클릭하면 실행
// 2. 텍스트 필드에 있는 내용을 가져와서 문자열 length확인
// 3. div에 태그에 결과를 출력 

// 여러가지 버튼 혹은 체크박스, 이미지, 스크롤 , 범위 등등등 
// 하나의 버튼에 여러가지 이벤트를 설정 

// 한번 클릭하면 실행 
// button.addEventListener("click",()=>{

//     const word = document.querySelector("#word").value;
//     const result = document.querySelector("#result");

//     let count = word.length; 
//     result.innerText = `${count}`;
// [연습2] 뭐 먹을까?(정답 체크 시 => CSS 적용)
// 1) 대상 DOM 객체 가져오기
const input = document.querySelector("#answer-c");
// 2) 감시를 시작
input.addEventListener("change", function(event) {
    // 3) 처리를 수행
    // 이벤트 발생 객체를 가져옴
    const checkbox = event.target;
    const listItem = checkbox.parentNode;
    // 체크여부에 따라 동작을 수행
    if (checkbox.checked) {
        // 클래스 부여 => CSS 스타일링 적용
        listItem.classList.add("text-primary");
    } else {
        // 클래스 제거 => CSS 스타일링 제거
        listItem.classList.remove("text-primary");
    }
});











// button.addEventListener("dblclick",()=>{

//     const word = document.querySelector("#word").value;
//     const result = document.querySelector("#result");

//     let count = word.length; 
//     result.innerText = `${count}`;


// });


//장바구니 담기
const menuCart = [];
const resultDiv = document.querySelector("#order-list");

const menuButtons = document.querySelectorAll("#practice-3 button");

for(let i=0; i<menuButtons.length; i++){

    //각각 버튼에 이벤트
    menuButtons[i].addEventListener("click",function(e){
        const btn = e.target;
        const menuName = btn.innerText;

        //저장한 거 리스트에 추가
        menuCart.push(menuName);

        resultDiv.innerText = `[${menuCart}이 주문이 되었습니다!]`;
    })
}


