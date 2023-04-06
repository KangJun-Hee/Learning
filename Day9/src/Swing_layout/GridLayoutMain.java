package Swing_layout;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyGrid extends JFrame{
	
	JButton btn1 = new JButton("버튼1");
	JButton btn2 = new JButton("버튼2");
	JButton btn3 = new JButton("버튼3");
	JButton btn4 = new JButton("버튼4");
	JButton btn5 = new JButton("버튼5");
	
	JPanel panel = new JPanel();
	public MyGrid() {
		setSize(400, 200);
		
		
		// 화면 배치 설정
		panel.setLayout(new GridLayout(3, 2));		
		
		// 보조 프레임에 여러개의 버튼 먼저 추가한다.
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);
		
		//보조프레임 메인프레임 추가!
		add(panel);
				
		setVisible(true);
		//x눌렀을 때 메인프레임과 자바프로그램 자체 종료
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

public class GridLayoutMain {

	public static void main(String[] args) {

		new MyGrid();
		//GridLayout
		//	- 행과 열을 만들어 격자 형태로 정렬하는 레이아웃
		//	- 엑셀, 바둑판
		//	- 모든 컴포넌트들이 동일한 크기를 가지고 프레임에
		//		배치된다.
		// 숫자버튼 16개 
		JButton[] btnlist = new JButton[16];
		// setLayout(행 열 좌우,위아래여백) 
				panel.setLayout(new GridLayout(4,4,10,10));
				
				for(int i = 0; i < btnlist.length; i++) {
					btnlist[i] = new JButton((i+1) + "");
					btnlist[i].addActionListener(this);
					panel.add(btnlist[i]);
					
				}
				
				add(panel);		
		
		
		
		//Arraylist 배열이나 반복문 써서
	}
}


//package Event;
//
//import java.awt.Font;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
//// 이벤트를 듣고 있는 리스너 클래스를 생성
//class MyListener implements ActionListener{
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		//이벤트 객체에서 getSource() 
//		//  이벤트 정보를 가지고 있다. 버튼.목록
//		// Object 모든 객체들을 받아서 돌려 줄 수있다.
//	
//		JButton btn = (JButton)e.getSource();
//		
//		String text = btn.getText();	
//		boolean res = text.equals("왜 눌렀니??");
//		
//		
//		if(res) {
//			btn.setText("아! 왜 눌렀냐니까!!");
//		}else {
//			btn.setText("왜 눌렀니??");
//		}
//		
//		//System.out.println(btn.getText());
//		//btn.setText("왜 눌렀니??");		
//	}	
//}
//
//class MyFrame extends JFrame implements ActionListener {
//
//	// 숫자버튼 16개 
//	
//	JButton[] btnlist = new JButton[16];
//	
//	
//	MyFrame() {
//
//		setBounds(450, 450, 400, 300);
//
//		JPanel panel = new JPanel();
//		add(panel);
//		
//		// setLayout(행 열 좌우,위아래여백) 
//		panel.setLayout(new GridLayout(4,4,10,10));
//		
//		for(int i = 0; i < btnlist.length; i++) {
//			btnlist[i] = new JButton((i+1) + "");
//			btnlist[i].addActionListener(this);
//			panel.add(btnlist[i]);
//			
//		}
//		
//		add(panel);		
//		
//
////		JButton btn1 = new JButton("버튼을 누르세요~");
////		
////		btn1.setFont(new Font("굴림체",Font.BOLD,30));
////		
////		// 버튼에 이벤트를 설정 할것 (버튼에 이벤트를 추가)
////		
////		// MyFrame클래스 안에 
////		btn1.addActionListener(this);
//		
//		// 객체 생성해서 사용 implements ActionListener
//		// 구현해서 자기 자신을 참조하게 만들어도 된다. 
//		//btn1.addActionListener(new MyListener());
//		
//		//panel.add(btn1);
//
//		setVisible(true);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// 버튼의 text값을 가지고 와서 
//		// 비교 
//	}
//}
//public class Main {
//
//	public static void main(String[] args) {
//
//		new MyFrame();
//
//		// 이벤트
//		// - 특정한 상황이 발생했다.
//		// - 상태 변화
//
//		// Font font = new Font("굴림체",Font.BOLD,30);
//
////		btn1.setFont(font);
//		//
//		//
//
//	}
//}
