package Swing;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyFrame extends JFrame{
	
	MyFrame(){
		setTitle("내가 만든 gui");
		setSize(500, 300);
		
		JButton btn1 = new JButton("눌렀니?");
		JButton btn2 = new JButton("왜 눌렀니?");

		//윈도우창에 버튼을 부착
		//밑에 btn1 내려가서 안 보인다.
		//화면의 배치(레이아웃)
		
		add(btn1);
		add(btn2);
		
		setVisible(true);
	}
	
}
public class Main {

	public static void main(String[] args) {
		MyFrame my = new MyFrame();
	}

}

//		//자바 GUI
//		//	- 그래픽이용, 사용자가 이해하기 쉬운 모양으로 정보 제공
//		//	- 마우스나 키보드를 이용하여 입력
//		
//		//그래픽을 하기 위해서 필요한 프레임
//		//	창 만드는 프레임
//		
//		//객체 생성
//		JFrame window = new JFrame();
//		
//		//프로그램 타이틀
//		window.setTitle("내가 만든 gui");
//		
//		//윈도우 창에 크기 설정
//		//setSize(너비, 높이);
//		window.setSize(400, 200);
//		
//		//윈도우 창을 보이게 하기
//		//true 보임 false 안 보임
//		window.setVisible(true);