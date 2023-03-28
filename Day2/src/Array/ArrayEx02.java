package Array;

import java.util.Scanner;

public class ArrayEx02 {

	public static void main(String[] args) {

		int[] hakbuns = {1001, 1002, 1003, 1004, 1005};
		int[] scores = {87,    11,    45,   98,    23};
		
		//hashset -> put()
		//검색 이진탐색:정렬해야함.
		//		순차탐색
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("학번> ");
		int hakbun = sc.nextInt();
		
		int index = 0;
		int findIdx = -1; //찾은 배열에 접근할 때 공간에 번호로 사용, 0이라고 하면 
		
		while(index < hakbuns.length) {

		if(hakbun == hakbuns[index]) {
			
			findIdx = index;
			//점수
			//System.out.println(scores[index]);
			
		}
		//위에 반복내용 실행했으면 담 공간으로 넘어가게 
		index += 1; //혹은 index++
	}
		//findIdx 번호가 -1 찾는 학번이 없다.
		//findIdx 번호 0~5번 사이로 값이 저장
		if(findIdx != -1) {
			System.out.println(scores[findIdx]);
		}else {
			System.out.println("찾는 학번 없음.");
		}
		
	}}
