package tcp;
import java.awt.*;
import java.awt.event.*;

public class ChatClient extends Frame implements ActionListener, MouseListener
{
   
   public TextField cc_tfLogon; // 로그온 입력 텍스트 필드
   public Button cc_btLogon; // 로그온 실행 버튼
   public Button cc_roomEnter; // 대화방 개설 및 입장 버튼
   public Button cc_btLogout; // 로그아웃 버튼
   public Button cc_roomcreate; // 방개설 버튼 

   public TextField cc_tfStatus; // 로그온 개설 안내
   public TextField cc_tfDate; // 개설시각
   public List cc_lstMember; // 대화방 참가자
   public List cc_roomlist; // 개설된 대화방 목록

   public static ClientThread cc_thread;
   public static ChatClient client;
   public String msg_logon="";
   public String cc_roomid = null;
   
   public ChatClient(String str){
      super(str);
      setLayout(new BorderLayout());

      // 로그온, 대화방 개설 및 입장 버튼을 설정한다.
      Panel bt_panel = new Panel();
      bt_panel.setLayout(new FlowLayout());
      cc_btLogon = new Button("로그온실행");
      cc_btLogon.addActionListener(this);
      bt_panel.add(cc_btLogon);
      
      cc_tfLogon = new TextField(10);
      bt_panel.add(cc_tfLogon);
            
      cc_btLogout = new Button("로그아웃");
      cc_btLogout.addActionListener(this);
      cc_btLogout.setEnabled(false);
      bt_panel.add(cc_btLogout);
      
      cc_roomEnter = new Button("대화방입장");
      cc_roomEnter.addActionListener(this);
      cc_roomEnter.setEnabled(false);
      bt_panel.add(cc_roomEnter);
      
      cc_roomcreate = new Button("대화방개설");
      cc_roomcreate.addActionListener(this);
      cc_roomcreate.setEnabled(false);
      bt_panel.add(cc_roomcreate);
      
      add("Center", bt_panel);

      // 4개의 Panel 객체를 사용하여 대화방 정보를 출력한다.
      Panel roompanel = new Panel(); // 3개의 패널을 담을 패널객체
      roompanel.setLayout(new BorderLayout());

      Panel northpanel = new Panel();
      northpanel.setLayout(new FlowLayout());
      cc_tfStatus = new TextField("하단의 텍스트 필드에 ID를 입력하십시오,",60); 

      // 대화방의 개설상태 알림
      cc_tfStatus.setEditable(false);
      northpanel.add(cc_tfStatus);  
      
      Panel centerpanel = new Panel();
      centerpanel.setLayout(new FlowLayout());
      centerpanel.add(new Label("로그온 시각 : "));
      cc_tfDate = new TextField("로그인 시각이 표시됩니다.", 47);
      cc_tfDate.setEditable(false);
      centerpanel.add(cc_tfDate);

      Panel southpanel = new Panel();
      southpanel.setLayout(new FlowLayout());
      southpanel.add(new Label("로그온 사용자"));
      cc_lstMember = new List(10);
      southpanel.add(cc_lstMember);
      southpanel.add(new Label("개설된 대화방"));
      cc_roomlist = new List(10);
      cc_roomlist.addMouseListener(this);
      southpanel.add(cc_roomlist);

      roompanel.add("North", northpanel);
      roompanel.add("Center", centerpanel);
      roompanel.add("South", southpanel);
      add("North", roompanel);
      pack();

      // 로그온 텍스트 필드에 포커스를 맞추는 메소드 추가
      addWindowListener(new WindowAdapter( ) {
     	 public void windowOpened(WindowEvent e) {
     		cc_tfLogon.requestFocus();
     	 }
       });

      addWindowListener(new WinListener());
   }

   class WinListener extends WindowAdapter
   {
      public void windowClosing(WindowEvent we){
    	 if(!msg_logon.equals(""))
    		 cc_thread.requestLogout(msg_logon);
         System.exit(0); // 나중에 로그아웃루틴으로 변경
      }
   }

