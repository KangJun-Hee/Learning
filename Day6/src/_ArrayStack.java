class _ArrayStack{
	int top;     // 마지막 데이터가 어디인지 알려주는 방번호(인덱스)
	int size;    // 스택 배열의 크기
	User[] stack;
	
	// 기본생성자
	_ArrayStack(){}
	
	_ArrayStack(int size) {
		 this.size = size;
		 stack = new User[size];
		 top = -1; //일케해야 나중에 증가할 때 0부터 시작.
	}
	
	// 추가
	void push(User item) {
		stack[++top] = item;
		System.out.println(stack[top] +"push");
	}
	
	// 삭제 
	void pop() {
		System.out.println(stack[top] + "pop");
		User pop = stack[top];
		stack[top] = null; 
		top = top -1; 
	}
	// 조회
	void peek() {
		System.out.println(stack[top] + "peek!");
	}
	
}


//고객의 정보 
class User{
	


	// 고객정보
	String id;
	String pw;
	String phone;
	String email;
	
	
	User(){}
	public User(String id, String pw, String phone, String email) {
		this.id = id;
		this.pw = pw;
		this.phone = phone;
		this.email = email;
	}
	
	
	
	
	
	// 예매정보를 저장하는 변수 
	Reservation res = new Reservation();
}

//예매정보 
class Reservation{
	
	public Reservation(String movie_name, String movie_time, int number_people, String moive_room) {
		super();
		this.movie_name = movie_name;
		this.movie_time = movie_time;
		this.number_people = number_people;
		this.moive_room = moive_room;
	}

	String movie_name;    //영화이름
	String movie_time;    //영화시간
	int number_people;    //인원수
	String moive_room;    // 몇 관인지 저장 
	
	
	void setInfo(String )
	
	
}

public class CGV_movie {

	public static void main(String[] args) {
		//저장하는 메모리공간인 stack 생성 5명
		_ArrayStack stack = new _ArrayStack(5);
		
		//User 1
		User user1 = new User("qwer", "qqq111", "292-2838-2839", "dkfjdisfj@naver.com");
				
		//스택에 user1을 저장
		stack.push(user1);
		System.out.println();
			
		//user1 예매 웅남이 98분 2명 5관
		stack.stack[stack.top].res.setInfo("웅남이", "98분", 2, "5관");
		//삭제
		stack.pop();
	}
}
