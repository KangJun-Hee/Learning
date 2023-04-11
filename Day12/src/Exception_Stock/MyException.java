package Exception_Stock;

//예외의 부모클래스인 Exception 상속받는다.
public class MyException extends Exception{

	String msg;
	public MyException(String msg) {
		//super(mgs); Exception 부모클래스가 객체를 생성할 때
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "예외발생:" + this.msg;
	}
}
