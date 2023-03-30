import java.awt.Image;

//주민등록증 자료형 만들거
//class
class 주민등록증{//틀 new int[6]랑 비슷.
	
	String 이름;
	String 주민번호;
	String 주소;
	String 발급기관;
	int 발급일자;
	Image 사진;
}
class 카드{
	String 카드번호;
	String 카드명;
	String 소유자;
	int cvc;
	String 등급;
	
}
class Parking{
	String num;
	String in;
	String out;
	String charge;
	String per;
}



/*
		 * 학생 클래스 만들기(정의)
		 * 이름, 생년월일, 주소, 핸드폰번호, 성별
		 */
class student{
	String name;
	String birth;
	String adrs;
	int phone;
	String s;
}

public class ClassEx01 {

	public static void main(String[] args) {

		//사용자(개발자) 정의 자료형
		//기본자료형 int, float, double, char
		
		//프로그래머가 프로그램에 맞게 다양한 기존 자료형으로
		//새로운 자료형을 만든다.
		//-타입이 다른 자료형을 묶는다.
		
		//배열은 '동일한' 자료형(데이터 타입) 여러개를 선언
		//클래스는 '다른' 자료형으로 여러개를 선언
		
		//객체
		//-클래스를 통해 만들어진 프로그램의 구성요소
		
		//클래스 멤버
		//-필드(정보/ 상태)
		//-메서드(기능/ 동작)
		
		//객체 지향 프로그래밍
		//-조립식 프로그래밍
		//ex)자전거(프로그램) = 몸체(객체) + 바퀴 + 핸들 + etc...이런 게 (클래스)=부품
		
		//조립식 프로그램의 장점
		//-재활용성(재사용)이 높다. 부품들로 이루어져 있으니까.
		//-확장성
		//-관리 쉽다.
		
		/*
		 * # 클래스
		 * 1. 정의(설계도)
		 * 	1) class	: 키워드
		 * 	2) Ex01		: 클래스명
		 * 	3) {}		: 자료형의 영역(기본 자료형을 조합해 생성)
		 * 2. 선언
		 * 	1) 자료형	 변수명  = new 자료형();	
		 *  2) Ex01  e    = new Ex01(); 
		 */
		
		
		

}
}