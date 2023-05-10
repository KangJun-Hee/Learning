/**
 * 
 */
 function a1(){
	//span 선택해 속성을 변경
	//js라면 -> document.querySelector('')
	
	//let span = document.getElementsByTagName('span');
	//let span = document.querySelectorAll('span');
	//console.log(span.length);
	// for(let i=0;)
	
	//jquery는 배열형태도 반복문 없이 알아서 처리한다.
	$('span').css('color','pink');
	
}

//a2 아이디
function a2(){
	$('#t1').css('color','red');
}
//a3 클래스
function a3(){
	$('.t2').css('color','blue');
}
//자식
function a4(){
	$('li > span').css('color','lime');
}
//자손
function a5(){
	$('li span').css('color','purple');
}
//nth-child 앞에서부터 '1부터' 셈
//같은 부모요소를 가지는 자매요소 중에서 특정 순서있는
//요소 선택

//$('li').eq(0)   =같은의미= 	$('li:eq(0)')
//	n은 자동을 0부터 1씩 증가하는 정수이고 '+', '-', '*' 연산을 사용할 수 있다.
//	$('li:nth-child(n)').css('backgroundColor', 'dodgerblue'); // 모두 선택된다.
//	$('li:nth-child(n + 3)').css('backgroundColor', 'dodgerblue'); // 3번째 부터 모두 선택된다.
//	'' 연산도 가능한데 '' 연산자를 사용하면 안되고 숫자가 n 앞에 나와야 한다.
//	$('li:nth-child(2n)').css('backgroundColor', 'dodgerblue'); // 짝수 인덱스만 선택한다.
//	$('li:nth-child(2n + 1)').css('backgroundColor', 'dodgerblue'); // 홀수 인덱스만 선택한다.


//$('li:nth-child(1)').css('backgroundColor','red');
function a6(){
	$('li:nth-child(3n)').css('backgroundColor','yellow');
}

function a7(){
	$('li:first-child').css('backgroundColor','tomato');
}

function a8(){
	$('li:last-child').css('backgroundColor','yellowgreen');
}






















