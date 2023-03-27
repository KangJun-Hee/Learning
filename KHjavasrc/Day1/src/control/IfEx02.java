package control;

public class IfEx02 {

	public static void main(String[] args) {

		/*
		 * #최대값 구하기
		 * 숫자 3개 입력받기
		 * 입력받은 것들 비교해서,
		 * 가장 큰 수 출력(MAX)
		 * 가장 작은 수 출력(MIN)
		 */
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("정수 세 개");
		int number1 = input.nextInt();
		int number2 = input.nextInt();
		int number3 = input.nextInt();
		
		int max = 0;
		int min = number1;
		
		//큰값
		if(max < number2) {
			max = number3;
		}
		if(max < number3) {
			max = number3;
		}
		
		//작은값
		if(max < number2) {
			max = number2;
		}
		if(max < number3) {
			max = number3;
		}
		System.out.println("최대값: " + max + ""최소값: " + min);
		//println()한 번만 써서
		//최대값:
		//최소값:
		
		
		
		
	}

}
