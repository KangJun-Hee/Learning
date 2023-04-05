package Abstract;

//프린터 기능을 print 꼭! 구현을 해야된다.
//강제성만 준다.
//추상메서드 : 구현부가 없는 메서드(비정상적 메서드)
//추상클래스 추상메서드가 하나라도 있으면 절대 정상적 클래스 될 수XXX
public abstract class Printer {
	//기능 print
	abstract void print();
}
class Lg_Printer extends Printer{

	@Override
	void print() {
		System.out.println("Lg 프린터");
	}
}
class Samsung_Printer extends Printer{
	//1. 오버라이딩
	@Override
	void print() {
		System.out.println("삼성프린터");
	}
	
	//2. 본인도 비정상적인 메서드를 가지고 있기 때문에
	//		추상클래스되라!
}
