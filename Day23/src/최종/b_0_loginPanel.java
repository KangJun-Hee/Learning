package 최종;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class b_0_loginPanel extends JPanel implements ActionListener{
	JButton login;
	JButton join;
	JButton find;
	
	JLabel maintxt;
	JLabel idlb;
	JLabel pwlb;
	JTextField idtf;
	JTextField pwtf;
	
	
	
	
	
	JButton mainimg;
	JLabel sidemenuMaintxt;
	JButton sidemenubtn;
	
	
	b_0_loginPanel(){
		setLayout(null);
		setBackground(Color.WHITE);
		
		////////////////////////////////////////////////////////////////////////////////
		mainimg = new JButton(new ImageIcon("./src/최종/덕성여대_.jpg"));
		mainimg.setBounds(0, 0, 1200, 250 );
		add(mainimg);
		
		
		Font font = new Font("맑은 고딕", Font.BOLD, 25);
        
        sidemenuMaintxt = new JLabel("회원정보");
        sidemenuMaintxt.setFont(font);
        sidemenuMaintxt.setBounds(30, 280, 300, 50);
        add(sidemenuMaintxt);
        
        font = new Font("", Font.PLAIN, 17);
        sidemenubtn = new JButton("로그인");
        sidemenubtn.setFont(font);
        sidemenubtn.setBounds(0, 340, 300, 40);
        sidemenubtn.setBackground(new Color(135,0,58));
        sidemenubtn.setForeground(Color.WHITE);
        add(sidemenubtn);
        
        
        join = new JButton("회원가입");
		join.setFont(font);
		join.setBounds(0, 380, 300, 40);
		join.setBackground(new Color(135,0,58));
		join.setForeground(Color.WHITE);
		join.addActionListener(this);
		add(join);
		
		
		find = new JButton("ID/PW 찾기");
		find.setFont(font);
		find.setBounds(0, 420, 300, 40);
		find.setBackground(new Color(135,0,58));
		find.setForeground(Color.WHITE);
		find.addActionListener(this);
		add(find);
		
		//////////////////////////////////////////////////////////////////////////////
		
		
		
		
		
		
		font = new Font("", Font.BOLD, 20);
		maintxt = new JLabel("회원로그인");
		maintxt.setBounds(500, 350, 150, 40);
		maintxt.setFont(font);
		add(maintxt);
		
		
		font = new Font("", Font.BOLD, 15);
		idlb = new JLabel("아이디 : ");
		idlb.setFont(font);
		idlb.setBounds(400, 400, 90, 30);
		idlb.setHorizontalAlignment(JLabel.RIGHT);
		add(idlb);
				
		pwlb = new JLabel("패스워드 : ");
		pwlb.setFont(font);
		pwlb.setBounds(400, 440, 90, 30);
		pwlb.setHorizontalAlignment(JLabel.RIGHT);
		add(pwlb);		
				
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
	
	
		
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login) {
			//String check_id = z_0_FileManager.instance.login(idtf.getText(), pwtf.getText());
			int userListsize = z_0_FileManager.instance.userManager.size();
			for(int i=0;i<userListsize;i++) {
				if(idtf.getText().equals(z_0_FileManager.instance.userManager.get(i).id)) {
					a_0_Main.log = i;
					break;
				}
			}
			System.out.println("log = " + a_0_Main.log);
			
			if(a_0_Main.log==0) {
				
				//idtf.getText().equals("admin") || pwtf.getText().equals("admin")
				a_0_Main.frame.setContentPane(new a_1_homeAdmin());
				a_0_Main.frame.revalidate();
			}
			else if(idtf.getText().equals("") || pwtf.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "아이디와 패스워드를 모두 입력해주세요","오류",JOptionPane.WARNING_MESSAGE);
			}else if(a_0_Main.log==-1) {
				JOptionPane.showMessageDialog(null, "아이디와 패스워드를 확인해주세요","오류",JOptionPane.WARNING_MESSAGE);
			}
			else if(a_0_Main.log!=-1 && a_0_Main.log!=0){
				
				a_0_Main.frame.setContentPane(new a_2_homeStudent());
				a_0_Main.frame.revalidate();
			}
			
		}else if(e.getSource()==find) {
			a_0_Main.frame.setContentPane(new b_2_findPanel());
			a_0_Main.frame.revalidate();
		}else if(e.getSource()==join) {
			a_0_Main.frame.setContentPane(new b_1__joinPanel());
			a_0_Main.frame.revalidate();
		}
	}
	
}