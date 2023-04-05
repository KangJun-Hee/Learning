package Abstract;

import StarCraft.StarCraft;

public class Main {

	public static void main(String[] args) {
		StarCraft st = new StarCraft();
		
		//탱크, 수송선, 군인
		//목숨확인 = hp 출력
		st.show();
	}

}


//비정상적 클래스라서
//객체 생성 안 된다.
//Printer p = new Printer();



//추상화
//	- 부모클래스에서 상속 받은 자식클래스에
//		특정 메서드를 강제적으로 만들도록 하는 것!

//	- 몸체가 구현되지 않는 메서드
/*
 * 리턴값 함수명(매개변수타입) -> 선언부
 * 구현부가 없음
 * 
 */