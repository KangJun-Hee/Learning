package Generics;





public class Main {

	public static void main(String[] args) {
		
		// public static 객체생성 클래스명으로 접근
		//FruitBox.addBoxStatic(1, 2);
		//매개변수의 데이터형을 보고 타입을 추론
		
		FruitBox<Integer, Long> box1 = new FruitBox<>();
		
		//인스턴스화에 지정된 타입 파라미터
		box1.printBox(1, 1);
		
		//제네릭 메서드에서 다른 타입으로 정의
		box1.<String, Double>printBox("hello", 5.55);
		box1.printBox("hello", 5.55);//생략이 가능하다.		
		
		
		
	}
	
}




//
//
////인터페이스 추상메서드들의 제네릭타입을 지정
////인터페이스 객체 생성X
////1회용 익명클래스(내부클래스중에)
//
//interface ISample<T>{
//	
//	public void addElement(T t,int index);
//	public T getElement(int index);
//	
//}
//
//class Sample<T> implements ISample<T>{
//
//	private T[] array;
//	
//	//기본생성자
//	public Sample() {
//		
//		array = (T[])new Object[10];
//	}
//	
//	//T타입으로 들어온 객체의 주소를 저장한다.
//	//index변수의 숫자를 이용해서 방 번호에 저장한다.
//	@Override
//	public void addElement(T t, int index) {
//		array[index] = t;
//		
//	}
//
//	@Override
//	public T getElement(int index) {
//		return array[index];
//		
//		//return으로 Main이든 내가 호출한 메서드든
//		//그걸 콘솔에 보여 주려면 무조건 println()
//		//저장만 하겠다면 변수에 저장! 객체 주소-> 참조변수
//	}
//}
//
////제네릭 많이 사용되는 람다 표현식의 함수형 인터페이스
////두 매개변수를 받아서 더하는 인터페이스
//interface IAdd<T>{
//
//	public T add(T x, T y);
//}
//	
//		//제네릭을 통해 람다 함수의 타입을 결정
//		//매개변수 x와 y 그리고 반환형 타입이 int형으로 설정된다.
//		//일반변수를 객체화 시켜주는 래퍼클래스
//		//자동으로 포장한다.
//		
//		IAdd<Integer> o = (x, y) -> x+y;
//	
//		int result = o.add(10, 20);
//		//결과값 콘솔에 보여 줘라~
//		System.out.println(result);
		

		
		
		
//		//객체생성
//		Sample<String> sa = new Sample<>();
//		
//		sa.addElement("this is string", 5);
//		System.out.println(sa.getElement(5));


//		T t = new T(); //이런 식은 불가함
//new 연산자 뒤에 제네릭타입
//파라미터 올 수 없다.
//}
//static 멤버는 클래스가 동일하게 공유하는
//변수로서 제네릭 객체 생성 전에 이미
//자료타입이 정해져 있어야 된다. 컴파일전이니까.
//	
//	public static T addAge(int n) {
//		
//	}







////제네릭으로 배열을 선언
////기본적으로 제네릭클래스 잧를 배여로 만들 수 없다
////		Sample<Integer>[] arr1 = new Sample<>[10];
//
////제네릭 배열을 선언하고 저장하고 싶다.
//Sample<Integer>[] list = new Sample[10];
//
//list[0] = new Sample<Integer>();
//list[1] = new Sample<>();
//
////제네릭은 타입을 지정!
////그 외 타입이 들어오면 당연히 에러!
////		list[2] = new Sample<String>();