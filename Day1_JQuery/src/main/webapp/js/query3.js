/**
 * 
 //웹브라우저를 실행시 문서가 준비되어있다면 팝업띄우겠다.
	$().ready()=>{
		alert("날이 너무 좋다~");
	}
	
 */
 
 $(() =>{
	//js에선 onclick,onchange와 같이 이벤트가 'on'으로 시작
	$('select').eq(0).change(() => {
		//select태그의 change이벤트 실행됨
		//option : selected는 option에서 선택된 태그를 가지고 온다.
		let select = $('select:eq(0) > option:selected').eq(0).val();
		console.log(select);
		
		$('input:text').eq(0).val(select);
	})
	
	$('input[name=gender]').click(()=> {
		let check = $('input[name=gender]:checked').val();
		console.log(check);
		
		$('input:text').eq(1).val(check);
	
	});
	
	
	
	
})
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 