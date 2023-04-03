package Inheritance_Car;

public class Main {

	public static void main(String[] args) {
		//현대자동차
		//브랜드명
		
		//차명
		//최대속력
		//등급
		//색상
		
		//기능
		//주행한다
		//브레이크
		//후진한다
		
		//아반떼 흰색 소형 현대자동차 200
		//그랜저 회색 대형 현대자동차 260
		//제네시스 검은색 대형 현대자동차 300
		//	안마기능()
		avan a = new avan();
		System.out.println(a.brand);
		a.colour = "wh";
		a.speed = 200;
		a.size = "sm";
		a.model = "아반떼";
		
		gran g = new gran();
		g.colour = "gr";
		g.speed = 260;
		g.size = "bg";
		g.model = "그랜저";
		//부모클래스에서 상속해 준 변수 메서드
		//이미 자식클래스 안에 만들어져 있다.
		//자식은 부모클래스 안에 있는 내용을
		//언제든지 가져다가 쓸 수 있다.
		
	}

}
