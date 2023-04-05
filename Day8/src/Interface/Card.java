package Interface;

public abstract class Card {//추상이니 객체생성불가
	String cardName;	//카드명
	private String cardNumber;	
	private String cardPw;
	private int cvc;

	abstract void pay();
	abstract void save();
	
	//setter, getter
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardPw() {
		return cardPw;
	}
	public void setCardPw(String cardPw) {
		this.cardPw = cardPw;
	}
	public int getCvc() {
		return cvc;
	}
	public void setCvc(int cvc) {
		this.cvc = cvc;
	}

}
//쇼핑, 주유, 적립, 영화할인, 놀이동산할인
interface Shopping{
	void shop();	//퍼센트 다 다르니까 만들 떄마다 할 거라 여기 안 씀
}
interface Gas{
	void gas();	
}
interface Movie{
	void movie();
}
interface Pack{
	void pack();
}

class Hyundai_Card extends Card implements Shopping, Gas{

	//위에 추상이니까 오버라이드해라
	@Override
	void pay() {
		System.out.println("현대카드결제");
	}

	@Override
	void save() {
		System.out.println("현대카드적립");
	}

	@Override
	public void gas() {
		System.out.println("현대카드로 주유시 10%할인");
	}

	@Override
	public void shop() {
		System.out.println("현대카드로 쇼핑시 5%추가 할인및적립");
	}
	
}

//삼성카드
//	- 놀이동산기능 5호 무료입장가능!
class Samsung_Card extends Card implements Pack{

	@Override
	public void pack() {
		System.out.println("놀이동산기능 5회 무료입장가능!");
	}

	@Override
	void pay() {
		System.out.println("삼성카드결제");		
		
	}

	@Override
	void save() {
		System.out.println("삼성카드적립");
	}
	
}
//롯데카드
//	- 쇼핑, 주유, 영화, 놀이동산 기능 추가
class Lotte_Card extends Card implements Shopping, Gas, Movie, Pack{

	@Override
	public void pack() {
		System.out.println("놀이동산5회무료");
	}

	@Override
	public void movie() {
		System.out.println("영화가 공짜~~");
	}

	@Override
	public void gas() {
		System.out.println("주요소 결제! 5퍼할인~");
	}

	@Override
	public void shop() {
		System.out.println("롯데카드로 결제 10퍼 할인~");
	}

	@Override
	void pay() {
		System.out.println("롯데카드로 결제 1+1~");
	}

	@Override
	void save() {
		System.out.println("롯데카드 1000원 적립~");
	}
	
}