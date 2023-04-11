package Exception;

class MyException extends Exception{
	String str1;
	
	public MyException(String str2) {
		str1 = str2;
	}
	@Override
	public String toString() {
		return "MyException 발생:"
				+ str1;
	}
}
public class DefineException {
	
	public static void main(String[] args) {
		
		try {
			System.out.println("try블록입니다.");
			throw new MyException("MyException클래스 호출됩니다.");
			
		}catch(MyException e) {
			System.out.println(e);
		}
		
		
		
		
		
//		사용자가 새로운 예외 클래스를 만들어서 이용할 수 있는 방법
//		 java.lang 패키지의 Exception 예외 클래스를 상속받아 작성
//		사용자 정의 예외 클래스에 대한 생성자를 정의하고(필수는 아님)
//		 toString() 메서드를 재정의하여 catch 블록에서 사용자 정의 메시지를 표시할 수 있음
//		사용자 정의 예외 클래스를 만들고 throw 키워드로 예외를 발생시켜 호출함
		
		
}
}
