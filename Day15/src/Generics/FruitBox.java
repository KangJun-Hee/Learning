package Generics;

public class FruitBox<T,U>{
	
	//독립적으로 운영되는 제네릭 메서드
	public <T,U> void printBox(T x, U y) {
		System.out.println(x.getClass());
		System.out.println(x.getClass());
	}
}










//public class FruitBox<T> {
//
//	public T addBox(T x, T y) {
//		return y;
//	}
//	
//	//static으로 선언을 해도 독립적으로 타입을 할당해서 사용할 수 있도록
//	//제네릭 메서드를 정의한다.
//	
//	//처음 제네릭 클래스로 인스턴스화하면 클래스 타입 매개변수가
//	//전달한 타입에 따라서 제네릭 메서드도 타입을 정한다.
//	//제네릭 메서드를 호출할 때 직접 타입 파라미터를 다르게
//	//지정하거나 다른 타입의 데이터를 매개변수에 넘긴다하면
//	//독립적인 타입을 가진 제네릭 메서드로 운용할 수 있다.
//	
//	public static<T> T addBoxStatic(T x, T y) {
//
//		return y;	
//	}
//}