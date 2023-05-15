/*
for(초기식;조건식;증감식){
    반복할 명령을 작성!
}
*/

//팝업창에 입력을 할 수 있는 창이 뜬다.
//prompt(메세지, 입력창에 보여지는 메세지)
/*let number = prompt("숫자입력:", "0");
alert(number);

let str = prompt("아무 문자나 입력");
alert(str);
*/

//술래잡기
//1부터 10까지 숫자세고 시작!

for(let i=1; i<=10; i++){
    console.log(i);
}

console.log("찾는다~");
//카운트 다운 54321
for(let i=5; i>=1; i--){
    console.log(i);
}
console.log("발사!");

//continue
// - 반복 흐름을 강제로 다음으로 넘긴다.
// 369게임
//숫자에 369가 들어가면 "짝" 출력
// 1부터 15까지 반복
// 시작
console.log("### START ###");
// 진행
for (let i = 1; i <= 10; i += 1) {
    if (i === 3 || i === 6 || i === 9) {
        console.log("짝");
        continue;
    }
    console.log(i);
}
// 종료
console.log("### END ###");

//3.break
// - 코드실행을 현재 흐름에서 탈출시킴
// - 반복문에서 사용되는 경우, 가장 가까운 반복흐름을 탈출함
//   상황설정:업다운, 숫자게임! 1~10중 입력 정수 찾기!
// - 정답이 입력값보다 크면 UP, 작으면 DOWN 멘트가 나옴
// - q 입력시, 종료
// 시작 멘트
console.log("### START ###");
    
const randIntNum =   5   //Math.trunc(Math.random() * 10 + 1); // 1 ~ 10
// 사용자 입력 받기

let inputStr = prompt("랜덤 정수 X(1~10)를 맞춰주세요:");    // 문자열로 입력받아온다. 
// 정답 확인
while (inputStr !== "q") {
    let inputNum = parseInt(inputStr); // "3" => 3
    if (inputNum === randIntNum) { // 정답!
        console.log("정답입니다");
    } else if (inputNum < randIntNum) {
        console.log("UP");
    } else {
        console.log("DOWN");
    }
    // 다음 입력 받기
    inputStr = prompt("랜덤 정수 X(1~10)를 맞춰주세요:");
}
// 종료 멘트
console.log("### END ###");
