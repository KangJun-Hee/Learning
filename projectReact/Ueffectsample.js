/*코드가 탄생하고 변화되는 시점*/
import { useEffect,useState } from "react";

function UnmountSample(){
    useEffect(() => {
        console.log("마운트 됐습니다");
    
        return ()=>{
            //Unmount 시점서 실행됨
            console.log("마운트가 제거되었습니다~")
        };
    },[]);

    return <div>Unmount 제거 컴포넌트</div>
}

export default function Ueffectsample(){
    //count에 사용할 const state,input에 사용될 text state
    const [count,setCount] = useState(0);
    const [text,setText] = useState("");
    

    //mount탄생시점
    useEffect(() =>{
        console.log("하나의 생성(mount) 탄생함!")
    },[])
    /*버튼은 계속 눌리지만 콘솔에선 한 번만 실행이
    확인해 보면 콘솔에는 한 번만 확인할 수 있다
        되는 걸 확인 가능
        업데이트는 누르는 만큼 된다
        
        컴포넌트가 탄생(mount)시점에 콘솔 실행되고=>
        console.log("생성됐다~");
        다른값 넣을시(클릭이나 input값 넣었을때)에 
    */

    //업데이트시점
    useEffect(()=> {
        console.log(`카운트 업데이트: ${count}`);
        if(count > 10){
            alert("최대수량은 10개입니닥!");
            setCount(10);
        }
    },[count]);
    /*업데이트는 생성과 달리 업데이트시마다 콘솔창에
    나타나는 걸 확인가능 */



    useEffect(()=> {
        console.log(`update : ${text}`);
    },[text]);

    //unmount const
    const [isUnmount,setIsUnmount]=useState(false);
    const toggle = ()=> setIsUnmount(!setIsUnmount);

    return(
        <div>
            {/*생성업데이트*/}
            <div>
                {count}
                {/*기존의 onClick,onChange에 들어가는 함수
                    따로 입력해 줬지만,
                    onClick,onChange 안에 바로 넣을 수 있음 */}
                <button onClick={()=>setCount(count+1)}>+</button>
                <br/>
                <input onChange={(e)=> setText(e.target.value)} value={text}/>
            </div>
            {/*언마운트=죽음*/}
            <div>
                <button onClick={toggle}>on / off</button>
                {isUnmount && <UnmountSample/>}
            </div>
        </div>
    );
}