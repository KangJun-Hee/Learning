package SuperMario;

public class Marigee extends Character implements Runnable{

	public Marigee(String name, String 공격명,int time) {
		super(name, 공격명,time);
		
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(this.time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(this.공격명+"공격!");
			Coopa.hp -=30;
		}
	}

}
