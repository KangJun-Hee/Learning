package members;

public class MemberVO {
	// VO(value object)클래스
	// 데이터 1건과 데이터를 처리하기 위한 메서드를 기억하는 클래스
	// bean -> 자바로 처리하는 최소한의 작업단위로 데이터를 기억하는 필드(멤버변수)와
	// 필드에 저장된 데이터를 출력하는 getter,setter메서드로만 구성된 클래스
	private String id;
	private String name;
	private String password;
	private int age;
	private boolean gender;
	private String ip;

	public MemberVO() {};
	public MemberVO(String id, String name, String password, int age, boolean gender, String ip) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.ip = ip;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", name=" + name + ", password=" + password + ", age=" + age + ", gender="
				+ gender + ", ip=" + ip + "]";
	}

}