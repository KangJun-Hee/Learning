package KHprac;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main extends JFrame{
	static int width = 1200;
	static int height = 850;
	static JFrame fr = new JFrame();
	static int log = -1;	
	
	public static void main(String[] args) {
		fr.setTitle("학사관리프로그램");
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		fr.setBounds(screensize.width/2 - width/2, screensize.height/2 - height/2, width,height);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		System.out.println("log = "+Main.log);
		new Main();
		fr.setContentPane(new Login());
		fr.revalidate();
	}

}
