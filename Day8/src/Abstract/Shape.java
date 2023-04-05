package Abstract;

public class Shape {
	
abstract class s{
	//도형 클래스
	// draw() 메서드를 추상화한다.
	// 정삼각형을 그린다.
	// 정사각형을 그린다.
	// 원을 그린다.
	// 선을 그린다.
	abstract void draw();
}
class Triangle extends s{
	@Override
	void draw() {
		System.out.println("정삼각형을 그린다.");
	}
}
class Squre extends s{
	@Override
	void draw() {
		System.out.println("정사각형을 그린다.");
	}
}class Round extends s{
	@Override
	void draw() {
		System.out.println("원을 그린다.");
	}
}class Line extends s{
	@Override
	void draw() {
		System.out.println("선을 그린다.");
	}
}
}