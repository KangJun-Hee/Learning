package Inheritance_bank;

public class Bank {

	String accNumber;
	String accName;
	int money;
	int pw;
}

class CheckCard extends Bank{
	
	String cardNumber;
	String cardName;
	int cardPw;
	
	void pay() {}
}
