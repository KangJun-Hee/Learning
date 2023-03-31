package methods;

public class 김밥천국 {

	public static String 주방장(String 이모님) {
		String 메뉴 = 이모님;
		
		System.out.println("주문이 들어왔다~");
		System.out.println("요리를 만드는 중~~");
		System.out.println(메뉴 + "가 완성되었습니다!");
		
		return 메뉴;
	}
	public static void 라면을산다() {
		System.out.println("라면이 떨어졌다 사자!");
	}
	public static void 물을올린다() {
		System.out.println("물을 올린다.");
	}
	public static void 스프를넣는다() {
		System.out.println("스프넣기");
	}
	public static void 면을넣는다() {
		System.out.println("면 넣기");
	}
	public static void 라면완성() {
		System.out.println("라면이완성");
	}
	
	public static void main(String[] args) {
		//여러분이 김밥천국 점심먹으러!
		//main = 나
		//주문
		//사장님이 주방장에게 전달
		//주문한 음식
		String 음식 = 주방장("김치찌개");
		System.out.println("맛있게 먹는다." + 음식);
		
		//함수의 실행 순서
		//라면을 조리하기 위해서 함수
		
		//라면이 없고 라면을 끓일 때 면을 넣고 스프 완성
		라면을산다();
		면을넣는다();
		스프를넣는다();
		라면완성();
		
		//라면 스프넣고 면을 넣고 완성
	}

}
/* public static 리턴타입 함수명(매개변수){
 * 				반복되는 명령문들1
 * 				2, 3, 4
 * 
 * 		return 데이터;
 * }
 * 
 * 
 * 
 * 
 * 
 * main 메소드
 main 메소드는 프로그램의 시작점 역할을 하는 JAVA의 약속된 내용이다. 
 즉, main 메소드가 없는 프로그램은 별도로 동작할 수가 없다. 
 컴퓨터가 소스 코드를 읽을 때 main 메소드를 실행하고 
 거기에 정의된 로직에 따라 프로그램이 동작하게 된다.
메소드 리턴 타입
 위에서 설명하였듯이 메소드의 리턴 타입은 자료형 또는 void가 올 수 있다. 
 자료형이 리턴 타입으로 오면 
 반환(return)해 주는 값(메소드 자료형과 동일한 값)이 반드시 있어야 하고 
 void는 반환 값이 없다. 
 다르게 말하면 반환하고자 하는 데이터가 있다면 
 그 데이터의 자료형을 메소드의 자료형으로 적어줘야 한다.
리턴(return) 문
 메소드 내에서 동작하고 얻은 결과(필요한 데이터)를 반환해주는 역할을 한다. 
 return문 뒤에는 어떠한 구문도 올 수 없다.(컴파일 에러 발생) 
 다르게 말하면 return문을 사용하면 값을 반환해 주고 
 해당 메소드는 실행이 종료된다.
 * 
 */


