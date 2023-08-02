/*
    defaultProps 로 기본값 설정
        컴포넌트에 props 를 설정하지 않았을 때
        기본적으로 사용 할 값을 설정하고 싶다면
        컴포넌트에 defaultProps 라는 값을 설정할 수 있음
*/

import React from 'react';

function Greet({ color, name }) {
    return <div style={{ color }}>안녕하세요 {name}</div>
  }
  
  Greet.defaultProps = {
    name: '이름없음'
  }

function App() {
  return (
    <>
      <Greet name="react" color="red"/>
      <Greet color="pink"/>
    </>
  );
}

export default App;