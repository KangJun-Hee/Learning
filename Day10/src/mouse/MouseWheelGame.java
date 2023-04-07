package mouse;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseWheelGame extends JFrame implements MouseWheelListener {
	
	// 총 색상을 표현하는 panel
	JPanel colorPanel = new JPanel();

	// 3개의 색상을 한꺼번에 올려주는 panel
	// 패널 생성과 동시에 화면 배치 같이 설정 
	JPanel controlPanel = new JPanel(new GridLayout(1, 3));
	
	// 각각 패널 
	JPanel redPanel = new JPanel();
	JPanel greenPanel = new JPanel();
	JPanel bluePanel = new JPanel();
	
	// 각각 rgb 색상을 저장하는 변수 
	int r = 128, g = 128, b = 128;
	
	// rgb 라벨
	JLabel redLabel = new JLabel(r + "");
	JLabel greenLabel = new JLabel(g + "");
	JLabel blueLabel = new JLabel(b + "");
	
		
	public MouseWheelGame() {
		setBounds(100,100,400,600);
		setLayout(new GridLayout(2,0));
		
		colorPanel.setBackground(new Color(r,g,b));
		// 각각 패널에 배경색을 저장 
		redPanel.setBackground(Color.red);
		greenPanel.setBackground(Color.green);
		bluePanel.setBackground(Color.blue);
		
		// 이벤트 설정 
		redPanel.addMouseWheelListener(this);
		greenPanel.addMouseWheelListener(this);
		bluePanel.addMouseWheelListener(this);
		
		// 라벨 글씨 색상
		redLabel.setForeground(Color.white);
		blueLabel.setForeground(Color.white);
		
		
		// 각각 패널 라벨을 추가 
		redPanel.add(redLabel);
		greenPanel.add(greenLabel);
		bluePanel.add(blueLabel);
		
		
		// 각각 패널을 컨트롤패널  추가 
		controlPanel.add(redPanel);
		controlPanel.add(greenPanel);
		controlPanel.add(bluePanel);
		add(controlPanel);		
		add(colorPanel);		
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	

	public static void main(String[] args) {
		new MouseWheelGame();
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		
		// 1. 휠이 앞으로 굴렀는지 뒤로 굴렀는지 확인 
		int wheel = e.getWheelRotation();
		//2. 어떤 객체에서 이벤트가 발생했는지 확인 
		Object obj = e.getSource();
		JPanel pan = (JPanel)obj;
		
		if(pan == redPanel) {
			if(wheel < 0) {
				r = --r < 0 ? 0 : r; 
			}else {
				r = ++r > 255 ? 255 : r;
			}
			// 글자 변경
			redLabel.setText(r + "");	
			
		}else if(pan == greenPanel) {
			if(wheel < 0) {
				g = --g < 0 ? 0 : g; 
					
			}else {
				g = ++g > 255 ? 255 : g;
			}
			
			greenLabel.setText(g + "");
			
		}else if(pan == bluePanel) {
			if(wheel < 0) {
				b = --b < 0 ? 0 : b; 
					
			}else {
				b = ++b > 255 ? 255 : b;
			}
			
			blueLabel.setText(b + "");
			
		}
		// RGB값이 변경되었다. 그러면 다시 Color 객체생성
		// 수정 
		colorPanel.setBackground(new Color(r,g,b));		
	}
}
