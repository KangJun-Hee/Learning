import {useEffect} from 'react';

export default function Timer(){
    useEffect(()=>{
        //setInterval:애니메이션처럼 반복해
        //      실행되는 함수의 지연 설정
        const timer = setInterval(()=> {
            console.log("타이머 작동중입니다");
        },1000)
    },[])
    return(
        <div>
            <span>타이머 시작!</span>
        </div>
    );
}