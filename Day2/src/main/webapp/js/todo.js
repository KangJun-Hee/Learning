/**
 * 
 */
 
 //웹 요소 가져오기
 const todoInput = document.querySelector('#todo-input');//사용자가 입력한 내용!
 const addButton = document.querySelector('#add-button');//추가버튼
 const todoList = document.querySelector('#todo-list');//리스트!
 
 //이벤트 처리
 //DOMContentLoaded 브라우저 html을 전부 읽고 DOM객체를 완성하는데 이미지 파일이나
 //스타일이 적용 태그들을 기다려야 되는데 기다리지 않고 
 document.addEventListener('DomContentLoaded',getLocal);
 addButton.addEventListener('click',addTodo);
 todoList.addEventListener('click',managerTodo);
 
 function addTodo(e){
	e.preventDefault();//기본동작 취소!
	//입력값을 가져와 새로운 소스를 추가한다!
	const newDiv = document.createElement('div');
	newDiv.classList.add('todo');
	
	const newTodo = document.createElement('li');
	newTodo.innerText = todoInput.value;
	newTodo.classList.add('todo-content');
	newDiv.appendChild(newTodo);//맨 마지막에 새로운 태그를 추가함.
	
	//로컬 스토리지에 추가한다.
	saveToLocal(todoInput.value);
	
	//완료!
	const completeButton = document.createElement('button');
	completeButton.innerText="완료";
	completeButten.classList.add('complete-button');
	newDiv.appendChild(completeButton);
	
	//삭제!
	const deleteButton = document.createElement('button');
	deleteButton.innerText="삭제";
	deleteButten.classList.add('delete-button');
	newDiv.appendChild(deleteButton);
	
	//ul에 자식으로 추가
	todoList.appendChild(newDiv);
	todoInput.value = ""; //초기화	
}
function saveToLocal(todo){
	let todos;
	if(localStorage.getItem('todos')===null){
		todos = [];
	}else{
		todos=JSON.parse(localStorage.getItem('todos'));
	}
	//위에 데이터를 하나의 배열에 저장 그래서 값을 가져와서 추가하는 항목은
	// 실제 변경된 배열에 추가한다.
	todos.push(todo);
	
	//현재배열을 문자형태로 돌려주겟다.
	localStorage.setItem('todos',JSON.stringify(todos));
}
function getLocal() {
  let todos;
  if (localStorage.getItem('todos') === null) {
    todos = [];
  } else {
    todos = JSON.parse(localStorage.getItem('todos'));
  }
  todos.forEach(function(todo) {  // todos 요소마다 반복
    const newDiv = document.createElement('div');
    newDiv.classList.add('todo');
    const newTodo = document.createElement('li');
    newTodo.innerText = todo; // 로컬 스토리지의 값 표시
    newTodo.classList.add('todo-content');
    newDiv.appendChild(newTodo);  

    const completeButton = document.createElement('button');
    completeButton.innerText = '완료';
    completeButton.classList.add('complete-button'); 
    newDiv.appendChild(completeButton);

    const deleteButton = document.createElement('button');
    deleteButton.innerText = '삭제';
    deleteButton.classList.add('delete-button');
    newDiv.appendChild(deleteButton);

    todoList.appendChild(newDiv);   // ul 요소의 자식 요소로 추가

    todoInput.value = "";   // 입력 창 초기화
  });
}

function manageTodo(e) {
  const whichButton = e.target.classList[0];
    // 클릭한 부분의 class명 가져오기 
  if(whichButton === 'complete-button') {
    const todo = e.target.parentElement;
    todo.children[0].classList.toggle('completed');
      // 내용 부분에 .completed 클래스 토글
  } else if(whichButton === 'delete-button') {
    const todo = e.target.parentElement;
    removeLocal(todo);
    todo.remove();
  }
}

function removeLocal(todo){
	let todos;
	if(localStorage.getItem('todos')===null){
		todos = [];
	}else{
		todos=JSON.parse(localStorage.getItem('todos'));
	}
	
	//삭제할 인덱스 갖고와라
	const index = todos.indexOf(todo.children[0].innerText);
	
	todos.splice(index,1);//index번째 요소 삭제
	
	//삭제한 배열을 가지고 와서 다시 로컬 스토리지에 저장.
	localStorage.setItem('todos',JSON.stringify(todos));
}























