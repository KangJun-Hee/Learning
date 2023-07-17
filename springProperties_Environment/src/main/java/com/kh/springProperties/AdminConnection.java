package com.kh.springProperties;

//이 클래스의 bean이 생성되는 순간 admin.properties파일 내용을 읽어서
//필드에 저장한다~
public class AdminConnection {
	private String adminId;// admin.id저장
	private String adminPw;// admin.pw저장

	public AdminConnection() {
	}

	public AdminConnection(String adminId, String adminPw) {
		super();
		this.adminId = adminId;
		this.adminPw = adminPw;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPw() {
		return adminPw;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}

	@Override
	public String toString() {
		return "AdminConnection [adminId=" + adminId + ", adminPw=" + adminPw + "]";
	}

}
