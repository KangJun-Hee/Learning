import java.util.Scanner;

public class KH_Ex3 {

	public void practice3() {
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("입력하세요>");
		String ip = sc.next();
		
		System.out.println("검색할 문자를 입력하세요>");
		String sr = sc.next();
		
		if(ip.indexOf(sr)!=-1){
			int hoho = ip.length()-ip.replace(sr,"").length();
			System.out.println(hoho);
		}else {
			System.out.println("찾고 계신 문자가 없습니다.");
		}
		
	}

}
