package Override;

public class Main {

	public static void main(String[] args) {
		Squre s = new Squre();
		s.name = "정사각형";
		int x = 3;
		s.Area(x);
		System.out.println(x);
		//클래스 shape
		//멤버변수 name
		//멤버메서드 area
		//			return double
		//클래스로 사용? 매개변수 맘대로 쓰든말든
		
		//정사각형은 도형 shape에게 상속받
		//squre 클래스이름
		//멤버 변수: 한 변의 길이 변수명
		//area 오버라이딩해서 넓이 구하시오!
		
		//삼각형 "
		//" triangle
		//밑변, 높이 멤버변수
		//area 오버라이딩
		
		//원 "
		//" circle
		//반지름 멤버변수
		//area 오버라이딩해서 넓이 구하시오!
		
		//위에있는 아이들의 그룹(업캐스팅)배열을 이용
	}

}
