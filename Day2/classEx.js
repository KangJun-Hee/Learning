//클래스
// - 객체를 만들기 위한 설계도
// - 객체를 찍어내는 틀!

// 데이터(저장해야되는 것)
// 메서드(기능)

//키워드 class
//캡슐화
// - 클래스와 관련된 것들을 하나로 묶어서 관리하는 것
// - 정보를 은닉!

class Hero{
    //fields(상태)
    name;
    leve;
    hp;

    //methods(동작)
    attach();
    move();
    spell();
}

//동물을 저장하는 클래스
// 상태 : 이름name,품종breed,나이age
// 동작 : 짖기bark,앉기sit,엎드리기laydown
class Animal{
    _name;
    _breed;
    _age;

    //생성자?
    // - 클래스의 객체를 생성할 때
    // - new Dog();
    //객체를 생성할 때 특별한 메서드
    constructor(name,breed,age){
        this._name = name;
        this._breed = breed;
        this._age = age;
    }
    
    bark(){
        console.log(this._name+"가 짖는다.")
    }
    sit(){
        console.log(this._name+"가 앉는다.")
    }
    laydown(){
        console.log(this._name+"가 눕는다.")
    }
};

//상속이 된다 extends
//override : 재정의
class Cat extends Animal{
    bark(){
        console.error("meow!");
    }
}

cat1 = new Cat();
console.log(cat1);
cat1.bark();
cat1.bark();



//객체 생성
const dog0 = new Dog("뭉치","시고르잡종",2);
const dog1 = new Dog("뽀비","푸들",2);
const dog2 = new Dog("콩이","골든리트리버",2);


console.log(dog0);
console.log(dog1);
console.log(dog2);

//객체 값 읽고 쓰기
//. , []
console.clear();

dog0._age += 1;
dog1._age += 1;
dog2._age += 1;

console.log(dog0);
console.log(dog1);

console.log(dog2);





//instanceOf()
//왼쪽에 있는 객체가 오른쪽에 있는 클래스의 
//인스턴슨지 확인
class Shape{
    constructor(width,height,colour){
        this.width = width;
        this.height = height;
        this.colour = colour;
    }
    
    draw(){
        console.log("drawing"+this.colour+"colour!!");
    }
    getArea(){
        return this.width*this.height;
    }
}

//상속 extends
class Rectangle extends Shape{}
class Triangle extends Shape{
    
    //재정의 오버라이딩
    getArea(){
        return (this.width*this.height)/2;
    }
    
    //필드출력 object 오버라이딩!
    toString(){
        return this.width + "너비다!";
    }
}
console.clear();
const rect = new Rectangle(20,20,"pink");

rect.draw();
let res1 = rect.getArea();
console.warn(res1);

const tria = new Triangle(30,30,"red");
console.error(tria.toString());

let res = tria.getArea();
console.log(res);

console.error(tria instanceof Rectangle);
console.error(rect instanceof Rectangle);
console.error(rect instanceof Shape);
console.error(rect instanceof Object);




class Person{
    name;
    age;
    height;
    weight;

    constructor(name,age,height,weight){
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }
    toString(){
        return this.name+"입니다."
    }
}
class Student extends Person{
    grade;
    major;

    constructor(name,age,height,weight,grade,major){
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.grade = grade;
        this.major = major;
    }
    toString(){
        return this.major+"이 내 전공이다"
    }
}
class Employee extends Person{
    salary;
    dept;

    constructor(name, age, height, weight, salary, dept){
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.salary = salary;
        this.dept = dept;
    }
    toString(){
        return this.dept+"에서 일합니다"
    }
}
const student1 = new Student("강건강",20, 178.2,70.0,1,"정보시스템공학과");
const student2 = new Student("남나눔",21, 187.3,80.0,2,"경영학과");
const student3 = new Student("류라라",23, 167.0,45.0,4,"정보통신공학과");
const employee1 = new Employee("박보배",26,180.3,72.0,100000000,"영업부");
const employee2 = new Employee("송성실",38,182.0,76.0,200000000,"기획부");