/*
    Context 만들기
        state 와 dispatch 를 Context 통해 다른 컴포넌트에서 바로 사용 할 수 있게 해줄예정 
        하나의 Context 를 만들어서 state 와 dispatch 를 함께 넣어주는게 아니라 
        두개의 Context 를 만들어서 따로 따로 넣어줄 것 
        이렇게 하면 dispatch 만 필요한 컴포넌트에서 불필요한 렌더링을 방지 할 수 있음
        추가적으로, 사용하게 되는 과정에서 더욱 편리함

        contextAPI를 사용하기 위해 Provider Consumer, CreateContext 알아야함
        Provider : 생성한 context를 하위 컴포넌트에게 전달하는 역할
        Consumer : context의 변화를 감시하는 컴포넌트
        CreateContext : context 객체 생성
*/


import React, { createContext, useReducer, useContext, useRef } from 'react';

const StateContext = createContext(null); //각각의 state 만들어줌
const DispatchContext = createContext(null); //각각의 dispatch 만들어줌

const NextIdContext = createContext(null); //nextId 값을 위한 Context 를 만들어줌
/*
    여기서 nextId 가 의미하는 값은 새로운 항목을 추가 할 때 사용 할 고유 ID  
    이 값은, useRef 를 사용하여 관리
*/
function reducer(state, action) {
  switch (action.type) {
    case 'CREATE':
      return state.concat(action.todo);
    case 'TOGGLE':
      return state.map(todo =>
        todo.id === action.id ? { ...todo, done: !todo.done } : todo
      );
    case 'REMOVE':
      return state.filter(todo => todo.id !== action.id);
    default:
      return state;
  }
}

const intodolist = [
  {
    id: 1,
    text: '리액트 공부',
    done: true
  },
  {
    id: 2,
    text: '영어 공부',
    done: true
  },
  { id: 3, text: '점심먹기', done: false },
  { id: 4, text: '회의하기', done: false }
];
/*
    *** 렌더링이란 서버로부터 HTML 파일을 받아 브라우저에 뿌려주는 과정 ***

    Context 에서 사용 할 값을 지정 할 때에는 아래와 같이 Provider 컴포넌트를 렌더링 하고 value 를 설정해주면 된다.
    props 로 받아온 children 값을 내부에 렌더링해줌
    이렇게 하면 다른 컴포넌트에서 state 나 dispatch를 사용하고 싶을 때 다음과 같이 할 수 있다.
*/
export function Provider({ children }) {
  const [state, dispatch] = useReducer(reducer, intodolist);
  const nextId = useRef(5);

  return (
    <StateContext.Provider value={state}>
      <DispatchContext.Provider value={dispatch}>
        <NextIdContext.Provider value={nextId}>
          {children}
        </NextIdContext.Provider>
      </DispatchContext.Provider>
    </StateContext.Provider>
  );
}

export function useState() {
  return useContext(StateContext);
}

export function useDispatch() {
  return useContext(DispatchContext);
}

export function useNextId() {
   // Q 에러가 안난다는 보장이 있을까? 에러 수정 추가하기
  return useContext(NextIdContext);
}
