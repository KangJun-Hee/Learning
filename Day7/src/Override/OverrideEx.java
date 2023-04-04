package Override;

public class OverrideEx {

	public static void main(String[] args) {

		//마법사
		Wizard w1 = new Wizard();
		w1.fireball();
		
		//전직 마법사
		GreatWizard g1 = new GreatWizard();
		g1.fireball();
		
		//동물
		Animal a1 = new Animal();
		a1.cry();
		
		//고양이
		Cat c = new Cat();
		c.cry();
		
		Dog d = new Dog();
		d.cry();
		
		Point p2 = new Point();
		p2.info();
		System.out.println(p2);
		
		//toString()
		//특별한 메서드!
		//함수호출 하지 않아도 Sytem.out.println()
		//호출하면 자동적으로 toString 호출되도록
		//약속되어있음.
		
		//중요!!!!!!! 메서드 오버라이딩 !!!!!!!중요
		// - 부모클래스의 메서드를 자식클래스가 재정의
		// - 부모클래스 메서드 이름을 자식클래스가 '똑같이' 만
		//	사용하는 것
		
		//오버라이딩
		// - "함수이름 똑같아야 함"
		// - "매개변수 개수 똑같아야 함"
		// - 리턴타입도!!
		
		//메서드 오버로딩
		// - 함수이름 여러개 사용하는 기능!
	}

}
