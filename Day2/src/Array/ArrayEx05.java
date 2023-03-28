package Array

;import java.util.Scanner;

public class ArrayEx05 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//숫자 (정수)
		int[] arr = {10, 20, 0, 0, 0};
		int count = 2; //지금 두 개 차있다.
		int totalsize = arr.length;//총 다섯 개
		
		while(true) {
			System.out.println("현재 남은 공간:" + (totalsize - count));
			System.out.println("1. 추가 2. 삭제 0. 종료");
			int sel = sc.nextInt();
			if(sel == 1) {
				//추가
				//1. 공간이 남아있니? 있습니다. 추가를 하면 됨.
				//공간이 남아있다?
				//	정수를 하나 입력 받는다.
				//	데이터의 개수가 증가
				//	공간이 없다. break;	
				
				//count > 5
				if(count > 5) {
					System.out.println("공간이 다 찼다!");
					break;
				}

				int num = sc.nextInt();
				//배열의 인덱스
				arr[count++] = num;

				//(totalsize - count) > 0
				if((totalsize - count) > 0) {
					System.out.println("저장");
				}else {
					System.out.println("다 찼다!");
					break;
				}
					
			}else if(sel ==2) {
				//삭제
				//1.삭제할 값 입력
				//2.찾는다 삭제할 인덱스
				//3.새로운 배열을 생성 5개
				
				findDelindex = -1;
				
				int[] temp = arr;//기존 배열
				int[] arr = new int[5];//새로운 배열
				
				int index = 0; //처음 방부터 순서대로 접근할 때
				int j = 0; //새로 복사하는 배열의 인덱스를 부여
				while(index < count -1) {
					
					if(count == 0) {break;}
					if(index != findEdlindex) {
						arr[j] = temp[index];
						j = j + 1;
					}
					index += 1;
				
			}else if(sel ==0) {
				break;
			}else {//예외적 메세지!
				System.out.println("0~2번 사이만 입력하세요!");
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		//문자 열과 문자열 비교할 땐! equals()
		//두 개 문자 같다 true
		//			다르다 false
//		String name = "이서희";
//		String name2 = "이지희";
		
		//비교 name == name2 같니? 출력
//		if(name == name2) {
//			System.out.println("같습니다.");
//		}else {
//			System.out.println("다릅니다.");
//		}
		
		
//		String name3 = "이서희";
		//비교 name == name3 같니? 출력
//		if(name == name3) {
//			System.out.println("같습니다.");
			String kdw = "강동원";
//			kdw = new name;
//			System.out.println(name);
//		}else {
//			System.out.println("다릅니다.");
		}
	}


