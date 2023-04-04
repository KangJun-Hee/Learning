package Override;

public class Shape {
		String name;
		
		double Area(double a) {
			
			return a;
		}
	}
	class Squre extends Shape{
		double Area(double a) {
			int x;
			
			a = x*x;
			return a;
		}
	class Triangle extends Shape{
		double Area(double a) {
			int x;
			int y;
			
			a = x*y;
			return a;
		}
	}
	class Circle extends Shape{
		double Area(double a) {
			int x;
			
			a = x*;
			return a;
		}
	}
}
