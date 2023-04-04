package Override;

public class Newbie {
	String name;
	int hp;
	int mp;
	
	public String toString() {
		return name+"의 에너지볼트!" +" 버프로 데미지 "+ " 추가";
		
	}
	void info() {
		System.out.println(name+"의 에너지볼트!" +" 버프로 데미지 "+ " 추가");
	}
}
class GreatWiz extends Newbie{
	int shi;
	
	public GreatWiz(String name, int hp, int mp, int shield) {
		// TODO Auto-generated constructor stub
	}

	void info() {
		System.out.println(name+"의 에너지볼트!" +" 버프로 데미지 +30"+ " 추가");

	}
}
