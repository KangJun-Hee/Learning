package Exception_Account;

import java.util.Scanner;

class AccountManager{
	int no;//계좌
	String name;//예금주
	private int money;//잔액
	private int pw;
	
	public AccountManager() {}
	public AccountManager(int no, String name, int money, int pw) {
		super();
		this.no = no;
		this.name = name;
		this.money = money;
		this.pw = pw;
	}
	void deposit() {
		Scanner sc = new Scanner(System.in);
		System.out.println("입금액:");
		int want1 = sc.nextInt();
		
		this.money += want1;
	}
	void withdraw(int total) throws MyAccount{
		if(this.money<total) {
			throw new MyAccount("출금금액을 확인하세요.");
		}else {
			this.money -= total;
			System.out.println("현재 잔액:"+this.money);
		}
	}}

//		Class명 : Account
//		속성 : no(계좌), name(예금주), private money(잔액)
//		생성자(기본 생성자 – 매개변수 O )
//		no=x
//		name=y
//		money=z
//		기능 : deposit() , withdraw()
//		deposit() : 매개변수만큼 예금(단위 만원)
//		withdraw() : 매개변수 만큼 출금(단위 만원)
		//출금액이 부족하면 한도 초과!출력과 예외처리!
		
		//check():계좌번호랑 비밀번호를 입력받는다.
		//			계좌등록시 입력한 비밀번호,현재입력비번 비교
		//			맞으면 출금함수 호출
		//			예외적 상황이 발생한다. "비번이 맞지 않습니다. 확인하세"
		
		//체크카드 발급
		//카드번호 카드비번. 외부에서 접근 불가능한 private
		//account 계좌의 내용을 체크카드가 상속구조
		//pay()만들어서 결제할 카드금액을 account 가지고 있는 출금 메서드로
		//넘긴다. 결과를 돌려 받는다. 카드금액만큼 결제되면 결제완료!
		
		//예외적상황 발생 한도초과!
		
		//카드로 결제를 합니다.

