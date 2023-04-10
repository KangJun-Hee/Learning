
//데몬스레드
// - main 스레드가 끝나면 나머지 스레드들도 모두 종료하게 만드는
// setDaemon(값)		true : main스레드가 종료하면 종료
//					false : main과 상관없이 실행된다.
//		ex) 게임 속 배경음악

class Music extends Thread{
	@Override
	public void run() {
		while(true) {
			try {
				sleep(200)}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}System.out.println();
			}
	}
}}

public class Main {

	public static void main(String[] args) {
		//뮤직클래스 생성
		Music m = new Music();
		
		//데몬스레드 설정은 무조건 start() 전!
		m.setDaemon(true);
		m.start();
		
		for(int i=0; i<10; i++) {
			System.out.println("신나게 게임중!");
			if(i == 9) {
				System.out.println("앗! 엄마다!");
				System.out.println("게임을 종료합니다~!");
				break;
			}
			try {
			Thread.sleep(200);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
