class Member{
    id; name; password; email; gender; age;
    constructor(id,name,password,email,gender,age){
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.age = age;    
    }
}
const member1 = new Member("aaaaa","박신우","aa","aaa@aaa.aaa","F",33);




class Person{
    name; age; height; weight;

    Person(){}
    Person(name, age, height, weight){
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }
    toString(){
        return this.name+"님의 정보입니다.";
    }
}
class Student extends Person{
    grade; major;
    
    Student(){}
    Student(grade, major){
        this.grade = grade;
        this.major = major;
    }
}
class Employee extends Person{
    salary; dept;
    
    Employee(){}
    Employee(salary,dept){
        this.salary = salary;
        this.dept = dept;
    }
}