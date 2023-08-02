/* 재사용 이전 컴포넌트 */

import React from 'react';

function App() {
  const animals = [
    {
        id: 1,
        name: 'Lion',
        email: 'Lion@kh.com'
      },
      {
        id: 2,
        name: 'Rabbit',
        email: 'Rabbit@example.com'
      },
      {
        id: 3,
        name: 'Dog',
        email: 'Dog@example.com'
    }
  ];
  return (
    <div>
      <div>
        <b>{animals[0].name}</b> <span>({animals[0].email})</span>
      </div>
      <div>
        <b>{animals[1].name}</b> <span>({animals[1].email})</span>
      </div>
      <div>
        <b>{animals[2].name}</b> <span>({animals[1].email})</span>
      </div>
    </div>
  );
}

export default App;