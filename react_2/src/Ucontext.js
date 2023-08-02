/*
일반적으로 React 데이터:위에서 아래(부모에서 자식) 
    props를 통해 전달
    여러 컴포넌트들에 전달해 줘야 할 prop경우 과정이
    번거로울 수 있음
context 사용하면 트리단계마다 명시적으로 props를 안
    넘겨 줘도 많은 컴포넌트가 이러한 값을 공유할 수
    있게 함
    중간에 있는 element에게 props 넘겨 주지 않아도 됨
    원한하는 값을 컴포넌트트리 깊숙한 곳까지 보낼 수 있
    음.
    컴포넌트 재사용 어려워짐
contextAPI 사용 위해 Provider Consumer,CreateConte
    xt 알아야 함
    Provider:생성한 context를 하위컴포넌트에게 전달하
    는 역할
    Consumer:context의 변화를 감시하는 컴포넌트
    CreateContext:context객체생성
 */

import { createContext } from "react";
export const AppContext = createContext();//context객체생성

function Children(){
    return(
        <AppContext.Consumer>{/*context의 객체를 생성
            하고 context의 변화를 감시하는 컴포넌트*/}
                {(user)=>(
                    <div>
                        <h3>
                            AppContext 존재하는 값의
                            name은 {user.name}입니다.
                        </h3>
                        <h3>
                            AppContext 존재하는 값의
                            직업은 {user.job}입니다~
                        </h3>
                    </div>
                )}
        </AppContext.Consumer>
    );
}

export default function Ucontext(){
    const user = {
        name:"김경난",
        job:"강사"
    };
    return(
        <div>
            {/*3.생성한 context를 하위 컴포넌트에게 전달하는 역할*/}
            <AppContext.Provider value={user}>
                <Children/>
            </AppContext.Provider>
        </div>
    );
}