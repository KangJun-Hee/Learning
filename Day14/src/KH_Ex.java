import java.util.Scanner;

public class KH_Ex {

	public void practice1() {
		
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("양수를 입력하세요.");
		int num = sc.nextInt();
		
		
		
		if(num >0) {
			
			
			for(int i = 1; i<=num; i++) {
				if(i%2 == 0){
					System.out.println("수");
				}else if(i%2 == 1){
					System.out.println("박");}
				}
			}
		
		else if(num<=0) {
			System.out.println("양수가 아닙니다.");			
			}
	}
}
		
	