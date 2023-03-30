package SuperMario;

import java.util.Random;

//슈퍼마리오, 쿠파
class Character1{
	
	public Character1(String _name, int _hp) {
		name = _name;
		hp = _hp;
	}

	String name;
	int hp; //목숨
	
	//기본생성자
	Character1(){}
	
	//기능(싸우는)
	void attack(Character1 ch) {//공격한 대상 말고 맞는 대상을 attack()
		System.out.println(this.name + "불주먹공격!");
		ch.hp -= 50;
		System.out.println(ch.name + "의 hp가 " + ch.hp);
	}
}







public class Main {

	public static void main(String[] args) {

		//마리오 객체 생성
		//150
		
		Character1 mario = new Character1("마리오", 150);
		Character1 coopa = new Character1("쿠파", 300);
		Character1 luigi = new Character1("루이지", 150);
		Character1 peach = new Character1("피치공주", 150);

		//우리는 한 팀!
		Character1[] team = new Character1[3];
		//피치 , 마료루이지 각각 저장
		team[0] = mario;
		team[1] = luigi;
		team[2] = peach;
		
		//마리오 -> 루이지 -> 피치공주 공격
		team[0].attack(coopa);//마리
		team[1].attack(coopa);//루이
		team[2].attack(coopa);//피치

		//랜덤값을 이용해서 
		Random r = new Random();
		int idx = r.nextInt(3);
		coopa.attack(team[idx]);
		
		
		//공격~
		
		coopa.attack(mario);
		luigi.attack(coopa);
		peach.attack(coopa);
		

	}
//mario.attack(coopa);
	
	/*
	 * 변수
	 * 레퍼런스 변수(참조) = 객체를 가리키는 변수, 찾아간다.
	 * 					= 특정 객체를 '간접적'으로 가리키는 변수
	 * 					= 주솟값!
	 * reference types
	 * 
	 * 
	 * 
	 * 기본형 (primitive types)
	 * 특정 값을 직접 저장
	 * 
	 */
}
