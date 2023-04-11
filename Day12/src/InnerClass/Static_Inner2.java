package InnerClass;

class Outer{//외부 클래스!
	private static int num = 0;
	
	static class Nested1{//내부클래스
		void add(int n) {num += n;}
	}
	static class Nested2{//내부클래스
		int get() {return num;}
	}
}
public class Static_Inner2 {

	public static void main(String[] args) {

		//static
		Outer.Nested1 nst1 = new Outer.Nested1();
		nst1.add(5);	//내부에 있는 클래스!
		
		Outer.Nested2 nst2 = new Outer.Nested2();
		int num = nst2.get();
		System.out.println(num);
		
		
		//단! static은 static 제어자가 붙은 메서드, 변수, 클래스에
		//서만객체 호출,객체 수정변경, 생성할 수 있다.
	}

}
