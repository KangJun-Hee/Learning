package String;

public class StringBufferEx {
	// String(불변), StringBuffer(불변아님), StringBuilder
	// 공통점:문자열 다룬다.
	// 차이점:사용목적에 따라 쓰임새가 많이 다르다.

	// StringBuffer, StringBuilder
	// 문자열을 연산(추가하거나 변경) 할 때 자주 쓴다.

	static void showstrbu() {
		
		//버퍼(buffer)
		// - 임시저장공간(독립적인 공간)
		// 문자열을 바로 추가할 수가 있고 공간 낭비도 없고
		// 연산 속도가 매우 빠르다.
		
		//append() 맨 마지막에 문자열을 추가한다.
		StringBuffer sb = new StringBuffer();
		sb.append("hello");
		sb.append("johyuna");
		sb.append("java ");
		sb.append("fun?");
		
		String result = sb.toString();
		System.out.println(result);
		System.out.println(sb.hashCode());
		System.out.println(result.hashCode());
		
		
		
	}
	
	static void showstrbu2() {
		//mutable 변경 가능
		
		String str = "abcdefg";
		StringBuffer sb = new StringBuffer(str);

		System.out.println(sb);
		
		//문자열 자르기(추출) substring(시작, 끝)
		
		//문자열 중간에 추가하기
		sb.insert(2, "추가합니다.");
		System.out.println(sb);
		//삭제
		sb.delete(2, 4);
		System.out.println(sb);

		//버퍼 용량
		System.out.println(sb.capacity());
		
		//뒤집기 reverse()
		//
		
		int[] arr = new int[3];
		StringBuffer sb3 = new StringBuffer(30);
		
		//길이 확인 length()
		//문자열 치환 replace()
		
		String str3 = "aaa";
		
		//전부 대문자로 변경
		str3 = str3.toUpperCase();
		System.out.println(str3);
		
		//String 클래스로 문자를 여러개를 연결 + 
		String a = new StringBuffer("hello").append("world").toString();
		System.out.println(a);
		
//		[ 자바 언어에서 String을 불변으로 설정한 이유 ]
//				String 객체를 불변하게 설계한 이유는 캐싱, 보안, 동기화, 성능측면 이점을 얻기 위해서이다.
//
//				1. 캐싱 : String을 불변하게 함으로써 String pool에 각 리터럴 문자열의 하나만 저장하며 다시 사용하거나 캐싱에 이용가능하며 이로 인해 힙 공간을 절약할 수 있다는 장점이 있다. 
//
//				2. 보안 : 예를 들어 데이터베이스 사용자 이름, 암호는 데이터베이스 연결을 수신하기 위해 문자열로 전달되는데, 만일 번지수의 문자열 값이 변경이 가능하다면 해커가 참조 값을 변경하여 애플리케이션에 보안 문제를 일으킬 수 있다.
//
//				3. 동기화 : 불변함으로써 동시에 실행되는 여러 스레드에서 안정적이게 공유가 가능하다.

	}
	
	
	
	
	
	void showstr() {
		String str = "";
		str += "이서희";
		str += ",";
		str += "jump to java";

		System.out.println(str);
		//심플하다 근데 연산속도 느리다. 단점
	}
}