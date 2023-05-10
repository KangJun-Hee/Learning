package 최종;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class a_1_homeAdmin extends JPanel implements ActionListener{

	JButton mainimg;
	
	JLabel maintxt;
	JLabel subtxt;
	
	JButton img;
	
	JLabel sidemenuMaintxt;
	JButton side_showAllStudent;
	JButton side_subjectManager;
	

	JButton logout;
	a_1_homeAdmin(){
		setLayout(null);
		setBackground(Color.WHITE);
		
		
		mainimg = new JButton(new ImageIcon("./src/최종/덕성여대_.jpg"));
		mainimg.setBounds(0, 50, 1200, 200 );
		add(mainimg);
		
		
		
		Font font = new Font("맑은 고딕", Font.PLAIN, 30);
		
		maintxt = new JLabel("" + z_0_FileManager.instance.userManager.get(a_0_Main.log).name + "님 반갑습니다.");
		maintxt.setBounds(350, 300, 500, 30);
		maintxt.setFont(font);
		add(maintxt);
		
		
		font = new Font("맑은 고딕", Font.PLAIN, 27);
		subtxt = new JLabel("좌측에서 수행하실 작업을 선택해주세요.");
		subtxt.setBounds(350, 350, 500, 30);
		subtxt.setFont(font);
		add(subtxt);
		
		font = new Font("맑은 고딕", Font.BOLD, 25);
		sidemenuMaintxt = new JLabel("관리자페이지");
		sidemenuMaintxt.setFont(font);
		sidemenuMaintxt.setBounds(30, 280, 300, 50);
		add(sidemenuMaintxt);

		font = new Font("", Font.PLAIN, 17);
		side_showAllStudent = new JButton("전체학생조회");
		side_showAllStudent.setFont(font);
		side_showAllStudent.setBounds(0, 380, 300, 40);
		side_showAllStudent.setBackground(new Color(135, 0, 58));
		side_showAllStudent.setForeground(Color.WHITE);
		side_showAllStudent.addActionListener(this);
		add(side_showAllStudent);

		side_subjectManager = new JButton("수강과목관리");
		side_subjectManager.setFont(font);
		side_subjectManager.setBounds(0, 340, 300, 40);
		side_subjectManager.setBackground(new Color(135, 0, 58));
		side_subjectManager.setForeground(Color.WHITE);
		side_subjectManager.addActionListener(this);
		add(side_subjectManager);

		
		logout = new JButton(new ImageIcon("./src/최종/로그아웃.jpg"));
		logout.setBounds(0, 0, 50, 50);
		logout.setBorder(null);
		logout.addActionListener(this);
		add(logout);
		//////////////////////////

	

		}
		
		
		
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == side_showAllStudent) {
			a_0_Main.frame.setContentPane(new c_1_showAllstudent());
			a_0_Main.frame.revalidate();
		} else if (e.getSource() == side_subjectManager) {
			a_0_Main.frame.setContentPane(new c_0_adminPanel());
			a_0_Main.frame.revalidate();
		}else if(e.getSource()==logout) {
			a_0_Main.log=-1;
			a_0_Main.frame.setContentPane(new b_0_loginPanel());
			a_0_Main.frame.revalidate();
		}
	}

}
