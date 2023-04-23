package total;

import java.util.Arrays;
import java.util.TreeMap;

import apple.laf.JRSUIUtils.Tree;

public class Total {
	String name;
	int age;
	
	
	public static void main(String[] args) {
		//sort(배열명); 기본 오름차순으로 정렬해 줌.
		int[] list = { 1, 26, 17, 4, 20, 44, 3 };
		Arrays.sort(list); 

		//toString v. Arrays.toString();
		double[] values = {1.5, 1.3, 1.5};
		//X이러면주솟값나옴X
		System.out.println(values.toString());
		//O이러면 값나옴O, 배열에 정의된 값들 문자열로 만들어 리턴함. 
		System.out.println(Arrays.toString(values));

		char[] ch = {'d', 'g', 'w', 'a'};
		Arrays.sort(ch);
		System.out.println(Arrays.toString(ch));
		
		System.out.println("-------------------");
		
		
		
		
		
		//상속, 생성자
	}
	class A{
		String aField = "클래스 A 필드";
		public void aMethod() {
			System.out.println(aField);
		}
	}
	class B extends A{
		String bField =	"class b field";
		public void bMethod() {
			System.out.println(aField);//부모클래스필드 사용
			System.out.println(bField);//본인클래스필드 사
			
		}
	}
	//기본생성자 필수~
	public Total() {}
	Total(String name, int age){
		
	}
	
	
	
	
	
	
	
	//TreeMap:키(key) 값(value) 쌍으로 구성된 객체를 저장하는 자료구조
	//키와값을 제네릭으로 넣어 줘야 함(Integer,String같은 거)
	TreeMap<Integer, String> map1 = new TreeMap<>();
	//map1의 모든값 가진 TreeMap생성 
	TreeMap<Integer, String> map2 = new TreeMap<>(map1);
	//초기값 생성
	TreeMap<String, String> map3 = new TreeMap<>() {{
			put("dwi","a");
	}};
	
	TreeMap<Integer, String> map = new TreeMap<>() {{
	map.put(1, "apple");//값추가 
	map.put(2, "peach");
	
	map.remove(1);//key값 1제거 
	
	map.clear();//모든값 제거 

	System.out.println(map);//전체출력 {1:apple, 2=peach}
	System.out.println(map.get(1));//key값 1의 v얻기  사과

	//keySet() 활용
	for(Integer i : map.keySet()) {//저장된 값 확인 
		System.out.println("key:"+i+ "value:"+map.get(i));
		//key:1 value:apple
	}
	
	TreeMap<Integer, String> dhk = new TreeMap<>();
	dhk.put(32, "it's cold");
	dhk.remove(32);//key값 32제
	dhk.clear();//remove all of it.
	
	for(Integer i : dhk.keySet()) {
		System.out.print("k:"+i+ "v:"+dhk.get(i));
	}
	
	
	
	}};
	









}//public class