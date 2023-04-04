package Override;

public class Animal {
	//모든 동물
	void cry() {
		System.out.println();
	}
}
class Cat extends Animal{
	void cry() {	//함수이름 똑같은데 자식에 맞게 내용 변경:오버라이딩
		System.out.println("야옹야옹!");
	}
}
class Dog extends Animal{
	void cry() {
		System.out.println("우렁루어렁럭!!월우렁루얼ㅇ!!!");
	}
}
