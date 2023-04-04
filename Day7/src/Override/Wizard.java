package Override;

//마법사 파이어볼 데미지가 10씩 공격
public class Wizard {
	
	void fireball() {
		System.out.println("데미지 10씩 준다!");
	}
}
//마법사가 전직 파이어볼 데미지를 30씩
//함수이름,리턴값 똑같이 쓰고 안의 내용만 다름:오버라이딩
class GreatWizarde extends Wizard{
	
	void fireball() {
		System.out.println("데미지 30씩 준다!");
	}
}