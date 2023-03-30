import java.util.ArrayList;
import java.util.Scanner;

/*네이버 클래스
 * 고객들의 정보를 저장만.
 */
class Account{
	//정보
	String id;
	String pw;
	
	//기본생성자
	Account(){} //객체를 생성()할 때 빈 객체로 저장된다.
	
	//생성자
	//객체를 생성()할 때 원하는 값으로 저장된다.
	//단! 기본생성자가 생기지 않는다. 비어있는 객체로 객체생성시 오류. 
	Account(String _id, String _pw){
		id = _id;
		pw = _pw;
	}
}
class Naver{
	//필드(정보)
	//고객들의 정보를 저장하는 타입<>
	ArrayList<Account> acclist = new ArrayList<>();
	
}

//고객의 정보
class User{
	User(String _id, String _pw, String phone, String _email) {
	}
	
	String id;
	String pw;
	String phone;
	String email;
	
	User k = new User("dwokk", "djei234", "010-3432-2323", "dkei@naver.com");
	User j = new User("wkid", "soeir994", "010-3828-2838", "id2k2@gmail.com");
	
	//예매정보를 저장하는 변수
//	Reservation res = new Reservation();
}

//예매정보
class Reservation{
	
	String movie_name;
	String movie_time;//영화시간
	int number_people;//인원수
	String movie_room;//몇 관인지 저장
	
	Reservation(String _movie_name, String _movie_time, int _number_people, String _movie_room) {
		movie_name = _movie_name;
		movie_time = _movie_time;
		number_people = _number_people;
		movie_room = _movie_room;
	}
	Reservation m = new Reservation("웅남이", "98분", 2, "5관");
}

//영화예매
class CGV{
	//고객들의정보를 저장하는 Arraylist선언
	//userlist 변수명
	//<> 내가 만든 고객 클래스 타입
	ArrayList<String> level = new ArrayList<>();
	//level.@add("top");
	
	//user정보는 본인 걸로!
	//웅남이 98분 5관 2명 데이터를 저장
	
	//각각의 객체들을 만들 때 생성자를 이용하면 좋을 것 같다!
	
}



public class ClassEx04 {

	public static void main(String[] args) {

		while(true) {
			System.out.println("---cgv---");
			System.out.println("1. 영화예매");
			System.out.println("2. 영화예매 조회");
			System.out.println("3. 영화예매 삭제");
			System.out.println("0. 영화예매 종료!");

			//입력받는 Scanner
			//입력받는 변수 만들고
			Scanner sc = new Scanner(System.in);
			System.out.println(" ");
			int choose = sc.nextInt();
			
			int sel = 0;
			switch(sel) {
			case 1:
				break;//예매정보 및 고객정보 입력 받아서 
						//객체생성 후 cgv리스트에 저장
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			default:
				System.out.println("다시 입력하세요!");
			}
		}
		
		
		
		
		
		
		
		
		//네이버 회사 생성
//		Naver com = new Naver();
		
		//네이버에 회원가입
		//id : qwer, pw:love
		
//		Account acc1 = new Account("qwer", "love");
		
		
		//acc1-> 네이버회의 고객정보 변수에 저장
//		com.acclist.add(acc1);
		
//		System.out.println(com.acclist.get(0));
	}

}
