package Object2;

class Person {

	String name;

	Person(String name) {
		this.name = name;

	}

	// Objects 클래스에서 오버라이딩 equals()
	@Override
	public boolean equals(Object obj) {

		// 만약 현객체 this와 매개변수 객체가 같을 경우 true면
		if (this == obj) {return true;}

		
		
		// 만약 Person 타입이 아니다! 호환안되면 에러!
		// true 객체 참조가 가능하다.
		// false 그대로 집어 넣으면 if문이 실행되지 않는다.
		// not 거짓을 참으로 변경했다!
		if (!(obj instanceof Person)) {
			return false;
		}

		// 객체 비교
		// 지금 현재 obj 부모타입 참조 다형성(업캐스팅)
		// 다운캐스팅 Object --> Person
		Person person = (Person) obj;

		
		if (person.name == this.name) {

			return true;
		}else {
			return false;
		}

	}

}

public class Main {

	public static void main(String[] args) {

		Person a1 = new Person("이서희");
		Person a2 = new Person("이서희");// 동명이인

		if (a1.equals(a2)) {
			System.out.println("같다.");
		} else {
			System.out.println("다르다.");
		}

		// Objects 클래스
		String s1 = "hello";
		String s2 = new String("hello");

		// 메모리에 문자를 저장할 때 똑같은 문자를 저장
		// String 조건 new String() 안 써도 된다
		// 단! 똑가은 문자가 들어 오면 기존에 만들어져 있던
		// 주소값을 던져 준다.
		if (s1 == s2) {
			System.out.println("같다.");
		} else {
			System.out.println("다르다.");
		}
		s2 = "이서희";
	}

}

//		Object 클래스가 아닌, Objects 클래스임을 조심하자.
//		Objects 클래스는 java.util 패키지에 있는 또다른 클래스이다. (Object 클래스는 java.lang 패키지에 포함)
//		Objects 클래스는 객체 비교, 해시 코드 생성, null 여부, 객체 문자열 리턴 등의 연산을 수행하는 정적 메소드들로 구성되어 있으며, 개발자가 가져가 쓰기 편하게 하기 위해서 구현되었다.
//		위의 코드에서 Object 클래스의 equals 메서드를 재정의 하였기 때문에, 본래의 equals 메서드 동작 결과를 얻기 위해 Objects 클래스의 메서드를 사용하는 것이라고 이해하면 된다.