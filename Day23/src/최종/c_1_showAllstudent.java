package 최종;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class c_1_showAllstudent extends JPanel implements ActionListener{
	JButton goback;
	JButton studentName;
	JButton studentId;
	JButton studentSubject;
	
	JLabel maintxt;
	JButton name;
	JButton id;
	JButton pw;
	JButton phone;
	JButton subject;
	
	
	c_1_showAllstudent(){
		setLayout(null);
		setBackground(Color.WHITE);
		
		Font font = new Font("", Font.BOLD, 25);
		maintxt = new JLabel("학생정보조회");
		maintxt.setFont(font);
		maintxt.setBounds(30, 50, 400, 50);
		add(maintxt);
		
		studentName = new JButton("이름");
		studentName.setBackground(Color.DARK_GRAY);
		studentName.setForeground(Color.WHITE);
		studentName.setBounds(30, 100, 150, 35);
		add(studentName);
		
		studentId = new JButton("ID");
		studentId.setBackground(Color.DARK_GRAY);
		studentId.setForeground(Color.WHITE);
		studentId.setBounds(180, 100, 150, 35);
		add(studentId);
		
		studentId = new JButton("PW");
		studentId.setBackground(Color.DARK_GRAY);
		studentId.setForeground(Color.WHITE);
		studentId.setBounds(330, 100, 150, 35);
		add(studentId);
		
		studentId = new JButton("Mobile");
		studentId.setBackground(Color.DARK_GRAY);
		studentId.setForeground(Color.WHITE);
		studentId.setBounds(480, 100, 250, 35);
		add(studentId);
		
		studentSubject = new JButton("수강과목");
		studentSubject.setBackground(Color.DARK_GRAY);
		studentSubject.setForeground(Color.WHITE);
		studentSubject.setBounds(730, 100, 400, 35);
		add(studentSubject);
		
		goback = new JButton(new ImageIcon("./src/최종/xIcon.png"));
		goback.setBounds(1130,0, 30, 30);
		goback.setBorder(null);
		goback.addActionListener(this);
		add(goback);
		
		
		
		
		int studentcnt = z_0_FileManager.instance.userManager.size()-1;
		
		for(int i=1;i<=studentcnt;i++) {
			name = new JButton(z_0_FileManager.instance.userManager.get(i).name);
			name.setBackground(Color.WHITE);
			name.setForeground(Color.BLACK);
			name.setBounds(30, 100 + i*35, 150, 35);
			add(name);
			
			
			id = new JButton(z_0_FileManager.instance.userManager.get(i).id);
			id.setBackground(Color.WHITE);
			id.setForeground(Color.BLACK);
			id.setBounds(180, 100 + i*35, 150, 35);
			add(id);
			
			pw = new JButton(z_0_FileManager.instance.userManager.get(i).pw);
			pw.setBackground(Color.WHITE);
			pw.setForeground(Color.BLACK);
			pw.setBounds(330, 100 + i*35, 150, 35);
			add(pw);
			
			phone = new JButton(z_0_FileManager.instance.userManager.get(i).phonenumber);
			phone.setBackground(Color.WHITE);
			phone.setForeground(Color.BLACK);
			phone.setBounds(480, 100 + i*35, 250, 35);
			add(phone);
			
			int subjectcnt = z_0_FileManager.instance.userManager.get(i).subject.size();
			String data = "";
			
			for(int j=0;j<subjectcnt;j++) {
				data += z_0_FileManager.instance.userManager.get(i).subject.get(j);
				
				if(j!=subjectcnt-1) {
					data += "/";
				}
			}
			
			subject = new JButton(data);
			subject.setBackground(Color.WHITE);
			subject.setForeground(Color.BLACK);
			subject.setBounds(730, 100 + i*35, 400, 35);
			add(subject);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==goback) {
			a_0_Main.frame.setContentPane(new c_0_adminPanel());
			a_0_Main.frame.revalidate();
		}
	}

}
