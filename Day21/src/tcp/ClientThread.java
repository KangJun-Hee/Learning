package tcp;
import java.io.*;
import java.util.*;
import java.net.*;

public class ClientThread extends Thread
{
   
   private ChatClient  ct_client; // ChatClient 객체
   private Socket ct_sock; // 클라이언트 소켓
   private DataInputStream ct_in; // 입력 스트림
   private DataOutputStream ct_out; // 출력 스트림
   private StringBuffer ct_buffer; // 버퍼
   private Thread thisThread;
   private DisplayRoom room;
   private String roomname;
   public String displayid;
   public String whisperid = null;

   private static final String SEPARATOR = "|";
   private static final String DELIMETER = "`";

   // 메시지 패킷 코드 및 데이터 정의

   // 서버에 전송하는 메세지 코드
   private static final int REQ_LOGON = 1001;
   private static final int REQ_CREATEROOM = 1010;
   private static final int REQ_ENTERROOM = 1011;
   private static final int REQ_UESRLIST = 1012;
   private static final int REQ_SENDWORDS = 1021;
   private static final int REQ_WHISPER = 1022;
   private static final int REQ_LOGOUT = 1031;
   private static final int REQ_QUITROOM = 1041;

   // 서버로부터 전송되는 메시지 코드
   private static final int YES_LOGON = 2001;
   private static final int NO_LOGON = 2002;
   private static final int YES_CREATEROOM = 2009;
   private static final int NO_CREATEROOM = 2010;
   private static final int YES_ENTERROOM = 2011;
   private static final int NO_ENTERROOM = 2012;
   private static final int MDY_USERID = 2013;
   private static final int MDY_WAITUSERS = 2014;
   private static final int MDY_CHATUSERS = 2015;
   private static final int MDY_ROOMUSERS = 2016;
   private static final int MDY_WAITROOMS = 2017;
   private static final int WAITROOM = 2018;
   private static final int CHATROOM = 2019;
   private static final int YES_SENDWORDS = 2021;
   private static final int NO_SENDWORDS = 2022;
   private static final int YES_WHISPERSEND = 2023;
   private static final int NO_WHISPERSEND = 2024;
   private static final int YES_LOGOUT = 2031;
   private static final int NO_LOGOUT = 2032;
   private static final int YES_QUITROOM = 2041;
   private static final int YES_USERLIST = 2042;

   // 에러 메시지 코드
   private static final int MSG_ALREADYUSER = 3001;
   private static final int MSG_SERVERFULL = 3002;
   private static final int MSG_CANNOTOPEN = 3011;

   private static MessageBox msgBox, logonbox;

   /* 원격호스트와 연결을 위한 생성자
          실행 : java ChatClient 호스트이름 포트번호 
   	  To DO .....				*/

   // 로컬호스트에서 사용하기 위하여 만든 생성자
   // 서버와 클라이언트가 같은 시스템을 사용한다. 
   public ClientThread(ChatClient client) {
      try{
         ct_sock = new Socket(InetAddress.getLocalHost(), 2777);
         ct_in = new DataInputStream(ct_sock.getInputStream());
         ct_out = new DataOutputStream(ct_sock.getOutputStream());
         ct_buffer = new StringBuffer(4096);
         thisThread = this;
         ct_client = client; // 객체변수에 할당
      }catch(IOException e){
         MessageBoxLess msgout = new MessageBoxLess(client, "연결에러", "서버에 접속할 수 없습니다.");
         msgout.show();
      }
   }

