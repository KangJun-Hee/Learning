package Generice;

public class Cup<T> {

	//컵은 여러개의 음료를 담을 수 있다.
	//안에 들어가는 내용물
	T obj;  
}
class Coffee{}  
//아메리카노는 커피이다!
class Americano extends Coffee{}
//카페라떼는 커피이다!
class Cafelatte extends Coffee{}
//카페모카는 커피이다!
class CafeMocha extends Coffee{}


class Milk{}
class Water{}
class Juic{}