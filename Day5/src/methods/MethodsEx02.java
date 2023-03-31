package methods;



	public class MethodsEx02 {
		
		
		
	public static int add(int a, int b) {
			return a + b;
	}
	public static int mult(int a, int b) {
		return a * b;
	}
	public static double div(int a, int b) {
		return (double)a / b;//나머지값
	}
	public static int loop(int d) {
		
		return d;
	}
	public static int maxNumber(int[] nums) {
		//배열의 길이를 확인
		int size = nums.length;
		return nums[size-1];
		
	}
	public static int minNumber(int[] nums) {
		
		return nums[0];
		
	}
	public static int info() {
		int i = 0;
		double i2 = 1.1;
		String i3 = "안녕";
		
		return i;
		//리턴은 함수가 종료하기 전에 결과값 하나를 main에게 내보낸다.
	}
	
	public static void main(String[] args) {
		//모든 결과값을 출력하는 건 main
		
		int a = 10, b = 20;
		
		//함수명 loop
		//매개변수 10
		//함수가 실행해야 되는 명령들
		//		1부터 매개변수의 값까지 더한다음
		//결과를 return 해서 출력하기
		int c = 1;
		int d = 10;
		
		//함수명:maxNumber, minNumber
		//3개의 정수를 매개변수로 받아서
		//가장 큰 값과 가장 작은 값 main에서 return 출력
		int[] nums = new int[3];
		int mn1 = 1;
		int mn2 = 2;
		int mn3 = 3;
		
		
		
		System.out.println(maxNumber(nums));
		//문자열을 비교하는 함수
		//함수명 equals
		//매개변수 srt1, str2
		//return true, false 둘중하나
		
		String str1 = "hello";
		String str2 = "world";
		
		
		//내가 만든 함수는 실제 시작을 main 안에서 해야한다.
		int res2 = mult(a, b);
		System.out.println("곱한 결과:" + res2);

		
		int res = add(a, b);
		
		System.out.println("더한 결과:" + res);
		
		
		
		
		
	}

		
		
		
		
		
		

		
	}


/*
public class MethodsEx02 {
	
	
	public static void show(int temp) {//void 없다
		
		System.out.println();
	}
	public static String input() {
		String name = "이서희";
		int number2 = 100;
		double number3 = 10.254;
		
		return name; //main에게 데이터를 보낸다.
	}
	public static int sq(int num) {
		num * num;
	}
	
	public static void main(String[] args) {
		
		int number = 10;
		
		//{}로 범위가 나눠진다. 데이터를 이동시킬 매개변수
		show(number);
		
		//내가 만든 함수에서 main으로 데이터를 이동시킬 것!
		String name = input();
		System.out.println(name);
		
		//하나의 정수를 Scanner로 받아서
		//제곱하는 함수를 만드세요
		//입력( ) <- 괄호 안에는 정수
		//함수명 sq
		//return 하셔도 되고 안하셔도 되고~
		//각각의 자료형 다름! 힌트~
	*/