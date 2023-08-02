추가적으로 해볼 것
    01과 02 파일 합쳐서 하나의 03 파일 만들기
    ex) 등록 버튼과 초기화 버튼을 하나의 컴포넌트 안에 넣어 만들고 동작하게 만들기

    뼈대
        <b> 값 : {text} </b>
        <input onChange={handleChange} placeholder="이름을 입력하세요." value={text} />
        <button onClick={hadleJoin}>등록</button>
        <button onClick={handleReset}> 초기화 </button>