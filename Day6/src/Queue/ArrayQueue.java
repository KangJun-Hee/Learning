package Queue;

import java.util.LinkedList;
import java.util.Queue;

//코드 정렬 ctrl +
public class ArrayQueue {
	int MAX = 1000;
	int front; // 머리 쪽에 위치할 index값, pop할때 참조하는 index
	int rear; // 꼬리 쪽에 위치할 index값, push할때 참조하는 index
	int[] queue;

	public ArrayQueue() {
		front = rear = 0; // 초기값 0
		queue = new int[MAX]; // 배열 생성
	}

	public boolean queueisEmpty() { // queue에 아무것도 들어있지 않은지 판단하는 함수
		return front == rear;
	}

	public boolean queueisFull() { // queue가 가득 차 공간이 없는지 판단하는 함수
		if (rear == MAX - 1) {
			return true;
		} else
			return false;
	}

	public int size() { // queue에 현재 들어가 있는 데이터의 개수를 return
		return front - rear;
	}

	public void push(int value) {
		if (queueisFull()) {
			System.out.println("Queue is Full");
			return;
		}
		queue[rear++] = value; // rear가 위치한 곳에 값을 넣어주고 rear를 증가시킨다.
	}

	public int pop() {
		if (queueisEmpty()) {
			System.out.println("Queue is Empty");
			return -1;
		}
		int popValue = queue[front++];
		return popValue;
	}

	public int peek() {
		if (queueisEmpty()) {
			System.out.println("Queue is Empty");
			return -1;
		}
		int popValue = queue[front];
		return popValue;
	}

	public static void main(String[] args) {

		Queue<Integer> qu = new LinkedList();

		//추가
		qu.offer(10);
		qu.offer(20);
		qu.offer(30);
		qu.offer(40);
		qu.offer(50);
		
		//조회
		//isEmpty() 값이 없다면 true
		//			값이 있다면 false
		
		while(!qu.isEmpty()) {
		System.out.println(qu.poll());
		}		
		
		Queue<String> po = new LinkedList();
		po.offer("뽀로로");
		po.offer("크롱");
		po.offer("루피");
		po.offer("포비");
		while(!po.isEmpty()) {
			System.out.println(po.poll());.
		}
		//자료구조 큐를 이용해서
		//뽀로로
		//크롱
		//루피
		//포비
		
		
		
		
		
		
		
		
		
		// 선입선출
		// - 먼저 들어간 데이터가 먼저 나간다
		// - 대기표, 순서표

	}

}
