import './App.css';
import { useState } from 'react';
function App() {
  /*
    script 작성한다.
    css, javascript 활동을 적는다.
    변수 선언, 상태 변경은 여기에서 진행해준다.
    
    useState : 상태값 관리자 초기값 세팅 / 값 변환이 가능
    import { useState } from 'react'; 를 임포트 해준다.
    const [useState(0), 변환될 값] = 초기값;
    state 
        - 컴포넌트 내부에서 선언한 값
        - setState를 통해서 내부 값을 변경할 수 있다.
    const [state, setState] = useState(0);
    const [number, setNumber] = useState([]);
    const [time, setTime] = useState(100);
  */
 
  const [number, setCount] = useState(100);
 
  const plus = () => { 
    // 값이 증가하는 자바스크립트
    // count = count + 1
    setCount(number + 1);
    console.log(number);
  }

  const minus = () => {
    // 값이 감소하는 자바스크립트
    //count = count - 1
    setCount(number - 1);
    console.log(number);
  }

  const [time, setTime] = useState(0);

  const updateTime = () => {
    setTime(time + 1);
  }
  return (
    /*  
        <div className = "App">은 <html> 태그와 비슷한 역할을 한다.
        리액트 에서는 카멜표기법을 주로 사용한다.
            ex) onClick={}
        위에서 변수 선언한 값을 가져오기 위해서는
        { } 중괄호를 사용해서 변수값을 넣어준다.
    */
    <div className="App"> 

    <h2> 증가하는 숫자값 :<br/>  {number} </h2>
    <button onClick={plus} > + </button>
    <button onClick={minus}> - </button>
    
    <h2> {time} 시 </h2>
    <button onClick={updateTime}> 시간올리기</button>
    </div>
  );
}

export default App;