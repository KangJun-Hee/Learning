/**
 * 
 */
 $(()=>{
	//전체선택
	$('input:checkbox[name=all]').click(()=>{
		//prop('속성이름'):인수로 지정된 속성의 프로퍼티(키와값으로이루어진파일)을 얻어온다.
		let checked = $('input:checkbox[name=all]').prop('checked');
				
		//prop('속성이름',프로퍼티):인수로 지정된 속성의 프로퍼티를 변경한다.
		//만약 여러개의 데이터가 있으면 자동으로 반복해서 데이터 저장!
		$('input:checkbox[name=chk]').prop('checked',checked);
		
	});
})

$(()=>{
	$('input:checkbox["#confirm"]').click(()=>{
		console.log($('').val());
	})
})