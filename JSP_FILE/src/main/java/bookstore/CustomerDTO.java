package bookstore;

public class CustomerDTO {

	
	// 이름 , 아이디 , 패스워드 , 가입일자 ,전화번호 , 주소 
	// 생성자(기본,매개변수)
	// setter , getter
	// toString() 

	private String id;					// 아이디
	private String passwd;					// 패스워드
	private String name;				// 이름
	private String reg_date;			// 가입일자
	private String tel;					// 전화번호
	private String address;				// 주소

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "[id=" + id + ", passwd=" + passwd + ", name=" + name + ", reg_date=" + reg_date + ", tel="
				+ tel + ", address=" + address + "]";
	}	
}