   public void run(){

      try{
         Thread currThread = Thread.currentThread();
         while(currThread == thisThread){ // 종료는 LOG_OFF에서 thisThread=null;에 의하여
            String recvData = ct_in.readUTF();
            System.out.println(recvData);
            StringTokenizer st = new StringTokenizer(recvData, SEPARATOR);
            int command = Integer.parseInt(st.nextToken());
            switch(command){

               // 로그온 성공 메시지  PACKET : YES_LOGON|로그인시각|ID1`ID2`ID3...
               case YES_LOGON:{
                  logonbox.dispose();   
                  ct_client.cc_tfStatus.setText("로그온이 성공했습니다.");
                  String date = st.nextToken(); // 로그인 시각
                  ct_client.cc_tfDate.setText(date);
                  String ids = st.nextToken(); // 대화방 참여자 리스트
                  StringTokenizer users = new StringTokenizer(ids, DELIMETER);
                  while(users.hasMoreTokens()){
                     ct_client.cc_lstMember.add(users.nextToken());
                  }
                  break;
               }
               
            // 로그온 실패 또는 로그온하고 대화방이 개설되지 않은 상태
               // PACKET : NO_LOGON|errCode
               case NO_LOGON:{
                  int errcode = Integer.parseInt(st.nextToken());             
                  if(errcode == MSG_ALREADYUSER){
                     logonbox.dispose();
                     msgBox = new MessageBox(ct_client, "로그온", "이미 다른 사용자가 있습니다.");
                     ct_client.cc_tfLogon.setEditable(true);
                     ct_client.cc_btLogon.setEnabled(true);
                     ct_client.cc_roomEnter.setEnabled(false);
                     ct_client.cc_btLogout.setEnabled(false);
                     ct_client.cc_roomcreate.setEnabled(false);
                     msgBox.show();
                  }else if(errcode == MSG_SERVERFULL){
                     logonbox.dispose();
                     msgBox = new MessageBox(ct_client, "로그온", "대화방이 만원입니다.");
                     msgBox.show();
                     ct_client.cc_tfLogon.setEditable(true);
                     ct_client.cc_btLogon.setEnabled(true);
                     ct_client.cc_roomEnter.setEnabled(false);
                     ct_client.cc_btLogout.setEnabled(false);
                     ct_client.cc_roomcreate.setEnabled(false);
                   
                  }
                  break;
               }
               
               // 대기실에 있는 유저목록을 갱신.
               case MDY_WAITUSERS: {
            	   String ids = st.nextToken();
            	   StringTokenizer users = new StringTokenizer(ids, DELIMETER);
            	   ct_client.cc_lstMember.removeAll();
            	   while(users.hasMoreTokens()) {
            		  ct_client.cc_lstMember.add(users.nextToken());            		
            	   }
            	   break;
               }
               
               // 채팅방에 있는 유저목록을 갱신.
               case MDY_ROOMUSERS : {           	   
            	   String ids = st.nextToken();
            	   StringTokenizer roomusers = new StringTokenizer(ids, DELIMETER);           	 
            	   room.dr_lstMember.removeAll();
            	   while(roomusers.hasMoreTokens()) {
            		   room.dr_lstMember.add(roomusers.nextToken());
            	   }
            	   break;
               }
               
               // 대기실에 있는 룸리스트를 갱신.
               case MDY_WAITROOMS : {
            	   String roomlist = st.nextToken();
            	   StringTokenizer roomlists = new StringTokenizer(roomlist, DELIMETER);
            	   ct_client.cc_roomlist.removeAll();
            	   while(roomlists.hasMoreTokens()) {
            		  ct_client.cc_roomlist.add(roomlists.nextToken());            		
            	   }
            	   break;
               }
               
               

               // 대화방 개설 성공 메시지  PACKET : YES_CREATEROOM|ROOMID|ROOMLIST
               case YES_CREATEROOM:{
            	  roomname = st.nextToken();
            	  String roomlist = st.nextToken();            	 
            	  StringTokenizer roomlists = new StringTokenizer(roomlist, DELIMETER);
            	  while(roomlists.hasMoreTokens()){
                     ct_client.cc_roomlist.add(roomlists.nextToken());
                  }                 
            	  ct_client.dispose(); // 로그온 창을
                  room = new DisplayRoom(this, roomname);
                  room.pack();
                  room.show(); // 대화방 창을 출력한다.
                  break;
               }
               
               // 대화방 입장 성공 메시지  PACKET : YES_ENTERROOM|ID|ROOMNAME
               case YES_ENTERROOM:{
            	   roomname = st.nextToken();
                   ct_client.dispose(); //로그온 창을 지운다.
                   room = new DisplayRoom(this, roomname);
                   room.pack();
                   room.show(); //대화방 창을 출력한다.
                   break;
                }

               // 대화방 개설 및 입장 실패 메시지  PACKET : NO_ENTERROOM|errCode
               case NO_ENTERROOM:{
                  int roomerrcode = Integer.parseInt(st.nextToken());
                  if(roomerrcode == MSG_CANNOTOPEN){
                     msgBox = new MessageBox(ct_client, "대화방입장", "로그온된 사용자가 아닙니다.");
                     msgBox.show();
                  }   
                  break;
               }

               // 대화방에 참여한 사용자 리스트를 업그레이드 한다.
               // PACKET : MDY_USERIDS|id
               case MDY_USERID:{
                  room.dr_lstMember.removeAll(); // 모든 ID를 삭제한다.
                  String id = st.nextToken(); // 대화방 참여자 리스트           
                  room.dr_lstMember.add(id);                
                  break;
               }
               
               // 대화방에 참여한 리스트를 받아옵니다.
               // PACKET : YES_USERLIST|CHATUSERS
               case YES_USERLIST : {
            	   String chatusers = st.nextToken();
            	   msgBox = new MessageBox(ct_client, "대화방 유저리스트", "현재 대화방에 있는 유저는 "+chatusers+"입니다.");
                   msgBox.show();  
                   break;
               }

               // 수신 메시지 출력  PACKET : YES_SENDWORDS|ID|대화말
               case YES_SENDWORDS:{
                  String id = st.nextToken(); // �대화말 전송자의 ID를 구한다.
                  try{
                     String data = st.nextToken();
                     room.dr_taContents.append(id+" : "+data+"\n");
                  }catch(NoSuchElementException e){}
                  room.dr_tfInput.setText(""); // 대화말 입력 필드를 지운다.
                  break;
               }
               
               // 귓속말 수신 메시지 출력 PACKET : YES_WHISPERSEND|ID|WID|대화말
               case YES_WHISPERSEND : {
            	   String id = st.nextToken();
            	   try {
            		   String wid = st.nextToken();
            		   String whisperwords = st.nextToken();
            		   room.dr_taContents.append(id + " -> " + wid + " : " + whisperwords + "\r\n");
            	   }
            	   catch(NoSuchElementException e) {
            		   System.out.println("현재 그 원소는 없습니다.");
            	   }
            	   room.dr_tfInput.setText("");
            	   whisperid = null;
            	   break;
               }
               
               // 귓속말할 상대방이 존재하지 않을경우의 패킷 PACKET : NO_WHISPERSEND|오류메시지
               case NO_WHISPERSEND : {
            	   String words = st.nextToken();
            	   room.dr_taContents.append(words + "\r\n");
            	   room.dr_tfInput.setText("");
            	   break;
               }

               // LOGOUT 메시지 처리
               // PACKET : YES_LOGOUT 전송 받음.
               // 모두 나간 후 마지막으로 로그아웃 시  YES_LOGOUT|탈퇴자id|zero가 왔을 경우에는 리스트 클리어
               case YES_LOGOUT:{
            	   ct_client.cc_tfStatus.setText("로그아웃을 성공했습니다.");                   
                   String id = st.nextToken();                   
            	   String ids = st.nextToken(); // 대화방 참여자 리스트
                   if(ids.equals("zero")) {
                	   ct_client.cc_lstMember.removeAll();
                	   ct_client.cc_roomlist.removeAll();
                   }
                   else {
                	   StringTokenizer users = new StringTokenizer(ids, DELIMETER);
                	   ct_client.cc_lstMember.removeAll();
                	   ct_client.cc_roomlist.removeAll();
                   }
                   break;        
               }

               // 퇴실 메시지(YES_QUITROOM) 처리 PACKET : YES_QUITROOM|EXIST OR YES_QUITROOM|ZERO        
               case YES_QUITROOM:{
            	  String state = st.nextToken();
            	  if(state.equals("EXIST")) {
            		  room.dispose();
            		  ct_client.pack();
            		  ct_client.show();
            	  }
            	  else {
            		  ct_client.cc_roomlist.removeAll();
            		  room.dispose();
            		  ct_client.pack();
            		  ct_client.show();
            	  }
                  break;
               }

            } // switch 종료

            Thread.sleep(200);

         } // while 종료(스레드 종료)


      }catch(InterruptedException e){
         System.out.println(e);
         try {
			release();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

      }catch(IOException e){
         System.out.println(e);
         try {
			release();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
      }
   }

   // 네트워크 자원을 해제한다.
   public void release() throws IOException{
	   ct_sock.close();
	   ct_in.close();
	   ct_out.close();
   };

   // Logon 해킷(REQ_LOGON|ID)을 생성하고 전송한다.
   public void requestLogon(String id) {
      try{
         logonbox = new MessageBox(ct_client, "로그온", "서버에 로그온 중입니다.");
         logonbox.show();
         ct_buffer.setLength(0);   // Logon 패킷을 생성한다.
         ct_buffer.append(REQ_LOGON);
         ct_buffer.append(SEPARATOR);
         ct_buffer.append(id);
         displayid = id; 
         send(ct_buffer.toString());   // Logon 패킷을 전송한다.
      }catch(IOException e){
         System.out.println(e);
      }
   }
   
   // Logout패킷(REQ_LOGOUT|ID)를 생성하고 전송한다.
   public void requestLogout(String id) {
	   try {
		   ct_buffer.setLength(0);
		   ct_buffer.append(REQ_LOGOUT);
		   ct_buffer.append(SEPARATOR);
		   ct_buffer.append(id);
		   send(ct_buffer.toString());
	   }
	   catch(IOException e) {
		   System.out.println(e);
	   }
   }

   // CreateRoom 패킷(REQ_CREATEROOM|ID)을 생성하고 전송한다.
   public void requestCreateRoom(String id) {
	   try {
		   ct_buffer.setLength(0);
		   ct_buffer.append(REQ_CREATEROOM);
		   ct_buffer.append(SEPARATOR);
		   ct_buffer.append(id);
		   send(ct_buffer.toString());
	   }
	   catch(IOException e) {
		   System.out.println(e);
	   }
   }
   
   // EnterRoom 패킷(REQ_ENTERROOM|ID|id.rooms)을 생성하고 전송한다.
   public void requestEnterRoom(String id, String idroom) {
      try{
         
    	 ct_buffer.setLength(0);   // EnterRoom 패킷을 생성한다.
         ct_buffer.append(REQ_ENTERROOM);
         ct_buffer.append(SEPARATOR);
         ct_buffer.append(id);
         ct_buffer.append(SEPARATOR);
         ct_buffer.append(idroom);
         send(ct_buffer.toString());   // EnterRoom 패킷을 전송한다.
      }catch(IOException e){
         System.out.println(e);
      }
   }
   
   // 방에 참여한 목록을 요청하는 패킷을 전송합니다. PACKET : (REQ_ALREADYUSER|ROOMID)
   public void requestAlreadyUsers(String roomid) {
	   try{	         
		   ct_buffer.setLength(0);   // EnterRoom 패킷을 생성한다.
	       ct_buffer.append(REQ_UESRLIST);
	       ct_buffer.append(SEPARATOR);
	       ct_buffer.append(roomid);
	       send(ct_buffer.toString());   // EnterRoom 패킷을 전송한다.
	   }catch(IOException e){
	       System.out.println(e);
	   }
   }   

   // QuitRoom 패킷(REQ_QUITROOM|ID)를 생성하고 전송한다.
   public void requestQuitRoom(String id) {
	   try {
		   ct_buffer.setLength(0);
		   ct_buffer.append(REQ_QUITROOM);
		   ct_buffer.append(SEPARATOR);
		   ct_buffer.append(id);
		   send(ct_buffer.toString());
	   }
	   catch(IOException e) {
		   System.out.println(e);
	   }	   		
   }
   
   // SendWords 패킷(REQ_SENDWORDS|ID|대화말)을 생성하고 전송한다.
   public void requestSendWords(String words) {
      try{
         ct_buffer.setLength(0);   // SendWords 패킷을 생성한다.
         ct_buffer.append(REQ_SENDWORDS);
         ct_buffer.append(SEPARATOR);
         ct_buffer.append(ct_client.msg_logon);
         ct_buffer.append(SEPARATOR);
         ct_buffer.append(words);
         send(ct_buffer.toString());   // SendWords 패킷을 전송한다.
      }catch(IOException e){
         System.out.println(e);
      }
   }
   
   // Whisper 패킷(REQ_WHISPER|ID|WID|대화말)을 생성하고 전송한다.  
   public void requestWhisper(String wid, String whisperwords) {
	   try {
		   ct_buffer.setLength(0);
		   ct_buffer.append(REQ_WHISPER);
		   ct_buffer.append(SEPARATOR);
		   ct_buffer.append(ct_client.msg_logon);
		   ct_buffer.append(SEPARATOR);
		   ct_buffer.append(wid);
		   ct_buffer.append(SEPARATOR);
		   ct_buffer.append(whisperwords);
		   send(ct_buffer.toString());
	   }
	   catch(IOException e) {
		   System.out.println(e);
	   }
   }
   
   // 클라이언트에서 메세지를 전송한다.
   private void send(String sendData) throws IOException {
      ct_out.writeUTF(sendData);
      ct_out.flush();
   }
}
