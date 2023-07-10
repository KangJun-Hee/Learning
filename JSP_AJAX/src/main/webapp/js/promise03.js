/**
 *동기적 함수 처리법 : 순서대로~
 */
 console.log('1');
 console.log('2');
 console.log('3');
 //위에처럼 123순서대로 실행해 출력한다
 
 //비동기 방식처리
 //setTimeout(함수,시간):지정시간 경과된 후 함수실행~
 console.log('a')
 setTimeout(function(){
	console.log('b');
},3000);//3초
console.log('c');
//실행결과는 ac b 비동기방식으로 실행했기에 3초후 출력함

//동기적콜백:변수var를 붙여 선언하거나 함수선언되면 호이스팅에 의해 맨위로 올라감~
printImmdiately(()=> console.log('hello'));
function printImmdiately(print){
	print();
}

//비동기적콜백
printWithDelay(()=> console.log('callback'),3000);
function printWithDelay(print,timeout){
	setTimeout(print,timeout);
}

//호이스팅
//인터프리터가 변수와 함수의 메모리공간을 선언전에 미리할당하는것!
//var로 선언한 변수의 경우 호이스팅시 undefined로 변수를 초기화한다~