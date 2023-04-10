package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MyFrame extends JFrame implements Runnable{
		Dimension dimen;	//너비랑 높이를 저장하고 있는 클래스
		int x;
		int y;
		public MyFrame() {
			setTitle("제목 없는 윈도우");
			setBounds(x,y,400,300);
			
			//화면의 해상도를 얻어 온다. 자동으로 Dimension 객체에 저장한다.
			dimen = Toolkit.getDefaultToolkit().getScreenSize();
			
			
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(true);
		}

		@Override
		public void run() {
		
		while(true) {
			//윈도우 창을 오른쪽으로 움직일 것!
			x++;
			
			//자바 프로그램창을 넘어간다
			//넘어가지 말고 멈출 것!
			if(x >= dimen.height - 400) {
				break;
			}
			y++;
			if(y >= dimen.width - 300) {
				break;
			}
			//지연을 시킨다.
			//스레드가 너무 빠르면 실행했는지 안 보임.
			//일정 시간마다 멈추고 동작을 보여줄 수 있게
			
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			setLocation(x, y);
				

			}
		}
		}
		




//창의 위치만 변겨아고 싶을 경우에는 setLocation(좌우, 상하)
//좌우 오른쪽 간다 증가+	왼쪽-
//상하 위 - 아래 +
//		public void run() {
//			int xt =1;
//			int yt =1;
//			boolean res = true; //왼쪽에서 오른쪽으로 움직일 때.
//								//오른쪽에서 왼쪽으로 움직일 떄.
//								//false 위에서 아래 아래 위로!
//			
//			while(true) {
//				
//				if(res) {
//					x += xt;
//					if((x >= dimen.width-400) || (x <= 0)) {
//						xt *= -1;
//						res = false;
//					}
//				}else {
//					y += yt;
//					if((y >= dimen.width-400) || (y <= 0)) {
//						yt *= -1;
//						res = true;
//					}
//				}
//				setLocation(x,y);
//				try {
//					Thread.sleep(10);
//				} catch (InterruptedException e){}
//			}