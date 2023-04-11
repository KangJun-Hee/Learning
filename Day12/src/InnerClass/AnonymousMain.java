package InnerClass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

interface A{
	void show();
}

public class AnonymousMain extends JFrame{
	
	public AnonymousMain() {
		setBounds(0,0,400,300);
		
		JButton btn = new JButton("눌렀니?");
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				btn.setText("놀랐네~");
			}
		});
		
		
		add(btn);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		//내부클래스 익명클래스
		// - 클래스를 정의와 동시에 객체를 생성할 때 만들어지는 클래스
		// - 1회용 클래스
		//추상클래스,인터페이스 객체생성불간데 익명클래스 써서 가능~
		//이벤트할 때 GUI 그래픽할 때 많이 사용이 된다.
		new AnonymousMain();
		
		
		
//		A a1 = new A() {
//			
//			@Override
//			public void show() {
//				System.out.println("딱 한 번 실행하는");
//			}
//		};
//		
//		a1.show();
//		a1.show();
//		a1.show();
//		a1.show();
		
		
		
	}

}
