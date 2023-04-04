package a;

//클래스의 접근 제어자 기본설정
//default -> 같은 폴더에서는 객체 생성이 가능
//다른 폴더에서는 객체생성 불가능
class A_default{
	
}



public class Main {

	public int a;
	private int b;
	int c;	//default 생략 가능 같은 폴더에서만 접근이 가능
	
	//접근성 private
	//조건 public class에 extends클래스명
	//상속해서 객체 생성을 하면 접근이 가능하다
	
	//접근 제어자
	//기본값:같은 폴더에서만 접근이 가능하다.
	//default 제어자 안 붙임.
	public static void main(String[] args) {

	}

}
