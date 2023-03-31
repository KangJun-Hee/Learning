package methods;

public class 은행 {
	public static String 은행원(String 어떤업무, String 신분증) {
		System.out.println("고객님의 정보를 조회중!");
		System.out.println(어떤업무 + "엔 필요한 서류가 있습니다.");

		return "필요한 서류를 안내한다.";
	}
	public static void main(String[] args) {

		//대출업무
		//은행원
		
		String 서류저장 = 은행원("대출", "신분증제출");
		System.out.println("서류 준비완료!");
	}

}
