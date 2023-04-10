//몬스터 이름, 몇초마다 "한번씩 출몰한다."
//오크, 오크전사
//2초마다, 5초마다
public class Monster extends Thread{
	String name;
	int time;
	
	Monster(String name, int time){
		
		this.name = name;
		this.time = time;
	}
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			try {
				Thread.sleep(time);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name+", "+time+"초마다 한 번씩 출몰한다.");
		}
	}
}
