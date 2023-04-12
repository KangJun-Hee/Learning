package IO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		//스트림(데이터 이동하는 통로)
		//input -> 외부에서 자바프로그램 안으로 가지고 들어옴.(읽기)
		//output -> 자바프로그램 안에서 외부로 나감.(저장)
		
//		InputStream input = null;
		//기본 프로젝트 주소에 저장이 된다.
		//
		
		
		
		//파일을 생성할 때 파일이 기존에 있으면 파일생성 안함
		// 그 안에 있는 내용을 싹 지우고 현재 저장되는 내용만 저장
		// 파일이 없다! 파일을 생성하고 내용 저장
		
		Scanner sc = new Scanner(System.in);
		//문자(텍스트 파일)
		FileWriter fw = null;
		
		try {
			String lo = "D:\\IO_test\\";
			String fileName = "ex01.txt";
			
			//1. 파일 생성
			fw = new FileWriter(lo+fileName);
		
			//2. 파일 내용 저장
			//문자열 안에서 특정한 행동을 한다.
			//\n 줄바꿈 \t탭만큼 \r커서를맨앞으로보냄
			fw.write("김철수/10, 이영희/30, 박민수/50 \n");
			fw.write("아 졸리다!\t");
			fw.write("아! 쉽다!");
			
			//3.파일 닫기
			fw.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println(fw);
		
		//바이트
		
		
		
		
		
		
		
		
	}

}
