package _05_User;

public class UserDTO {
	private String id;
	private String pw;
	private String name;
	private String reg_date;
	
	public UserDTO() {};
	
	public UserDTO(String id, String pw, String name, String reg_date) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.reg_date = reg_date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
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
}
