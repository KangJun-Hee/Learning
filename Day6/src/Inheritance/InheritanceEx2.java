package Inheritance;

class A{
	int num;
	
	//생성자 부모클래스의 변수에 초기화!
	A(int num){
		this.num = num;
		System.out.println("A클");

	}
	
}
//부모쿨래스에서 생성자가 생기면
//부모의 변수를 포기화해서 자식클래스에 줘야 된다.
class B extends A{
	B(int num){
		super(num);
		//this.num = num;
		System.out.println("B클");
	}
class Person{
	
	String name;
	int age;
	
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
}
class Teacher extends Person{

	Teacher(String name, int age) {
		super(name, age);
	}
	void lecture() {
		System.out.println("강의한다.");
	}
}
class Student extends Person{

	Student(String name, int age) {
		super(name, age);
		
	}
	void study() {
		System.out.println("공부한다.");
	}
	
}
//super() : 부모클래스의 생성자를 호출한다.
//			무조건 생성자 함수가 시작하자마자 바로 첫 번째 줄에
//			선언되어야 한다. 안 그러면 에러 남. 부모거생성하고자식거

//상속
// - 다중상속X -> 인터페이스!


}



public class InheritanceEx2 {

	public static void main(String[] args) {
		//상속 받은 자식클래스 객체를 생성
		B b1 = new B(10);
		
		System.out.println(b1.num);
		//상속 받은 부모클래스의 객체 먼저 생성
		//자식클래스 생성된다.
	}

}
