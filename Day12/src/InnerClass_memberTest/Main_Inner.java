package InnerClass_memberTest;
class hoyo{
	static int a=1;
	
	static class Inhoyo{
		String Infun() {
			return a+"살 stt냅클래스~";
		}
	}
}
public class Main_Inner {
	public static void main(String[] args) {
		String str = "";
		hoyo.Inhoyo obj = new hoyo.Inhoyo();
		str = obj.Infun();
}
}
