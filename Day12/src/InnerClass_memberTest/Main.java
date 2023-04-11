package InnerClass_memberTest;

class jojyk{
	class doubles{
		void add(int a) {}
		int get() {}
	}
}

public class Main {

	public static void main(String[] args) {
		jojyk out new Outer();
		
		jojyk.doubles o1 = out.new doubles();
		
		o1.add(32);
		System.out.println(o1.get());
		
	}

}
