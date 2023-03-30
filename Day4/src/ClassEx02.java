import java.util.ArrayList;
import java.util.Arrays;

//클래스 첫 글자는 대문자.
class Cat{
	//필드(정보, 상태)영역
	String name;
	String breeds;
	double weight;
	boolean d;
	//메서드(동작, 기능)영역
	void claw() {
		System.out.println("할퀴기");
	}
	void meow() {
		System.out.println("야옹!");
	}
}
//학생의 정보로
//필드 이름, 학번, 각 과목 점수는 배열로! map

class Stu{
	//학생의 정보 영역(필드)
	String name;
	int hakbun;
	//int[] scores = new int[3];
	ArrayList<Integer> scores = new ArrayList<>();
	
	//학생의 기능(동작) 영역
	void info() {
		System.out.println(name);
		System.out.println(hakbun);
		
		for(Integer num : scores) {
			System.out.println(num);
		}
		
		//Arrays.toString(scores);
	}
}
public class ClassEx02 {

	public static void main(String[] args) {
		//학생 개체 생성
		Stu student1 = new Stu();
		student1.name = "이서희";
		student1.scores.add(100);
		//이서희 학번: 1001 점수들: [10, 20, 30]
		student1.info(); //서희변수에 들어가서 함수(기능)실행
		
		Stu student2 = new Stu();
		student2.scores.add(25);
		student2.info();
		
		//프로젝트폴더 안에 여러개의 자바파일
		//클래스명은 중복 될 수 없다!
		
		//객체 생성
		//'자동으로 초기화'해 줌 String는 null로
		//int는 0, double은 0.00으로 초기화 됨
		//boolean은 false.
		Cat c = new Cat();
		
		//저장
		c.name = "나비";
		c.weight = 1.5;
		c.breeds = "먼치킨";
		
		System.out.println(c.name);
		System.out.println(c.weight);
		System.out.println(c.d);
	}

}
