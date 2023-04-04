
class Parent{
	int money;	//상속금액
	private int amount;	//비상금
	Parent(){
		money = 100000000;
		amount = 100000;
	}
	
	
	int getMoney(String s) {
		if(s.equals("허락")) {
			this.amount = 1000;
			return 1000;
		}else {
			System.out.println("미안하다 내 여생을 즐겨야 된다!");
			return 0;
		}
	}
	void setMoney(int amount) {
		this.amount += amount;
	}
}
class Children extends Parent{
	
}


public class Main {

	public static void main(String[] args) {
		
		//private(비공개)
		//-상속을 한 자식클래스여도 접근이 불가능
		
		//public(공개)
		
		Parent p1 = new Parent();
		System.out.println(p1.money);
		
		Children c1 = new Children();
		System.out.println(c1.money);
		
		Parent p2 = c1;
		c1.getMoney("허락");
	}

}
