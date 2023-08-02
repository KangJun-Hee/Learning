import { useReducer } from "react";

function reducer(state,action){
    switch(action.type){
        case'PLUS':
            return state + 1;
        case'MINUS':
            return state - 1;
        default:
            return state;
    }
}

export default function Count(){
    //const [number,setCount] = useState(100)
    //const [상태객체,디스패치함수] = useReducer(reducer함수,초기상태)
    const [number,dispatch] = useReducer(reducer,0)


    const onPlus = () => {
        //dispatchEvent:state가 너무 많아지거나 부모와
            //자식간의 관계가 복잡할 땐 관리를 해서 빠르
            //게 작업할 수 있도록 돕는 Hook(ex:ref같은)

            //dispatch가 reducer를 호출함
            //reducer는 store에 가서 현재 state값 가져와 
            //새로운 state 반환해 줌
        //Component -(dispatch)->Action->Reducer->Store

        //dispatch({type:'값'});
        //dispatch({type:'값',data:'변경될 값'});
        dispatch({type:'PLUS'});
    }
    const onMinus = () => {
        dispatch({type:'MINUS'})
    }

    return(
        <div>
            <h3>{number}</h3>
            <button onClick={onPlus}>+</button>
            <button onClick={onMinus}>-</button>
        </div>
    )
}