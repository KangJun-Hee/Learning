package Thread_synchronized;

public class FamilyThread extends Thread {//집에 화장실 하나 밖에 없다.

	private Washroom wr;//
	private String who;
	
	public FamilyThread(String name, Washroom wr) {
		this.wr = wr;
		this.who = name;
	}
	@Override
	public void run() {
			wr.openDoor(who);
	}
}
