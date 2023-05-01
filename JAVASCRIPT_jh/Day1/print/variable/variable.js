//변수
//문자 여러개 저장하는 방법 '', "" 상관무
//타입 지정 안해도 된다. 자바스크립트 알아서 데이터파악해서 저장
//중복허용 X
/*
let name1 = "이서희";
let name2 = "강동원";


console.log(name1);
console.log(name2);

const number = 1;
console.log(number);

//고정된 상수! 변경 X
//자바스크립트는 기본값 저장, Object 객체
number = 10;
console.log(number);
console.log(a);
let a = 10;

console.log(a);

undefined : 변수는 있는데 초기화하지 않았다.
*/


//호이스팅(면접단골질문)
// - js가 var 선언된 변수들을 모아서 미리 메모리공간에 올린다.
// - let 대체

//var 문제점
// - 호이스팅
// - 중복선언, 초기화 가능
// - 범위 구별 없다.

//전역변수 : 프로그램 전체적인 곳에서 사용가능
//지역변수 : {}안에 선언된 것, 함수 내부에 선언된 것!

console.log(b);
var b = 10;
console.log(b);

var b = 100;
console.log(b);

{
    var c = 10000;
}
console.log(c);

for(let i=0; i<5; i++){
    console.log(i);
}
console.log(i);

//document.write("하하하하");

//정수실수구분 X 
//number

//문자
//String 

//function