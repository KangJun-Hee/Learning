package com.rentcar;

public class Member {
//회원가입시 사용할 클라스
	String id;
	String pw1;
	String email;
	String tel;//전화번호
	String hobby;
	String job;
	int age;
	String info;//인사말
	
	public Member()	{}
	public Member(String id, String pw1, String email, String tel, String hobby, String job, int age, String info) {
		super();
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
		return "Member [id=" + id + ", pw1=" + pw1 + ", email=" + email + ", tel=" + tel + ", hobby=" + hobby + ", job="
				+ job + ", age=" + age + ", info=" + info + "]";
	}	
}