package Generice;

import java.util.ArrayList;

class Calc<T>{//계산기를 만드는 클래스
	
	//두 수를 입력해 계산을 하는 계산기
	T x;
	T y;
}

	public class Main {

	public static void main(String[] args) {
//		Person<Integer, Double> p1 = new Person<Integer, Double>();
		Person<String, Integer> p2 = new Person<String, Integer>();
		
		ArrayList<Person> list = new ArrayList<>();
		
		
	}

}

//	
//	//박스생성(사과만 담는 박스)
//	//new <- 메모리 생성하겠다. 박스라는 클래스 이용해서Apple타입만
//	//저장하겟다.
//	Box applebox = new Box<Apple>();
//	
//	//30개의 사과를 사과박스 안에 저장하겠다.
//	applebox.obj = new Apple[30];
//	
//	//사과박스에 신발을 저장한다.
//	//obj[0] = new Shoes();
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	//컵 하나 생성
//	Cup c1 = new Cup();
//	
//	//컵에 첫 번째 담을 음료는 커피
//	c1.obj = new Coffee();
//	
//	//컵에 물을 담는다.
//	c1.obj = new Water();
//	
//	//우유 담는다.
//	c1.obj = new Milk();
//	
//	//다형성 위에 내용!
//	
//	//컵인데 넌 무조건 커피만 담아라!
//	//coffee 상속받거나 관련이 있는 클래스들은 객체를 생성할 수 있다.
//	//instaneOf 타입검사를 할 필요가 없다@
//	//인터페이스 타입도 지정할 수 있다.
//	Cup<Coffee> cup1 = new Cup<Coffee>();
//	
//	//컵에 내용물을 저장한다.
//	cup1.obj = new Coffee();
//	cup1.obj = new Americano();
//	cup1.obj = new Cafelatte();
//	
//	//매개변수의 타입
//	//E 원소 (Element)
//	//K key
//	//N 숫자 (Number)
//	//T 타입 (Type)
//	//V 값 (Value)
//	
//	//타입매개변수(타입파라미터)
//	// - 제네릭을 이용한 클래스나 메소드를 설계할 때
//	
//	
//	//물 담아 먹는다.
//	
//	//제네릭은 타입을 검사하는 과정은 생략가능
//	//객체들의 다형성을 할 때 강제 형변환을 한다.
//	//에러를 낸 경우가 많다. 에러를 줄일 수 있고
//	//클래스의 개수도 줄일 수 있다.
//	
//	//무조건 정수타입의 데이터만 저장할 수 있다.
//	//Calc<Integer> calc1 = new Calc<Integer>();
//	
//	//무조건 더블타입의 데이터만 저장할 수 있다.
//	//Calc<Double> calc2 = new Calc<Double>();
//	
//	
//	//제네릭<>
//	// - <> 꺾쇠 안에 타입명을 기재한다.
//	// - 클래스 내부에서 사용할 데이터 타입을 외부에서 지정하는 기법
//	// - 객체 자료형(타입)을 지정하여 지정된 타입만 객체를 저장하는 기능
//	// - 클래스 정의시 클래스명<타입>
//	// - 기본자료형을 받지 않는다. 객체 타입으로 생성