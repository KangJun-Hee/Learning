package enrolment;

public class MySubjectDTO {
	private int myNum;
	private int subjectNum;
	private String hakbun;
	private String subjectName;
	private String professorName;
	private int hakjom;
	private String major;
	private int grade;
	
	public MySubjectDTO() {}
	public MySubjectDTO(int myNum, int subjectNum, String hakbun, String subjectName, String professorName, int hakjom,
			String major, int grade) {
		super();
		this.myNum = myNum;
		this.subjectNum = subjectNum;
		this.hakbun = hakbun;
		this.subjectName = subjectName;
		this.professorName = professorName;
		this.hakjom = hakjom;
		this.major = major;
		this.grade = grade;
	}
	public int getMyNum() {
		return myNum;
	}
	public void setMyNum(int myNum) {
		this.myNum = myNum;
	}
	public int getSubjectNum() {
		return subjectNum;
	}
	public void setSubjectNum(int subjectNum) {
		this.subjectNum = subjectNum;
	}
	public String getHakbun() {
		return hakbun;
	}
	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getProfessorName() {
		return professorName;
	}
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	public int getHakjom() {
		return hakjom;
	}
	public void setHakjom(int hakjom) {
		this.hakjom = hakjom;
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
	@Override
	public String toString() {
		return "MySubjectDTO [myNum=" + myNum + ", subjectNum=" + subjectNum + ", hakbun=" + hakbun + ", subjectName="
				+ subjectName + ", professorName=" + professorName + ", hakjom=" + hakjom + ", major=" + major
				+ ", grade=" + grade + "]";
	}
	
	
}
