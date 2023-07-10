/**
 * 
 */
console.log("1--------------------------");
 const words = ['spray','limit','elite','exuberant','destruction'];
 /*
 function callback(element){
	console.log(element);
}
words.filter(callback);

words.filter(function(element){
	console.log(element);
})
*/
words.filter(element=>console.log(element));


console.log("2--------------------------");
function callback2(element){
	if(element.length > 6){
		return element;
	}
}
let newWords = words.filter(callback2);
console.log(newWords);
//filter메서드 배열에서 사용함
//조건준다.해당조건이 참인 요소 모아 새배열로 반환




console.log('4. ====================================');
function callback4(element) {
//	element.length > 6 실행 자체가 논리값이므로 바로 리턴하면 된다.
	return element.length > 6;
}
newWords = words.filter(callback4);
console.log(newWords);

console.log('5. ====================================');
//	filter 함수의 인수로 익명 함수를 바로 넣어준다.
newWords = words.filter(function (element) {
	return element.length > 6;
});
console.log(newWords);

console.log('6. ====================================');
//	filter 함수의 인수로 익명 함수를 화살표 함수로 바꿔준다.
newWords = words.filter((element) => {
	return element.length > 6;
});
console.log(newWords);

console.log('7. ====================================');
//	화살표 함수를 생략형으로 바꿔준다.
newWords = words.filter(word => word.length > 6);
console.log(newWords);
