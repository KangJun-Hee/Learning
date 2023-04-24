package tcp;
import java.io.*;
import java.net.*;
import java.util.*;

public class ServerThread extends Thread 
{
   private Socket st_sock;
   private DataInputStream st_in;
   private DataOutputStream st_out;
   private StringBuffer st_buffer;
   private String roomname="";
   /* 로그온된 사용자 저장 */
   private static Hashtable<String,ServerThread> logonHash; 
   private static Vector<String> logonVector;
   /* 대화방 참여자 저장 */
   private static Hashtable<String,ServerThread> roomHash; 
   private static Vector<String> roomVector;
   
   /* 대화방 저장 */
   private static Vector<String> userRoomVector;

   private static final String SEPARATOR = "|"; // 메시지간 구분자
   private static final String DELIMETER = "`"; // 소메시지간 구분자
   private static final String COMMA = ",";
   private static Date starttime;  	// 로그온 시각

   public String st_ID; 			// ID 저장

   // 메시지 패킷 코드 및 데이터 정의

   // 클라이언트로부터 전달되는 메시지 코드
   private static final int REQ_LOGON = 1001;
   private static final int REQ_CREATEROOM = 1010;
   private static final int REQ_ENTERROOM = 1011;
   private static final int REQ_UESRLIST = 1012;
   private static final int REQ_SENDWORDS = 1021;
   private static final int REQ_WHISPER = 1022;
   private static final int REQ_LOGOUT = 1031;
   private static final int REQ_QUITROOM = 1041;
   
   // 클라이언트에 전송하는 메시지 코드
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


   static{	
      logonHash = new Hashtable<String,ServerThread>(ChatServer.cs_maxclient);
      logonVector = new Vector<String>(ChatServer.cs_maxclient); 
      roomHash = new Hashtable<String,ServerThread>(ChatServer.cs_maxclient);
      roomVector = new Vector<String>(ChatServer.cs_maxclient); 
      userRoomVector = new Vector<String>(ChatServer.cs_maxclient);
   }

   public ServerThread(Socket sock){
      try{
         st_sock = sock;
         st_in = new DataInputStream(sock.getInputStream()); 
         st_out = new DataOutputStream(sock.getOutputStream());
         st_buffer = new StringBuffer(2048);
      }catch(IOException e){
         System.out.println(e);
      }
   }

