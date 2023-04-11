package Exception_Account;

public class MyAccount extends Exception{

	String msg;
	public MyAccount(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "한도초과!"+this.msg;
	}

}
