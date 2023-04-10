package GUI;

public class Main {

	public static void main(String[] args) {

		MyFrame my = new MyFrame();
		Thread myt = new Thread(my);
		myt.start();
		
	}

}
