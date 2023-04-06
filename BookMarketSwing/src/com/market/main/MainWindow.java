package com.market.main;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainWindow extends JFrame{
	
	JPanel mMenuJPanel = new JPanel();
	
	public MainWindow(String title,int x,int y,int width,int height)
	{
		initContainer(title,x,y,width,height);
		
		setVisible(true);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	private void initContainer(String title,int x,int y,int width,int height) {
		
		setTitle(title);
		setBounds(x, y, width, height);
		setLayout(null);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		// 창 위치 setLocation(화면의너비,화면의 높이)
		setLocation((screenSize.width - 750) / 2, (screenSize.height - 750) / 2);

		
		//메뉴 버튼 표시를 위한 보조프레임 설정 및 출력
		mMenuJPanel = new JPanel();
		
		// 한번에 x,y,width,height
		// setSize(x,y) -> 컴포넌트들의 위치 변경
		// setLocation(width,height) -> 창의 너비 높이 
		mMenuJPanel.setBounds(x, y, width, height);
		
		// 첫번째  아이콘 1 고객 정보 확인하기 버튼 
		// 두번째  아이콘 2 장바구니 상품 목록 보기 버튼
		// 세번째  아이콘 3 장바구니 비우기 버튼
		// 네번째        4  장바구니 항목 추가하기
		//			   5 장바구니 항목 수량 줄이기
		//             6 장바구니 항목 삭제 
		//             7 주문하기
		//             8 종료
		//             9 관리자 
		
		JLabel buttonLabel1 = new JLabel("고객 정보 확인하기 버튼", new ImageIcon("images\1.png"), JLabel.LEFT);
		JButton btn1 = new JButton();
		JLabel buttonLabel2 = new JLabel("장바구니 상품 목록 보기", new ImageIcon("images\2.png"), JLabel.LEFT);
		JButton btn2 = new JButton();
		JLabel buttonLabel3 = new JLabel("뿡~", new ImageIcon("images\2.png"), JLabel.LEFT);
		JButton btn3 = new JButton();
		JLabel buttonLabel3 = new JLabel("뿡~", new ImageIcon("images\2.png"), JLabel.LEFT);
		JButton btn3 = new JButton();JLabel buttonLabel3 = new JLabel("뿡~", new ImageIcon("images\2.png"), JLabel.LEFT);
		JButton btn3 = new JButton();JLabel buttonLabel3 = new JLabel("뿡~", new ImageIcon("images\2.png"), JLabel.LEFT);
		JButton btn3 = new JButton();JLabel buttonLabel3 = new JLabel("뿡~", new ImageIcon("images\2.png"), JLabel.LEFT);
		JButton btn3 = new JButton();
		mMenuJPanel.add(buttonLabel1);
		mMenuJPanel.add(buttonLabel2);
		mMenuJPanel.add(buttonLabel3);
//		mMenuJPanel.add(buttonLabel4);
//		mMenuJPanel.add(buttonLabel5);
//		mMenuJPanel.add(buttonLabel6);
//		mMenuJPanel.add(buttonLabel7);
		
		add(mMenuJPanel);
		setVisible(true);
	}
	public static void main(String[] args) {
		new MainWindow("도서쇼핑몰", 0, 0, 1000, 750);
	
	
	
	
}
}
