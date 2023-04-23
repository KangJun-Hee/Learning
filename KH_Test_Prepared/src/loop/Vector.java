package loop;

public class Vector {


	public static void main(String[] args) {

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
	}//main

}//class
