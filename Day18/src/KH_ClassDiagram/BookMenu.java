package KH_ClassDiagram;

import java.io.IOException;
import java.sql.Date;
import java.util.Scanner;

public class BookMenu {
	Scanner sc = new Scanner(System.in);
	private BookController bc;
	private Book[] bArr;
	
	
	BookMenu(){
		bc = new BookController();
		try {
			bc.makeFile();
		}catch(IOException e) {
			System.out.println("파일생성실패");
		}
		bArr = bc.fileRead();
	}
	public void mainMenu(){
		System.out.println("1. 도서 추가 저장");
		System.out.println("2. 저장 도서 출력");
		System.out.println("9. 프로그램 끝내기");
		int num = sc.nextInt();
		
		while(true) {
			switch (num) {
			case 1: {
				fileSave();				
				break;
			}
			case 2: {
				fileRead();				
				break;
			}
			case 9: {
				System.out.println("프로그램 종료~~~~~~@ㅡ@");
				return;
			}
			default:
				System.out.println("잘못 입력하셨소. 다시 입력하슈~");
			}
		}
	}
	public void fileSave() {
		System.out.println("도서 명 : ");
		String bn = sc.next();
		System.out.println("저자 명 : ");
		String an = sc.next();
		System.out.println("도서 가격 : ");
		int bp = sc.nextInt();
		System.out.println("출판 날짜(yyyy-mm-dd) : ");
		String pd = sc.next();
		System.out.println("할인율 : ");
		String dp = sc.next();
		
//		Date day = new Date();
		System.out.println("출판 날짜: "+day);
	}
	public void fileRead() {
		
	}
	
}
