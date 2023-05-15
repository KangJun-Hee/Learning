// 출력 log 
// 계절 찾기 
// 월을 저장하고 봄 3,4,5 여름 6,7,8 가을 9,10,11
//  겨울 12,1,2
// switch 문으로 작성하기

let season = undefined;
// 입력 월에 따른 계절 계산
let month = 3;

switch (month) {
    case 3:
    case 4:
    case 5:
        season = "봄";
        break;
    case 6:
    case 7:
    case 8:
        season = "여름";
        break;
    case 9:
    case 10:
    case 11:
        season = "가을";
        break;
    case 12:
    case 1:
    case 2:
        season = "겨울";
        break;
    default:
        season = null;
        break;
}
console.log(season);

let fare = 0;
let age = 15;

// 나이에 따른 요금 계산
if (age > 18) {
    fare = 1200; // 일반: 1200원
} else if (age > 12) {
    fare = 720; // 청소년: 720원
} else {
    fare = 450; // 어린이: 450원
}

document.write(fare,"원 <br>");




/*
// 결과를 옆에 적어보세요!
7 !== 3      
5 === “5”
!(2 <= 5)
56 % 8 === 0


// 5. 논리 연산자, 풍부한 조건식 만들기!
// - AND(&&): 두 조건이 모두 참이면, 참(true)
// - OR(||): 둘 중 하나라도 참이면, 참(true)
// - NOT(!): 참을 거짓으로, 거짓을 참으로 변경
// 상황 설정: 소개팅 어플, 등급 계산
// - 평가 속성: 외모(0~100), 대화(0~100), 재력(0~100)
// - 결과 등급: S(최상), A(상), B(중), C(하)

// 1. 등급변수 생성
// 2. 점수에 따른 등급 계산 
//   모두 90이상 S
//   재력이 90이상이면서 외모와 대화 총점이 160이상 A
//   적어도 하나가 90점 이상이면 B 
//   나머지는 C 

document.write()

*/


let tier = undefined;
let looking = 80;
let talking = 80;
let rich = 80;

if (looking >= 90 && talking >= 90 && rich >= 90) {
    tier = "S";
} else if (rich >= 90 && (looking + talking) >= 160) {

    tier = "A";
} else if (looking > 90 || talking > 90 || rich > 90) {
    tier = "B";
} else {
    tier = "C";
}

console.log(tier);

document.write("왜이래 진짜!");

let name2 = prompt("당신의이름>");
alert(name2);
