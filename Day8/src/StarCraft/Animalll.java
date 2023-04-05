package StarCraft;


public class Animalll {

	public static void main(String[] args) {
		Dog d = new Dog("뭉치", "치와와");
		d.toString();
	}

}
//abstract=이 클래스에선 메서드 자체를 정의할 수 없으니,
//나로부터 파생된 클래스에서 정의해 주세요!
abstract class Animal{
	private String name;
	public Animal(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public abstract String toString();
	public void introduce() {
		System.out.println(toString()+"이다.");
		bark();
	}
	public abstract void bark();
}


class Dog extends Animal{
	private String type;
	
	public Dog(String name, String type) {
		super(name);
		this.type = type;
	}
	
	public void bark() {
		System.out.println("멍멍!");
	}
	@Override
	public String toString() {
		return type+"의"+getName();
	}
}
class Cat extends Animal{
	int age;

	public Cat(String name, int age) {
		super(name);
		this.age = age;
	}

	public void bark() {
		System.out.println("야옹~");
}

	@Override
	public String toString() {
		return age+"의"+getName();
	}}