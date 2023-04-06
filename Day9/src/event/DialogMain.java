package event;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.JobAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class MyDialog extends JFrame implements ActionListener{
	
//	JButton btn1 = new JButton("에러");
//	JButton btn2 = new JButton("정보");
//	JButton btn3 = new JButton("경고");
//	JButton btn4 = new JButton("질문");
	
	JButton[] btnlist = new JButton[4];
	String[] str = {"에러","정보","경고","질문"};
	
	JPanel pan = new JPanel();
	
	public MyDialog() {
	
		setBounds(100, 100, 500, 400);
			
		
		for(int i = 0; i < btnlist.length; i++) {
			btnlist[i] = new JButton(str[i]);
			btnlist[i].addActionListener(this);
			pan.add(btnlist[i]);
			
		}
		
		
		
		/*// 각각의 버튼에 리스너 추가 
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		
		
		pan.add(btn1);
		pan.add(btn2);
		pan.add(btn3);
		pan.add(btn4);
		*/
		add(pan);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 어떤 버튼이 눌렸는지 확인 
		Object obj = e.getSource();
		
		if (obj == btnlist[0]) {// 객체의 주소값끼리 비교! 발생한이벤트객체와 btn1
			
			// 팝업창 (JOptionPane)클래스 static선언이 되어있다.
			btnlist[0].setBackground(Color.cyan);
			
			JOptionPane.showMessageDialog(this
										,"팝업창 대화상자"
										,"에러"
										,JOptionPane.ERROR_MESSAGE);
		}else if (obj == btnlist[1]) {// 객체의 주소값끼리 비교! 발생한이벤트객체와 btn1
			btnlist[1].setBackground(Color.cyan);
			
			// 팝업창 (JOptionPane)클래스 static선언이 되어있다.
			JOptionPane.showMessageDialog(this
										,"팝업창 대화상자"
										,"정보"
										,JOptionPane.INFORMATION_MESSAGE);
		}else if (obj == btnlist[2]) {// 객체의 주소값끼리 비교! 발생한이벤트객체와 btn1
			btnlist[2].setBackground(Color.cyan);
			
			// 팝업창 (JOptionPane)클래스 static선언이 되어있다.
			JOptionPane.showMessageDialog(this
										,"팝업창 대화상자"
										,"경고"
										,JOptionPane.WARNING_MESSAGE);
		}else if (obj == btnlist[3]) {// 객체의 주소값끼리 비교! 발생한이벤트객체와 btn1
			btnlist[3].setBackground(Color.cyan);
			
			// 팝업창 (JOptionPane)클래스 static선언이 되어있다.
			JOptionPane.showInputDialog(this,"읾을 입력하세요");
		}
		
		
		
		// else if 정보 JOptionPane.Infomation_MESSAGE
		//         경고 JOptionPane.WARNIMG_MESSAGE
		//         질문 JOptionPane.QUESTION_MESSAGE
		
		// 버튼1 눌렸다. 버튼의 배경색 변경 
		//     setBackground()
		//     Color.컬러 
		
	}	
}


public class DialogMain{

	public static void main(String[] args) {
		new MyDialog();
	}

}
