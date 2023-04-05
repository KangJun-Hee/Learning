package Interface;

//인터페이스에서 제어자!

interface B{
	void show();
	default void show2() {
		System.out.println("인터페이스의 default 제어자");
	}
}

class C implements B{

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
}
public class A {

	public static void main(String[] args) {

	}

}