   //로그온, 대화방 개설 및 입장버튼 눌림 이벤트를 처리한다.
   public void actionPerformed(ActionEvent ae){
      Button b = (Button)ae.getSource();
      if(b.getLabel().equals("로그온실행")) {
         //로그온 처리 루틴
         msg_logon = cc_tfLogon.getText(); //로그온 ID를 읽는다.
         if(!msg_logon.equals("")){
            cc_thread.requestLogon(msg_logon); // ClientThread의 메소드 호출
            cc_tfLogon.setEditable(false);
            cc_btLogon.setEnabled(false);
            cc_roomEnter.setEnabled(true);
            cc_btLogout.setEnabled(true);
            cc_roomcreate.setEnabled(true);
         }else{
            MessageBox msgBox = new  MessageBox(this, "로그온", "로그온 id를 입력하세요.");
            msgBox.show();
         }
      }
      else if(b.getLabel().equals("대화방입장")) {
         //대화방 개설 및 입장 처리 루틴
         msg_logon = cc_tfLogon.getText(); //로그온 ID를 읽는다.
         if(cc_roomid != null) {
        	 if(!msg_logon.equals("")){
        		 cc_thread.requestEnterRoom(msg_logon, cc_roomid); // ClientThread의 메소드를 호출
        		 cc_roomid=null;
        	 }else{
        		 MessageBox msgBox = new MessageBox(this, "로그온", "로그온을 먼저 하십시오.");
        		 msgBox.show();
           	 }
         }
         else {
        	 MessageBox nullmsgBox = new MessageBox(this, "없는방",  "현재 선택한 방이 없습니다.");
        	 nullmsgBox.show();
         }
      }
      else if(b.getLabel().equals("로그아웃")) {
      //로그아웃 처리 루틴
    	  msg_logon = cc_tfLogon.getText();
    	  if(!msg_logon.equals("")) {
    		  cc_thread.requestLogout(msg_logon);
    		  cc_tfLogon.setEditable(true);
    		  cc_btLogon.setEnabled(true);
    		  cc_roomEnter.setEnabled(false);
              cc_btLogout.setEnabled(false);
              cc_roomcreate.setEnabled(false);
    		  msg_logon="";
    	  }
    	  else {
    		  MessageBox msgBox = new MessageBox(this, "공백로그아웃", "현재 로그인이 되지 않은 상태입니다.");
    		  msgBox.show();
    	  }
      }
      else if(b.getLabel().equals("대화방개설")) {
      //대화방 개설루틴
    	  msg_logon = cc_tfLogon.getText();
    	  if(!msg_logon.equals("")) {
    		  cc_thread.requestCreateRoom(msg_logon);
    	  }
      }
   }

   public static void main(String args[]) {
      client = new ChatClient("대화방 개설 및 입장");
      client.setSize(350, 400);
      client.setVisible(true);
      client.pack();

      //소켓을 생성하고 서버와 통신할 스레드를 호출한다.
      
      // 서버와 클라이언트를 다른 시스템으로 사용하는 경우
      // 실행 : java ChatClient [호스트이름과 포트번호가 필요하다.]
      // To DO
      
      //서버와 클라이언트를 같은 시스템으로 사용하는 경우
      // 실행 : java ChatClient [호스트이름과 포트번호가 필요없다.]
      try{
         cc_thread = new ClientThread(client); //로컬 호스트용 생성자
         cc_thread.start(); //클라이언트의 스레드를 시작한다.
      }catch(Exception e){
         System.out.println(e);
      }
   }

@Override
public void mouseClicked(MouseEvent arg0) {
	cc_roomid = cc_roomlist.getSelectedItem();
	if(cc_roomid != null) {
		cc_thread.requestAlreadyUsers(cc_roomid);
	}
	System.out.println(cc_roomid);	
}

@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mousePressed(MouseEvent e) {
	
	
}

@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
}
