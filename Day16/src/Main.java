import java.util.HashMap;

public class Main {

	public static void main(String[] args) {

		//map
		//키(key) 값(value) 쌍으로 구성된 객체를 저장하는 자료구조
		//연락처, 국어사전, 영어사전
		//기본타입 -> 래퍼클래스 같이 사용해야 한다.
		//배열:공간의 번호가 자동으로 부여 0부터
		//map:공간의 이름을 내가 마음대로 작성가능!
		
		//배열, 리스트 가장 큰 장점:나란하게 메모리공간이 선언
		//						인덱스 순서가 있는 자료형
		
		
		//map:인덱스 번호가 부여되지 않는다
		//반복문을 쓸 수가 없다. for 문
		
		//기준이 되는 key는 중복되면 안 된다.
		//value는 중복 가능하다~
		
		//hashmap
		//treemap
		
		HashMap<String, Integer> map = new HashMap<>();
		//put() 저장
		
		map.put("오십", 50);
		map.put("십", 10);
		map.put("삼십", 30);
		map.put("사십", 40);
		
		//이름, 폰 번호
		HashMap<String, String> map2 = new HashMap<>();
		
		map2.put("이서희", "292-3939-2929");
		map2.put("옹화호", "393=4939-2892");
		map2.put("이호호", "39292-39393-29");

		//전체출력X
		System.out.println(map2);
		System.out.println();	//공백, 줄바꿈
		
		System.out.println(map);
		
		//부분적으로 출력, 원하는 값value만 가져오기
		//get(key)
		
		System.out.println(map.get("오십"));
		System.out.println(map2.get("이서희"));
		
		//map에서 key만 출력
		//keySet() set 계열로 데이터를 뽑아온다.
		System.out.println(map.keySet());
		
		for(String key : map.keySet()) {
			System.out.println(key + " " + map.get(key));
		}
		
		//키 안에 삼십이 있니?
		String q = "삼십";
		boolean res = false;
		String r = "";
		
		for(String key : map.keySet()) {
			if(q.equals(key)) {
				r = "있다.";
			}else {
				r = "없다.";
			}
		}
		System.out.println(r);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
