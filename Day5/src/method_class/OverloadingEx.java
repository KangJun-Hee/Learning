package method_class;
//계산기
class Calc{
	
	//더하는 기능
	
	
	
	
}
public class OverloadingEx {//타입이 중요. 이름 상관무
	public static void add(int a, int b) {
		System.out.println("합:" + (a+b));
	}
	public static void add(double a, double b) {
		System.out.println("실수합:" + (a+b));
	}
	public static void add(int a, double b) {
		System.out.println("정수와 실수 합:" + (a+b));
	}
	public static void main(String[] args) {
		add(1,1);
		add(1.1 , 2.2);
		add(1, 2.25);
		
		
		
		//똑같은 이름의 함수를 여러개 정의할 수 있다.
		
		
		//조건
		//함수명 똑같아야 된다.
		//리턴값은 똑같을 필요 없다.
		//!!!!!단!!!! 매개변수의 개수가 다르거나 매개변수 타입이 달라야 된다.
		
		System.out.println();
		
	}

}
