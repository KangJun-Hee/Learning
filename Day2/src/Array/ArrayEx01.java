import java.util.Random;

package Array;

public class ArrayEx01 {

	public static void main(String[] args) {

		//배열: 동일한 타입의 변수를 여러개 묶었다.
		//학생분들의 점수를 저장하는 배열. 학생 25명.
		//단점: 삭제, 추가가 불가능(공간) 예: 리조트, 한 층에 방 만들어져있음.
		
		//순서(인덱스) 0부터 시작
		
		int[] scorelist = new int[25];
		
		int[] a = {1, 2, 3};
		int[] b;
		//배열의 길이
		System.out.println(scorelist.length);
		
		//배열을 복사
		//1:1로 하나씩 복사하기
		b[0] = b[0];
		b[1] = a[1];
		b[2] = a[2];
		//함수 사용해서 복사하기
		//	깊은복사, 얇은복사
		b = a.clone();

		//값을 변경
		b[0] = 3;
		System.out.println(b[0]);
		System.out.println(a[0]);
		
		
		
		
		
		//문제1) 10부터 50까지 arr 배열에 저장
		//정답1) 10 20 30 40 50
		
		int[] arr = {10, 20 , 30, 40, 50};
		
		//각각 공간에 접근(노가다)
		System.out.println(arr[0]);
		System.err.println(arr[1]);
		
		//문제2) 전체 합 출력
		//정답2) 150
		
		
		
		//문제3) 4의 배수의 개수출력
		//정답3) 2개
		int index1 = 0; //시작값
		int count = 0;
		
		int i = 0;
		
		while(index < arr.length) {//조건
			if(arr[index] % 4 == 0) {
				count += 1; //count++, ++count;
			}
			index++;
		}
		
		// 점심메뉴 정하는 프로그램작성
		Random r = new Random();
		String[] m = {"샌드위치", "쌀국수", "샐러드", "파스타", "냉면", "비냉"};
		//메뉴개수
		int size = m.length;
		//랜덤값 뽑는다
		int ra = r.nextInt(size);
		System.out.println(m[ra]);
		
		
		
		
		
		
		//로또 프로그램 작성
		//1~45중 하나 뽑는다.
		//중복상관무 하나씩 뽑아서 각각의 배열에 저장 출력
		//2 13 14 25 44 10
		
		int index = 0;
		
		while(index < lotto.length) {
			lotto[index] = r.nextInt(45)+ 1;
			index += 1;
		}
		System.out.println(index);
		index = 0; //증가한 방 번호를 다시 0으로 초기화하겠다.
		
		while(index < lotto.length) {
			System.out.println(lotto[index++]);
		}
		
		
		
		
		
		//중복을 제거하는 명령문을 추가
		//set
		
		
		
	/*	if(arr[index] % 4 == 0) {
			count += 1; //count++, ++count;
		}
	}*/

}}
