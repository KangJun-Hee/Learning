package Override;

public class Point {
	//좌표를 저장하는 클래스
	int x;
	int y;
	
	//기존에 toStirng()
	//클래스명@주소값 이게 기본값 설정
	//단! 안에 있는 내용은 자식클래스에 맞게 변경하겠다
	@Override
	public String toString() {

		return "x:"+x+ " Y:"+y;
	}
	//좌표를 출력하는 메서드
	void info() {
		System.out.println("x:"+x+ " Y:"+y);
	}
}
class Point3D extends Point{
	int z;
	
	void info() {
		System.out.println("x:"+x+ " Y:"+y+ " z:"+z);
	}
}