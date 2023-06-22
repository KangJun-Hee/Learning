package com.rentcar;

public class Member {
	//회원가입시! 
	private String id;       // 아이디
	private String pw1;		 // 비번
	private String email;	 // 이메일
	private String tel;      // 폰번호
	private String hobby;    // 취미
	private String job;      // 직업
	private int age;         // 나이
	private String info;     // 인사말
	
	
	
	public Member() {}
	
	public Member(String id, String pw1, String email, String tel, String hobby, String job, int age, String info) {
	
		this.id = id;
		this.pw1 = pw1;
		this.email = email;
		this.tel = tel;
		this.hobby = hobby;
		this.job = job;
		this.age = age;
		this.info = info;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw1() {
		return pw1;
	}

	public void setPw1(String pw1) {
		this.pw1 = pw1;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return " [id=" + id + ", pw1=" + pw1 + ", email=" + email + ", tel=" + tel + ", hobby=" + hobby + ", job="
				+ job + ", age=" + age + ", info=" + info + "]";
	}
	
	
	
	
	
	
	
	
	
}
