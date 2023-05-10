package 최종;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class d_1_subjectManagement extends JPanel implements ActionListener {
	JLabel maintxt;
	JLabel[] subject;
	JButton[] addbtn;
	JButton[] delbtn;
	JButton goback;

	JButton mainimg;
	JLabel sidemenuMaintxt;
	JButton sidemenubtn;
	JButton side_subjectManagement;
	JButton side_showAllSubject;

	JButton logout;

	d_1_subjectManagement() {

		setLayout(null);
		setBackground(Color.WHITE);

		//////////////////
		mainimg = new JButton(new ImageIcon("./src/최종/덕성여대_.jpg"));
		mainimg.setBounds(0, 50, 1200, 200);
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
		side_showAllSubject.setBackground(new Color(135, 0, 58));
		side_showAllSubject.setForeground(Color.WHITE);
		side_showAllSubject.addActionListener(this);
		add(side_showAllSubject);

		side_subjectManagement = new JButton("수강과목관리");
		side_subjectManagement.setFont(font);
		side_subjectManagement.setBounds(0, 380, 300, 40);
		side_subjectManagement.setBackground(new Color(135, 0, 58));
		side_subjectManagement.setForeground(Color.WHITE);
		side_subjectManagement.addActionListener(this);
		add(side_subjectManagement);

		goback = new JButton(new ImageIcon("./src/최종/홈.jpg"));
		goback.setBounds(0, 00, 50, 50);
		goback.setBorder(null);
		goback.addActionListener(this);
		add(goback);

		logout = new JButton(new ImageIcon("./src/최종/로그아웃.jpg"));
		logout.setBounds(50, 0, 50, 50);
		logout.setBorder(null);
		logout.addActionListener(this);
		add(logout);
		////////////////////////

		font = new Font("", Font.BOLD, 23);
		maintxt = new JLabel("수강신청/수강철회");
		maintxt.setFont(font);
		maintxt.setBounds(400, 300, 400, 50);
		add(maintxt);

		int adminSubSize = z_0_FileManager.instance.userManager.get(0).subject.size();
		int studentSubSize = z_0_FileManager.instance.userManager.get(a_0_Main.log).subject.size();
		System.out.println("size확인 = " + adminSubSize);

		subject = new JLabel[adminSubSize];
		addbtn = new JButton[adminSubSize];
		delbtn = new JButton[adminSubSize];

		font = new Font("", Font.BOLD, 17);

		for (int i = 0; i < adminSubSize; i++) {
			subject[i] = new JLabel(z_0_FileManager.instance.userManager.get(0).subject.get(i));
			subject[i].setFont(font);
			subject[i].setBounds(400, 370 + i * 40, 250, 30);
			add(subject[i]);

			int check = -1;
			for (int j = 0; j < studentSubSize; j++) {
				if (z_0_FileManager.instance.userManager.get(0).subject.get(i)
						.equals(z_0_FileManager.instance.userManager.get(a_0_Main.log).subject.get(j))) {
					check = 1;
				}

			}

			if (check == -1) {
				addbtn[i] = new JButton("수강신청");
				addbtn[i].setBackground(new Color(49, 98, 199));
				addbtn[i].setForeground(Color.WHITE);

				delbtn[i] = new JButton("-");
				delbtn[i].setBackground(Color.GRAY);
				delbtn[i].setForeground(Color.WHITE);
			}
			if (check == 1) {
				addbtn[i] = new JButton("신청완료");
				addbtn[i].setBackground(Color.GRAY);
				addbtn[i].setForeground(Color.WHITE);

				delbtn[i] = new JButton("수강철회");
				delbtn[i].setBackground(Color.PINK);
				delbtn[i].setForeground(Color.GRAY);
			}

			addbtn[i].setBounds(650, 370 + i * 40, 140, 30);
			addbtn[i].addActionListener(this);
			add(addbtn[i]);

			delbtn[i].setBounds(800, 370 + i * 40, 140, 30);
			delbtn[i].addActionListener(this);
			add(delbtn[i]);

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == goback) {
			a_0_Main.frame.setContentPane(new a_2_homeStudent());
			a_0_Main.frame.revalidate();
		} else if (e.getSource() == side_showAllSubject) {
			a_0_Main.frame.setContentPane(new d_0_studentPanel());
			a_0_Main.frame.revalidate();
		} else if (e.getSource() == logout) {
			a_0_Main.log = -1;
			a_0_Main.frame.setContentPane(new b_0_loginPanel());
			a_0_Main.frame.revalidate();
		}

		int adminSubSize = z_0_FileManager.instance.userManager.get(0).subject.size();
		for (int i = 0; i < adminSubSize; i++) {
			if (e.getSource() == addbtn[i]) {
				if (addbtn[i].getBackground().equals(new Color(49, 98, 199))) {
					// 수강신청
					z_0_FileManager.instance.userManager.get(a_0_Main.log).subject.add(subject[i].getText());
					addbtn[i].setBackground(Color.GRAY);
					addbtn[i].setText("신청완료");
					delbtn[i].setBackground(Color.PINK);
					delbtn[i].setText("수강철회");
					a_0_Main.frame.setContentPane(new d_1_subjectManagement());
					a_0_Main.frame.revalidate();
				} else if (addbtn[i].getBackground().equals(Color.gray)) {
					// 이미 수강신청된 과목임
					JOptionPane.showMessageDialog(null, "이미 수강신청이 완료된 과목입니다.", "오류", JOptionPane.WARNING_MESSAGE);
				}

			} // end of e.getsourse()==addbtn[i];

			// ---------------------------------------------------------------------
			if (e.getSource() == delbtn[i]) {
				if (delbtn[i].getBackground().equals(Color.PINK)) {
					// 수강신청철회할때
					z_0_FileManager.instance.userManager.get(a_0_Main.log).subject.remove(subject[i].getText());
					addbtn[i].setBackground(new Color(49, 98, 199));
					addbtn[i].setText("수강신청");
					delbtn[i].setBackground(Color.GRAY);
					delbtn[i].setText("-");
					a_0_Main.frame.setContentPane(new d_1_subjectManagement());
					a_0_Main.frame.revalidate();
				} else if (delbtn[i].getBackground().equals(Color.gray)) {
					// 이미 수강신청된 과목임
					JOptionPane.showMessageDialog(null, "수강신청한 과목이 아닙니다.", "오류", JOptionPane.WARNING_MESSAGE);
				}

			}

		} // end of 반복문

		z_0_FileManager.instance.saveData();

	}
}
