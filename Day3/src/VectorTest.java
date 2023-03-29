import java.util.Vector;
import java.util.Scanner;
public class VectorTest {

	public static void main(String[] args) {

		//이름을 저장하는 배열(백터구조로)
		//학번을 저장하는 배열, 점수를 저장하는 배열(백터구조로)
		Scanner sc = new Scanner(System.in);
		Vector<String> hak = new Vector<>();
		hak.add("이서희");
		hak.add("호호호");
		
		Vector<Integer> scores = new Vector<>();
		scores.add(2315);
		scores.add(3522);
		
		while(true) {
			System.out.println("---kh academy---");
			System.out.println("1.학번과 점수 추가");//학번기준
			System.out.println("2.학번과 점수 삭제");//학번기준
			System.out.println("3.학번과 점수 조회");//if, switch 상관무
			System.out.println("4.학번과 점수 파일저장");
			System.out.println("0.종료");
			//조회 학번조회를 하면 1.전체출력 2.조회하는 학번의 내용
		}
	}

}
