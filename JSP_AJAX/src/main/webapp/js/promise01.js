/**
 * 
 */
 
 //stringity()문자열로 반환
 //json(javaScript object Notation)
 //	js객체를 json으로 변환하기
 let json = JSON.stringify(true);
 console.log(true);
 console.log(json);
 console.log("1.=================");
 json = JSON.stringify(['apple','banana']);
 console.log(json);
 
 console.log(['apple','banana']);
 
 
 console.log("'2.================");
 //javascript객체
 const rabbit ={
	name:'토오끼',
	colour:'회식',
	size:'겁나큼',
	//js객체나 함수는 stringity()함수로 json형태를 변화시킬 수 '없다'
	
	birthDate:new Date(),
	jump: () => console.log('junp')
}
//폼데이터를 json문자열로 전송하려면 formData객체로 폼데이터전체를 가져온 후
//변환하는루프문으로 처리해 객체배열로 가공해야 함~
console.log(rabbit);

//json은 key부분을 반드시 큰따옴표를 사용하는 문자열로 만들어야 한다
json = JSON.stringify(rabbit);
console.log(json);
console.log("3.=============");

//stringify()의 2번째 인수로 json으로 변환할속성을 배열로 지정가능
json = JSON.stringify(rabbit,['name','colour']);
console.log(json);
console.log("4.=============");

//공공 api
//개발자 센터랑 데이터를 전송하고 (주고받는 형태 json)
//url,data

//2번째 인수로 콜백함수(함수의 매개변수로 함수가 들어간다)
json = JSON.stringify(rabbit,(key,value)=>{
	console.log(`key:${key}, value:${value}`);
	console.log('key:'+key+ 'value:'+value);
	
	return key =='name' ? '별주부' : value;
});
console.log(json);
console.log("5.===============");

//데이터를 문자열로 변환해 보냈다~
//응답오면 json의 문자열 형태로 온다

//json 데이터타입
//Number 숫자형,String 문자열,boolean, Array, Object, null
let booklist={
	"booklist" : [
		{"title" : "선덕왕쓰","author":"김선덕"},
		{"title" : "박인주코드","author":"Inju Park"}
	]
};
console.log(booklist);

//booklistobj.booklist[1].title
//json객체로 온 걸 js객체로 변환
//	= parse()로!
console.log(json)

const obj = JSON.parse(json);
console.log(obj);

//js객체의 객체안에 함수는 json으로 변환불가!
//json에 포함된 날짜도 문자열형태니 객체로 변환불가!
const obj2 = JSON.parse(json,function(key,value){
	console.log(`key:${key}, value:${value}`);
	
	return key == 'birthdDate' ? new Date() : value;
});