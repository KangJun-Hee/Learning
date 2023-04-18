package MVC_TreeSet;

import java.util.Objects;

public class Lottery {

	String name;
	String phone;

	public Lottery() {
	}

	public Lottery(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Lottery [name=" + name + ", phone=" + phone + "]";
	}

	@Override
	public int hashCode() {
		return ;
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
