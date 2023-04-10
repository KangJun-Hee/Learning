package SuperMario;

public class Mario extends Character implements Runnable{

	public Mario(String name, String 공격명,int time) {
		super(name, 공격명,time);
				
	}
	@Override
	void attack() {
		System.out.println(this.공격명 + "공격합니다.");
	}
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(this.time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			attack();
			Coopa.hp -=35;
		}		
	}	
}
