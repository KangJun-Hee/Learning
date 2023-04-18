package Set;

import java.util.HashMap;
import java.util.HashSet;

class Person{
	
	String name;
	int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	@Override
	public boolean equals(Object obj) {

		if(!(obj instanceof Person)) return false;
		
		Person temp = (Person)obj;
		
		return this.name.equals(temp.name)
				&& this.age == temp.age;
	}
	
	@Override
	public int hashCode() {

		return (name + age).hashCode();
	}
	
	
}




public class Main {

	public static void main(String[] args) {
		//문자열의 길이를 가지고 인덱스로 사용
		//문자열의 길이가 똑같다! 두 개의 데이터가
		//하나의 인덱스번호를 가지고 있는것=충돌
		//안의 공간을 여러개로 쪼개서 사용하면 된다~ 링크드나 배열어쩌고로
		
		//hash -> key가 String 무조건 쓴다.
		//중복없이. 안에 key값 모두 hashset
		//			안에 value가 중복허용 map
		
		HashTable h = new HashTable(3);
		h.put("sung","She is pretty");
		h.put("jin","She is a model");
		h.put("hee","She is an angel");
		h.put("min","She is cute");
		h.put("min","She is Pure");
		
		
		System.out.println(h.get("sung"));
		System.out.println(h.get("jin"));
		System.out.println(h.get("hee"));
		System.out.println(h.get("min"));
		System.out.println(h.get("min"));

		HashSet<Person> list = new HashSet<>();
		System.out.println(list);
		
		Person p1 = new Person("이서희", 10);
		int hashcode1 = p1.hashCode();
		int hashcode2 = p1.hashCode();
		
		System.out.println(hashcode1);
		System.out.println(hashcode2);
		//hashcode() 여러번 호출해도 동일한 값을 반환해야 한다.
		Person p2 = new Person("이서희", 10);
		
		boolean b = p1.equals(p2);
		
		hashcode1 = p1.hashCode();
		hashcode1 = p2.hashCode();
		
		System.out.println(hashcode1);
		System.out.println(hashcode2);
		//equals() 비교한 결과가 false 두 개의
		//hashCode()값이 같을 수도!
		//서로 다른 값을 반환하도록 작성!ㅜ
		
		
		
		
		//set
		// - 순서 x, 중복 x
		//hashset
		//	- set 인터페이스를 구현한 대표적인 컬렉션 클래스
		//	- 순서를 유지하고 싶을 때 LinkedhashSet클래스사용
		
		//treeset
		// - 범위 검색과 정렬에 유리한 클래스
		// - hashset보다 데이터를 추가, 삭제에 시간이 더 걸림
		
	}

}






//		HashSet<Integer> set = new HashSet<>();
//		
//		//추가
//		//set.add() 함수를 실행하고 나면 결과 true, false
//		set.add(2);
//		set.add(5);
//		set.add(3);
//		set.add(1);
//		set.add(4);
//		System.out.println(set);
//		
//		set.remove(1);
//		System.out.println(set);
//		
//		//set 계열 중간에 삽입하는 것이 안 된다.
//		//인덱스방번호가 없으니까!
//		
//		set.clear();
//		System.out.println(set);
//		
//		
//		//객체를 저장하기 전에 기존에 같은 객체가 있는지 확인
//		
//		list.add(new Person("이서희", 10));
//		list.add(new Person("이서희", 5));
//		list.add(new Person("이지희", 6));
//		list.add(new Person("이정희", 5));