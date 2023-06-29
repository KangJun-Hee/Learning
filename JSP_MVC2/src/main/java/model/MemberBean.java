package model;

/**
 * @author user1
 *
 */
public class MemberBean {
	private String id;
	private String pw;
	private String name;
	private String tel;
	private String email;
	private String field;
	private String skill;
	private String major;

	public MemberBean(String id, String pw, String name, String tel, String email, String field, String skill,
			String major) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.tel = tel;
		this.email = email;
		this.field = field;
		this.skill = skill;
		this.major = major;
	}

	public MemberBean() {
		super();
	}

	@Override
	public String toString() {
		return "MemberBean [id=" + id + ", pw=" + pw + ", name=" + name + ", tel=" + tel + ", email=" + email
				+ ", field=" + field + ", skill=" + skill + ", major=" + major + "]";
	}

	
	// alt + shift + s,r
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

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	// 생성자 만들 시
	// 기본 생성자랑 매개변수 받는 생성자를 만드는데 여기서 수정할 때 데이터를
	// 다시 저장하는 매개변수 생성자
	
	
	
	
}
