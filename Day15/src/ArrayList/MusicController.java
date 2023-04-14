package ArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MusicController {

	//전역변수
	Scanner sc;
	//컨트롤러 안에 list를 생성했다.
	private ArrayList<Music> list = new ArrayList<>();
	
	
	//생성자
	public MusicController() {};
	public MusicController(Scanner sc) {
		this.sc = sc;
	}
	
	//리스트에 추가하는 addList(뮤직객체)
	int addList(Music temp) {
		
		//뷰 addList()에서 입력받아 만든 뮤직클래스의 객체
		//실제 컨트롤러에 있는 Arraylist에 추가한다. add(뮤직클래스의 객체)
		boolean res = list.add(temp);
		if(res) {
			return 1;//정상적으로 저장됐다. 뷰가 받는다.
		}else {
			return 0;
		}			
	}
	
	//스캐너 안 만들고 뷰가 가지고 있는
	//스캐너 사용할 것!
	void input() {
		
	}
	List<String> list = new ArrayList<>();
	
	int addAtZero(Music music) {
		return 0;}
	
	List printAll() {
		return null;
	}
	
	Music searchMusic(String title) {
		return null;}
	Music removeMusic(String title) {
		return null;}
	Music setMusic(String title, Music music) {
		return music;}
	
	int ascTitle() {
		return 0;}
	
	int descSinger(){
		return 0;}
}
