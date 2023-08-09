function mainFormCheck(obj) {
//	alert('formCheck');
	if (!obj.category.value || obj.category.value.trim().length == 0) {
		alert('메인 카테고리는 반드시 입력해야 합니다.');
		obj.category.value = '';
		obj.category.focus();
		return false
	}
	return true;
}

function subFormCheck(obj) {
//	alert('formCheck');
	if (!obj.category.value || obj.category.value.trim().length == 0) {
		alert('서브 카테고리는 반드시 입력해야 합니다.');
		obj.category.value = '';
		obj.category.focus();
		return false
	}
	return true;
}

// $(document).ready(function () {
// $(document).ready(() => {
// $(function () {
$(() => {
//	alert('제이쿼리 온로드');

//	메인 카테고리에 아무것도 입력되지 않았나 검사한다.
//	메인 카테고리 입력은 1개만 있기 때문에 id를 지정해서 처리한다.
//	$('#form').submit(function (event) { }): form이라는 id 속성이 지정된 form에서 submit 버튼이 클릭되면
//	submit() 메소드의 인수로 지정한 익명 함수가 실행된다.
//	이 때, 익명 함수의 인수(event)로 실행되는 이벤트가 넘어온다.
	$('#form').submit(function (event) {
		// alert('submit 버튼이 클릭됨');
		// alert($('#category').val());
		// $.trim(): 인수로 지정된 문자열 앞, 뒤의 불필요한 빈 칸을 제거한다.
		let category = $.trim($('#category').val()).length; // 메인 카테고리 박스에 입력한 글자의 개수
		// console.log(event);
		if (category == 0) {
			alert('메인 카테고리는 반드시 입력해야 합니다.');
			// 유효성 검사를 실행했는데 규칙에 위배되므로 action 페이지로 넘겨주는 submit 이벤트의
			// 기본(default) 동작을 중지시킨다.
			// preventDefault(): event로 넘어온 이벤트의 실행을 중지시킨다.
			event.preventDefault();
			
			// $('#category').val(''); // category라는 id 속성이 지정된 텍스트 박스의 내용을 지운다.
			// form이라는 id 속성이 지정된 폼에서 reset 이벤트를 실행한다.
			// 반드시 [0]이라고 인덱스를 지정해야 정상적으로 실행된다.
			$('#form')[0].reset();
			
			$('#category').focus(); // category라는 id 속성이 지정된 텍스트 박스로 포커스를 옮겨준다.
		}
	});
	
//	서브 카테고리에 아무것도 입력되지 않았나 검사한다.
//	서브 카테고리 입력은 여러개가 있기 때문에 class를 지정해서 처리한다.
//	서브 카테고리를 입력하는 폼의 개수만큼 반복하며 모든 서브 카테고리 폼에 name 속성이 다른게 지정한다.

//	sub_form이라는 class 속성이 지정된 폼의 개수만큼 each() 메소드의 인수로 지정한 익명 함수가 반복되서
//	실행된다.
//	each() 메소드는 익명 함수로 2개의 인수를 넘기는 첫 번째 인수는 선택된 객체의 인덱스이고 두 번째 인수는
//	선택된 객체 중에서 인덱스 번째 객체이다. 
//	index: sub_form이라는 class 속성이 지정된 객체의 일련번호(인덱스)가 저장된다.
//	item: sub_form이라는 class 속성이 지정된 인덱스 번째의 객체가 저장된다.
//	$('.sub_form').each(function (index, item) { });

	$('.sub_form').each(function (index, item) {
		// console.log(index, item);
		// addClass() 메소드로 each() 메소드를 통해서 반복되는 객체(서브 카테고리 폼)에 class 속성을
		// 추가한다.
		$(item).addClass('sub_form' + index);
	});

//	서브 카테고리를 입력하는 텍스트 박스의 개수만큼 반복하며 모든 서브 카테고리를 입력하는 텍스트 박스에
//	이름이 다른 class를 지정한다.
	$('.sub_category').each(function (index, item) {
		$(item).addClass('sub_category' + index);
	});

	$('.sub_form').each(function (index, item) {
		$('.sub_form' + index).submit(function (event) {
			// 서브 카테고리 텍스트 박스에 입력한 글자수
			let sub_category = $.trim($('.sub_category' + index).val()).length;
			if (sub_category == 0) {
				// submit() 이벤트가 실행된 폼에서 <span> 태그를 찾아서 입력된 문자열을 얻어온다.
				category = $('.sub_form' + index).find('span').text();
				// console.log(category);
				alert(category + '의 서브 카테고리는 반드시 입력해야 합니다.');
				event.preventDefault();
				$('.sub_form' + index)[0].reset();
				$('.sub_category' + index).focus();
			}
		});
	});

});




















