package InnerClass;

//멤버클래스도 선언을 하게 되면 외부클래스 멤버기 때문에
//private에는 아무런 영향이 없!

class Outer1{//외부 클래스!
	private static int num = 0;
	
	class Member{
		void add(int n) {num+=n;}
		int get() {return num;}
	}
}
public class MemberClass {

	public static void main(String[] args) {
		
		//멤버클래스
		// - 외부인스턴스를 생성하고 그 다음에 내부클래스를 생성
		
		//외부클래스 생성
		Outer1 out new Outer();
		//내부클래스 생성
		//먼저 만들어ㅓ진 객체 접근
		Outer1.Member o1 = out.new Member();
		Outer1.Member o2 = out2.new Member();
		
		//실제 내부클래스들의 메서드를 이용해서 데이터를 저장
		o1.add(100);
		System.out.println(o1.get());
		
		
		
		
		
	}

}
//static_inner 클래ㅡ 파일을 member2클래스 파일만들고
//똑같은 내용을 변경해서 똑같은 결과를 출력하세요
                                                                                                                                                                       