package enrolment;

public class MysubjectViewDTO {
	private int subjectNum;
	private String subjectName;
	private String professorName;
	private int hakjom;
	private String major;
	private int grade;
	
	public MysubjectViewDTO() {}
	public MysubjectViewDTO(int subjectNum, String subjectName, String professorName, int hakjom, String major,
			int grade) {
		super();
		this.subjectNum = subjectNum;
		this.subjectName = subjectName;
		this.professorName = professorName;
		this.hakjom = hakjom;
		this.major = major;
		this.grade = grade;
	}
	public int getSubjectNum() {
		return subjectNum;
	}
	public void setSubjectNum(int subjectNum) {
		this.subjectNum = subjectNum;
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
		return "MysubjectViewDTO [subjectNum=" + subjectNum + ", subjectName=" + subjectName + ", professorName="
				+ professorName + ", hakjom=" + hakjom + ", major=" + major + ", grade=" + grade + "]";
	}
	
	
}
