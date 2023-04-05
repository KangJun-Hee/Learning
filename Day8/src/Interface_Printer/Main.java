package Interface_Printer;


public class Main {

	public static void main(String[] args) {

		//흑백 프린터 잘 사용
		SamsungPrinter seohee = new SamsungPrinter();
		LgPrinter jihee = new LgPrinter();
		
		Lg3D_Printer hee = new Lg3D_Printer();
		//hee 참조할 수 있는 타입 모두?
		//Sam3D_Printer, Print3D, PrintClour, Three_dimensional,
		//Object
		
		Print3D p1 = hee;
		boolean res = p1 instanceof Print3D;
		System.out.println(res);
		
		res = jihee instanceof Print;
		
	}

}
//public abstract class Printer {
//	//기능 print
//	abstract void print();
//}
//class Lg_Printer extends Printer{
//
//	@Override
//	void print() {
//		System.out.println("Lg 프린터");
//	}
//}
//class Samsung_Printer extends Printer{
//	//1. 오버라이딩
//	@Override
//	void print() {
//		System.out.println("삼성프린터");
//	}
	
	//2. 본인도 비정상적인 메서드를 가지고 있기 때문에
	//		추상클래스되라!
