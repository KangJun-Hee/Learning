import React from "react";
import {styled} from 'styled-components';
import { useState } from "../Context";

const HeaderBlock = styled.div`
    h1{
        margin:0;
        color:gray;
    }
    .day{
        margin-top:4px;
        color:Black;
    }
`
function Header(){
    const today = new Date();//오늘날짜
    const dateString = today.toLocaleString('ko-KR',{
        //날짜값을 받을 땐 int를 사용하지 않고 numeric long numeric을 사용함
        year:'numeric',//int같은 거
        month:'long',
        day:'numeric'
    });
    const dayName = today.toLocaleString('ko-KR',{weekday:'long'});
    const todos = useState();
    const undoneTask = todos.filter(todo => !todos.done);

    return(
        <HeaderBlock>
            <h1>{dateString}</h1>
            <div className="day">{dayName}</div>
            <div>할 일{undoneTask.length}개 남았어요</div>
        </HeaderBlock>
    );
}
export default Header;