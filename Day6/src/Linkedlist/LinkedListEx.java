package Linkedlist;

class Node{
	int data;	//데이터
	Node next;	//다음 주소
}
public class LinkedListEx {

	public static void main(String[] args) {

		int count = 0;	//데이터의 개수를 저장
		//리스트
		// - 배열기반이 아니라 리스트 기반
		// - 열차 칸
		// - 변수를 만들어서 주소값을 이용해서 찾아간다.
		// - 시작점에는 데이터를 저장하지 않는다.
		
		//Arraylist와  Linkedlist의 차이점
		//검색편함			검색불편
		//인덱스			인덱스X
		//추가삭제 불편		추가삭제 편함

		//링크리스트의 시작점
		//머리(head) -- 데이터 저장X
		
		Node head = new Node();
		
		//실제 첫 번째 노드를 생성
		Node node1 = new Node();
		node1.data = 10;
		head.next = node1;
		count++;
		
		
		//두 번째 노드를 생성
		Node node2 = new Node();
		node2.data = 20;
		node1.next = node2;
		count++;
		
		
		//두 번째 노드를 생성
		Node node3 = new Node();
		node3.data = 20;
		node2.next = node3;
		count++;
		
		
		//nodenext를 이용해서 데이터 결과를 출력
		//첫 번재 node 데이터
//		System.out.println(head.next.data);
//		System.out.println(head.next.next.data);
		
		//head를 넣게 되면 head객체의 data를 출력
		//0부터 출력
//		head.next 다음 주솟값을 가져온다. 첫번쨰 node1
		
		Node temp = head.next;
		
		for(int i=0; i<count; i++) {
			System.out.println(temp.data);
			temp = temp.next;	//head.next.next
		}
		//node1삭제
		//1. node1 먼저 찾는다.
		//2. node1.next -> head.next 연결
		Node del = node1;
		
		//node1 가지고 있는 next 즉 node2의 주소값을 저장
		head.next = del.next;
}

}
