package enrolment;

public class SubjectDTO {
	private int subjectNum;
	private String subjectName;
	private String professorName;
	private int hakjom;
	private String major;
	private String room;
	private String subjectPurpos;
	private String subjectGoal;
	private String subjectTest;
	private int grade;
	private int studentCount;
	
	public SubjectDTO() {}
	public SubjectDTO(int subjectNum, String subjectName, String professorName, int hakjom, String major, String room,
			String subjectPurpos, String subjectGoal, String subjectTest, int grade, int studentCount) {
		super();
		this.subjectNum = subjectNum;
		this.subjectName = subjectName;
		this.professorName = professorName;
		this.hakjom = hakjom;
		this.major = major;
		this.room = room;
		this.subjectPurpos = subjectPurpos;
		this.subjectGoal = subjectGoal;
		this.subjectTest = subjectTest;
		this.grade = grade;
		this.studentCount = studentCount;
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
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getSubjectPurpos() {
		return subjectPurpos;
	}
	public void setSubjectPurpos(String subjectPurpos) {
		this.subjectPurpos = subjectPurpos;
	}
	public String getSubjectGoal() {
		return subjectGoal;
	}
	public void setSubjectGoal(String subjectGoal) {
		this.subjectGoal = subjectGoal;
	}
	public String getSubjectTest() {
		return subjectTest;
	}
	public void setSubjectTest(String subjectTest) {
		this.subjectTest = subjectTest;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getStudentCount() {
		return studentCount;
	}
	public void setStudentCount(int studentCount) {
		this.studentCount = studentCount;
	}
	@Override
	public String toString() {
		return "SubjectDTO [subjectNum=" + subjectNum + ", subjectName=" + subjectName + ", professorName="
				+ professorName + ", hakjom=" + hakjom + ", major=" + major + ", room=" + room + ", subjectPurpos="
				+ subjectPurpos + ", subjectGoal=" + subjectGoal + ", subjectTest=" + subjectTest + ", grade=" + grade
				+ ", studentCount=" + studentCount + "]";
	}
	
	
}
