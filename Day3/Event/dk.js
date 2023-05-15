//입력창에 있는 데이터가 가지고 와서 글자수 확인
//출력

const button = document.querySelector("#bttn");
//1. 버튼을 클릭하면 실행

//2. 텍스트 필드에 있는 내용을 가져와서 문자열 length확인

//3. div에 태그의 결과를 출력

//여러가지 버튼 혹은 체크박스,
//하나의 이벤트에 설정

// 더블클릭 
button.addEventListener("dblclick",()=>{

    const word = document.querySelector("#word").value;
    const result = document.querySelector("#result");

    let count = word.length; 
    result.innerText = `${count}`;


});