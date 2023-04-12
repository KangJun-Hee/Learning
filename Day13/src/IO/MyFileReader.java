package IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyFileReader {
	
	public static void main(String[] args) {
	
		//file 읽기
		
		FileReader fr = null;
		BufferedReader br = null;	//중간에 버퍼생성(임시저장공간)
		
		
		try {
			fr = new FileReader("D:\\IO_test\\ex01.txt");
			br = new BufferedReader(fr); //FileReader버퍼랑연결됨
			
			 // 자식 클래스들이 구현해야할 read 추상 메서드  
		    // 바이트 하나를 읽어서 int로 반환하되, 
			//더 이상 읽을 값이 없으면 -1을 리턴.
			String str = br.readLine();	//한 줄 읽기
			System.out.println(str);
			
			str = br.readLine();
			System.out.println(str);
			
			str = br.readLine();
			System.out.println(str);
			
			fr.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
		
		try {
			
			for(int i = 0; i == 100; i++) {
				System.out.println(i+"번 줄 출력했습니다.");
				i +=1;
				if(i ==100) {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * 1. test.txt 파일명 폴더 현재 기본폴더
		 *  1번 줄 출력했습니다.
		 *  2번 줄 출력했습니다.
		 *  3번 줄 출력했습니다.
		 * ...
		 *  100번 줄 출력했습니다.
		 * 
		 * 저장(문자만)반복문
		 * 
		 * 2.읽기 반복문
		 * 
		 * 3.김철수/20, 이만수/30, 이영희/40
		 * 문자열 구분하는 함수 split() 
		 * 
		 * 4.가져와서 출력
		 * 	이름 : 김철수
		 *  나이 : 20
		 *  
		 *  이름 : 이만수
		 *  나이 : 30
		 * 
		 */
		
	
	}
}
