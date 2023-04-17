package Generics;

import java.util.ArrayList;


public class Run {
		
	public static void main(String[] args) {
		
		new MemberMenu().mainMenu();
	
	}
}
/*
 * 
 * class A<T>{
	int num;
}

class B<T> extends A{
	int num2;
}

class C<T>{ // 관련 X A,B
	int num3;
}
 * 
 *
 * 
 * public static void print(ArrayList<? super B> list) {
		System.out.println(list);
	}
	
	public static void print2(ArrayList<? extends B > list) {
		System.out.println(list);
	}

	public static void print3(Object[] list) {
		System.out.println(list);
	}

 * 
 * 
 * 	// 다형성 
		// 변성 - 타입의 상속 계층 관계에서 서로 다른 타입간에 
		//       어떤 지표

		// 공변성 
		// 반 공변성 
		
		
		int[] arr = new int[10];
		Integer[] arr2 = new Integer[10];
		
		//print3(arr);
		print3(arr2);
		
		ArrayList<A> list1 = new ArrayList<>();
		ArrayList<B> list2 = new ArrayList<>();
		ArrayList<C> list3 = new ArrayList<>();
		ArrayList<Object> list4 = new ArrayList<>();
		
		// 제네릭으로 타입을 고정하면 아무리 상속 구조라고 해도
		// 선언한 타입으로만 참조가능하다.!
		 
		//list1 = list2;
		
		
		// A랑 관련이 없다! 
		//print(list4); 에러
		//print(list3); 에러
		
		// <? extends 클래스명>
		// 상속에서 자식클래스들은 타입으로 들어올 수있다.
		// 위에 부모들은 들어올 수 없다!		
		print(list1);
		print(list2);
		
		// < ? super 클래스명 >
		print(list1);
		print(list2); 
		print(list4);
		
		System.out.println(list1);
		
			
		// 와일드카드 
		//  ? 
		// 메서드를 이용해서 제네릭 타입들을 넘기는 경우!
		// 제네릭 타입들의 <> 타입이 맞지 않으면 실행X
		// 제한 걸 때 & 클래스와 인터페이스 자체를 같이 제한을 걸
		// 었는데 와일드카드에서는 & 쓸 수가 없다.
		
		
		// ? 모든 타입을 받을 수 있다.
		
		// 제한 걸기 !
		// ? extends 클래스명 
		//  클래스명과 관련 있는 하위 클래스들을 받을 수 있다.
		
		//ArrayList<Integer> list = new ArrayList<>();
		//ArrayList<A> list2 = new ArrayList<>();
		
		//list.add(1);
		
		//print(list);
		//print(list2);
		
		
		// 노션 
		//  - 공부한 걸 정리!
		//  - 프로젝트 일정관리 다른 사람들이 한 내용을 공유 
		
			
 * 
 * 
 */
