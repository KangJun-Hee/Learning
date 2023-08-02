import { createGlobalStyle } from 'styled-components';
import './App.css';
import Template from './components/Template';
import Header from './components/Header';
import List from './components/List';
import Create from './components/Create';
import { Provider } from './Context';

function App() {
  const GlobalStyle = createGlobalStyle `
    body{
      background:lightblue;
    }
  `;
  
  return (
    <Provider>
      <GlobalStyle/>
      <Template/>
        <Header/>
        <List/>
        <Create/>
    </Provider>
  );
}

export default App;
