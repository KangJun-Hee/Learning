package sf_practice;

public class Abstract {

	public static void main(String[] args) {

	}
	abstract class Animal{
		private String name;
		public Animal(String name) {this.name = name;}
		public abstract void bark();
		public String getName() {return name;}
		
	}
	class Dog extends Animal{
		private String type;
		public Dog(String name, String type) {
			super(name); this.type = type;
		}
		public void bark() {System.out.println("멍멍!");
	}
		public class PrintArray {
		    public static void main(String[] args) {
		        int[][] arr = { { 1, 2 }, { 3, 4 }, { 5, 6, 7 } };
		 
		        System.out.println(Arrays.deepToString(arr));
		    }
		}

}
}