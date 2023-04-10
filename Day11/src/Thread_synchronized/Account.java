package Thread_synchronized;

import java.util.Scanner;

public class Account extends Thread{
	private String name; //계좌명
	private int pw;
	private int money = 1000000;	//잔액
	String who;
	
	public Account(String name, int pw) {
		this.name = name;
		this.pw = pw;
		
	}
	
	synchronized void withd(int pw, String name) {
		while(money == 0) {
		Scanner sc = new Scanner(System.in);
		System.out.println(name + "님 비밀번호를 입력하세요.");
		int inpw = sc.nextInt();
			if(inpw == pw) {
			System.out.println("출금액을 입력하세요.");
			int womn = sc.nextInt();	
				if(womn <= money) {
					money -= womn;
					System.out.println(name+"님이 "+womn+"원을 출금. 잔액:"+money+"원.");
			}else {
				System.out.println("한도초과 출금안됨");
			}
		}}
	}
	@Override
	public void run() {
		name.withd();
	}
	//출금 함수명 withd()매개변수는 비번, 접근자의 이름
	//기능:비번이 맞으면 출금액 입력 받고
	//출금액이 기존 돈보다 적으면 출금
	//				많으면 "한도초과 출금안됨"
	
	public static void main(String[] args) {
		Account ac = new Account("가족통장", 1234);
		
		ac.start();
	}
}
//Account a; 고객정보 받는 참조변수
//String name; 이용하는 사람의 정보!
//엄마가 10만원-> 내 통장엔 90만원 잔액
//아빠가 20만원 -> 내 통장엔 70만원 남음
//내가 30만원-> 내 통장엔 50만원 남음
class ATM{
	
}






