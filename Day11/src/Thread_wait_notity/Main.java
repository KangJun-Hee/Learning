package Thread_wait_notity;

public class Main {

	public static void main(String[] args) {

		final Dish d = new Dish();
		new Thread(new Coustomer(d)).start();
		new Thread(new Cook(d)).start();
		
//		Coustomer s = new Coustomer(d);
//		Thread st = new Thread(s);
//		st.start();
	}

}
