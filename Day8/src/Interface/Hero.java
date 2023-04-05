package Interface;

//static 인터페이스명.상수에 접근가능.
public class Hero {
	//체력 public static final 생략
	int MAX_HP = 100;
	
	//공격력
	void attack();
	//치료(힐)
	void heal(int portion);
}
