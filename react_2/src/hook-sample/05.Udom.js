/*
 DOM 돔요소 접근
 로그인 화면이 보여졌을 때 id를 넣는 Input을 굳이 클릭하지 않아도
 자동적으로 포커스가 되어 있게 해주면 바로 키보드를 입력해서 id를 입력할 수 있도록 함

 useRep와 useEffect 동시 사용하며 console.log 로 결과확인
*/

import { useRef,useEffect } from "react";

export default function App() {
    const inputRef = useRef();

    useEffect(() => {
      console.log(inputRef);
      inputRef.current.focus();
    }, [])
  
    const loginAlert = () => {
      alert(`Welcome to my world. ${inputRef.current.value}`);
      inputRef.current.focus();
    }
    return (
      <div className="App">
        
          <input ref={inputRef} type="text" placeholder="id"/>
          <button onClick={loginAlert}>Login</button>
      
    </div>
    );
}