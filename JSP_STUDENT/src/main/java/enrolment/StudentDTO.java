package enrolment;

public class StudentDTO {
	private String hakbun;				//학번(id)
	private String passwd;				//비밀번호
	private String name;				//이름
	private String address;				//주소
	private String tel;					//전화번호
	private String email;				//이메일
	private String major;				//전공 (1==컴공, 2==전자공학, 3==응용수학 , 4==교양)
	private int grade;					//학년
	private int hakjom;					//학점(전공교양 합해서 130==>졸업조건)
	
	public StudentDTO() {}
	public StudentDTO(String hakbun, String passwd, String name, String address, String tel, String email, String major,
			int grade, int hakjom) {
		super();
		this.hakbun = hakbun;
		this.passwd = passwd;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.major = major;
		this.grade = grade;
		this.hakjom = hakjom;
	}
	public String getHakbun() {
		return hakbun;
	}
	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getHakjom() {
		return hakjom;
	}
	public void setHakjom(int hakjom) {
		this.hakjom = hakjom;
	}
	@Override
	public String toString() {
		return "StudentDTO [hakbun=" + hakbun + ", passwd=" + passwd + ", name=" + name + ", address=" + address
				+ ", tel=" + tel + ", email=" + email + ", major=" + major + ", grade=" + grade + ", hakjom=" + hakjom
				+ "]";
	}
	
	
}
