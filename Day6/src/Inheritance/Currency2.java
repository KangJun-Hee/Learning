package Inheritance;

public class Currency2 {
	//수량 amount
	//표기법(원, 유로, 엔)
	
	double amount;
	String notation;
	
	Currency2(double amount, String notation){
		this.amount = amount;
		this.notation = notation;
	}
}
class KRW extends Currency2{

	KRW(double amount, String notation) {
		super(amount, notation);
	}
	@Override
	public String toString() {
		//객체의 정보를 문자열로 반환
		//String 클래스 안에 format()함수를 이용해서!
		return String.format("KRW: %.2f %s", amount, notation);
	}
}
class USD extends Currency2{

	USD(double amount, String notation) {
		super(amount, notation);
	}
	@Override
	public String toString() {
		return "USD:"+ amount + notation;
	}
}
class EUR extends Currency2{

	EUR(double amount, String notation) {
		super(amount, notation);
	}
	@Override
	public String toString() {
		return "EUR:"+ amount + notation;
	}
}
class JPY extends Currency2{

	JPY(double amount, String notation) {
		super(amount, notation);
	}
	@Override
	public String toString() {
		return "JPY:"+ amount + notation;
	}
}
