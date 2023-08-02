import './App.css';
import { useState } from 'react';

function AppTime() {
    /*script style 작성하는 공간*/
  const [time, setTime] = useState(0);
  const updateTime = () => {
    setTime(time + 1);
  }
  return (
  /*html 작성공간 */
    <div className="App"> 
    <h2> {time} 시 </h2>
    <button onClick={updateTime}> 시간올리기</button>
    </div>
  );
}
export default AppTime;














