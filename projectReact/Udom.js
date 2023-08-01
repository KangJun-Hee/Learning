/*
DOM요소 접근
로그인 화면이 보여졌을 때 id를 넣는 Input을 굳이
클릭하지 않아도 자동적으로 포커스가 되어있게 해 주면
바로 키보드를 입력해 id를 넣을 수 있도록 함
*/

import {useRef,useEffect} from "react";

export default function Udom(){
    const inputRef = useRef();

    useEffect(()=> {
        console.log(inputRef);
        inputRef.current.focus();
    },[])

    const loginAlert = ()=>{
        alert("Welcome to my World. ${input.current.value}");
        inputRef.current.focus();
    }
    return(
        <div>
            <input ref={inputRef} type="text" placeholder="id"/>
            <button onClick={loginAlert}>Login</button>
        </div>
    );
}