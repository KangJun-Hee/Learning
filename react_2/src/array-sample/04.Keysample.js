/*
    리액트에서 배열을 렌더링 할 때에는 key 라는 props 를 설정
     key 값은 각 원소들마다 가지고 있는 고유값으로 설정
     지금의 경우엔 id 가 고유 값
     만약 배열 안의 원소가 가지고 있는 고유한 값이 없다면 map() 함수를 사용 할 때 설정하는 콜백함수의 두번째 파라미터 index 를 key 로 사용
*/

import React from 'react';
//prop 상속 (현재 위치에서 prop는 food)
function Food({ food }) {
  return (
    <div>
      <b>{food.type}</b>
      <span>({food.name})</span>
    </div>
  );
}

function App() {
  const foods = [
    {
      id: 1,
      username: 'velopert',
      email: 'public.velopert@gmail.com'
    },
    {
      id: 2,
      username: 'tester',
      email: 'tester@example.com'
    },
    {
      id: 3,
      username: 'liz',
      email: 'liz@example.com'
    }
  ];

  return (
    <div>
     
      {foods.map(food => ( // const foods = [{ },{ },{ }] 에 있는 값들을 가져옴
        <Food food={food} key={food.id} /> //map을 작성하고 map(food=> )에서 food 라는 이름으로 지정 해줬기 때문에
      ))}                                  {/*food 는 위 function Food 에서 ({food(=상속받을(prop)}) 되는것 */}
    </div>
  );
}

export default App;