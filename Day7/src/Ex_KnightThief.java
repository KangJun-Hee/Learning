
public class Ex_KnightThief {

	public static void main(String[] args) {
	    // 기사 객체 생성 및 초기화
	    Knight knight = new Knight();
	    knight.name = "아서스";
	    knight.hp = 180;
	    knight.strength = 50;

	    // 도적 객체 생성 및 초기화
	    Thief thief = new Thief();
	    thief.name = "발리라";
	    thief.hp = 120;
	    thief.agility = 40;

	    // 업 캐스팅 - 부모 타입으로 객체를 해석
	    Adventurer adv0 = knight;
	    Adventurer adv1 = thief;

	    // 모험가들의 배열 생성
	    Adventurer[] advs = { adv0, adv1 };
	    
	    // 모든 모험가의 정보 출력
	    for (int i = 0; i < advs.length; i++) {
	      System.out.println(advs[i].toString());
	    }
	  }//main 끝
	}//public class끝

	/* 1. 부모 클래스 Adventurer를 만드세요. */
	class Adventurer {
	  /* 1.1 공통 필드를 선언하세요. */
	  String name;
	  int hp;
	  
	  /* 1.2 공통 메소드를 작성하세요. */
	  public void punch() {
		    System.out.printf("[%s]의 펀치!!\n", name);
		  }
	  public String toString() {
		    return String.format("[%s] HP: %d", name, hp);
		  }

	/* 2. Knight를 Adventurer의 자식 클래스로 정의하세요. */
	class Knight extends Adventurer{
	  /* 2.1 부모와 중복된 필드를 제거하세요. */
	  int strength; // 힘

	  /* 2.2 부모와 중복된 메소드를 제거하세요. */
	  public void berserker() {
	    System.out.println("체력과 공격력이 증가합니다.");
	  }
	}

	/* 3. Thief를 Adventurer의 자식 클래스로 정의하세요. */
	class Thief extends Adventurer{
	  /* 3.1 부모와 중복된 필드를 제거하세요. */
	  int agility; // 민첩

	  /* 3.2 부모와 중복된 메소드를 제거하세요. */
	  public void sharpen() {
	    System.out.println("크리티컬 확률이 증가합니다.");
	  }
	}
	}
