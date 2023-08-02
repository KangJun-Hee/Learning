/*컴포넌트를 재사용 할 수 있도록 컴포넌트 내부 변경*/

import React from 'react';

function Animal({ animal }) {
  return (
    <div>
      <b>{animal.animalname}</b> <span>({animal.email})</span>
    </div>
  );
}

function App() {
  const animals = [
    {
      id: 1,
      animalname: 'Lion',
      email: 'Lion@kh.com'
    },
    {
      id: 2,
      animalname: 'Rabbit',
      email: 'Rabbit@example.com'
    },
    {
      id: 3,
      animalname: 'Dog',
      email: 'Dog@example.com'
    }
  ];

  return (
    <div>
      <Animal animal={animals[0]} />
      <Animal animal={animals[1]} />
      <Animal animal={animals[2]} />
    </div>
  );
}

export default App;