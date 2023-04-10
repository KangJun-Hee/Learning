package SuperMario;

public class Main {

	public static void main(String[] args) {
		Mario mario = new Mario("마리오","펀치",1000); 
		Marigee marigee = new Marigee("마리지","폭탄",500); 
		Peach_Princess prin = new Peach_Princess("피치공주","물건던지기", 1000); 

		//Thread 클래스에게 도움요청
		//다른 상속을 받은 클래스들은 Thread한테 객체생성시
		//인터페이스로 구현한 run() 들어있는 객체를 넘겨준다.
		Thread mariot = new Thread(mario);//다형성
		Thread marigeet = new Thread(marigee);//다형성
		Thread print = new Thread(prin);//다형성
		
		mariot.setDaemon(true);
		marigeet.setDaemon(true);
		print.setDaemon(true);

		for(int i=0; i<10; i++) {
			System.out.println("결투중!");
			if(i == 0) {
				System.out.println("쿠파가 죽었다!");
				System.out.println("게임클리어~");
				break;
			}
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//멀티실행(배열)
		mariot.start();
		marigeet.start();
		print.start();
		
		
		
		//마리오,마리지,피치공주,버섯돌이 클래스
		//이름, 목숨, 기본레벨 10
		
		//마리오 300 펀치공격	(35씩 감소) 1초에 한 번
		//마리지 300폭탄공격	(30씩 감소) 0.5초에 한 번
		//피치공주 300물건던지기 공격	(30씩) 1초에
		//버섯도리 300버섯던지기	(35씩) 1.5초에
		
		//쿠파! 쿠파의 목숨은 인스턴스들이 접근할 수 있도록 공유
		//이름, 목숨1000, 기본레벨 30
		//쿠파 불기둥 공격 공격시간 랜덤 30씩
		
		//마리오가 쿠파 965
		//피치	쿠파 935
	}

}
