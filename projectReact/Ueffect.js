/*
useEffect 컴포넌트가 렌더링 이후 어떤 일 수행해야 
          하는지 말함
React 우리가 넘긴 함수(effect) 기억했다 DOM업데이트 수행후
      불러낼 것
      이렇게 UseEffect 이후(마운트해제될 때) 정리실행

첫 번째 인자 effect함수, 두 번째 인자 dependency array
첫 번째 파라미터로 입력한 함수가 호출되는 시점
    = 컴포넌트가 첫 렌더링 되는 시점

dependency array의 각 element값이 변경되나 판단하는 시점
    = 컴포넌트가 렌더링 될 때


dependency(의존성)




useEffect함수의 의도
    컴포넌트 상태(prop,state)의 상태변화에 따라 상태를
    이용해 리액트와 관련없는 부수작업(side dffect,api호출)등
    을 처리하기 위해 있음
*/

import { useState } from "react";
import Timer from "./Timer";
/*
State 초기화 및 상태설정
Ref 유지
Effect 계속적 변화
*/

export default function Ueffect(){
    const[timer,setTimer] = useState(false);
    return (
        <div>
            {timer && <Timer/>}
            <button onClick={()=> setTimer(!timer)}>타이머</button>
        </div>
    );
}