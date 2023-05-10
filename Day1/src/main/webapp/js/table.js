function tableAdd() {
//	데이터가 입력된 form을 얻어와서 form에 입력된 데이터를 배열에 저장한다.
//	let form = document.getElementsByTagName('form')[0];
//	let form = document.querySelectorAll('form')[0];
//	forms: 현재 문서의 form을 배열 형태로 저장하는 자바스크립트 내장 객체
	let form = document.forms[0];

	
	let values = [form.id.value, form.password.value, form.address.value, form.phoneNo.value];
//	console.log(values);
	
//	form에 데이터가 모두 입력되었나 검사한다.
	for (let i=0; i<values.length; i++) {
		let value = values[i];
		if (value == null || value == '' || value == undefined) {
			switch (i) {
				case 0:
					alert('아이디를 입력하세요');
					break;
				case 1:
					alert('비밀번호를 입력하세요');
					break;
				case 2:
					alert('주소를 입력하세요');
					break;
				case 3:
					alert('전화번호를 입력하세요');
					break;
			}
			return;
		}
	}
	
//	배열에 저장된 데이터를 id 속성이 ctb인 테이블에 추가한다.
//	<tbody> 태그를 얻어온다.
	let tbody = document.getElementById('addtr');

//	배열에 저장된 데이터를 사용해서 <tbody> 태그에 추가할 행(<tr> 태그)을 만들어 리턴하는
//	함수를 실행해서 리턴된 결과를 추가한다.
	tbody.appendChild(createRow(values));
	
//	다음 데이터를 입력받기 위해 텍스트 상자의 내용을 모두 제거한다.
	form.id.value = '';
	form.password.value = '';
	form.address.value = '';
	form.phoneNo.value = '';
//	텍스트 상자의 내용을 지운 후 다음 데이터 입력을 위해 아이디 텍스트 상자로 포커스를 이동시킨다.
	form.id.focus();
}

//	<tbody> 태그에 추가할 <tr> 태그를 만들어 리턴하는 함수
function createRow(values) {

//	<tr> 태그를 만든다.
	let tr = document.createElement('tr'); // <tr></tr>

//	열의 개수(인수로 넘어온 values 배열의 length)만큼 반복하며 <td> 태그를 만든다.
	for (let i=0; i<values.length; i++) {
		// <td> 태그를 만든다.
		let td = document.createElement('td'); // <td></td>
		// <td> 태그에 데이터를 넣어준다.
		td.innerHTML = values[i];
		// <tr> 태그에 <td> 태그를 추가한다.
		tr.appendChild(td);
	}

//	현재 데이터 삭제 버튼을 추가하기 위해 <td> 태그에 삭제 버튼을 만들어 <tr> 태그에 추가한다.
	let td = document.createElement('td');

	td.innerHTML = `<input type="button" value="${values[0]}번 데이터 삭제" onclick="removeCurrent(this)"/>`;
	tr.appendChild(td);

//	<tbody> 태그에 추가할 <tr> 태그를 리턴한다.
	return tr;
}

function removeLast() {
//	<tbody> 태그를 선택해서 마지막 <tr> 태그를 제거한다.
	let tbody = document.getElementById('addtr');
	tbody.removeChild(tbody.lastChild);
}

function removeAll() {
//	<tbody> 태그를 선택해서 공백으로 채운다.
	let tbody = document.getElementById('addtr');
	tbody.innerHTML = '';
}

function removeCurrent(obj) {

//	삭제할 <tr> 태그를 선택한다.
	let removeTr = obj.parentNode.parentNode;
//	<tbody> 태그의 자식인 <tr> 태그를 제거한다.
	let tbody = document.getElementById('addtr');
	tbody.removeChild(removeTr);
}



//
