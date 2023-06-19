/**
 * 
 */
function passwordCheck(obj) {
	//입력한 비번이 8~12인지 검사한다.
	//trim()공백제거
	let len = obj.password.value.trim().length;
	console.log(len);

	if (len < 8 || len > 12) {
		alert("비번은 8~12자 사이로 입력해야 해~~");
		obj.password.value = "";
		obj.repassword.value = "";
		obj.password.focus();
		return false;
	}
	//영문자,숫자,특수문자가 각각 1개 이상 입력됐나 검사한다~
	let alphaCount = 0; //영문
	let numberCount = 0;//숫자
	let etcCount = 0;	//특수문자

	//입력된 비번의 문자개수만큼 반복해 영문,숫자,특수문자의 개수를 센다.
	const pw = obj.password.value.trim();
	for (let i = 0; i < len; i++) {
		if (pw.charAt(i) >= 'a' && pw.charAt(i) <= 'z' || pw.charAt(i) >= 'A' && pw.charAt(i) <= 'Z') {
			alphaCount++;
		} else if (pw.charAt(i) >= '0' && pw.charAt(i) <= '9') {
			numberCount++;
		} else {
			etcCount++;
		}
	}
	console.log('영문자: ' + alphaCount + '개, 숫자: ' + numberCount + '개, 특수문자: ' +
		etcCount + '개');

	if (alphaCount == 0 || numberCount == 0 || etcCount == 0) {
		alert('비밀번호는 영문자, 숫자, 특수문자를 각각 1글자 이상 포함해야 합니다.')
		obj.password.value = '';
		obj.repassword.value = '';
		obj.password.focus();
		return false;
	}





	//new RegExp('정규식 패턴')->자바스크립트 정규식 객체를 만든다.
	// . =>모든 문자 1글자를 대신한다.
	// * =>모든 문자 0글자 이상을 대신한다.(아무문자가 안 나와도 되고 몇개가 나와도 상관무)
	// + =>모든 문자 1글자 이상을 대신한다.(아무거나)
	// ^ =>시작하는
	// $ =>끝나는

	//글자수를 제한
	//무조건 8자만 허용!
	const pattern = new RegExp('^.{8}$');

	//8자 이내만 허용한다.
	const pattern2 = new RegExp('^.{1,8}$');

	//8자 이상만 허용한다.
	const pattern3 = new RegExp('^.{8,}$');

	//8~12자 사이로 입력
	const pattern4 = new RegExp('^.{8,12}$');

	//숫자만 허용. 허용가능한 문자를 [] 안에 나열한다.
	// + 를 안 쓰면 딱 1글자만 확인함.
	const pattern5 = new RegExp('^[0123456789]+$');

	// - 를 사용해 범위를 지정가능
	const pattern6 = new RegExp('^.[0-9]+$');

	//숫자 4자만 허용. {}가 사용되면 +나 * 사용불가!
	const pattern7 = new RegExp('^.[0-9]{4}$');

	//	const pattern = new RegExp('^[A-Z]+$'); // 대문자만 허용한다.
	//	const pattern = new RegExp('^[a-z]+$'); // 소문자만 허용한다.
	//	const pattern = new RegExp('^[A-Za-z]+$'); // 영문자만 허용한다.
	//	const pattern = new RegExp('^[a-zA-Z]+$'); // 영문자만 허용한다.

	//	const pattern = new RegExp('^[ㄱ-힣]+$'); // 한글만 허용한다.
	//	const pattern = new RegExp('^[!@#$%^&]+$'); // 지정된 특수문자만 허용한다.

	//위 내용을 섞어 조건을 완성하시오!
	//영문,숫자,특수만 8~12자로 허용.
	const pattern8 = new RegExp('^.[A-Za-z0-9!@#$%^&]{8,12}$');



	//	긍정형 전방 탐색 기능으로 특정 문자가 포함되어있나 검사한다. => (?=.*)
	//	(?=정규식)
	//  전방 탐색->패턴과 일치하지만 값으로 리턴하지 않는 정규식!
	//	const pattern = new RegExp('(?=.*[0-9]+)'); // 숫자가 포함되어있나 검사한다.
	//	const pattern = new RegExp('(?=.*[A-Z]+)'); // 대문자가 포함되어있나 검사한다.
	//	const pattern = new RegExp('(?=.*[a-z]+)'); // 소문자가 포함되어있나 검사한다.
	//	const pattern = new RegExp('(?=.*[A-Za-z]+)'); // 영문자가 포함되어있나 검사한다.
	//	const pattern = new RegExp('(?=.*[ㄱ-힣]+)'); // 한글이 포함되어있나 검사한다.
	//	const pattern = new RegExp('(?=.*[!@#$%^&]+)'); // 지정된 특수문자가 포함되어있나 검사한다.

	const pattern9 = new RegExp('^(?=.[0-9]+)(?=.[A-Za-z]+)(?=.*[!@#$%^&]+)[A-Za-z0-9!@#$%^&]{8,12}$');


	//test() 함수 인수로 지정된 문자열이 정규식 패턴이 만족하는지 검사해 
	//만족하면 true, 만족 안 하면 false를 리턴

	//만족하지 않을 땐 경고를 띄울 것~
	if (!pattern8.test(pw)) {
		alert("비번이 영문,숫자,특수문자를 각각 1개 이상 포함해야 해~~");
		obj.password.value = '';
		obj.repassword.value = '';
		obj.password.focus();
		return false;
	}
	//입력한 두 개의 비번이 같은가 검사한다.
	if (obj.password.value.trim() != obj.repassword.value.trim()) {
		alert("비번이 일치하지 않습니다~");
		obj.password.value = '';
		obj.repassword.value = '';
		obj.password.focus();
		return false;
	}





}