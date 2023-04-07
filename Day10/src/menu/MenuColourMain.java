package menu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MenuColourMain extends Main implements ActionListener{
	JPanel panel;
	JMenuItem[] mnlist = new JMenuItem[3];
	String[] str = {"파랑색", "빨강색", "노랑색"};
	public MenuColourMain() {

		setTitle("메뉴 만들기");
		setSize(400, 200);
		
		init();//메뉴들에 관한 명령문 저장하는 메서드
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(panel);

	}
	void init() {
		//니모닉키
		//마우스를 사용하지 않고 단축키 메뉴에 접근할 수 있도록
		//설정을 해 주는 것!
		//setMnemonic("니모닉 키에 설정하는 문자");
		
		
		//1.메뉴바 만들기
		JMenuBar menubar = new JMenuBar();
		
		//2.메뉴
		JMenu menu01 = new JMenu("File");
		menu01.setMnemonic(KeyEvent.VK_ALT);
		menubar.add(menu01);
		
		
		
		JMenu menu02 = new JMenu("Colour");
		menu02.setMnemonic(KeyEvent.VK_CONTROL);

		menubar.add(menu02);

		//3.항목만들기
		JMenuItem item01 = new JMenuItem("파란색");
		JMenuItem item02 = new JMenuItem("빨간색");
		JMenuItem item03 = new JMenuItem("노란색");
		//file 메뉴에 붙인다. add()
		menu02.add(item01);
		menu02.add(item02);
		menu02.add(item03);
		
		//프레임에 메뉴 설정 setJMenuBar(메뉴바객체); <-함수
		setJMenuBar(menubar);
		
		
		
		
		
	}
	public static void main(String[] args) {
		new MenuColourMain();
		
	}
	public void itemStateChanged(ItemEvent e) {
		Object obj = ((JMenuItem) e).getSelectedItem();
		
		if(obj == mnlist[0]) {
			panel.setBackground(Color.blue);
		}else if(obj == mnlist[1]) {
			panel.setBackground(Color.red);
		}else if(obj == mnlist[2]) {
			panel.setBackground(Color.yellow);
		}

}}
