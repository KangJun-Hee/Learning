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

export default function UeffectUnmount(){
    //unmount const
    const [isUnmount,setIsUnmount]=useState(false);
    const toggle = ()=> setIsUnmount(!isUnmount);

    return(
        <div>
            {/*언마운트=죽음*/}
            <div>
                <button onClick={toggle}>on / off</button>
                {isUnmount && <UnmountSample/>}
            </div>
        </div>
    );
}