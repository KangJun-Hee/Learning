import React,{useReducer,useContext,useRef, createContext} from "react";

const StateContext = createContext(null);
const DispatchContext = createContext(null);
const NextIdContext = createContext(null);

function reducer(state,action){
    switch(action.type){
        case 'CREATE':
            return state.concat(action.todo);
        case 'TOGGLE':
            return state.map(todo=>
                    todo.id === action.id? 
                        {...todo,done:!todo.done}:todo
                );
        case 'REMOVE':
            return state.filter(todo=>todo);
        default:
            return state.concat(action.todo);
    }
}

const intodolist = [
    {
        id : 1,
        text : 'react study',
        done : true
    },
    {
        id : 2,
        text : 'eat lunch',
        done : true
    },
    {
        id : 3,
        text : 'yarn~~~~~~ strecth~~~~',
        done : true
    },
    {
        id : 4,
        text : 'study eng',
        done : false
    }
];

/*렌더링:서버로부터 htmlq받아 브라우저에 뿌려주는 과정
Context에서 사용할 값으리정시 아래와 같이 Provider컴포넌트를
렌더링하고 Value설저해 주면 된다 */

export function Provider({children}){
    const [state,dispatch] = useReducer(reducer,intodolist);
    const nextId = useRef(5);

    return (<StateContext.Provider value={state}>
                <DispatchContext.Provider value={dispatch}>
                    <NextIdContext.Provider value={nextId}>
                        {children}
                    </NextIdContext.Provider>
                </DispatchContext.Provider>
            </StateContext.Provider>

    );
}

/*
    createContext:생성한 context객체를 원하는 클래스
        의 contextType프로퍼티(이름,값=key,value)로 지정가능

*/
export function useState(){
    return useContext(DispatchContext);
}

export function useDispatch(){
    return useContext(DispatchContext);
}

export function useNextId(){
    return useContext(NextIdContext);
}