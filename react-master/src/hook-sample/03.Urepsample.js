/*
    useRef
        변수관리 DOM 요소에 접근을 위해 사용되는 React Hook
        Ref reference 약자로 참조
        React 컴포넌트는 State가 변할 때마다 다시 렌더링이 되면서 컴포넌트 내부 변수들이 초기화된다.
        컴포넌트 내부 변수들이 초기화가 된다는 것은 해당 컴포넌트 함수의 변수들이 모두 초기화가 되고 모든 함수 로직등이 다시 실행되는 것을 의미

        그렇다면 State 대신 Ref 안에 값을 저장하면 어떻게 될까!
        => Ref의 값들은 아무리 변경해도 컴포넌트를 다시 렌더링 되지 않는다. 불필요한 렌더링을 막을 수 있다.
            값이 보존되고 유지가 된다.
*/

import { useRef,useState } from "react";

export default function App() {

    const [render, setRender] = useState(false);
    const countRef = useRef(0); //countRef.current 여기에 저장된다.
    let countVar = 0;

    const increaseRef = () => {
        countRef.current = countRef.current + 1;
        console.log('Ref up => ',countRef.current);
    }
    const increaseVar = () => {
        countVar = countVar + 1;
        console.log("var up => ",countVar);
    }

    // Render 버튼을 클릭하지 않으면 화면에 업데이트 되지 않음
    const doRender = () => {
        setRender(!render);
    }
    //countRef.current : 최신상태 유지
    console.log("렌더링 후 Ref : ",countRef.current)
    console.log("렌더링 후 Var : ",countVar);
    
    return(
        <div>
            <header>
                <p>Ref : {countRef.current}</p>
                <p>Var : {countVar}</p>
                <div>
                    <button onClick={increaseRef}>Ref Up</button>
                    <button onClick={increaseVar}>Var Up</button>
                    <button onClick={doRender}>Render</button>
                </div>
            </header>
        </div>
    );
}

/*
    각각의 Ref Up 버튼과 Var Up 버튼을 클릭하면 콘솔의 값이 증가하는 것을 볼 수 있다.
    다.

    화면에서 Ref의 값이 7이고, Var의 값이 5일 때 Render 버튼을 클릭했을 때, 
    Ref는 7이 표시되지만 Var은 0으로 표시된다.
    왜냐하면 렌더링이 될 때마다 컴포넌트 함수 내부에 있는 변수들이 초기화 되지만 Ref는 초기화 되지 않는다.
    Ref의 값은 컴포넌트의 전 생애주기를 통해 유지
    컴포넌트가 브라우저의 마운팅 된 시점부터 마운트 해제될 때가지 같은 값을 계속 유지할 수 있기 때문이다.
*/