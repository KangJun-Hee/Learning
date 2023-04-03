package Inheritance;
class 포켓몬{//부모클래스
	//포켓몬의 공통적 부분을 묶는다.
	String name;
	int hp;
	String type;
	double wei;
	
	void attack() {
		System.out.println("펀치!");
	}
}
class 꼬부기 extends 포켓몬{//자식클래스
	
	void 물대포() {}
}
class 어니부기 extends 꼬부기{
	
	void 두배는강한물대포() {}	//어니부기만의 특별한 기능
}
class 거북왕 extends 어니부기{
	
	void 폭포공격() {}			
}
class 캐릭터{
	
	String id;
	int 목숨;
	int 마법력;
	int 민첩;
	int 힘;
	
	void attack() {
		System.out.println("기본 공격!");
	}
	
}
class 마법사 extends 캐릭터{
	
}
class 바드 extends 마법사{
	void 힐() {
		
	}
}
class 아르카나 extends 마법사{
	
	void 카드() {	}
}
class 전사 extends 캐릭터{
	
}






public class InheritanceEx01 {

	public static void main(String[] args) {

		꼬부기 서희꼬부기 = new 꼬부기();
		어니부기 서희어니부기 = new 어니부기();
		
		서희꼬부기.hp = 100;
		서희꼬부기.name = "꼬부기";
		
		//상속
		// - 기존클래스를 확장하여 새 클래스를 만든다.
		// - 물려 받는다.
		// - 공통되는 클래스들의 내용을 묶는다.
		
		// class 클래스명 extends 기존 클래스명
		
		//장점
		// - 코드 중복 제거
		// - 프로그램 확장성 좋다
		
		
		
		//히어로 클래스 상속
		class heros{
			String name;
			int age;
			double hei;
			double wei;
			String b;
			
			void eat() {};
			void play() {};
			void sleep() {};
		}
		//메서드
		//캡틴 => 방패공격()
		//아이언맨 => 한손공격()
		//헐크 =>초록공격()
		//위도우 = 암살()
		class cap extends heros{
			void shild() {};
		}
		class iron extends heros{
			void hand() {}
		}
		class hulk extends heros{
			void green() {}
		}
		class widow extends heros{
			void kill() {}
		}
		
		
		
		//Person 클래스
		//이름, 나이 , 키, 몸무게, 혈액형
		//먹다. 놀다. 잔다.
		
		
		
		
		
		
		
	}

}
