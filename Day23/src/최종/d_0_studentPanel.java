package 최종;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class d_0_studentPanel extends JPanel implements ActionListener{

	JLabel maintxt;
	JButton goback;
	
	JButton mainimg;
	JLabel sidemenuMaintxt;
	JButton side_subjectManagement;
	JButton side_showAllSubject;
	
	
	JButton numbar;
	JButton subjectbar;
	
	
	JButton num;
	JButton subject;
	
	JButton logout;
	d_0_studentPanel(){
		setLayout(null);
		setBackground(Color.WHITE);
		
		
		//////////////////
		mainimg = new JButton(new ImageIcon("./src/최종/덕성여대_.jpg"));
		mainimg.setBounds(0, 50, 1200, 200 );
		add(mainimg);
		
		
		Font font = new Font("맑은 고딕", Font.BOLD, 25);
		
		sidemenuMaintxt = new JLabel("학사관리");
		sidemenuMaintxt.setFont(font);
		sidemenuMaintxt.setBounds(30, 280, 300, 50);
		add(sidemenuMaintxt);
		
		font = new Font("", Font.PLAIN, 17);
		
		side_showAllSubject = new JButton("수강과목조회");
		side_showAllSubject.setFont(font);
		side_showAllSubject.setBounds(0, 340, 300, 40);
		side_showAllSubject.setBackground(new Color(135,0,58));
		side_showAllSubject.setForeground(Color.WHITE);
		side_showAllSubject.addActionListener(this);
		add(side_showAllSubject);
		
		
		side_subjectManagement = new JButton("수강신청/철회");
		side_subjectManagement.setFont(font);
		side_subjectManagement.setBounds(0, 380, 300, 40);
		side_subjectManagement.setBackground(new Color(135,0,58));
		side_subjectManagement.setForeground(Color.WHITE);
		side_subjectManagement.addActionListener(this);
		add(side_subjectManagement);
		
		
		
		goback = new JButton(new ImageIcon("./src/최종/홈.jpg"));
		goback.setBounds(0,0, 50, 50);
		goback.setBorder(null);
		goback.addActionListener(this);
		add(goback);
		
		logout = new JButton(new ImageIcon("./src/최종/로그아웃.jpg"));
		logout.setBounds(50, 0, 50, 50);
		logout.setBorder(null);
		logout.addActionListener(this);
		add(logout);
		////////////////////////
		
		font= new Font("", Font.BOLD, 23);
		maintxt = new JLabel("수강과목조회");
		maintxt.setFont(font);
		maintxt.setBounds(400, 300, 400, 50);
		add(maintxt);
		
		numbar = new JButton("NO.");
		numbar.setBackground(Color.DARK_GRAY);
		numbar.setForeground(Color.WHITE);
		numbar.setBounds(400, 370, 80, 30);
		add(numbar);
		
		subjectbar = new JButton("과목명");
		subjectbar.setBackground(Color.DARK_GRAY);
		subjectbar.setForeground(Color.WHITE);
		subjectbar.setBounds(480, 370, 200, 30);
		add(subjectbar);
		
		
		font= new Font("", Font.PLAIN, 15);
		int	cnt = z_0_FileManager.instance.userManager.get(a_0_Main.log).subject.size();
		
		for(int i=0;i<cnt;i++) {
			num = new JButton(i+1 + "");
			num.setBackground(Color.WHITE);
			num.setForeground(Color.BLACK);
			num.setFont(font);
			num.setBounds(400, 400 + i*35, 80, 35);
			num.setBorder(null);
			add(num);
			
			String subjectname = z_0_FileManager.instance.userManager.get(a_0_Main.log).subject.get(i);
			
			//System.out.println("subjectname : " + subjectname);/////////////////00000000000000000
			subject = new JButton(subjectname + "");
			subject.setBackground(Color.WHITE);
			subject.setForeground(Color.BLACK);
			subject.setBounds(480, 400 + i*35, 200, 35);
			subject.setFont(font);
			subject.setBorder(null);
			add(subject);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==goback) {
			a_0_Main.frame.setContentPane(new a_2_homeStudent());
			a_0_Main.frame.revalidate();
			
		}else if(e.getSource()==side_subjectManagement) {
			a_0_Main.frame.setContentPane(new d_1_subjectManagement());
			a_0_Main.frame.revalidate();
		}else if(e.getSource()==logout) {
			a_0_Main.log=-1;
			a_0_Main.frame.setContentPane(new b_0_loginPanel());
			a_0_Main.frame.revalidate();
		}
	}

}
