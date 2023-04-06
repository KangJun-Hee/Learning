package Swing_layout;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyBorder extends JFrame{
	
	JButton btn1 = new JButton("버튼1");
	JButton btn2 = new JButton("버튼2");
	JButton btn3 = new JButton("버튼3");
	JButton btn4 = new JButton("버튼4");
	JButton btn5 = new JButton("버튼5");
	
	JPanel panel = new JPanel();
	public MyBorder() {
		setSize(400, 200);
		
		
		// 화면 배치 설정
		panel.setLayout(new BorderLayout());		
		
		// 보조 프레임에 여러개의 버튼 먼저 추가한다.
		panel.add(btn1, BorderLayout.NORTH);
		panel.add(btn2, BorderLayout.WEST);
		panel.add(btn3, BorderLayout.EAST);
		panel.add(btn4, BorderLayout.SOUTH);	
		panel.add(btn5, BorderLayout.CENTER);	
				
		//보조프레임 메인프레임 추가!
		add(panel);
		
		setVisible(true);
	}
}

public class BorderLayoutMain {

	public static void main(String[] args) {
		
		new MyBorder();
		//BorderLayout
		//동서남북 중앙 or 상하좌우 가운데

		//기본적으로 JFrame 화면 배치BorderLayout
		//가운데로 기본설정
		//각 영역당 하나의 컴포넌트(버튼, 스크롤, 체크박스, 라디오박스)
		//
		
	}
}
