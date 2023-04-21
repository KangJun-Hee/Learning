package chatting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerEx {

	public static void main(String[] args) {
		// 간단한 채팅 프로그램
		//  서로 한번씩 번갈아 가면서 문자열 전송 
		//  문자열 끝에 \n 덧붙여 보내고 라인 단위로 수신 
		//  종료 (bye) 클라이언트가 
		
		BufferedReader in = null;
		BufferedWriter out = null;
		ServerSocket listener = null;
		Socket socket = null;
		Scanner sc = new Scanner(System.in); // 키보드에서 읽을 내용
		
		try {
			// 서버 생성 
			listener = new ServerSocket(9999);
			System.out.println("연결을 기다리고 있습니다.....");
			// 클라이언트로 부터 연결 요청 대기 무한대기중!
			socket = listener.accept(); 
			
			in = new BufferedReader(new InputStreamReader(
									socket.getInputStream()));
			
			out = new BufferedWriter(new OutputStreamWriter(
									 socket.getOutputStream()));
			while(true) {
				// 클라이언트로 부터 한 행 씩 읽기!
				String inputMessage = in.readLine();
				
				if(inputMessage.equalsIgnoreCase("bye")) {
					System.out.println("클라이언트가 bye로 연결 종료!");
					break;
				}	
				System.out.println("클라이언트:"+inputMessage);
				System.out.print("서버>");
				String outputMessage = sc.nextLine();
				out.write(outputMessage +"\n");
				out.flush(); // 모든 내용을 전송!				
			}
			
		}catch(IOException e) {	}
		finally {
			sc.close();  // 스캐너 닫기
			try {
				socket.close();   // 통신용 소캣 닫기
				listener.close(); // 서버소캣닫기
				
			} catch (IOException e) {} 			
		}// finally 끝
	}
}
