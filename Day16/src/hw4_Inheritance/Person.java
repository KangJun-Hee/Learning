package hw4_Inheritance;

public class Person {
	private String name;
	private int age;
	private double height;
	private double weight;
	
	public Person() {}
	public Person(String name, int age, double height, double weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight + "]";
	}
	
}

class Student extends Person{
	int grade;
	String major;
	
	public Student() {}
	public Student(int grade, String major, String name, int age, double height, double weight) {
		super(name, age, height, weight);
		this.grade = grade;
		this.major = major;
	}
	
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	@Override
	public String toString() {
		return "Student [grade=" + grade + ", major=" + major + "]";
	}
}

class Employee extends Person{
	int salary;
	String dept;
	
	public Employee(){}
	public Employee(int salary, String dept, String name, int age, double height, double weight) {
		super(name, age, height, weight);
		this.salary = salary;
		this.dept = dept;
	}
	
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	@Override
	public String toString() {
		return "Employee [salary=" + salary + ", dept=" + dept + "]";
	}
}


























