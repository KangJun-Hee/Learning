package Thread_synchronized;





public class Main {

	public static void main(String[] args) {

		//스레드 동기화
		// - 멀티스레드 환경에서 여러 스레드가 하나의 공유자원에 동시에
		// 	 접근 못하게 막는 것!
		
		Washroom wr = new Washroom();
		
		FamilyThread father = new FamilyThread("아빠",wr);
		FamilyThread mother = new FamilyThread("엄마",wr);
		FamilyThread sister = new FamilyThread("여동생",wr);
		FamilyThread me = new FamilyThread("나",wr);
		
		father.start();
		mother.start();
		sister.start();
		me.start();
	}

}

//계좌만들기
//계좌의 주인이 있다.
//