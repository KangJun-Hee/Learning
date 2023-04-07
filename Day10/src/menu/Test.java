package menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;






public class Test extends JFrame implements KeyListener, ItemListener, ActionListener {

	// 필드 두개
	JTextField t1, t2;
	JTextArea area; // 여러 줄을 입력할 수있는 클래스
	JButton cal, reset; // 버튼 계산과 리셋!
	JComboBox cb; // 드롭다운 클래스

	// JFrame클래스 기본적으로 borderlayout
	// 동서남북가운데! 기본 가운데
	Test() { // 생성자 메임프레임 설정
		setTitle("원 넓이 구하기");
		setLayout(new BorderLayout(10, 10));
		setSize(400, 300);

		showNorth();
		showCenter();
		showSouth();
		
		t1.addKeyListener(this);
		cal.addActionListener(this);
		reset.addActionListener(this);
		cb.addItemListener(this);

		
		//화면보이기는 무조건 이벤트,창크기,컴포넌트들 생성후
		//맨 마지막에~!
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	void showNorth() {
		JPanel pan1 = new JPanel(); // 반지름 필드
		JPanel pan2 = new JPanel(); // 원의넓이 필드
		JPanel panel = new JPanel(new GridLayout(2, 0));

		JLabel l1 = new JLabel("원의 반지름");
		JLabel l2 = new JLabel("원의 넓이");

		t1 = new JTextField(10);
		t2 = new JTextField(10);

		// 보여지긴 하지만 비활성화!setEnabled(false)
		// 활성화 true
		t2.setEnabled(false);

		// 추가
		pan1.add(l1);
		pan1.add(t1);
		pan2.add(l2);
		pan2.add(t2);

		// 두개를 묶어주는 panel 추가
		panel.add(pan1); // grid 0번
		panel.add(pan2); // 1번

		// 메임판 추가 (위)
		add(panel, BorderLayout.NORTH);

	}

	void showCenter() {
		// panel.setBackground(Color.black); // println()
		// 여러 줄을 입력받는 공간

		JPanel panel = new JPanel();
		area = new JTextArea(10, 20); // 행,열
		area.setText("이 영역에 원의 넓이를 \n 계산하는 과정");

		area.setForeground(Color.red);

		panel.add(area);
		add(panel, BorderLayout.CENTER);
	}

	void showSouth() {

		String[] color = { "red", "blue" };
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

		cal = new JButton("계산");
		cb = new JComboBox(color);
		reset = new JButton("리셋");

		panel.add(cal);
		panel.add(cb);
		panel.add(reset);

		add(panel, BorderLayout.SOUTH);

	}

	public static void main(String[] args) {
		new Test();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == cal) {
			if (t1.getText().isEmpty()) {
				area.setText("반지름을 입력하세요!!!");
			}else {
				String s = t1.getText();
				double radius = Double.parseDouble(s);
				double result = radius * radius * 3.14;
				t2.setText("" + result);
				area.setText(radius + " * " + radius + " * 3.14 = " + result);
			}
			
		}else if(obj == reset) {
			
			t1.setText("");
			t2.setText(null);
			area.setText(null);
			
			
		}
		
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		//아이템 배열로 저장했다.
		//인덱스(방번호)
		//getSelectedIndex() 선택된 인덱스번호를 가지고온다.
		int index = cb.getSelectedIndex();
		
		if(index == 0) {
			area.setForeground(Color.red);
		}else {
			area.setForeground(Color.blue);
		}
		
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {}
}
