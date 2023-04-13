package Object;

public class User implements Cloneable{
	
	private String id,pw;

	public User(String id, String pw) {
		
		this.id = id;
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) { return true;}
		
		if (!(obj instanceof User)){return false;}
		
		User user = (User)obj;
		if(this.id == user.id && this.pw == user.pw) {
			return true;			
		}else{
			return false;
		}
	}
	@Override
	public int hashCode() {
		
		return super.hashCode();
		
	}
	
	// 오버라이딩이 재정의 (메서드 내용을 변경하는 것으로만)
	// 사용하는데 접근제어자의 변경 할 때 사용을 한다. 
	// User 클래스 객체들은 누구나 접근해서 복사할 수 있도록
	// 설정 
	
	
	//protected 접근제어 되어있으면 User클래스를
	//누군가 상속을 받아야함. 상속받은 자식클래스가
	//객체를 생성해야만 clone() 복사메서드를 사용가능.
	
	//무분별하게 객체들을 복사하는 경우가 생길 수 있다.
	//조건 인터페이스로 cloneable
	@Override
	public Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}
	
	
	// hashcode() 메서드 
	// 객체의 주소값을 이용해서 해싱 기법을 해시코드를 만든 후 반환
	// 서로 다른 객체는 같은 해시 코드를 가질 수 없다. 
	// 해시코드는 주소값은 아니고 주소값으로 만든 고유의 숫자값 
	// int형태로 표현 
		
	
	// equals() 
	// private id,pw 멤버 변수 
	// 생성자는 기본생성자 X
	// set,get메서드를 이용해서 사용
	
	// 회원가입시 qwer qwer 객체 생성을 한다.
	// User()
	
	// 로그인시 id, pw 
	// equals(Objcet o)
	// temp = User() scanner로 입력을 받아서 넘겨주면됨
	// 안에 id,pw비교해서 
	// 만약 두개 다 같다면 true -> 로그인 성공입니다.
	//						   userid  + "님 환영합니다"
	//                false -> 아이디 또는 비밀번호 확인하세요

}