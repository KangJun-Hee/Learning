package InnerClass;

class PocketBall{
	
	int size = 100;
	static int price = 5000;

	class User{
		String name;
		
		public User(String name) {
			this.name = name;
		}
	}
	static class PocketMonster{
		static String name = "이상해씨";
		int level = 10;
		
		public static void getPoketMember() {
			//외부클래스 인스턴스 멤버 접근 불가능하다.
//			System.out.println(size);
			
			System.out.println(price);
			
			System.out.println(name);
//			System.out.println(level);
		}
	}
}
public class Total {

	public static void main(String[] args) {

		//static이랑 member 클래스랑 같이 사용을 할 수 있다.
		new PocketBall.PocketMonster();
		
		//멤버 클래스 선언
		PocketBall.User u1 = new PocketBall().new User("이서희");
	}
//*class에 붙는 static과 멤버에 붙는 static의 의미차이
//
//클래스에 붙는 static과 클래스의 멤버, 즉 field와 method에 붙는 static키워드의 의미는 다르다.
//
//익히 알고 있듯이 멤버에 붙는 static키워드는 정적으로 메모리를 잡아준다는 의미로서 컴파일 타임에 컴파일러가 메모리를 할당해 주기 때문에 객체생성 없이도 사용 가능하다는 의미이다. 반면
//
//클래스에 붙는 static은 외부 클래스의 객체 생성없이 내부 클래스의 객체를 생성할 수 있다는 의미이다.
//
// 
//
// 
//
//*스테틱 클래스 내부에 선언된 정적멤버의 활용
//
//System.out.println에서 객체를 생성하지 않고 해당 메소드를 사용할 수 있는 이유는 무엇인가?
//
//우선 객체생성과 상관없이라는 말을보면 무언가 static과 관련이 있을 것 같다.
//
// 
//
//java에서 클래스에 static을 붙일수 없지만 내부 클래스에는 static을 붙일 수 있다. 내부 클래스의 스테틱 클래스는 멤버 클래스로서 외부 클래스의 멤버와 같은 성질을 가졌기 때문이다. 즉, out은 System클래스의 스태틱 클래스이고 println()메소드는 스테틱 메소드이기 때문에 System.out.println()이 가능한 것이다. 그런데 out이 내부 클래스라면 첫 문자가 대문자여야 하는데 아니다. 그래서 API를 찾아보니 아니었다... out은 System클래스의 정적 참조 변수 즉, static PrintStream out 이었다. 아마
//
//public static final PrintfStream out = new PrintStream(); 이라고 되어있지 않을까 싶다.
//
//아무튼 틀렷지만 이러한 접근도 가능하다는 것을 말하기 위해 이 글을 적었다.
}
