import React from 'react';
import styled from 'styled-components';
import Item from './Item';
import { useState } from '../Context';

const ListBlock = styled.div`
  flex: 1;
  padding: 20px 32px;
  padding-bottom: 48px;
  overflow-y: auto;
`;

function List() {
  const todos = useState();
  return (
    <ListBlock>
      {todos.map(todo => (
        <Item
          id={todo.id}
          text={todo.text}
          done={todo.done}
          key={todo.id}
        />
      ))}
    </ListBlock>
  );
}

export default List;
