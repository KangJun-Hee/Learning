$(() => {
	
//	$('div b').css({'fontSize': '30px', 'color': 'purple'});
	$('div').find('b').css({'font-size': '30px', 'color': 'tomato'});
	
//	$('#chd').text('손오공');
	$('div').children('#chd').html('<i>사오정</i>');
	
	$('span').css('fontSize', '20px').css('background', 'yellowgreen');
	$('span').parent().css('background', 'skyblue');
	$('span').parents('div').css('background', 'dodgerblue');
	
	$('p').eq(2).next().css('background', 'lime');
	$('p').eq(2).prev().css('background', 'hotpink');
	
});






















