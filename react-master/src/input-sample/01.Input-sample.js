import { useState } from "react";
import './App.css'
function App() {
    //const [초기변수명,변화될 변수명]= 초기값;
    //useState("")  ()괄호 안에는 우리가 지정할 값을 넣어줄 수 있음
    const [name, setName] = useState("");
    const [text, setText] = useState("");

    const hadleJoin = () => {
        //기존에 있는 text 값을 setName(새로 적어주는 값)으로 변경해줌
        setName(text);
    }
    //                   evenet는 임의로 지정해준 값 event가 아니라 e 등 자신이 지정해준 값을 넣을 수 있음
    const handleChange =(event) => {
    //   위에서 event 라고 지정해줬기 때문에 event.target.value 가 됨 
    //    만약 e라는 이름으로 지정을 해주면 e.target.value 라고 작성하고 넣을 수 있음
        setText(event.target.value); 
    }
    return(
        <div>
            {name ==="" ?(
                <input
                //onChange : input 안의 값이 변경될 때 사용
                onChange={handleChange}
                placeholder="이름을 입력하세요."
                value={text}
                />
            ):(
                <div>{name}님 환영합니다.</div>
            )}
            <button onClick={hadleJoin}>등록</button>
        </div>
    );
}
export default App;