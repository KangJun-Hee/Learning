//당당치킨 13000 칼로리
//사람의 정보를 간단히 입력
//이서희 20 이지희 30

//객체 object
// - 사용자 정의 자료형
// - 내가 담고 싶은 변수(데이터) 묶는다.
// - 여러가지 프로퍼티(key:value)로 구성된다.

const seohee = {
    name1: "이서희",
    age: 20,
    address: "경기도 성남시",
};

const jihee = {
    name1: "이지희",
    age: 30,
    address: "인천광역시"
}
//java의 map이랑 똑같다!

//객체 출력
console.log(seohee);
console.log(jihee);




const ramen = {
    name1: "뽀글이",
    price: 3500
};
const chicken = {
    name1: "슈넬치킨",
    price: 5500
};
const coke = {
    name1: "코카콜라",
    price: 1500
};
const americano = {
    name1: "아메리카노",
    price: 3500
};

console.log("========메뉴판========");
console.log(ramen);
console.log(chicken);
console.log(americano);
console.log(coke);

//console.clear();
//object를 생성하면 주소값
//const변수를 이용해서 주소값을 변경 못하게
//고정시킨다.

//프로퍼티 다루기(읽기, 쓰기)
//. 닷연산 : 객체의 키를 통해 값을 가져옴
//[]대괄호 연산 : 객체의 키를 조작해 값을 가져올 수 있다.

//가격 변경
ramen.price += 1000;
chicken.price += 1000;
coke.price += 1000;
americano.price += 1000;

//[] 이용시 문자열 key 줘야 함
ramen['price'] += 1000;
chicken['price'] += 1000;
coke['price'] += 1000;
americano['price'] += 1000;

console.log(ramen);
console.log(chicken);
console.log(americano);
console.log(coke);

//User만들어서 게임 쿠키들을 저장하는
//객체 생성하기
//쿠키 이름,등급,레벨,속성
const cookie1 = {
    cookie_name: "천사맛 쿠키",
    cookie_level: 10,
    cookie_grade: 'S',
    cookie_skill: ["악령퇴치", "소생"]
};

//반복문 이용해서 출력
//1.key 가져온다.
//2.cookie1 변수 안에 key가 있니?
//     키 존재O true, 존재X false
for (let i in cookie1) {
    console.error(i);
    console.warn(cookie1[i]);
};

//객체 배열 생성 및 순회
//     당연히 객체도 배열에 저장될 수 있음.
// for, for each, for of(value)

const arr = [
    { name1: "강아지", age: 2 },//0번방
    { name1: "고양이", age: 1 },//1번방
    { name1: "도마뱀", age: 1 },//...~
    { name1: "토끼", age: 2 }
];
console.clear();
console.log(arr);

//기존 for문
for (let i = 0; i < arr.length; i += 1) {
    console.log(arr[i].name1);
    console.log(arr[i].age);
}
//for .. of문
for (let item of arr) {
    //{name1:"강아지", age:2}
    console.error(item);
}

//자바스크립트는 자바와 다르게
//객체를 생성하고 나서 멤버변수를 추가할 수 있다.
//추가하는 방법
//객체생성할 때
const user1 = {
    id: "love",
    pw: "love"
};
//프로그램 실행중!(런타임)
console.log(user1);
console.clear();

//중간에 추가가 된다!
user1['ninkname'] = "empross";

//삭제delete 객체명.필드명
console.log(user1);

delete user1.nickname;
console.log(user1);


//변수명['key'] = 값;
//중간에 변수를 추가하는 것은 좋으나 나중에
//유지 보수가 많이 힘들다.

//자바스크립트에서 객체를 생성하는 방법은
//두 가지가 있다.

//obj = {} 중괄호를 이용하는 방법.
//obj2 = new Object(); 객체를 이용하는 방법


const person1 = { name1: "박신우", age: 33 };
const person2 = { name1: "강고결", age: 35 };
const person3 = makePerson("우영우", 27);
const person4 = makeperson("문미미", 33);

console.log(person3);
console.log(person4);

//매개변수 받아서 객체를 생성하는 함수
//매개변수 값이랑 멤버 key이름이 같을 경우,
//key부분을 생략해도 된다.
function makePerson(name, age) {
    return {
        name1,
        age
    };
}

const person5 = new Person("송성실", 41);
console.log(person5);
//생성자 object
//constructor function
function Person(name1, age) {
    //객체생성할 때 각각 this
    //this={}
    this.name1 = name1;
    this.age = age;
    //return this;
};
/*
생성자함수 이용해 객체 저장
배열에 저장해 출력(함수를 이용해서 객체를 출력)
학생들 배열
실제 학생 name,subject,score
생성자 함수를 이용해서 저장하고 출력
 */
function Student(name,subject,score){
    this.name = name;
    this.subject = subject;
    this.score = score;
};
const student1 = new Student("김길동", "자바", 100);
const student2 = new Student("박길동", "디비", 50);
const student3 = new Student("이길동", "화면", 85);
const student4 = new Student("정길동", "서버", 60);
const student5 = new Student("홍길동", "자바", 20);




//객체복사!
//cloning : 객체를 복사할 수 있다.(자바에서 깊은 복사, 얇은 복사개념)

//객체 복사는 새로운 객체를 만들어서 안에 있는 값
//똑같이 복사
// 아래 거는 주소값만 복사를 한 것!
const a = {id:"qwer",pw:"qwer"};
const b = a;
b.id = "asdf";

console.log(a);
console.log(b);

console.clear();

//각각 대입하기
const c = {};   //비어있는 객체 생성 먼저
for(key in a){
    c[key] = a[key];
}
console.log(c);

//assign(새로운객체, 기존객체) 객체 복사할 때 사용하는 함수
const d = {};
Object.assign(d, a);
console.error(d);

const e = Object.assign({}, d);
console.warn(e);

//여러개를 하나의 객체에 복사를 한다.
//복사하는 대상 key 중복되는 것은 새로 만들지
//않고 덮어쓴다.
const f = {colour:"red"};
const g = {colour:"pink",size:"big"};

const mix = Object.assign({}, f,g);
console.log(mix.colour);
console.log(mix.size);