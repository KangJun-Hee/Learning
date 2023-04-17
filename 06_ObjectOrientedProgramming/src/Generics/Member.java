package Generics;

public class Member {
	private String name;
	private String pass;
	
	public Member() {}

	public Member(String name, String pass) {
		super();
		this.name = name;
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", pass=" + pass + "]";
	}
	
}
