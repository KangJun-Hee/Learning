package PPTSelf;

public class ClassBasic {

	public static void main(String[] args) {
		//이름, 신장, 체중 등을 멤버로 가지는 '사람 클래스'를 작성하자.
		//필드는 자유롭게 설정할 것.
		class Person{
						
			private String name;
			private double height;
			private double weight;
			private int age;

			//생성자
			Person(String n, double h, double w, int a) {
				name = n;
				height = h;
				weight = w;
				age = a;	
			}
			String getName() {return name;}
			
			
			
			
//		Person kjh = new Person("강준희", 294.3, 84.35, 35);
//		System.out.println(kjh.toStirng());
		}
		
	}

}
