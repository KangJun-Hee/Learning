/*
1.useRef
    변수관리DOM 요소에 접근을 위해 사용되는 React Hook
    Ref=reference의 약자로 참조
    React컴포넌트는 State가 변할 때마다 
        다시 렌더링되며 컴포넌트 내부변수들이 초기화됨
        *해당 컴포넌트 함수들의 변수들이 모두;
        
        그렇다면 State대신 Ref 안에 값을 저장하면 어케
        될까?
        => Ref의 값들은 아무리 변경해도 컴포넌드를 다시
            렌더링되지 않음, 값이 보존되고 유지된다,
            불필요한 렌더링 막을 수 있음.
        
        DOM요소에 접근
            예:로그인화면 보여줬을시 id를 넣는 input을
                굳이 클릭 안 해도 자동적으로 포커스돼
                바로 키보드를 입력해 id를
useEffect
*/

import {useRef,useState}from "react";

export default function Use(){
    {/*
    각각의 Ref Up버튼과 Var Up버튼을 클릭시 콘솔의 값이
    증가하는 것
    Render버튼을 클릭하지 않으면 화면에 업데이트 안 된다

    화면서 Ref의 값=7, Var의 값=5일 때,Render버튼 클릭시
    Ref는 7이 표시되지만 Var는 0으로 된다
    왜냐! 렌더링이 될 때마다 컴포넌트함수 내부의 변수들이
        초기화되기 때문! Ref는 안 그러는데, Ref의 값은
        컴포넌트의 전 생애주기를 통해 유지되는데
        컴포넌트가 브라우저의 마운팅된 시점부터 마운트
        해제될 때까지 같은 값 계속 유지가능하기 때문

        마운트:연결시켜 주는 과정
        컴포넌트 생애주기:생성(mounting)->업데이트->
                        제거(unmounting)
    */}
                            //useState안에는 다 들어감
    const [render,setRender]=useState(false);
    const countRef = useRef(0); //countRef.current여기에 저장된다
    let countVar = 0;//재사용할 거라 let

    const increaseRef = ()=>{
        countRef.current = countRef.current + 1;
        console.log('Ref up =>',countRef.current);
    }
    const increaseVar = ()=>{
        countVar = countVar +1;
        console.log("var up => ",countVar);
    }
    const doRender = ()=>{
        setRender(!render);
    }
    
        //current:최신상태유지
    console.log("렌더링 후 Ref:",countRef.current)
    console.log("렌더링 후 Var:",countVar);

    return (
        <div>
            <header>/*렌더링보통 헤더에서 함*/
                <p>Ref:{countRef.current}</p>
                <p>Var:{countVar}</p>

                <div>
                    <button onClick={increaseRef}>Ref Up</button>
                    <button onClick={increaseVar}>Var Up</button>
                    <button onClick={doRender}>Render</button>
                </div>
            </header>
        </div>
    );
}