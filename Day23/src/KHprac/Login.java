package KHprac;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JPanel implements ActionListener{
	JButton login;
	JButton join;
	JButton fidpw;

	JLabel ulogin;
	JLabel idlb;
	JLabel pwib;
	JTextField idtf;
	JTextField pwtf;
	
	JButton mainimg;
	JLabel uinfo;
	JButton sidemenubtn;
	
	Login(){
		setLayout(null);
		setBackground(Color.white);
		
		mainimg = new JButton(new ImageIcon("덕성여대_.jpg"));
		mainimg.setBounds(0,0,1200,250);
		add(mainimg);
		
		Font font = new Font("맑은 고딕", Font.BOLD,25);
		
		uinfo = new JLabel("회원정보");
		uinfo.setFont(font);
		uinfo.setBounds(30,280,300,50);
		add(uinfo);
		
		font = new Font("", Font.PLAIN,17);
		login = new JButton("로그인");
		login.setFont(font);
		login.setBounds(0,340,300,40);
		login.setBackground(new Color(135,0,5));
		login.setForeground(Color.WHITE);
		add(login);
		
		join = new JButton("회원가입");
		join.setFont(font);
		join.setBounds(0, 380, 300, 40);
		join.setBackground(new Color(135,0,58));
		join.setForeground(Color.WHITE);
		join.addActionListener(this);
		add(join);
		
		
		fidpw = new JButton("ID/PW 찾기");
		fidpw.setFont(font);
		fidpw.setBounds(0, 420, 300, 40);
		fidpw.setBackground(new Color(135,0,58));
		fidpw.setForeground(Color.WHITE);
		fidpw.addActionListener(this);
		add(fidpw);
		
		font = new Font("", Font.BOLD, 20);
		ulogin = new JLabel("회원로그인");
		ulogin.setBounds(500, 350, 150, 40);
		ulogin.setFont(font);
		add(ulogin);
		
		
		font = new Font("", Font.BOLD, 15);
		idtf = new JLabel("아이디 : ");
		idtf.setFont(font);
		idtf.setBounds(400, 400, 90, 30);
		idtf.setHorizontalAlignment(JLabel.RIGHT);
		add(idtf);
				
		pwtf = new JLabel("패스워드 : ");
		pwtf.setFont(font);
		pwtf.setBounds(400, 440, 90, 30);
		pwtf.setHorizontalAlignment(JLabel.RIGHT);
		add(pwtf);		
				
		idtf = new JTextField();
		idtf.setBounds(500, 400, 250, 30);
		add(idtf);
		
		pwtf = new JTextField();
		pwtf.setBounds(500, 440, 250, 30);
		add(pwtf);
		
		font = new Font("", Font.BOLD, 15);
		login = new JButton("로그인");
		login.setFont(font);
		login.setBounds(500, 480, 250, 40);
		login.setBackground(new Color(135,0,58));
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
	}
	uinfo.setBounds(120,50,90,50);
	uinfo.setHorizontalAlignment(JLabel.CENTER);
	
	ActionListener uinfo_action = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int count = Integer.parseInt(uinfo.getText());
			count += 1;
			uinfo.setText(String.valueOf(count));
		}
	};
	uinfo.addActionListener(uinfo_action);
	
	ActionListener uinfo_action2 = new ActionListener() {
		@Override
		public void actionPerforme(ActionEvent e) {
			uinfo.setText("0");
		}
	};
	uinfo.addActionListener(uinfo_action);
	
	fr.getContentPane().add(uinfo);
	
	fr.setVisible(true);


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login) {
			int userListsize = FileManager.instance.usermanager.size();
			for(int i=0;i<userListsize;i++) {
				if(idft.getText().equals(FileManager.instance.userManager.get(i).id)) {
					Main.log = i;
					break;
				}
			}
		}
		
	}}
