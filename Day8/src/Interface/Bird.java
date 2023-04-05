package Interface;

interface Fly{
	void fly();
}
interface Walk{
	void walk();
}
interface Cry{
	void cry();
}

interface Flyable{
	void fly();
}

class Helicopter implements Flyable{

	@Override
	public void fly() {
		System.out.println("프로펠러를 힘차게 돌리며 날아갑니다!");
	}
	
}
class Rocket implements Flyable{

	@Override
	public void fly() {
		System.out.println("제트 엔진을 분출하며 날아갑니다!");
	}
	
}
//강아지 어떤 기능
class Dog implements Cry, Walk{

	@Override
	public void walk() {
		
	}

	@Override
	public void cry() {
		
	}
	
}
class Chicken implements Walk, Fly{

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void walk() {
		// TODO Auto-generated method stub
		
	}
	
}

public class Bird implements Walk, Fly, Cry, Flyable{

	@Override
	public void cry() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void walk() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void fly() {
		System.out.println("날개를 퍼덕이며 날아갑니다!");
		}
		
	}

}
