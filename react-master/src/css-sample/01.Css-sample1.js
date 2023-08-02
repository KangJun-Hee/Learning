import React from 'react';

function Greet({ color, name }) {
    return <div style={{ color }}>안녕하세요 {name}</div>
  }

function Main() {
  const style = {
    border: '2px solid black',
    padding: '16px',
  };
  return (
    <div style={style}>

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