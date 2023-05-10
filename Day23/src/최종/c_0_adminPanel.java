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

public class c_0_adminPanel extends JPanel implements ActionListener {

	JLabel maintxt;
	JButton img;
	JTextField subjecttf;
	JButton addsub;
	
	JLabel[] subject;
	JButton[] delbtn;

	JButton mainimg;
	JLabel sidemenuMaintxt;
	JButton side_showAllStudent;
	JButton side_subjectManager;
	
	
	
	JButton goback;
	JButton logout;
	
	

	c_0_adminPanel() {
		setLayout(null);
		setBackground(Color.WHITE);

		////////////////////////////
		mainimg = new JButton(new ImageIcon("./src/최종/덕성여대_.jpg"));
		mainimg.setBounds(0, 50, 1200, 200);
		add(mainimg);

		Font font = new Font("맑은 고딕", Font.BOLD, 25);

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

		goback = new JButton(new ImageIcon("./src/최종/홈.jpg"));
		goback.setBounds(0, 0, 50, 50);
		goback.setBorder(null);
		goback.addActionListener(this);
		add(goback);
		
		logout = new JButton(new ImageIcon("./src/최종/로그아웃.jpg"));
		logout.setBounds(50, 0, 50, 50);
		logout.setBorder(null);
		logout.addActionListener(this);
		add(logout);
		//////////////////////////

		font = new Font("", Font.BOLD, 23);
		maintxt = new JLabel("수강과목관리");
		maintxt.setFont(font);
		maintxt.setBounds(400, 300, 400, 50);
		add(maintxt);

		font = new Font("", Font.PLAIN, 15);

		subjecttf = new JTextField();
		subjecttf.setBounds(400, 360, 300, 30);
		add(subjecttf);

		addsub = new JButton("과목추가");
		addsub.setFont(font);
		addsub.setForeground(Color.WHITE);
		addsub.setBackground(new Color(49, 98, 199));
		addsub.setBounds(710, 360, 145, 30);
		addsub.addActionListener(this);
		add(addsub);

		int size = z_0_FileManager.instance.userManager.get(0).subject.size();
		// System.out.println("size확인 = " + size);

		subject = new JLabel[size];
		delbtn = new JButton[size];

		font = new Font("", Font.PLAIN, 15);
		for (int i = 0; i < size; i++) {
			subject[i] = new JLabel(z_0_FileManager.instance.userManager.get(0).subject.get(i));
			subject[i].setFont(font);
			subject[i].setBounds(400, 420 + i * 40, 300, 30);
			add(subject[i]);

			delbtn[i] = new JButton("삭제");
			delbtn[i].setBackground(new Color(135, 0, 58));
			delbtn[i].setForeground(Color.WHITE);
			delbtn[i].setFont(font);
			delbtn[i].setBounds(710, 420 + i * 40, 145, 30);
			delbtn[i].addActionListener(this);
			add(delbtn[i]);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int size = z_0_FileManager.instance.userManager.get(0).subject.size();
		if (e.getSource() == goback) {
			a_0_Main.frame.setContentPane(new a_1_homeAdmin());
			a_0_Main.frame.revalidate();

		} else if (e.getSource() == addsub) {
			z_0_FileManager.instance.userManager.get(0).subject.add(subjecttf.getText());
			subjecttf.invalidate();
			a_0_Main.frame.setContentPane(new c_0_adminPanel());
			a_0_Main.frame.revalidate();
			z_0_FileManager.instance.saveData();///////

		} else if (e.getSource() == side_showAllStudent) {
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
		
		
		for (int i = 0; i < size; i++) {
			if (e.getSource() == delbtn[i]) {//// 이거 다시해야함

				int allsize = z_0_FileManager.instance.userManager.size();
				for (int j = 0; j < allsize; j++) {
					int usersubsize = z_0_FileManager.instance.userManager.get(j).subject.size();
					int check = -1;
					for (int k = 0; k < usersubsize; k++) {
						if (z_0_FileManager.instance.userManager.get(j).subject.get(k).equals(subject[i].getText())) {
							check = 1;
						}
					}

					if (check == 1) {
						z_0_FileManager.instance.userManager.get(j).subject.remove(subject[i].getText());

					}

				}

				a_0_Main.frame.setContentPane(new c_0_adminPanel());
				a_0_Main.frame.revalidate();
				z_0_FileManager.instance.saveData();//////
				
			}
		}

		z_0_FileManager.instance.saveData();//////
	}

}
