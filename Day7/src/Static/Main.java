package Static;

class Socar{
	
	//운전자명
	static String name;
}
class User{
	String name;
	
	User(String name){
		this.name = name;
	}
}




public class Main {

	public static void main(String[] args) {

		//접근, 실행을 할 때 클래스명.변수명;
		System.out.println("현재 count값:"+ Student.count);
		
		//학생들을 관리하는 배열을 선언
		//배열:동일한 자료형으로 여러개 선언!
		//내가 만든 자료형 배열을 선언!
		Student[] stulist = new Student[4];
		
		
		
		stulist[0] = new Student(Student.count++, "이서희");
		stulist[1] = new Student(Student.count++, "강동원");
		stulist[2] = new Student(Student.count++, "강준희");
		stulist[3] = new Student(Student.count++, "이보영");
		System.out.println(stulist[0].id);
		System.out.println(stulist[1].id);
		System.out.println(stulist[2].id);
		System.out.println(stulist[3].id);
		
		System.out.println(Student.count);
		
		
		
		
		
		
		
		
		//static 생성
//		Socar.name = "이서희";
		
//		User u2 = new User("김자바");
//		User u2 = new User("김이썬");
//		User u2 = new User("이스타일");
		
		
		
		//static "공유"
		//클래스의 필드와 메서드에 적용할 수 있다.
		//static필드 -> 클래스변수
		//static메서드 -> 클래스 메서드
		
		//클래스 변수(하나만)
		//공유를 위한 객체 외부 변수
		
		//인스턴스 변수(각각각)
		//객체 내부에 존재하는 변수
	}

}
