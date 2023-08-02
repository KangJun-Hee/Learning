/*
    props.children
        컴포넌트 태그 사이에 넣은 값을 조회하고 싶을 땐, props.children 을 사용해서 조회할 수 있음
*/

import React from 'react';

function Greet({ color, name }) {
    return <div style={{ color }}>안녕하세요 {name}</div>
  }
  
  Greet.defaultProps = {
    name: '이름없음'
  }


  function Main({ children }) {
    const style = {
      border: '2px solid black',
      padding: '16px',
    };
    return (
      <div style={style}>
        {children}
      </div>
    )
  }


function App() {
    return (
      <Main>
        <Greet name="react" color="red"/>
        <Greet color="pink"/>
      </Main>
    );
  }
  
  export default App;