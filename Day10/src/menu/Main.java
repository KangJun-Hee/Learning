package menu;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Main extends JFrame{
	public Main() {
		setTitle("메뉴 만들기");
		setSize(400, 200);
		
		init();//메뉴들에 관한 명령문 저장하는 메서드
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	void init() {
		//1.메뉴바 만들기
		JMenuBar menubar = new JMenuBar();
		
		//2.메뉴
		JMenu menu01 = new JMenu("File");
		menubar.add(menu01);
		JMenu menu02 = new JMenu("Edit");
		menubar.add(menu02);
		JMenu menu03 = new JMenu("Help");
		menubar.add(menu03);
		//3.항목만들기
		JMenuItem item01 = new JMenuItem("New");
		JMenuItem item02 = new JMenuItem("Open");
		JMenuItem item03 = new JMenuItem("Help");
		//file 메뉴에 붙인다. add()
		menu01.add(item01);
		menu01.add(item02);
		
		//프레임에 메뉴 설정 setJMenuBar(메뉴바객체); <-함수
		setJMenuBar(menubar);
		
		
		
		
		
	}
	public static void main(String[] args) {
		 new Main();//객체생성
	}

}
