/**
 *  Ajax (Asynchronous Javascript And XML)
 	웹 페이지 전체를 다시 로딩하지 않고도 , 웹 페이지의 일부분만 갱신할 수 있게 한다.
 	브라우저와 웹 서버간의 통신을 해주는 것이 ajax 
 */

// 송수신을 도와주는 자바스크립트 객체 
const searchRequest = new XMLHttpRequest(); // 검색용 
const insertRequest = new XMLHttpRequest(); // 입력용 


function searchFunction(){
	//console.log("searchFunction()");
	//console.log(document.getElementById('username').value);
	
	// 요청을 할 때 문자열로 나가기는 하지만 인코딩 
	// encodeURIComponent() : 문자열을 유니코드로 인코딩을 하는 메서드
	
	let url = './AjaxSearch?name='
				+encodeURIComponent(document.getElementById('username').value);
	console.log(url);
	searchRequest.open('GET',url,true);
	// send()서버로 객체 전달 send() -> get방식  send(문자열) -> post
	// 데이터 url의 일부인 쿼리스트링 
	// ?~~~~)으로 전송할 경우 send() 함수의 인수를 null 을 사용한다.
	searchRequest.send(null);
	
	// onreadystatechange를 사용해서 ajax 요청이 완료되면 실행할 콜백 함수 이름을 지정한다.
	searchRequest.onreadystatechange = searchProcess; // 함수를 작성할 때 () 를 쓰면 안된다. 

}
// ajax 요청이 완료되면 실행할 콜백 함수 
function searchProcess(){
	
	console.log('searchProcess() 요청한 ajax가 완료되면 자동으로 실행되는 함수 ');
	
	// xml 객체의 ready status
	// 서버로 부터 응답을 확인하기 위해서 readyState 프로퍼티 
	// 0 : 아직 실행하지 않음 (xmlhttpRequest 객체를 생성됨 )
	// 1 : 로딩중			   (open()메서드가 성공적으로 실행됨)
	// 2 : 로딩됨  		   (모든 요청에 대한 응답이 도착함)
	// 3 : 통신중			   (요청한 데이터를 처리 중임)
	// 4 : 통신완료 		   (요청한 데이터의 처리가 완료되어 응답할 준비가 완료됨)
	
	// XML 객체의 status
	// 200: 수신성공
	// 3xx: 금지
	// 400: 페이지없음
	// 500: 서버 오류(백프로 문법오류,오타!,서블릿의 이름이 없을 경우!)
	
	// 통신이 정상적으로 완료 되었음을 확인하고 필요한 작업을 실행한다.
	if(searchRequest.readyState == 4 && searchRequest.status == 200){
		
	}
	
	
}

// 페이지가 로드 되자마자 화면에 전체 데이터가 보여지게 하기위해서 onload이벤트에서
// searchFunction() 함수를 실행한다. 

onload = () => searchFunction();
















