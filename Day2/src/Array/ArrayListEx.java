package Array;

import java.util.ArrayList;

public class ArrayListEx {

	public static void main(String[] args) {

		//공간을 자동으로 추가, 삭제, 조회
		//배열을 편하게, 여러개의 데이터를 저장하고 싶다~
		//ArrayList<자료형>
		
		//정수 저장하고 싶다~ full name. intX IntergerO
		ArrayList<Integer> list1 = new ArrayList<>();
		
		//추가 add(값)
		list1.add(10);
		list1.add(20);
		list1.add(30);
		
		//출력
		System.out.println(list1);
		//길이
		System.out.println("길이: " + list1.size());
		
		//조회 indexOf(찾는 값을 괄호에!)
		int find = list1.indexOf(20);
		
		//삭제 remove 정수문자 상관무, 대신 괄호에 그거랑 같은 건 넣어야 함
		list1.remove(find);
		
		
		//실수를 저장하는 배열
		ArrayList<Double> list2 = new ArrayList<>();
		list2.add(1.243);
		list2.add(22.423);
		list2.add(3.3433);
		list2.add(200.2);
		
		
		System.out.println(list2);
		
		// 200.2 찾아서 삭제
		//indexOf()
		int ebk = list2.indexOf(200.2);
		//remove()
		list2.remove(ebk);
		//출력~
		System.out.println(list2);
		
		//문자열 저장하는 배열
		ArrayList<String> list3 = new ArrayList<>();
		//add() 김연아 강동원 출력
		list3.add("김연아");
		list3.add("강동원");
		System.out.println(list3);
		//강동원 삭제
		int find3 = list3.indexOf("강동원");
		list3.remove(find3);
		
		System.out.println(list3);
		
		//전부다 삭제!
		list3.clear();
		list2.clear();
		list1.clear();
		
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list3);
		
		//

		
	}

}
