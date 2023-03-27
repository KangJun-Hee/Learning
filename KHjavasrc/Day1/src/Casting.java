
public class Casting {

	public static void main(String[] args) {
		//형변환
		//명시적(강제적 형변환:프로그래머가)
		
		System.out.println((double)1);
		System.out.println((int)1.353);
		
		//묵시적(자동적 형변환)
		System.out.println(1 + 1.1);
		
		//정수는 실수보다 표현의 범위가 작기에 불가능
		int a = 1.1;
		double b = 10;
		//정+정=정, 실+실=실, 정+실=실
		
		//소수점 자리 표현
		// %f 실수, .6자리
		// %자리수lf, .15자리
		//printf("서식", 값)
		System.out.printf("%f /n", 1.123456);
		System.out.printf("%.5f n", 1.123456);
		System.out.printf("%.4f n", 1.123456);
		System.out.printf("%.3f n", 1.123456);
		
		/*
		 * %d 정수표현
		 * %c 한문자
		 * %s 문자열
		 */
	}

}
