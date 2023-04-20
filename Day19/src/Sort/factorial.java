package Sort;

public class factorial {
	// 팩토리얼 재귀로 풀었을 때 

		public static int factorial(int n) {
			if (n <= 1) return 1;
			return n* factorial(n-1);
		}

	Scanner in = new Scanner(System.in);
			
			int n = in.nextInt();
			
			in.close(); // 이렇게 닫을 수도 있어요~사용이 끝나면
			// 단! 함부로 사용하게 되면 뒤에 입력을 받을 때 문제가
			// 생기니 close() 가장 나중에 하기!입니다!
			
					
			
			// 재귀함수
			// - 자기 자신을 다시 호출하여 문제를 해결해 가는 함수
			// StackOverflowError 스택이 넘쳐 흐를 수 있다.
			// 끝나는 조건을 잘 주어야된다.
			// - 새로운 함수를 계속 해서 스택에 쌓아간다.
			// 그러다 넘치면 예외가 발생한다.
			try {
				Function(5);
				int res = Function2(5);
				System.out.println(res);
				
				int sum = factorial(n);
				System.out.println(sum);
				

				// 1 + N까지의 합을 구하기!
				// 피보나치수열 구하기 
				
				
			} catch (StackOverflowError e) {
				System.out.println("재귀함수 예외발생 조건작성하기");
			}
			public class Main {
				 
				public static void main(String[] args) throws IOException {
			 
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					
					int N = Integer.parseInt(br.readLine());
					
					int sum = factorial(N);
					System.out.println(sum);
					
				}
				
				public static int factorial(int N) {
					if(N <= 1) return 1;	// 재귀 종료조건
					return N * factorial(N - 1);		
				}
			 
			}
}
