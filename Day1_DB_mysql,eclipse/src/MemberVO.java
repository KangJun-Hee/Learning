
public class MemberVO {
	private String id;
	private String pw;
	private String name;
	private String address;
	private String phone;

	
	public MemberVO() {};
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public MemberVO(String id,String pw) {
		this.id=id;
		this.pw=pw;
	}
	
	
	
	//데이터베이스에서 데이터를 가지고 와서 저장할 때 사용
	//클래스의 필드명은 테이블에 정의한 필드이름
	//	(ex:html의 form태그 요소의 name속성에 정의한 이름과 반드시 같은 이름을 만든다.)
	
	//VO(Value Object) vs DTO(Data Transfer Object)
	// - VO 값만 담는 객체
	// - DTO 값,객체끼리 통신할 때 통신의 내용까지 포함하고 있다.
	
	//DTO(Data Transfer Object)
	// - DB에서 데이터 얻어서 서비스(service->데이터베이스에 연결을 돕는 기능)
	// - Controller 등으로 보낼 때 사용하는 객체
	// - 데이터를 다 캡슐화,암호화했기에 setter getter메서드만 가지는 클래스
	
	//DAO(Data Access Object)
	// - 데이터베이스 접근을 위한 객체
	// - 데이터베이스를 이용해서 데이터를 조회하거나 조작하는 기능을 전담하도록 만든 오브젝트
	// - 서비스와 DB를 연결하는 고리의 역할이다. MCV1, 2
}
