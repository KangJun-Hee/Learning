package InnerClass;

class Student{
	String name;
	int math, eng, kor;
	public Student(String n, int m, int e, int k) {
		name = n;
		math = m;
		eng = e;
		kor = k;
	}
	void score() {
		int total =3;
		class Avg{
			int sum = math + eng + kor;
			
			void grade() {
				//total = 4; //메서드 안의 클래스 함수에서 메서드 지역변수의
							//값 변경은 불가능(상수취급)
				System.out.println(sum/total);
			}
		}
		Avg a1 = new Avg();
		a1.grade();
		
		
		
		
	}//score()함수 끝
}


public class LocalClassMain {
	public static void main(String[] args) {
	
		Student s1 = new Student("이서희",60, 70, 80);
		s1.score();
		//로컬클래스
		// - 특정 메서드 내에 내부클래스를 선언
		// - 해당 메서드가 호출시 생성, 수행 종료시 소멸(지역변수처럼)
		// - 내부 클래스가 접근할 수 있는 지역변수 final변수만
		//		가능하다.
}
}
