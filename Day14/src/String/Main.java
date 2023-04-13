package String;

public class Main {

	public static void main(String[] args) {
		//StringBuffer 객체생성
		
		StringBuffer sb = new StringBuffer();

		StringBufferEx.showstrbu();
	}

}

//		//String 클래스 aka 데이터 char[], 메서드(문자열 관련)
//		// - 문자배열로 이루어진 클래스
//		// - 참조형 변수로 분류
//		
//		// - 스택 영역이 아닌 객체와 heap(힙)에서 문자열 데이터가
//		// - 생성되고 다뤄진다.
//		//String 불변(Immutable)
//		// 기본으로 객체의 값을 변경 못하게 해 놨다.
//
//		
//		int num = 35;
//		String name = "홍길동";
//		String name2 = "홍길동";
//		
//		//hashcode() 메서드를 이용해 실제로 변수가 가지고 있는
//		//주소값을 찍어보면 알 수 있다.
//		//객체 메모리 번지를 이용해서 해시코드를 만들어 리턴하는 메서드 
//		//상수만 저장하는 영역에 문자 상수가 올라가면 똑같은 내용은
//		//저장 안된다. 그래서 가지고 있는 문자를 공유해서 주소값을
//		//준다.
//		
//		//문자열 리터럴(상수) 프로그램 실행시 자동으로 생성됨.
//		//constant pool에 저장. 상수들만.
//		
//		//멀티스레드 문제점=동기화를 발생시키지 않으려고!
//		String a = "123";
//		
//		System.out.println(name.hashCode());
//		System.out.println(name2.hashCode());
//		
//		String str = "hello";
//		System.out.println(str.hashCode());
//		
//		str = str + "World";
//		System.out.println(str.hashCode());
//		System.out.println(str);
//		
//		
//		//문자 리터널(상수 : 고정된 값)
//		final int num2 = 10;
//		
//		//JVM 가상머신 메모리 내부측에서 큰 차이를 냄.
//		String str7 = "";
//		String str8 = "";
//		String str9 = "";
//		
//		//String 클래스
//		// 객체 new 새로운 주소값을 할당한다.
//		String str3 = new String("");
//		String str4 = new String("");
//		String str5 = new String("");