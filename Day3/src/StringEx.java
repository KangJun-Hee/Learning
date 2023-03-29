import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class StringEx {

	public static void main(String[] args) {

		String[] arr = {
				"건강식", "변비", "ADHD", "공사장", "영어", "개발자"
		};
		//배열을 정렬
		Arrays.sort(arr);
		
		//toString()
		System.out.println(Arrays.toString(arr));
		
		//기준이 되는 변수값.compareTo(비교할 값)
		//숫자일 때(기본자료형X Integer)
		/*
		 * 비교했을 때 같으면 0이 온다.
		 * 
		 * 다르면 기준이 되는 값이 비교하는 값보다 크다 = 1(양수)가 온다.
		 * 			"					작다. = -1(음수)가 온다.
		 */
		//문자일 때
		//비교했을 때 같으면 0이 온다.
		//			다르면, 비교값이 작으면 음수(-1)
		//			다를 때 비굣값이 크면 양수(1)
		
		//다르면 문자의 개수만큼 리턴
		//
		
		String str1 = "가";
		String str2 = "나";
		String str3 = "가";
		
		int res1 = str1.compareTo(str2);//음수(가가 나보다 작으니까= 가랑 나는 다르다, 비굣값인
		System.out.println(res1);
		
		int res2 = str2.compareTo(str1);//양수(나가 가보다 크니까)
		System.out.println(res2);
		
		int res3 = str1.compareTo(str3);//0 같으니까
		System.out.println(res3);
		
		
		//"hello"
		String str = "hello";
		System.out.println(str);
		//문자 한 개 추출 chatAt(방번호)
		char ch = str.charAt(3);
		System.out.println(ch);
		
		ch = str.charAt(1);
		System.out.println(ch);
		
		ch = str.charAt(2);
		System.out.println(ch);
		
		str = "python java html jsp spring";
		
		//문자 여러개를 추출(슬라이싱)
		//substring(시작번호, 끝번호)
		String res = str.substring(7,11);
		System.out.println(res);
		
		str = "python,java,html,jsp,spring";
		//구분자를 이용해서 잘라내기
		//split('구분자')
		//구분자를 이용해 배열형태로 저장이 되어 온다.
		
		String[] arr2 = str.split(",");
		System.out.println(arr2[0]);
		
		//길이확인 length() 함수
		//System.out.println(str.length());
		
		String jumin = "890101-2012932";
		//문제 1) 성별 출력
		//정답 1) 여성
		String[] jm = jumin.split("-");
		System.out.println(jm[1]);
		
		System.out.println(jm.length);
		int j = jm.length;
		if(j == 2) {					
			System.out.println("여성");
		}else {
			System.out.println("남성");
		}
		

				

		
		
		
		
		
		
		
		
		//이메일을 입력 받는다.
		//empress8069@gmail.com
		//9글자 이상 "가입이 가능하다."
		//9글자 미만 "가입이 불가능합니다."
		//구분자를 이용해서 아이디와 도메인주를 분리
		//.com 또는 .net 끝나니?
		//"정상적으로 가입이 가능하다"
		//"정상적으로 가입할 수 없습니다."
		
		Scanner sc = new Scanner(System.in);
		System.out.println("이메일: ");
		String em = sc.next();
	}

}
