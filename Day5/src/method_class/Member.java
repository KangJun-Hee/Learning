package method_class;

import java.util.Random;
import java.util.Scanner;

class Objection{
	String ob;
	int pay;
	
	public Objection(String _ob, int _pay) {
		
		ob = _ob;
		pay = _pay;
	}	
}

public class Member {

	public static void trainPrint(Objection o) {
		System.out.println("----예매 정보----");
		System.out.println("목적지 : " + o.ob);
		System.out.println("운임비 : " + o.pay);
	}

	
	public static void main(String[] args) {
	 
		// 수원
		// 광주
		// 대전
	
		Objection h1 = new Objection("수원", 3000);		
		Objection h2 = new Objection("광주", 35000);
		Objection h3 = new Objection("대전", 25000);
		
		// 배열 
		//  나란하게 선언 (접근이 쉽다. 인덱스번호로 접근)
		
		// 내가 만든 클래스로 여러개를 저장 
		// 배열은 클래스명[개수] 기본타입[개수] 만큼 변수를 묶었다.(똑같은 자료형)
		Objection[] list = new Objection[3];
		
		// h1변수의 주소값을 list 배열의 0번 방에 저장 
		list[0] = h1;
		
		// h1으로 접근을 했을 때 수원
		// list[0] 접근을 했을 때 수원
		
		System.out.println(h1.ob);   
		System.out.println(list[0].ob);
		
		//h2 ->list[1] 저장해서 ob출력
		list[1] = h2;
		System.out.println(list[1].ob);
		
		//h3 =>list[2] 저장해서 ob출력
		list[2] = h3;
		System.out.println(list[2].ob);
	}
}







//class User{
//	int id;
//	int pw;
//	
//}
//클래스 끝
//자바가 만들어 준 api
//		Random r = new Random();
//		Scanner sc = new Scanner(System.in);
//		
//		
//		//내가 만든 클래스
//		//User 1111 2222
//		User u1 = new User();//{id: 0 pw: 0}
//		u1.id = 1111;
//		u1.pw = 2222;


//변수 int -> 매개변수 int
	//double -> 매개변수 double
	//클래스 . 클래스타입으로 매개변술ㄹ 만들어 준다.

//public static void info(User _u1) {//변수이름신경 ㄴㄴ
//	System.out.println("---kh user---");
//	System.out.println(_u1.id);
//	System.out.println(_u1.pw);
//}
//public static void funt1(Random _r) {
//	
//}
//public static void funt2(Scanner _sc) {
//	
//}







//class Movie{
//	String movie_name; //영화명
//	String movie_time;	//상영시간
//}
//메서드 이름을 만들 때 두 단어 중 뒤에 오는 첫 글자 대문자!암묵적규칙
//	public static void moviePrint(Movie m) {
//		System.out.println("영화 제목:" + m.movie_name);
//		System.out.println("영화 시간:" + m.movie_time);
//	}
//웅남이 98분
//Movie m = new Movie();
//m.movie_name = "웅남이";
//m.movie_time = "98분";
//
////존윅4 130분
//Movie m2 = new Movie();
//m2.movie_name = "존윅4";
//m2.movie_time = "130분";
//moviePrint(m2);






//Objection b = new Objection();
//		b.loc = "Busan";
//		b.charge = "40000";	
//		
//			
//		System.out.println("----- 예매");
		//Objection 클래스(목적지 클래스)
		//String 목적지, int 운임비;
		//대구 25000
		//부산 40000
		
		//새로운 변수를 각각 만들어서
		
		//trainPrint
		//매개변수로는 objection 타입의 변수 저장
		//return void (없다)
		
		//----- 예매 정보 -----
		//	목적지 : 대구			부산
		//	운임비 : 25000		40000





//public class Member {
//	public static Objection objectInput() {
//		Scanner sc = new Scanner(System.in);
//		//춘천 5000
//		System.out.println("목적지와 운임비를 입력하세요");
//		String loc = sc.nextLine();
//		int charge = sc.nextInt();
//		
//		Objection o = new Objection();
//		o.loc = loc; //클래스변수안에 ob변수에 내가 입력받은 ob변수를 저장
//		o.charge = charge;
//		
//		return o;
//	}

//함수를 실행하면 목적지 객체 생성되서 온다.
//Objection o1 = objectInput();
//System.out.println(o1);

//열차정보 출력하는 함수
//trainPrint(o1);