import React from "react"

export default function Mapsample(){
    //const들은 JSX다
    const menus = ['마라탕','바나커피','새우볶음밥']

        //menuList는 JSX JavaScript Xml다
    const menuList = menus.map((data)=>(<li>{data}</li>))
    const menuList2 = menus.map((data)=>(<p>{data}</p>))
    //map이란? 각 배열의 요소를 돌며 인자로 전달된
    //  함수를 사용해 처리된 새 결과를 새 배열에 담아
    //  반환하는 함수
    //map사용공식:const에 변수명 작성->
    //  데이터.map((사용할 데이터변수))

    //map key
    //  key는 리스트의 다른 항목 사이서 해당항목을 고유히
    //  식별할 수 있는 문자열을 사용해야 한다!
    //  리액트서 컴포넌트 렌더링시 어떤 원소가 변경됐나
    //  빠르게 감지하기 위해 사용!
    //  만약 key가 설정 안 돼있으면 가상DOM(그림자분신술)이
    //  순차적으로 비교하며 감지하기 key가 없을 때보다 속도 느림
    const numbers = [1,2,3,4,5];
    const listItems = numbers.map((number)=>
                                /*
                                .toString():갖고있는 정보나 값을 문자열로 만들어 줌
                                */
                <li key={number.toString()}>{number}</li>
            );

    const animals = [
        {key:1,value:"lion"},
        {key:2,value:"rabbit"},
        {key:3,value:"dog"}
    ];
    const animalList = animals.map((index,data)=>(<li key={index}>{data}</li>))

    return(
        <div>
            <ul>//그래서 여기에 담아서 출력가능
                {menuList}
                {menuList2}
                {listItems}
                {animalList}
            </ul>
        </div>
    );
}