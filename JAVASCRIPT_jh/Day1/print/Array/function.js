//함수
//입력O, 출력O
//입력X, 출력O
//입력O, 출력X
//입력X, 출력O

/*
함수 : 선언부, 구현부

키워드 : function 함수명(입력값){타입 안 적어도 됨.
    실행할 문장
    return 값;
}
*/
//입력O, 출력O
//자바스크립트에 먼저 만들어놓았다.
//가져다가 쓰는데 api
const max_num = Math.max(20,30,45);
console.info(max_num);

//지역변수,전역변수
//함수 안에서 설명

//선언부 함수를 정의한 영역
function sayHi(username){
    console.log("hihi~~"+username);
    return "그래";
}

//호출 : 함수를 실제 실행하는 영역
sayHi("이서희");
sayHi("뽀로로");

let a = sayHi("다다야!");
console.log(a);

//선언부 : 숫자를 받아서 세제곱 반환
function cube(num){
    return num* num* num;
}

const res1 = cube(3);
console.log(res1);

const res2 = cube(2);
console.log(res2);

//라면을 생성하는 자판기를 만들기
//파라미터 : 값을 이동시킨다.
//입력X, 출력O
function createRamen(){
    return "라면";
}

const ramen = createRamen();
console.log(ramen);

//선언부 만두생성자판기
//재료를 넘겨서 만두를 만든다.
function createMandoo(menu){
    return menu+"만두";
}

const mandoo1 = createMandoo("고기");
const mandoo2 = createMandoo("김치");
console.log(mandoo1);
console.log(mandoo2);

function createKimbab(a,b){
    return a+b+"김밥";
}

const kimbab1 = createKimbab("참치"+"멸치");
const kimbab2 = createKimbab("스팸"+"김치");

console.log(kimbab1);
console.log(kimbab2);

//반환값이 없는 함수
//return 생략가능.  함수종료,값반환 후 끝!
function test(){
    console.log("반환값 읎다.");
}
test();

//스코프(scope)
//변수의 활동 범위

function changeA(x){
    x = x+3;
    console.log(x);
}
changeA(10);
console.log(x);

let y = 100;

function changeB(){
    console.log(y);
    let mgs = "hello";

    //함수 안에 함수선언 가능
    function changeC(){
        console.log(msg);
        console.log(y);
        let msg2 = "world";
    }
    changeC();
    //console.log(msg2);
}
changeB();

//매개변수에 기본값 설정
//매개변수 = 값
function Show(name, age=0){
    console.log("이름"+name+"나이:"+age)
}
show("이서희",20);
show("이지희");

//함수를 변수에 담을 수 잇다.
//익명함수 : 이름이 없다.
const print = function(){
    console.log("print");
}

/*
//열차예매
    함수명:메뉴
    목적지 보여 주는 함수
    춘천 5000 수원10000 대전 20000 부산 30000
    입력->운임비 리턴

    열차종류
    ktx10000 srt 5000 새마을호3000

    최종운이미를출력하는 함수
*/


//여러개의 매개변수가 넘어올 때 사용하는 방법
//배열형태로 저장시킨다.

//콘솔 지우기!
console.clear();
function info(...args){
    console.error(args);

    //반복문 for each문
    //in 배열의 인덱스번호 갖고 옴!
    //of 값
    for(temp in args){
        console.log(temp);
    }
}
info("1",1,33.25);

//자바스크립트 배열 자료구조(스택, 큐)
//큐 push() -> 맨 마지막
//   shift()-> 제일 앞쪽에 데이터를 꺼낸다.
//              두 번째 있는 데이터를 앞으로 밀어 준다.

//스택 push()-> 가장 마지막에 저장한다.
//      pop()->가장 마지막 요소를 꺼내옴.

let fruit = ["사과", "바나나", "애플망고"];

 fruit.push("딸기");
 alert(fruit.pop());
 console.error(fruit.shift());

 //배열도 매개변수로 전달 될 수 있다!
 //주소값을 넘긴다.
 //배열이 파라미터로 전달되는 경우 원본이 전달됨
 //call by reference

 function info(fruit){
    for(fruit1 of fruit){
        console.warn(fruit1);
    }
 }

 //값이 넘어 올 때 '복사된' 값이 넘어온다.
 //call - by - value
 let a3 = 10;

 function show(num){//변수 10 값을 복사해서 저장
    console.log(num);
    return num + 1;
 }

 show(a3);
 console.error(show(a3));
 console.error(a3);