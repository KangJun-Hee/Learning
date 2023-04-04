package Override;

public class Main_Coffee {

	public static void main(String[] args) {
		Coffee c = new Coffee();
		c.name = "아메리카노";
		c.ordered(null);
		
		Tea t = new Tea();
		t.name = "허브";
		t.ordered(null);
		
		Juice j = new Juice();
		j.name = "오렌지";
		j.ordered(null);
	}

}
