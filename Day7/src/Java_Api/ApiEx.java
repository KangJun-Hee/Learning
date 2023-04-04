package Java_Api;

import java.util.Random;


import a.Main;

public class ApiEx {

	public static void main(String[] args) {

		Main as = new Main();
		System.out.println(as);
		as.a = 1000;
		
		
		
		//자바api
		//-프로그램을 만들기 위한 도구!
		//-이를 사용하면 더 편리한 프로그래밍이 가능하다.
		//-자바API는 패키지로 제공된다. 여행패키지처럼
		
		
		//패키지
		//=디렉토리(폴더)
		//-중복적 메서드, 변수, 클래스명 방지하려고~
		
		//import
		//-객체의 위치를 컴파일한테 알려 준다.
		
		
		//역할
		//-관련 코드들을 하나로 묶어서 관리를 수월하게 한다
		
		//Math클래스
		//0.0<=변수 <1
		double r1 = Math.random();
		System.out.println(r1);
		
		//절댓값
		double a = Math.abs(-9.82);
		System.out.println(a);
		
		//max, min
		double m = Math.max(3.14, 12.7);
		System.out.println(m);
		
		//랜덤
		Random r = new Random();
		int a1 = r.nextInt();	//-21억 +21억 사이 숫자
		double a2 = r.nextDouble();//Math.random()
		boolean a3 = r.nextBoolean();
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		
		
		
		/*
		 * 주사위를 100번 던질 것!
		 * 1~6사이의 숫자가 몇번씩 나왔는지 출력
		 * 
		 * 배열
		 * 
		 * 100번을 던지고 나면
		 * 1의 개수:
		 * 2의 개수:
		 * 3의 개수: 
		 */
		
		//배열
		int[] d = new int[6];
		
		System.out.println(d[0]);
		
		for(int i=0; i<100; i++) {
			int index = r.nextInt(6)+1;
			
			//1을 0번째 방에 카운트, 2를 1번째에 카운트
			d[index -1]++; //2를 뽑았으면 하나 뺀다.를 계속 한다
		}
		for(int i=0; i<d.length; i++) {
			System.out.println((i+1)+ "번 개수:" +d[i]);
		}
		
		
		
		
		
		
		
		
		
		//자바 API란
//		자바 API란 미리 만들어진 도구(클래스)이다.
//		자바 API는 패키지를 통해 제공된다.
//		패키지
//		패키지란, 소스코드를 담는 디렉터리이다.
//		패키지는 관련 코드를 묶거나, 같은 이름의 코드를 구분하기 위해 사용한다.
//		자바 API 사용 예
//		자바 API 문서 또는 구글링을 통해 API를 검색한다.
//		학습 시 많이 사용하는 API로 Math, Random, ArrayList 등이 있다.

	}
}
