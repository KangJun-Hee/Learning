package Swing_layout;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyFlow extends JFrame{
	
	JButton btn1 = new JButton("버튼1");
	JButton btn2 = new JButton("버튼2");
	JButton btn3 = new JButton("버튼3");
	JButton btn4 = new JButton("버튼4");
	
	
	
	//화면 클래스 정의 FlowLayout
	FlowLayout flow = new FlowLayout();
	
	JPanel panel = new JPanel();
	
	MyFlow(){//기본생성자
		setSize(400, 200);
		
		//화면배치를 설정
		panel.setLayout(new java.awt.FlowLayout());
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		
		add(panel);
		
		setVisible(true);
	}
}

public class FlowLayout {

	public static void main(String[] args) {

		//왼쪽에서 오른쪽으로 한 줄에 차례대로 정렬 레이아수
		//왼쪽에서 실행, 오른쪽에서 실행 결정해라
		
		//Jframe
		//하나의 버튼만 올라갈 수 있고 여러가지 표현불가
		//여러가지의 버튼, 게시물, 스크롤 등을 위해

		//보조 프레임 필요(패널)
		//Jpanel
	}

}
