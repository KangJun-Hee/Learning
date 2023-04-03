package Inheritance;

public class Currency {

	int x;
	int y;
	
	@Override
	public String toString() {
		return "Currency [x=" + x + ", y=" + y + "]";
	}
	
	public static void main(String[] args) {
		Currency c = new Currency();
		System.out.println(c);
		
		KRW krw = new KRW(1500.00, "원");
		USD usd = new USD(23.393, "달러");
		EUR eur = new EUR(3243.34, "유로");
		JPY jpy = new JPY(333.32, "엔");
		
		System.out.println(krw);
		System.out.println(usd);
		System.out.println(eur);
		System.out.println(jpy);
		
		
		/*Object 클래스
		 * - 자바는 어떤 클래스던지 Object클래스를
		 * 		자동적으로 상속
		 * - 모든 클래스의 부모클래스!
		 * 
		 *  toString()
		 *  -객체가 가지고 있는 정보나 값들을 문자열로 리턴하는 메서드
		 *  -기본적으로 클래스이름@주소값
		 * 
		 * 
		 * 
		 * 
		 */
		
		
		
		
	}

}
