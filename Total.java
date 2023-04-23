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
	
	
	
	
	
	
	
	//Loop
	class Vector{
		//정수
				//처음에 프로그램을 시작. 비어있는 배열 선언.
						Scanner sc = new Scanner(System.in);
				int[] arr = null;
				
				//데이터 개수를 count(변수)
				int count = 0;
				int sel; //굳이 초기화 안했음
				//1.추가 2.삭제 3.정렬(조회) 0.종료

				//무한반복
				while(true) {
					//메뉴
					System.out.println("1.추가 2.삭제 \n 3.정렬(조회) 0.종료");
					sel = sc.nextInt();
					
					switch(sel) {
					case 1:
						//count가 0이면 데이터 없단 뜻. 배열 하나만 생성
						//count가 1이상이면 데이터 있다. 배열 새로 만들어
						//기존 데이터 복사하고 새로운 데이터를 추가.
						
						if(count == 0) {
							arr = new int[1];
						}else {
							int[] temp = arr; //기존 데이터 있으면 잠깐 임시저장
							arr = new int[count + 1];//새로 공간 만ㄷㄹ어라
							
							//기존배열에서 데이터 저장(복사)!
							for(int i = 0; i < count; i++) {
								arr[i] = temp[i];
							}
							
							//기존배열이 필요 ㄴㄴ
							//새로운 배열 복사를 했으니깐.
							//주소값 저장할 필요 ㄴㄴ. 가비지가 해결!
							temp = null; //알아서 삭제
						}
						//위에서 공간 생성함.
						//실제 그 안에 데이터 추가해야지!
						
						System.out.println("추가할 정수>");
						int data = sc.nextInt();
						arr[count] = data;
						
						count += 1;
						
						break;
					
					case 2:
						//삭제
						if(count == 0) {
							System.out.println("빈 공간입니다. 데이터를 추가하쇼~");
						}else {
							//삭제 데이터 찾기
							//입력 받고 반복문으로 찾기
							System.out.println("삭제할 데이터를 입력>");
							int del = sc.nextInt();
							//삭제할 값을 이용해서 인덱스를 찾는다. 있을 수도 있고 없을 수도 있음.
							int delIndex = -1; //그냥 마이너스일, 인덱스에는 있을 수 없는 거니까.
							
							for(int i = 0; i < count; i++) {
								if(arr[i] == del) {
									delIndex = i;
									break;
								}
							}
							//데이터가 없다고 하면
							if(delIndex == -1) {
								System.out.println("삭제할 값이 없다!");
								
							}else {
								//삭제할 인덱스 빼고 복사
								int[] temp = arr;
								arr = new int[count -1];
								
								//복사 과정에 삭제할 인덱스 데이터는 복사 xxxxxxxxx
								//i는 기존 배열의 방번호 사용
								//j는 새로운 배열의 방번호 사용
								for(int i = 0, j=0; i < count; i++) {
									if(i != delIndex) {
										arr[j] = temp[i];
										j += 1;
							}
						}
						temp = null;
						count -= 1; //다 처리했으니깐 빼줘야지
							}}
					case 3:
						//전체 출력
						for(int num : arr) {
							System.out.println(num);
						}
						break;
						
					case 0:
						return;//리턴은 프로그램을 다 끄겠다. 함수를 종료해라. 브레이크는 스위치만 빠져나감.
						
					default://예외적인 처리! 프로그램 비정상으로 안 꺼지게
						
					}//switch done
				}//while done
	}
}







}//public class