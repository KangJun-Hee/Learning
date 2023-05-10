$(() => {
	
	$('div > p').first().click(() => $('div > b').first().toggle());
	
	$('div > p').eq(1).click(() => {
		// $('div > b:eq(1)').toggle();
		// $('div > b:eq(1)').css('color', 'red');
		// $('div > b:eq(2)').css('color', 'blue').html('기능 연결');
		// end(): 마지막에 실행한 메소드의 실행 전 상태로 선택된 요소 집합을 복원시킨다.
		$('div > b').eq(1).css('color', 'red').toggle().end().eq(2).css('color', 'blue').html('기능 연결');
	});
	
	$('div > p').eq(2).click(() => {
		$('div > b').slice(1, 3).css('color', 'hotpink').toggle();
	});
	
	$('div > p').last().click(() => {
		$('div > b').last().css('color', 'dodgerblue').toggle();	
	});
	
});






















