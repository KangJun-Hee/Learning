package SuperMario;


//스레드는 인터페이스
public class Character {
	String name;        // 캐릭터명
	int time;           // 공격시간
	int hp = 300;       // 목숨
	String 공격명;       // 공격이름
	int level = 10;
	
	public Character(String name,String 공격명,int time) {
		this.name = name;
		this.공격명 = 공격명;
		this.time = time;
	}
	//공격 
	void attack() {}	
}
