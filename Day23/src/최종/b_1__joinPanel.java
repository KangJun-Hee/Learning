package ����;

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

public class b_1__joinPanel extends JPanel implements ActionListener{
	JLabel maintxt;
	JLabel subtxt;
	
	JLabel namelb;
	JLabel idlb;
	JLabel pwlb;
	JLabel phonelb;
	
	JTextField nametf;
	JTextField idtf;
	JTextField pwtf;
	JTextField phonetf;
	
	
	JButton join;
	JButton goback;
	
	
	
	
	JButton mainimg;
	JLabel sidemenuMaintxt;
	JButton sidemenubtn;
	
	
	
	b_1__joinPanel(){
		setLayout(null);
		setBackground(Color.WHITE);
		
		//////////////////
		mainimg = new JButton(new ImageIcon("./src/����/��������_.jpg"));
		mainimg.setBounds(0, 50, 1200, 200 );
		add(mainimg);
		
		
		Font font = new Font("���� ���", Font.BOLD, 25);
        
        sidemenuMaintxt = new JLabel("ȸ������");
        sidemenuMaintxt.setFont(font);
        sidemenuMaintxt.setBounds(30, 280, 300, 50);
        add(sidemenuMaintxt);
        
        font = new Font("", Font.PLAIN, 17);
        sidemenubtn = new JButton("ȸ������");
        sidemenubtn.setFont(font);
        sidemenubtn.setBounds(0, 340, 300, 40);
        sidemenubtn.setBackground(new Color(135,0,58));
        sidemenubtn.setForeground(Color.WHITE);
        add(sidemenubtn);
        
        goback = new JButton(new ImageIcon("./src/����/Ȩ.jpg"));
		goback.setBounds(0,0, 50, 50);
		goback.setBorder(null);
		goback.addActionListener(this);
		add(goback);
		////////////////////////
        
        
        
		 font= new Font("", Font.BOLD, 23);
		maintxt = new JLabel("ȸ������");
		maintxt.setFont(font);
		maintxt.setBounds(450, 300, 400, 50);
		add(maintxt);
		
		font= new Font("", Font.PLAIN, 17);
//		subtxt = new JLabel("�ϴܿ� ������ ��� �Է����ּ���.");
//		subtxt.setFont(font);
//		subtxt.setBounds(120, 100, 500, 30);
//		add(subtxt);
		
		namelb = new JLabel("�̸� : ");
		namelb.setFont(font);
		namelb.setBounds(450, 370, 200, 30);
		nametf = new JTextField();
		nametf.setBounds(550, 370, 300, 30);
		
		idlb = new JLabel("���̵� : ");
		idlb.setFont(font);
		idlb.setBounds(450, 410, 200, 30);
		idtf = new JTextField();
		idtf.setBounds(550, 410, 300, 30);
		
		
		pwlb = new JLabel("�н����� : ");
		pwlb.setFont(font);
		pwlb.setBounds(450, 450, 200, 30);
		pwtf = new JTextField();
		pwtf.setBounds(550, 450, 300, 30);
		
		phonelb = new JLabel("��ȭ��ȣ : ");
		phonelb.setFont(font);
		phonelb.setBounds(450, 490, 200, 30);
		phonetf = new JTextField();
		phonetf.setBounds(550, 490, 300, 30);
		
		
		font= new Font("", Font.PLAIN, 20);
		join = new JButton("�����ϱ�");
		join.setFont(font);
		join.setBackground(new Color(135,0,58));
		join.setForeground(Color.WHITE);
		join.setBounds(450, 550, 400, 40);
		join.addActionListener(this);
		
		
		
		
		add(namelb);
		add(nametf);
		add(idlb);
		add(idtf);
		add(pwlb);
		add(pwtf);
		add(phonelb);
		add(phonetf);
		add(join);
		add(goback);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==join) {
			if(nametf.getText().equals("") || idtf.getText().equals("") || pwtf.getText().equals("") || phonetf.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "��� �׸��� �������ּ���.","����", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			z_1_userInfo user = new z_1_userInfo();
			user.name = nametf.getText();
			user.id = idtf.getText();
			user.pw = pwtf.getText();		
			user.phonenumber = phonetf.getText();
			
			z_0_FileManager.instance.addUser(user);
			JOptionPane.showMessageDialog(null, "ȸ�������� �Ϸ�Ǿ����ϴ�.","ȸ������", JOptionPane.WARNING_MESSAGE);
			a_0_Main.frame.setContentPane(new b_0_loginPanel());
			a_0_Main.frame.revalidate();


		}else if(e.getSource()==goback) {
			a_0_Main.frame.setContentPane(new b_0_loginPanel());
			a_0_Main.frame.revalidate();
		}
	}

}
