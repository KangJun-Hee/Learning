/*
    props :  properties 의 줄임말
            어떠한 값을 컴포넌트에게 전달해줘야 할 때, props 를 사용

    컴포넌트에게 전달되는 props 는 파라미터를 통하여 조회 할 수 있음
    props 는 객체 형태로 전달되며, 만약 name 값을 조회하고 싶다면 props.name 로 조회하면 됨
 */

import React from 'react';

function Hello(props) {
  return <div>안녕하세요 {props.name}</div>
}

export default Hello;