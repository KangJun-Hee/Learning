package methods;

public class Atm {

	//내가 현재 가지고있는 money, 입금금액
	public static int 입금(int money, int addmoney) {
		money = money + addmoney;
		return money;
	}
	public static void main(String[] args) {

		//main = 나.
		int money = 10000;
		//입금
		입금(money, 20000);
		//입금하고 난 총 잔액 확인 30000원
		System.out.println();
	}

}
