package 최종;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class a_0_Main {
	static int width = 1200;
	static int height = 850;
	static JFrame frame = new JFrame();
	static int log = -1;
	public static void main(String[] args) {
		
		frame.setTitle("학사관리프로그램");
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(screensize.width/2 - width/2, screensize.height/2 - height/2, width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		z_0_FileManager.instance.loadData();
		//z_0_FileManager.instance.addAdmin();
		
		System.out.println("log = " + a_0_Main.log);
		
		frame.setContentPane(new b_0_loginPanel());
		frame.revalidate();
		
	}

}
