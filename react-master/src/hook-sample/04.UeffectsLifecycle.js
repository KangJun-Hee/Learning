/** 코드가 탄생하고 변화되는 시점 */

import { useEffect,useState } from "react";

function UnmountSample() {
    useEffect(() => {
        console.log("마운트 됐습니다.!");
        
        return () => {
            //Unmount 시점에서 실행됨
            console.log("마운트가 제거 되었습니다.")
        };
    }, []);

    return <div>Unmount 제거 컴포넌트</div>
}

export default function APP(){
    //count에 사용할 const state, input에 사용될 text state
    const [count, setCount] = useState(0);
    const [text, setText] = useState("");
    const [isUnmount, setIsUnmount] = useState(false);
   
    //1. Mount 탄생 시점
    useEffect(() =>{
        console.log("생성(Mount) 탄생")
    }, [])
    /*
        버튼은 계속 눌리지만 콘솔에서는 한번만 실행이 되는것을 확인할 수 있다.
        업데이트는 누르는만큼 업데이트 된다.

        컴포넌트가 탄생(mount) 시점에 콘솔이 실행되고 =>console.log("생성(Mount) 탄생했습니다.") 실행
        다른값을 넣었을 때 (클릭이나 Input 값 넣었을 때) 확인해보면 콘솔에는 한번만 확인할 수 있다.

    */

    //2. Update 시점
    useEffect(() => {
        console.log(`카운트 업데이트 : ${count}`);
        if (count > 10) {
            alert("최대 수량은 10개 입니다.");
            setCount(10);
        }
    },[count]);

    useEffect(() => {
        console.log(`업데이트 : ${text}`);
    },[text]);
    /*
        업데이트는 생성과 달리 업데이트 될 때마다 콘솔창에 나타나는 것을 확인할 수 있다.
    */

            
    //3. Unmount 시점
    const toggle = () => setIsUnmount(!isUnmount);

    return(
        <div>
            {/* 생성 업데이트 */}
            <div>
                {count}
                {/* 기존에 onClick onChange 에 들어가는  함수를 따로 입력해줬지만
                    onClick이나 onChange 안에 바로 넣을 수 있다.
                */}
                <button onClick={() =>setCount(count + 1)}>+</button>
                <br />
                <input onChange={(e)=> setText(e.target.value)} value={text} />
            </div>
            {/* 죽음 */}
            <div>
                <button onClick={toggle}>on/off</button>
                {isUnmount && <UnmountSample />}

            </div>

        </div>
    );
}