package Thread_synchronized;

public class Washroom {

	synchronized void openDoor(String name) {
		System.out.println(name + "입장");
		
		for(int i=0; i<100000; i++) {
			if(i == 10000) {
				System.out.println("끄으으응~");
			}
		}
		System.out.println(name + "아! 시원해!");
	}
}
