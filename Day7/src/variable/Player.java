package variable;
class Players{
	String name;
	int[] points;
	
	public Players(String name, int[] points) {
		this.name = name;
		this.points = points;
	}
	
	int totalPoints() {
		int sum = 0;
		for(int i=0; i<points.length; i++) {
			sum+=points[i];
		}
		return sum;
		
	}
	void printTotalPoints() {

		System.out.println(name+ " -> " +totalPoints()+ "점");
	}
}





public class Player {

	public static void main(String[] args) {
		int[] kp = {10, 9, 9, 8};
		int[] lp = {9, 10, 9, 9};
		int[] pp = {10, 9, 10, 10};
		
		Players p0 = new Players("Kim", kp);
		Players p1 = new Players("Lee", lp);
		Players p2 = new Players("Park", pp);
		
		p0.printTotalPoints();
		p1.printTotalPoints();
		p2.printTotalPoints();
	}

}
