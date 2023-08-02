import React from 'react';
import { createGlobalStyle } from 'styled-components';
import Template from './components/Template';
import Header from './components/Header';
import List from './components/List';
import Create from './components/Create';
import { Provider } from './Context';

const GlobalStyle = createGlobalStyle`
  body {
    background: #f8f9fa
  }
`;
/*
  우리 프로젝트 모든 곳에서 할 일 관련 Context 들을 사용 할 수 있도록, 
  App 컴포넌트에서 Provider 를 불러와서 모든 내용을 Provider 로 감싸기
*/
function App() {
  return (
    
    <Provider>
      <GlobalStyle />
      <Template>
        <Header />
        <List />
        <Create />
      </Template>
    </Provider>
  );
}

export default App;
