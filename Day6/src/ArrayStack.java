import java.util.Stack;

class A{
	//컴파일 시에 자동으로 작성, 기본생성자는 생략이 가능.
	A(){}
}
public class ArrayStack {

	int top;	//마지막 데이터가 어디인지 알려 주는 방 번호(인덱스)
	int size;	//스택 배열의 크기
	int[] stack;
	
	//기본생성자
	ArrayStack(){};
	
	ArrayStack(int size) {
		this.size = size;
		stack = new int[size];
		top = -1; //아직 데이터 없으니까 의미 없는 것 넣기. 인덱스는 0부터니까
	}
	
	//추가
	void push(int item) {
		stack[++top] = item;//원래 top이 -1인데 플플하니까 하나씩 증가하면서 막데이터 가리킴
		System.out.println(stack[top] + "push");
	}
	//삭제
	void pop() {
		System.out.println(stack[top] + "pop");
		int pop = stack[top];
		stack[top] = 0; //초기화했다
		top = top -1;
	}
	//조회
	void peek() {
		System.out.println(stack[top] + "peek!");
	}
	public static void main(String[] args) {
		Stack<Integer> stack1 = new Stack<>();
		
		//추가
		stack1.push(10);
		//삭제
		stack1.pop();
		stack1.remove(10);
		//조회
		stack1.peek();		
		
		
		//스택객체생성
		ArrayStack stack = new ArrayStack(7);
		//함수실행
		stack.push(10);
		stack.push(20);
		stack.push(30);
		
		stack.peek();

		//void remove() 값 삭제, 객체리턴pop()인덱스 삭제
		//remove : 삭제한 값을 확인시키지 않고 걍 삭제함.
		//pop : 삭제한 값을 프로그래머한테 보여 줌.
		stack.pop();//30
		stack.pop();//20
		stack.pop();//10
		stack.pop();//
		/*
		 * 자료구조란?
		 * -데이터를 효율적으로 다룰 수 있게 도와 주는 데이터 보관법
		 * -효율적(검색, 삭제, 추가) 쉬워야 된다.
		 * 
		 * 스택(Stack)
		 * -컴퓨터에서 아주 많이 사용 되는 자료구조 
		 * 
		 * 후입선출(LIFO)
		 * -가장 최근에 들어온 데이터가 첫 번째로 나간다.
		 */
	}

}
