
//제네릭 타입을 지정할 때는 객체를 생성할 때 타입지정
//미리 기본자료형들 선언할 수 없다!

public class Person<T,E> {
	
	T id;
	E pw;
}

//	String name;
//	int age;
//	T weight;//정수
//	T height;//실수