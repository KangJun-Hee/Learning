package chatting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx {

	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedWriter out = null;

		Socket socket = null;
		Scanner sc = new Scanner(System.in); // 키보드에서 읽을 내용

		try {
			// 클라이언트 소캣 생성 , 서버에 연결 (자동연결됨)
			// 둘 중 하나라도 없으면 연결X 소캣은 생성된다!
			socket = new Socket("localhost",9999);
			
			in = new BufferedReader(new InputStreamReader(
									socket.getInputStream()));

			out = new BufferedWriter(new OutputStreamWriter(
									socket.getOutputStream()));
			
			while(true) {
				System.out.println("클라이언트 >");
				
				// 클라이언트로 부터 한 행 씩 읽기!
				// 클라이언트가 먼저 시작! 
				String outputMessage = sc.nextLine();
				
				if(outputMessage.equalsIgnoreCase("bye")) {
					out.write(outputMessage +"\n");
					out.flush();
					break; // 서버로 전송 후 끝내기!
				}	
				System.out.print(outputMessage +"\n");
				out.flush(); // 만약 bye 안해도 전송 
				
				// 서버에서 한 행 수신 
				String inputMessage = in.readLine();
				System.out.println("서버:" + inputMessage);
					
			}
		} catch (IOException e) {}
		finally {
			sc.close();  // 스캐너 닫기
			try {
				
				if(socket != null) socket.close();   // 통신용 소캣 닫기
												
			} catch (IOException e) {
				System.out.println("서버와 채팅 중 오류가 발생했다!");
			} 			
		}// finally 끝

	}
}
