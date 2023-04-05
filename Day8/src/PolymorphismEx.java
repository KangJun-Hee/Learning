
public class PolymorphismEx {

	public static void main(String[] args) {

		//레퍼런스 변수
		Car c1 = new Car();
		
		//레퍼런스 변수
		FireEngine f1 = new FireEngine();
		Ambulance a1 = new Ambulance();
		
		//부모클래스인 car, 만들어진 소방차
		//참조 = 주솟값 가리킨다.
		//부모클래스 참조를 하고 있으면 부모가 물려 준 변수,메서드만
		//접근이 가능하다.
		
		//자식클래스에 있는 내용을 접근하고 싶을 경우, 오버라이딩해라.
		Car c2 = f1;
		c2.drive();
		
		Car c3 = a1;
		c3.stop();
		
		//Object클래스
		//모든 클래스의 최고 부모! 자동상속 이루어진다.
		Object o1 = new Car();
		Object o2 = new FireEngine();
		Object o3 = new Ambulance();
		
		boolean res = o1 instanceof Car;
		System.out.println(res);
		
		res = c3 instanceof Ambulance;
		System.out.println(res);
		
		String str = "이서희";
		res = str instanceof String;
		System.out.println(res);
		
		res = str instanceof Object;
		System.out.println(res);
		
		
		
		
		
		
		//다형성
		// - 업캐스팅과 똑같은 내용
		// - 하나의 참조변수로 여러 타입의 객체를 참조할 수 있는 것!
		// - 서로 상속관계 가능
		// - 형변환 
		// - 부모는 자식을 참조가능
		// - 자식은 부모참조 XX 가능하게 인터페이스
	}

}


//참조변수의 개수?
//Ambulance 자기 자신의 주소값 저장
//	car, object 3개!


//intstanceof 연산자
//참조변수가 참조하는 인스턴스의 실제 타입을 체크
//true, false

//객체변수 instanceof 클래스명