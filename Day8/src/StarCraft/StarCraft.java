package StarCraft;

// 빈 인터페이스 
// marker interface 
//  상속관계가 아닌 클래스들을 그룹화 시켜줄 수있다.
interface Repairable{}//기계들만 표시



public class StarCraft {}

class 테란 extends StarCraft{}
class 저그 extends StarCraft{}
class 프로토스 extends StarCraft{}

abstract class Unit{
	// 공격성을 가진 아이들을 모두 유닛!
	final int maxhp;
	public int hp;
	int x,y;
	
	Unit(int maxhp){
		this.maxhp = maxhp;
		this.hp = maxhp;		
	}	
	
	abstract void attack();	 // 공격
	abstract void move();   // 이동
}
class Dropship extends Unit implements Repairable{

	Dropship(int maxhp) {super(maxhp);}

	@Override
	void attack() {}

	@Override
	void move() {} // 군인,기계 옮겨주고 싸움
	
}
class Tank extends Unit implements Repairable{

	Tank(int maxhp) {super(maxhp);}
	@Override
	void attack() {}
	@Override
	void move() {} 
}

class Marine extends Unit{ 	
	
	Marine(int maxhp) { super(maxhp);}
	
	@Override
	void attack(){}

	@Override
	void move() {}	
}

class Doctor extends Unit implements Medical{
	Doctor(int maxhp) {
		super(maxhp);
	}

	void heal(Unit u) {
		boolean res = u instanceof Medical;
		//System.out.println(res);
		if(!res) {//기계가 들어왔다. 밑에 고치는기능 실행필요 없다!
			System.out.println("나는 사람고치는 의사다! 로봇은 못 고침.");
			return;
		}
		while(u.hp <= u.maxhp) {//각자 최대피가 다르니까 숫자안됌.
			System.out.println(u.hp++);
			
			try {Thread.sleep(1);
			} catch (InterruptedException e) {}
			// 프로그램을 지연시키는 함수
			//sleep(ms)1초=1000, 0.5초=500
		}
		System.out.println("수리 완료!");
		System.out.println("사람만 고친다.");
	}

	@Override
	void attack() {}

	@Override
	void move() {}
}

//기계만 고친다
class SCV extends Unit implements Repairable{

	SCV(int maxhp) {
		super(maxhp);
	}

	@Override
	void attack() {}

	@Override
	void move() {}
	
	//기계만 고쳐야 한다.
	//자식클래스가 tank 안에는 유닛과 repairable이 들어있다.
	//자식입장에서는 타입을 변환가능
	void repair(Repairable r) {
	
		Unit u = (Unit)r;
		
		while(u.hp <= u.maxhp) {//각자 최대피가 다르니까 숫자안됌.
			System.out.println(u.hp++);
			
			try {Thread.sleep(1);
			} catch (InterruptedException e) {}
			// 프로그램을 지연시키는 함수
			//sleep(ms)1초=1000, 0.5초=500
		}
		System.out.println("수리 완료!");
}}







/*
 * 
 * 

public class StarCraft {
	
	// 3개의 그룹 
	// 테란, 저그, 프로토스 
	
	// 탱크 수송선 군인
	public Tank t = new Tank(1000);
	public Marine m = new Marine(100);
	public Dropship g = new Dropship(2000);
	
	public void show() {
		System.out.println("탱크:"+ t.hp);
		System.out.println("군인:"+ m.hp);
		System.out.println("수송선:" + g.hp);
		
	}
}

// 인터페이스 
class 테란 extends StarCraft{}
class 저그 extends StarCraft{}
class 프로토스 extends StarCraft{}

abstract class Unit{
	// 공격성을 가진 아이들을 모두 유닛!
	final int maxhp;
	public int hp;
	int x,y;
	
	Unit(int maxhp){
		this.maxhp = maxhp;
		this.hp = maxhp;		
	}	
	
	abstract void attack();	 // 공격
	abstract void move();   // 이동
}
class Dropship extends Unit {

	Dropship(int maxhp) {
		super(maxhp);	
	}

	@Override
	void attack() {
		}

	@Override
	void move() {
		
	} // 군인,기계 옮겨주고 싸움
	
}
class Tank extends Unit{

	Tank(int maxhp) {
		super(maxhp);
	
	}
	@Override
	void attack() {
				
	}
	@Override
	void move() {
				
	} //탱크
}


class Marine extends Unit{ 
	
	Marine(int maxhp) {
		super(maxhp);	
	}

//군인

	@Override
	void attack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void move() {
		// TODO Auto-generated method stub
		
	}	
}





 * 
 * 
 * 
 * 
 * 
 */







//public class StarCraft {
//
//	//3개의 그룹
//	//테란, 저그, 프로토스
//	
//	//탱크, 수송선, 군인
//	//다른 곳에서 생성하고 싶을 때 public붙여라
//	public Tank t = new Tank(1000);
//	public Marine m = new Marine(100);
//	public Dropship d = new Dropship(2000);
//	
//	public void show() {
//		System.out.println("탱크:"+t.hp);
//		System.out.println("군인:"+m.hp);
//		System.out.println("수송선:"+d.hp);
//		
//	}
//	
//}
//
////인터페이스
//class 테란 extends StarCraft{}
//class 저그 extends StarCraft{}
//class 프로토스 extends StarCraft{}
//
//abstract class Unit{
//	//공격성을 가진 아이들 모두 유닛!
//	final int maxhp;
//	public int hp;
//	int x,y;
//	
//	Unit(int maxhp){
//		this.maxhp = maxhp;
//		this.hp = maxhp;
//	}
//	
//	abstract void attack();	//공격
//	abstract void move();	//이동
//}
//
//class Dropship extends Unit{ //군인, 기계 옮겨주고 같이싸움
//
//	public Dropship(int maxhp) {
//		super(maxhp);
//	}
//	@Override
//	void attack() {
//		
//	}
//	@Override
//	void move() {}
//}
//class Tank extends Unit{ //탱크
//
//	public Tank(int maxhp) {
//		super(maxhp);
//	}
//	@Override
//	void attack() {
//		
//	}
//	@Override
//	void move() {}
//}
//class Marine extends Unit{ //군인
//
//	public Marine(int maxhp) {
//		super(maxhp);
//	}
//	@Override
//	void attack() {
//		
//	}
//	@Override
//	void move() {}
//}