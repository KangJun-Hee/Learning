package variable;

class Hotel{

	static String master_key = "마스터 키 여깃다 짜샤";
	
	//투숙객마다 방번호랑 예약한 사람의 이름
	static Hotel_Cut[] list = new Hotel_Cut[10];
	
	//투숙객들의 정보를 교환
	static void ch() {}
}
class Hotel_Cut{
	
	//클래스 객체가 생성 될 때마다 변수를 만든다.
	//객체 안에 변수가 여러개 생긴다.
	//인스턴스 변수
	String name;	//이름
	int roomNumber;	//방번호
}
//변수의 크기가 유동적(크거나 작거나 변경이 많이 된다.)
// heap영역 - 프로그램이 시작하고 나서 변수를 선언

//stack 영역 - 프로그램 시작 전에 변수를 저장하는 공간
// 변수의 크기가 고정되어 있음. 중괄호 시작되고 중괄호 끝나면
// 삭제된다.

//static영역
//	프로그램이 끝날 때까지 전역변수 데이터가 유지!
//	중복적인 이름은 쓸 수 없다.

public class Main {

	public static void main(String[] args) {
		//접근 방법 즉 one1 참조변수
		Hotel_Cut one1 = new Hotel_Cut();
		one1.roomNumber = 1001;
		
		Hotel_Cut one2 = new Hotel_Cut();
		one2.roomNumber = 1002;
		
		//static 객체를 생성할 필요가 없음!
		//접근 방법
		//Hotel hotel = new Hotel();
		System.out.println(Hotel.master_key);
		
	}

}
class Mon{
}