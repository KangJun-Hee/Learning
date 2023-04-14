package ArrayList;

import java.util.Scanner;

public class MusicView {//관리하는 클래스

	//프라이빗. 다른쪽으로 상속 안 됨.
	//이 스캐너 쓰려면 지금 생성된 주소값을 넘겨 줘야 함.
	private Scanner sc = new Scanner(System.in);
	
	//실제 화면에서 입력한 처리하는 부분
	private MusicController mc = new MusicController(sc);
	
	//이미 컨트롤러가 만들어 놓은 주소값을 가지고 주소값 복사해서
	//저장해서 사용하기
	
	
	void mainMenu() {
		
		//메서드가 실행될 때 Scanenr 주소값을 넘겨 준다.
		mc.input(sc);
		
		System.out.println("******* 메인 메뉴 *******");
		System.out.println("1. 마지막 위치에 곡 추가 \n "
				+ "2. 첫 위치에 곡 추가 \n 3. 전체 곡 목록 출력 "
				+ "\n 4. 특정 곡 검색 \n 5. 특정 곡 삭제 "
				+ "\n 6. 특정 곡 정보 수정 \n 7. 곡명 오름차순 정렬 "
				+ "\n 8. 가수명 내림차순 정렬 \n 9. 종료");
		System.out.println("메뉴 번호를 입력하세요");
		int sel = sc.nextInt();
		
		//위에서 메뉴를 선택한 sel 변수가 들어간다.
		switch (sel) {
		case 1: {
			//추가 메서드가 실행됨
			addList();
			
			//1. 뷰가 컨트롤러가 가지고 있는 arraylist 접근하기
			//자신이 가지고 있는 mc변수가 컨트롤러다
			mc.list.size();
			break;
		}
		case 2:{
			addAtZero();
		}
		case 3:{
			printAll();
		}
		case 4:{
			searchMusic();
		}
		case 5:{
			removeMusic();
		}
		case 6:{
			setMusic();
		}
		case 7:{
			ascTitle();
		}
		case 8:{
			descSinger();
		}
		case 9:{
			System.out.println("종료");
//			return main();
		}
		default:

		}
		
		
	}
	//뷰가 가지고 있는 addList()함수가 실행된다.
	void addList() {
		//뮤직에 대한 입력을 받는다.
		System.out.println("****** 마지막 위치에 곡 추가 ******");
		System.out.println("곡명:");
		String name = sc.next();
		
		System.out.println("가수명:");
		String sname = sc.next();
		
		//Music클래스를 만들어서 한꺼번에 넘겨준다.
		Music temp = new Music(name, sname);
		
		//실제 저장은 컨트롤러가 한다.
		//뷰입장에선 컨트롤러가 가진 list 안보여요!
		//addList() 컨트롤러에 메서드를 만들어서 뮤직 대한 객체에
		//주소값 주겠다.
		int res = mc.addList(temp); //컨트롤러의 메서드가 실행되면 리턴값이 1이면 저장
		if(res == 1) {
			System.out.println("추가완료~");
		}else {
			System.out.println("에러에러에러");
		}
		
	};
	void addAtZero() {
		System.out.println("****** 첫 위치에 곡 추가 ******");
		System.out.println("곡명:");
		String name = sc.next();
		
		System.out.println("가수명:");
		String sname = sc.next();	
		
		Music temp = new Music(name, sname);
		
		int res = mc.addList(temp); //컨트롤러의 메서드가 실행되면 리턴값이 1이면 저장
		if(res == 1) {
			System.out.println("추가성공~");
		}else {
			System.out.println("에러!에러!에러");
		}
	};
	String printAll(Music temp) {
		System.out.println("****** 전체 곡 목록 출력 ******");
		return temp;
	};
	
	
	
	void searchMusic() {
		System.out.println("****** 특정 곡 검색 ******");
		String src = sc.next();
		
		if(name.contains(src)) {
			System.out.println("검색한 곡은"+ name+"입니다.");
		}else {
			System.out.println("검색한 곡이 없습니다.");
		}	
	
	};
	
	
	
	void removeMusic() {
		System.out.println("****** 특정 곡 삭제 ******");{
		String remv = sc.next();
		
		if() {}
		else {}
		}
	};
	void setMusic() {
		System.out.println("****** 특정 곡 정보 수정 ******");
		String set = sc.next();
		set.indexOf(sosi);
	};
	void ascTitle() {
		for(int i=0; i+)
	};
	void descSinger() {};
	
	public class AscTitle implements Comparaor
}
