package mouse;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseWheelMain extends JFrame implements MouseWheelListener{

	JLabel label = new JLabel("안녕하세요");
	JPanel pan = new JPanel();
	int size = 30;
	Random r = new Random();
	
	
	public MouseWheelMain() {
		setTitle("마우스 이벤트");
		setSize(400,200);
		
		label.setFont(new Font("굴림체",Font.PLAIN,size));
		pan.add(label);
		
		add(pan);
		
		
		addMouseWheelListener(this);
		
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}
	
	
	public static void main(String[] args) {
		new MouseWheelMain();
	}


	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// 휠이 움직였을 때 이벤트가 발생!
		//  마우스가 앞으로 움직임 -1
		//  마우가가  뒤로 움직임  1 
		int res = e.getWheelRotation();
		
		//RGB랜덤값 0~255
		int red = r.nextInt(256);
		int gre = r.nextInt(256);
		int blu = r.nextInt(256);
		
		
		pan.setBackground(new Color(red,gre,blu));
		
		if(res == -1) {//휠이 앞으로 움직인 것!
			size--;
		}else {//뒤로 움직였다!
			size++;
		}
		label.setFont(new Font("궁서체", Font.BOLD, size));
		
		
	}
}
