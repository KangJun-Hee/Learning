/*
    map() 함수는 배열안에 있는 각 원소를 변환하여 새로운 배열을 만들어쥰다.
    리액트에서 동적인 배열을 렌더링해야 할 때는 이 함수를 사용하여 일반 데이터 배열을 리액트 엘리먼트로 이루어진 배열로 변환
*/

import React from 'react';

function Book({ book }) {
  return (
    <div>
      <b>{book.booktitle}</b> <span>({book.type})</span>
    </div>
  );
}

function App() {
  const users = [
    {
      id: 1,
      booktitle: 'velopert',
      type: 'public.velopert@gmail.com'
    },
    {
      id: 2,
      booktitle: 'tester',
      type: 'tester@example.com'
    },
    {
      id: 3,
      booktitle: 'liz',
      type: 'liz@example.com'
    }
  ];

  return (
    <div>
      {users.map(book => (
        <Book book={book} />
      ))}
    </div>
  );
}

export default App;