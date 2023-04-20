package SelfPrac_Generic;

public class Main {

	public static void main(String[] args) {
		Goods goods1 = new Goods();
		goods1.set(new Apple());//Apple 저장
		Apple apple = (Apple)goods1.get();//Object->Apple
		
		Goods goods2 = new Goods();
		goods2.set(new Pencil());//Pencil 저장
		Pencil pencil = (Pencil)goods2.get();//Object->Pencil
		
	}

}
class Apple{}
class Pencil{}

//모든 타입 객체 저장 가능
class Goods{
	private Object object = new Object();
	public Object get() {
		return object;
	}
	public void set(Object object) {
		this.object = object;
	}
}