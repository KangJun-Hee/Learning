package InnerClass;

import javax.swing.JOptionPane;

//클래스 안에 클래스를 작성하는 공간
//멤버변수

class Out{
	static int a = 1;	//컴파일하는 동안 static영역에 메모리 할당
	
	static class In{
		String Infun() {
			return a + "번째 static 내부 클래스!";
		}
	}
}
public class Static_Inner {

	public static void main(String[] args) {
		String str = "";
		
		//외부클래스의 이름은 주고, 내부클래스의 명 주면 된다.
		Out.In obj = new Out.In();
		
		str = obj.Infun();
		
		JOptionPane.showMessageDialog(null, str);
	}

}