   public void run(){
      try{
         while(true){
            String recvData = st_in.readUTF();
            System.out.println(recvData);
            StringTokenizer st = new StringTokenizer(recvData, SEPARATOR);
            int command = Integer.parseInt(st.nextToken());
            switch(command){

               // 로그온 시도 메시지 PACKET : REQ_LOGON|ID
               case REQ_LOGON:{
                  int result;
                  String id = st.nextToken(); // 클라이언트의 ID를 얻는다.
                  result = addUser(id, this);
                  st_buffer.setLength(0);
                  starttime = new Date();
                  if(result ==0){  // 접속을 허용한 상태
                     st_buffer.append(YES_LOGON); 
                     					// YES_LOGON|개설시각|ID1`ID2`..
                     st_buffer.append(SEPARATOR);
                     st_buffer.append(starttime);
                     st_buffer.append(SEPARATOR);
                     String userIDs = getUsers(); //대화방 참여 사용자ID를 구한다
                     st_buffer.append(userIDs);
                     send(st_buffer.toString());
                     modifyWaitUsers();
                     if(!userRoomVector.isEmpty())
                    	 modifyWaitRooms();
                  }else{  // 접속불가 상태
                     st_buffer.append(NO_LOGON);  // NO_LOGON|errCode
                     st_buffer.append(SEPARATOR);
                     st_buffer.append(result); // 접속불가 원인코드 전송
                     send(st_buffer.toString());
                     
                  }
                  break;
               }

               // 대화방 개설 시도메시지 PACKET : REQ_CREATEROOM|ID
               case REQ_CREATEROOM : {
            	   st_buffer.setLength(0);
                   String id = st.nextToken(); // 클라이언트의 ID를 얻는다.
                   
                   if(checkUserID(id) == null){

                   // NO_ENTERROOM PACKET : NO_ENTERROOM|errCode
                      st_buffer.append(NO_CREATEROOM);
                      st_buffer.append(SEPARATOR);
                      st_buffer.append(MSG_CANNOTOPEN);
                      send(st_buffer.toString());  // NO_CREATEROOM 패킷을 전송한다.
                      break;
                   }
                   String roomid = id+".room";
                   roomname = roomid;
                   //System.out.println(roomid);
                   roomVector.addElement(id);  // 사용자 ID 추가
                   roomHash.put(id, this); //사용자 ID 및 클라이언트와 통신할 스레드 저장
                   userRoomVector.addElement(roomid); // 사용자의 방이름 저장

                   
                   // YES_CREATEROOM PACKET : YES_CREATEROOM|ROOM|ROOMLIST
                   st_buffer.append(YES_CREATEROOM); 
                   st_buffer.append(SEPARATOR);
                   st_buffer.append(roomid);
                   st_buffer.append(SEPARATOR);
                   String roomlist = getRoomlist();
                   st_buffer.append(roomlist);
                   send(st_buffer.toString()); // YES_CREATEROOM 패킷을 전송한다.
                   modifyWaitRooms();
                   
                   //MDY_USERIDS PACKET : MDY_USERID|id
                   st_buffer.setLength(0);
                   st_buffer.append(MDY_USERID);
                   st_buffer.append(SEPARATOR);                
                   st_buffer.append(id);
                   send(st_buffer.toString());
                   break;
               }
               
               // 대화방 참가시도 메시지  PACKET : REQ_ENTERROOM|ID|ROOMID
               case REQ_ENTERROOM:{
                  st_buffer.setLength(0);
                  String id = st.nextToken(); // 클라이언트의 ID를 얻는다.
                  roomname = st.nextToken();
                  if(checkUserID(id) == null){

                  // NO_ENTERROOM PACKET : NO_ENTERROOM|errCode
                     st_buffer.append(NO_ENTERROOM);
                     st_buffer.append(SEPARATOR);
                     st_buffer.append(MSG_CANNOTOPEN);
                     send(st_buffer.toString());  // NO_ENTERROOM 패킷을 전송한다.
                     break;
                  }
                  roomVector.addElement(id);  // 사용자ID 추가
                  roomHash.put(id, this); //사용자 ID 및 클라이언트와 통신할 스레드저장
                  if(userRoomVector.contains(roomname)) {
                	  // YES_ENTERROOM PACKET : YES_ENTERROOM|ROOMID
                	  st_buffer.append(YES_ENTERROOM); 
                	  st_buffer.append(SEPARATOR);
                	  st_buffer.append(roomname);
                	  send(st_buffer.toString()); // YES_ENTERROOM 패킷을 전송한다.

                	  //MDY_ROOMUSERS PACKET : MDY_ROOMUSERS|ROOOMID|각방에 있는IDid1'id2' ....
                	  st_buffer.setLength(0);
                	  st_buffer.append(MDY_ROOMUSERS);
                	  st_buffer.append(SEPARATOR);               	
                	  String userIDs = getRoomUsers(); // 대화방 참여 사용자 ID를 구한다
                	  st_buffer.append(userIDs);
                	  System.out.println(st_buffer);
                	  broadcast(st_buffer.toString(),MDY_USERID); // MDY_USERIDS 패킷을 전송한다.               	 
                  }
                  break;
               }
               
               // 대화방 유저목록 요청 메시지 PACKET : REQ_ALREADYUSER|ROOMID
               case REQ_UESRLIST : {
            	  String roomname = st.nextToken();
            	  String chatlist = getRoomUsers(roomname);
            	  
            	  // YES_USERLIST|CHATLIST
            	  st_buffer.setLength(0);
            	  st_buffer.append(YES_USERLIST); 
            	  st_buffer.append(SEPARATOR);
            	  st_buffer.append(chatlist);
            	  send(st_buffer.toString());   
            	  break;
               }

               // 대화말 전송 시도 메시지 PACKET : REQ_SENDWORDS|ID|대화말
               case REQ_SENDWORDS:{
                  st_buffer.setLength(0);
                  st_buffer.append(YES_SENDWORDS);
                  st_buffer.append(SEPARATOR);
                  String id = st.nextToken(); // 전송한 사용자의 ID를 구한다.
                  st_buffer.append(id);
                  st_buffer.append(SEPARATOR);
                  try{
                     String data = st.nextToken(); // 대화말을 구한다.
                     st_buffer.append(data);
                  }catch(NoSuchElementException e){}
                  broadcast(st_buffer.toString(), YES_SENDWORDS); // YES_SENDWORDS 패킷 전송
                  break;
               }
               
               // 귓속말 전송 시도 메시지 PACKET : REQ_WHISPHER|ID|WID|대화말
               case REQ_WHISPER : {
            	   String id = st.nextToken();
            	   String wid = st.nextToken();
            	   String whisperwords = st.nextToken();
            	   // 송신자 클라이언트의 해시쓰레드를 구함.
            	   ServerThread SendThread = (ServerThread)roomHash.get(id);
            	   if(wid != null) {           		   
            		    st_buffer.setLength(0);
            		    st_buffer.append(YES_WHISPERSEND);
            		    st_buffer.append(SEPARATOR);
            		    st_buffer.append(id);
            		    st_buffer.append(SEPARATOR);
            		    st_buffer.append(wid);
            		    st_buffer.append(SEPARATOR);
            		    st_buffer.append(whisperwords);            		
            		    // 귓속말 메시지를 수신할 클라이언트에 전송함
            		    SendThread.send(st_buffer.toString());                 
            		    
            		    // 수신자 클라이언트의 해시쓰레드를 구함.
            		    ServerThread RecvThread = (ServerThread)roomHash.get(wid);                  
            		    st_buffer.setLength(0);
            		    st_buffer.append(YES_WHISPERSEND);
            		    st_buffer.append(SEPARATOR);
            		    st_buffer.append(id);
            		    st_buffer.append(SEPARATOR);
            		    st_buffer.append(wid);
            		    st_buffer.append(SEPARATOR);
            		    st_buffer.append(whisperwords); 
            		    // 귓속말 메시지를 수신할 클라이언트에 전송함
            		    RecvThread.send(st_buffer.toString());
            	  }
                  else {                	                	  	
                	  	st_buffer.setLength(0);
                	 	st_buffer.append(NO_WHISPERSEND);
                	 	st_buffer.append(SEPARATOR);
                	 	st_buffer.append("현재 그 사용자는 없습니다.\r\n");
                	 	SendThread.send(st_buffer.toString());
                 }	
                 break;
               }
               
               
               // LOGOUT 전송 시도 메시지 
               // PACKET : YES_LOGOUT|탈퇴자ID|탈퇴자 이외의 ids
               case REQ_LOGOUT:{
            	  String id = st.nextToken();           	  
            	  logonVector.remove(id);
            	  logonHash.remove(id,this);
            	  
            	  int vecsize = logonVector.size();
            	  System.out.println(vecsize);
            	  if(vecsize > 0) {
            		  String ids = getUsers();
            		  st_buffer.setLength(0);
            		  st_buffer.append(YES_LOGOUT);
            		  st_buffer.append(SEPARATOR);
            		  st_buffer.append(id);
            		  st_buffer.append(SEPARATOR);
            	  	  st_buffer.append(ids);
            	  	  send(st_buffer.toString());
            	  	  modifyWaitUsers();
            	  }
            	  else {
            		  st_buffer.setLength(0);
            		  st_buffer.append(YES_LOGOUT);
            		  st_buffer.append(SEPARATOR);
            		  st_buffer.append(id);
            		  st_buffer.append(SEPARATOR);
            		  st_buffer.append("zero");
            		  send(st_buffer.toString());
            		  modifyWaitUsers();
            	  }
                  break;
               }

               // 방 입장전의 퇴실하기 전송 시도 메시지  PACKET : YES_QUITROOM|EXIST
               // 방에 아무도 없을 경우 전송 시도 메시지 PACKET : YES_QUITROOM|ZERO
               case REQ_QUITROOM:{
            	  String id = st.nextToken();
            	  roomVector.remove(id);
            	  roomHash.remove(id, this);
            	  String roomids = getRoomUsers();
            	  if(roomids.equals("")) {
        			  userRoomVector.remove(roomname);          
        		  }            	 
            	  int vecsize = userRoomVector.size();
            	  if(vecsize>0) {
            		  st_buffer.setLength(0);
            		  st_buffer.append(YES_QUITROOM);
            		  st_buffer.append(SEPARATOR);
            		  st_buffer.append("EXIST");
            		  send(st_buffer.toString());
                	  modifyRoomUsers();
                	  modifyWaitRooms();
            	  }
            	  else {           		  
            		  st_buffer.setLength(0);
            		  st_buffer.append(YES_QUITROOM);
            		  st_buffer.append(SEPARATOR);
            		  st_buffer.append("ZERO");           		  
            		  send(st_buffer.toString());
            		  modifyWaitRooms();
            	  }
            	  break;
               }

            } // switch 종료

            Thread.sleep(100);
         } //while 종료

      }catch(NullPointerException e){ // 로그아웃시 st_in이 이 예외를 발생하므로
      }catch(InterruptedException e){
    	  try {
			release();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
      }catch(IOException e){
    	  try {
			release();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
      }
   }

   // 자원을 해제한다.

   public void release() throws IOException{
	   st_sock.close();
	   st_in.close();
	   st_out.close();
   }

   /* 해쉬 테이블에 접속을 요청한 클라이언트의 ID 및 전송을 담당하는 스레드를 등록.
    * 즉, 해쉬 테이블은 대화를 하는 클라이언트의 리스트를 포함 */
    private static synchronized int addUser(String id, ServerThread client){
      if(checkUserID(id) != null){
         return MSG_ALREADYUSER;
      }  
      if(logonHash.size() >= ChatServer.cs_maxclient){
         return MSG_SERVERFULL;
      }
      logonVector.addElement(id);  // 사용자ID 추가
      logonHash.put(id, client); // 사용자 ID 및 클라이언트와 통신할 스레드를 저장한다.
      client.st_ID = id;
      return 0; // 클라이언트와 성공적으로 접속하고, 대화방이 이미 개설된 상태.
   }

   /* 접속을 요청한 사용자의 ID와 일치하는 ID가 이미 사용되는지를 조사한다
    * 반환값이 null이라면 요구한 ID로 대화방 입장이 가능함. */
   private static ServerThread checkUserID(String id){
      ServerThread alreadyClient = null;
      alreadyClient = (ServerThread) logonHash.get(id);
      return alreadyClient;
   }
   
   // 대기실에 있는 유저를 갱신한다.
   private void modifyWaitUsers() throws IOException {
	   String ids = getUsers();
	   st_buffer.setLength(0);
	   st_buffer.append(MDY_WAITUSERS);
	   st_buffer.append(SEPARATOR);
	   st_buffer.append(ids);
	   broadcast(st_buffer.toString(), WAITROOM);
   }
   
   // 대기실의 채팅방 리스트를 갱신한다.
   private void modifyWaitRooms() throws IOException {
	   String rooms = getRoomlist();
	   st_buffer.setLength(0);
	   st_buffer.append(MDY_WAITROOMS);
	   st_buffer.append(SEPARATOR);
	   st_buffer.append(rooms);
	   broadcast(st_buffer.toString(), WAITROOM);
   }
   // 채팅방에 있는 유저를 갱신한다.
   private void modifyRoomUsers() throws IOException {
	   String ids = getRoomUsers();
	   st_buffer.setLength(0);
	   st_buffer.append(MDY_ROOMUSERS);
	   st_buffer.append(SEPARATOR);
	   st_buffer.append(ids);
	   broadcast(st_buffer.toString(), CHATROOM);
   }
   
   // 로그온에 참여한 사용자ID를 구한다.
   private String getUsers(){
      StringBuffer id = new StringBuffer();
      String ids;
      Enumeration<String> enu = logonVector.elements();
      while(enu.hasMoreElements()){
         id.append(enu.nextElement());
         id.append(DELIMETER); 
      }
      try{
         ids = new String(id);  // 문자열로 변환한다.
         ids = ids.substring(0, ids.length()-1); // 마지막 "'"를 삭제한다.
      }catch(StringIndexOutOfBoundsException e){
         return "";
      }
      return ids;
   }   

   // 대화방에 참여한 사용자 ID를 구한다.
   private String getRoomUsers(){
      StringBuffer id = new StringBuffer();
      String ids;
      Enumeration<String> enu = roomVector.elements();
      ServerThread client;
      while(enu.hasMoreElements()){
    	 client = (ServerThread)logonHash.get(enu.nextElement());
    	 if(client.roomname.equals(roomname)) {
    		 id.append(client.st_ID);
    		 id.append(DELIMETER); 
    	 }
      }
      try{
         ids = new String(id);
         ids = ids.substring(0, ids.length()-1); // 마지막 "'"를 삭제한다.
      }catch(StringIndexOutOfBoundsException e){
         return "";
      }
      return ids;
   }
   
   private String getRoomUsers(String roomid){
	      StringBuffer id = new StringBuffer();
	      String ids;
	      Enumeration<String> enu = roomVector.elements();
	      ServerThread client;
	      while(enu.hasMoreElements()){
	    	 client = (ServerThread)logonHash.get(enu.nextElement());
	    	 if(client.roomname.equals(roomid)) {
	    		 id.append(client.st_ID);
	    		 id.append(COMMA); 
	    	 }
	      }
	      try{
	         ids = new String(id);
	         ids = ids.substring(0, ids.length()-1); // 마지막 "'"를 삭제한다.
	      }catch(StringIndexOutOfBoundsException e){
	         return "";
	      }
	      return ids;
	   }
   
   // 대화방의 리스트를 구한다.
   private String getRoomlist(){
	   StringBuffer room = new StringBuffer();
	   String rooms;
	   Enumeration<String> enu = userRoomVector.elements();
	   while(enu.hasMoreElements()){
		   room.append(enu.nextElement());
		   room.append(DELIMETER); 
	   }
	   try{
		   rooms = new String(room);
		   rooms = rooms.substring(0, rooms.length()-1); // 마지막 "'"를 삭제한다.
	   }catch(StringIndexOutOfBoundsException e){
		   return " ";
	   }
	   return rooms;
   }

   // 대화방에 참여한 모든 사용자(브로드케스팅)에게 데이터를 전송한다.
   public synchronized void broadcast(String sendData, int room) throws IOException{
      ServerThread client;
      Enumeration<String> enu = roomVector.elements();
      if(room == WAITROOM ) {
    	enu = logonVector.elements();  
    	while(enu.hasMoreElements()){
    		client = (ServerThread)logonHash.get(enu.nextElement());
    		client.send(sendData);
    	}
      }
      else {
    	  enu = roomVector.elements();
    	  while(enu.hasMoreElements()){
      		client = (ServerThread) roomHash.get(enu.nextElement());
      		if(client.roomname.equals(roomname)) {
      			client.send(sendData);
      		}
      	}
      }
   }

   // 데이터를 전송한다.
   public void send(String sendData) throws IOException{
      synchronized(st_out){
         st_out.writeUTF(sendData);
         st_out.flush();
      }
   }
}   
