package Swing;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class MyText extends JFrame{
	
	JPasswordField obj1 = new JPasswordField(10);
	JPasswordField obj2 = new JPasswordField("댕댕이");
	JPasswordField obj3 = new JPasswordField("댕댕이", 10);
	
	
	
	
	
	JPanel pan = new JPanel();
	
	MyText(){
		setSize(500, 300);
		
		
				
		pan.add(obj1);
		pan.add(obj2);
		pan.add(obj3);
		
		add(pan);
		
		
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

public class TextFieldMain {

	public static void main(String[] args) {
		

		//TextField
		//	- 텍스트 입력 한 줄 입력하거나 수정하거나 등
		//	- 편집을 할 수 있는 텍스트 구성 요소!
		//	검색창, 아이디, 댓글창(패스워드는 좀 다름)
		//JTextField(글자수)
		
		new MyText();
		
		//passwordField
		//	- 비밀번호 입력에 특화된 텍스트
		//	- 암호 기능을 처리하고 한 줄의 텍스트로 편집을 할 숭 있다.
		
	}}



////글자 10만큼의 크기로 생성
//JTextField obj1 = new JTextField(10);
//
////글자로 초기화
//JTextField obj2 = new JTextField("고양이");
////강아지로 초기화하고 글자 10개만큼 크기로 생성
//JTextField obj3 = new JTextField("강아지", 10);}




//CheckBox
//선택하거나 선태글 해제할 수 있고 사용자한테 보여 주는 것!
//한꺼번에 여러개의 답을 얻을 수 있다.
//		JCheckBox obj1= new JCheckBox();
//		JCheckBox obj2= new JCheckBox("고양이");
//		JCheckBox obj3= new JCheckBox("강아지",true);
//		





//Label
//	- 고정된 텍스트값을 표현
//	- 읽기 전용 한 줄 표시
//	String[] name = {"고양이", "강아지", "돼지"};
//	JComboBox obj1 = new JComboBox(name);	
//	
//	JLabel obj2 = new JLabel("고양이");
//	JLabel obj3 = new JLabel(new ImageIcon("cat.png"));
//	JLabel obj4 = new JLabel("고양이", new ImageIcon("cat.png"), JLabel.RIGHT);
//	






//라디오버튼
//	- 여러 옵션 중에 하나를 선택할 수 있는 라디오버튼
//	- 한 번에 하나만 결과를 얻는다.
//	JRadioButton obj1 = new JRadioButton();
//	JRadioButton obj2 = new JRadioButton("강아지");
//	JRadioButton obj3 = new JRadioButton("고양이", true);