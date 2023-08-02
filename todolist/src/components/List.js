import Item from "./Item";
import React, { useState } from "react";

function List(){
    const todos = useState();

    return(
        <>
                    //todo말고 맘대로 써도 된다
            {todos.map(todo => (
                <Item
                    id={todo.id}
                    text={todo.text}
                    done={todo.done}//true인지 false지
                    key={todo.id}
                />
            ))}
        </>
    );
}
export default List;