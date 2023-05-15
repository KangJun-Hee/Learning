//선택한 옵션을 팝업창에 띄우기
const selectMenu = document.querySelector("#major");

function displaySelect(){
    let selectedText = selectMenu.options[selectMenu.selectedIndex]
            .innerText;
    // alert();
    alert(`[${selectedText}]를 선택했습니다!`);
}
selectMenu.onchange = displaySelect;

/*
라디오 버튼이나 체크 박스는 name 을 사용해 버튼을 그룹으로
 묶는다. (라디오 버튼이나 체크 박스는 하나의 그룹 안에서
     항목을 선택하기 때문)
라디오 버튼과 체크박스는 name 값을 사용해 접근한다.
같은 name을 가진 항목이 많기 때문에 RadioNodeList라는 
노드 리스트 형태로 저장됨.(배열과 비슷한 형태)
어떤 항목을 선택했는지 알려면 checked 속성이 있는지 
체크 (checked 속성은 HTML에서 라디오 버튼과 체크 박스에
    서 사용할 수 있는 속성)
 */