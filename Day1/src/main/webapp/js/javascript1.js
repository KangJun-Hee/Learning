/**
 * 
 */
 function elementCreate(){
	//요소를 만들어서 문서에 추가한다.
	//createElement('태그이름')#인수로 지정된 태그를 만든다.
	
	let div = document.createElement('div')
	
	//태그에 속성과 속성값을 추가한다.       : <-키의?
	div.setAttribute('style', 'border: 2px solid red');
	div.serAttribute('class','skyblue');
	
	document.body.appendChild(div);
	
	div.innerHTML = '<marquee>div 태그 추가</marquee>'
	
	

}