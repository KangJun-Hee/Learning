
public class Person {

	private String name;
	private int pn;
	private String adrs;
	
	public Person(String name, int pn) {
		this.name = name;
		this.pn = pn;
	}
	public Person(String name, int pn, String adrs) {
		this.name = name;
		this.pn = pn;
		this.adrs = adrs;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPn() {
		return pn;
	}
	public void setPn(int pn) {
		this.pn = pn;
	}
	public String getAdrs() {
		return adrs;
	}
	public void setAdrs(String adrs) {
		this.adrs = adrs;
	}
	}


