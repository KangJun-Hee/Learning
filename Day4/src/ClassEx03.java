class Pokemon{
	//포켓몬 정보
	String name;	//이름
	double weight;	//몸무게
	String charact;	//특징
	
	//생성자
	//특징1: 리턴 타입이 없는 메서드.
	//특징2: 이름이 클래스명과 같다.

	//기본생성자
	Pokemon(){
		
	}
	//생성자(전설의 포켓몬)이름만
	Pokemon(String _name){
		name = _name;
	}
	//생성자
	Pokemon(String _name, double _weight, String _charact){
		name = _name;
		weight = _weight;
		charact = _charact;
	}
	//싸우는 기능
	void attack() {
		System.out.println(name + "의 펀치~!!!");
		
	}
}


public class ClassEx03 {

	public static void main(String[] args) {

		//푸린
		Pokemon p1 = new Pokemon(); //객체를 생성한다. p1 ->{name: null,
		p1.charact = "헤롱헤롱";		//weight: 0.0, charact:null}
		p1.weight = 5.5;			//p1->{charact:"헤롱헤롱", weight: 0.0}
		p1.name = "푸린";
		
		p1.attack();	//p1->{}.attack(); 기능을 실행
		
		
		
		//객체를 생성 동시에 초기화
		//p2->{name:"피카츄", "wei":3.5, "char":"백만볼트"}
		Pokemon p2 = new Pokemon("피카츄", 3.5, "백만볼트");
		
		p2.attack();
		
		//new
		//1. 메모리 공간 heap(힙 영역)
		//2. 생성자를 호출(실행)
		//3. ()괄호 안에 값이 있으면 원하는 값으로 초기화를 진행한다.
		//	()괄호 안에 값이 없으면 기본값 진행한다.
		//4. 만들어진 객체 어디있는지 주소값 부여하고
		//5. 그 주소값을 변수에 저장한다.
		
		//전설의 포켓몬(비밀스러워요~ 정보가 이름 뿐이다.)
		
		
		
		
		
		//생성자(constructor)
		//객체를 만드는 '특별한' 메서드
		
		//역할
		//-객체 생성(객체를 만드는 것)
		//-객체의 필드(변수)값을 설정하는 것~~~~~~~
		
		
		
		/*회원가입 member클래스
		 * 
		 * 꼭 받아야 되는 데이터
		 * id, name, email, pw, pw_check
		 * 
		 * 
		 * 선택사항(입력하면 입력한 값으로 저장, 입력x는 빈공간)
		 * 성별, 취미, 직업, 결혼여부
		 * f/m, 			truefalse
		 * 
		 * 클래스 생성자 이용해서 객체를 생성하세요~
		 * 본인 데이터 저장
		 * 
		 */
		class Member{
			String id, name, email, pw, pw_check;
			
			public Member(String id, String name, String email) {
				
				this.id = id;
				this.name = name;
				this.email = email;
			}
			
		//Member m = new Member("im_id", "이서희", "email@naver.com");
		
		
	}

}
