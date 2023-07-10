/**
 * 
 */
 let number = [1,2,3,4,5];
 
 //화살표함수
 				//x에서 반복합니다
 number.forEach(x =>{
	console.log(x*2);
})

//익명함수				매개변수x
number.forEach(function(x) {
	console.log(x*2);
})

function one(){
	console.log("one");
}

function two(name,callback){
	console.log("two");
	callback();
}
	//name   함수
two('junhee',one);

//js는 null과 undefined타입 제외하고 모든걸 객체로 다룸!
//매개변수로 함수이름 들어갈 때() 붙일 필요없다

//전역변수,지역변수를 콜백함수의 파라미터로 전달가능!
//전역변수(Global Variable):함수외부에서 선언된 변수
//지역변수(Local Variable):함수내부에서    "
let fruit = 'apple'; //전역변수

function callbackFunc(callback){
	let vegetable = "tomato"; //전역변수
	callback(vegetable);
}

function eat(vegetable){
	console.log(`fruit:${fruit}/vegetable:${vegetable}`);
}
callbackFunc(eat);