package com.kh;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PollWrite {
	// 텍스트 파일에 저장할 데이터가 저장된 Arraylist를 넘겨 받아 텍스트 파일로 저장하는 메서드
	public static void pollWrite(String filepath,ArrayList<String> poll) {
		
		PrintWriter printwriter = null;
		
		try {
			
			printwriter = new PrintWriter(filepath);
			
			//Arraylist에 저장된 개수만큼 반복하며 텍스트 파일로 출력 한다
			// 텍스트 파일이 다 문자로 되어있기때문에 텍스트 파일안에서 
			// 줄을 바꾸거나 줄의 맨 앞쪽으로 이동을 해야된다 -> 엔터 
			// "\r\n"
			for(String str : poll) {
				printwriter.write(str +"\r\n");
			}
							
		}catch(FileNotFoundException e) {
			System.out.println("디스크에 파일이 존재하지 않는다.");
		}finally {
			// 예외가 발생 하든 안하든 무조건 파일을 열었으면 닫는 문장!
			// 텍스트 파일을 저장하는 객체를 닫는다.
			// 출력 객체를 닫지 낳으면 파일로 출력한 데이터가 저장 되지 않는다.
			if( printwriter != null) {
				printwriter.close();
			}
		}
		
	}
}
