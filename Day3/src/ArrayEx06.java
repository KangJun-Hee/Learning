import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx06 {

	public static void main(String[] args) {
//
//		/*
//		 * 신체검사한다. 키(실수) 저장
//		 * 1학년엔 3개의 반이 있다.
//		 * 각반의 5명의 키를 저장하는 2차원 배열
//		 */
//		
//		double[][] hei = new double[3][5];
//		
//		
//		
//		
//		int[][] arr2 = {
//				{1, 2, 3},
//				{4, 5, 6},
//				{7, 8, 9}
//				
//		};
		
		//전체출력
		//2차원 배열에서 length
//		System.out.println(arr2.length);
//		
//		for(int i = 0; i < arr2. length; i++) {
//			for(int j = 0; j < 3; j++) {
//				System.out.print(arr2[i][j]);
//			}
//			System.out.println();
//		}
//		
//		
//		//for
//		for(int[] num : arr2) {//행 전체 꺼내온다.{1, 2, 3}
//			for(int num2 : num) {//열에서 하나씩 꺼내온다.
//				System.out.println(num2);
//			}System.out.println();
//		}
//		//부분출력(원하는 값만 하나 출력)
//		//배열명[행][열]
//		//배열명[행][열] = 값
//		
//		System.out.println(arr2[1][1]);
		
		
		
		
		
		int[][] arr3 = new int[3][3];
				
				int k = 1;
				for(int i=0; i<3; i++) {
					for(int j=0; j<3; j++) {
						arr3[i][j] = 10 * k;
						k += 1;
					}
				}
				
		// 문제 1) 인덱스 2개를 입력받아 값 출력
		// 예    1) 인덱스1 입력 : 1	인덱스2 입력 : 2
		//		   값 출력 : 60 
	
		// 문제 2) 값을 입력받아 인덱스 2개 출력
		// 예    2) 값 입력 : 60
		//		   인덱스1 출력 : 1	인덱스2 출력 : 2

		// 문제 3) 값 2개를 입력받아 교체(방 바꾸기)
	
				
		int[] list = {1, 26, 17, 4, 20, 44, 3};
		//이미 배열(Array)
		//외워 ~ sort(배열명); ~ 외워 
		
		Arrays.sort(list); //오름차순 (내림차도 가능함)
		
		//toString()
		//배열을 출력할 수 있게 밑에 for문처럼 쓸 수 있게
		// 안에 값들을 무나타입으로 정리해 놓았다.
		
		String res = Arrays.toString(list);
		System.out.println(res);
		
		for(int n : list) {
			System.out.println(n);
		}
	}}


