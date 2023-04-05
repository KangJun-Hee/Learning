package Final;

class Company{
	
	static final String name = "KH회사";
	
	
	//static은 프로그램 시작 전에 이미 메모리에 생성이
	//되기 때문에 상수final이라고 해도 값을 초기화힞
	//못한다.
//	Company(String com){
//		this.name = com;
//	}
	
	//인스턴스 변수
	//String name = "kh회사";

	final void print() {
		System.out.println(name);
	}
	void setInfo(final int temp) {
		//매개변수의 값을 변경 불가
		temp = 10;
		
	}
}

class Company_Sbs extends Company{
	
	//상속은 가능하지만 오버라이딩이 안 된다.
}


//클래스에 final 상속이 안 된다.
//class Company_Sbs extends Company{}


public class Main {

	public static void main(String[] args) {
		
		Company_Sbs cs = new Company_Sbs();
		cs.print();
		
		
		//final 객체
		final Company c = new Company();
		
		//c = new Company();
		//객체를 한 번 생성했다면 재생성 불가능
		//객체 안에 있는 변수는 값을 변경 가능하다
		
		//static final 경우에는 값을 변경 못함.
		//c.name = "m회사";
		
	}

}

//class Person{
//	final int hp = 100;
//	final int age = 0;
//	
//	
//}
//
//class Tank{
//	final int hp;
//	
//	Tank(int hp){
//		this.hp = hp;
//	}
//	@Override
//	public String toString() {
//		return "탱크:" + this.hp;
//	}
//}
//final int num = 10;
//
//Tank a = new Tank(10);
//System.out.println(a);








//상수(final)
//	- 변수처럼 값을 저장하지만 한번 값을 저장하면
//	변경 할 수 없다.
//	- 변수 생성과 동시에 초기화까지 진행되야 된다.
//	- 상속을 했을 때 오버라이딩을 불가능하게 한다.
//	- final class로 설정하면 클래스 상속이
//		불가능하다.

//클래스 안에 final 상수값을 줄 때
//객체를 생성할 때마다 특정한 값으로 초기화해야 할 땐
//생성자