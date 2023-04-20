package SelfPrac_Generic;

	public static void main(String[] args) {

	}

	
	
	
접근지정자 class 클래스명<T>{//<T>=제네릭 타입변수명
	//타입 T를 사용한 코드
}

//예시
public class GenericClassInterface<T>{
	private T t;
	public T get() {
		return t;
	}
	public void set(T t) {
		this.t = t;
	}
}

//제네릭의 기본 개념은 클래스 내에 사용되는 타입을 클래스의 정의 때가
//아닌 객체 생성 때 정의하겠다는 의미