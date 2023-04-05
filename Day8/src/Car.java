//상속은 물려만 준다.
//강제성이 없다(쓸 거면 쓰고~)

public abstract class Car {	//세상에 존재하는 자동차들//중요!!!!!기본생성자 있다!!!!!중요
	
	String colour;
	int door;
	
	//강제성
	abstract void drive();
	abstract void stop();
	abstract void 와이퍼();
	
	//비강제성 
	void 엉따() {};
	void 썬루프() {};
	void 블루투스() {}	;
	}


class FireEngine extends Car{

	int a;
	
	@Override
	void drive() {
		a = 1000;
		System.out.println(a);
		water();
	}
	
	void water() {
		System.out.println("물 뿌리는 기능");
	}
}
class Ambulance extends Car{
	void siren() {
		System.out.println("환자 이송!");
		
	}
	@Override
	void stop() {
		System.out.println("부모접근가능!");
	}
}

//default 제어자
//생략이 가능하다.
//같은 패키지에서만 접근이 가능하다.
//	값을 변경, 객체를 생성, 메서드를 호출