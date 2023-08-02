import React from "react";
import { styled } from "styled-components";


//전체로 쓸 거라 const를 바깥에 만듦
const TemplateBlock =styled.div`
    //화면크기
    width:720px;
    height:820px;

    position:relative;/*추후 박스 하단에 추가버튼 위치시킬 거임*/
    background:white;

    margin: 0 auto; /*페이지 중앙에 나타나도록 설정*/
`
function Template(){
    return<TemplateBlock>상속받을 값</TemplateBlock>;
}

export default Template;