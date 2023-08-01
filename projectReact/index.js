import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import Mapsample from './Mapsample';
import Usef from './Usef';
import Udom from './Udom';
import Ueffectsample from './Ueffectsample';
import UeffectUnmount from './UeffectUnmount';
import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
    <Mapsample/>
    <Usef/>
    <Udom/>
    <Ueffectsample/>
    <UeffectUnmount/>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
