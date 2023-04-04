package Override;

class Drink{
	String name;
	int price;
	
	String ordered(String s) {
		System.out.println(name + "가 주문되었습니다.");
		return s;
		
	}
}
class Coffee extends Drink{
	String ordered(String s) {
		System.out.println(name+ "커피가 주문되었습니다.");
		return s;
	}
}
class Tea extends Drink{
	String ordered(String s) {
		System.out.println(name+ "티가 주문되었습니다.");
		return s;
	}
}
class Juice extends Drink{
	String ordered(String s) {
		System.out.println(name+ "주스가 주문되었습니다.");
		return s;
	}
}


public class Coffee_home {
	//주문서 (여러개의 객체를 관리하는 배열)
	String[] menulist = new String[];
	
}

