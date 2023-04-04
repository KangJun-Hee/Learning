package variable;

public class Instance_static_variable {

	public static void main(String[] args) {
		//객체생성은 main에서
		//레퍼런스 변수
		FishBread b1 = new FishBread("팥");
		FishBread b2 = new FishBread("피자");
		FishBread b3 = new FishBread("슈크림");
		FishBread b4 = new FishBread("고구마");
		
		//철판
		FishBread[] 철판 = new FishBread[4];
		철판[0] = b1;
		철판[1] = b2;
		철판[2] = b3;
		철판[3] = b4;
		
		
		//for each문
				//0번 부터 순서대로 b변수에 담기고
				//번까지 반복하고 더 이상 꺼내올 데이터가 없으면
				//반복이 자동으로 종료된다.
		for(FishBread b : 철판) {
			b.print();
		}
		System.out.println("--------");
		System.out.println(FishBread.count);
	}

}
class FishBread{
	//내용물(팥, 치즈, 고구마, 슈크림)
	//인스턴스 변수
	String contents;
	
	//붕어빵 갯수
	//클래스 변수
	static int count;//0으로 자동초기화
	
	FishBread(String c){
		this.contents = c;
		
		//붕어빵 객체 수 카운팅
		FishBread.count += 1;
		
		
	}
	void print() {
		System.out.println(this.contents+"붕어빵");//this. = 안에 있는~
	}
}