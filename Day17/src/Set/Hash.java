package Set;

import java.util.LinkedList;

class HashTable{
	
	// key, value 
	class Node{
		String key;
		String value;
		
		public Node(String key, String value) {
			this.key = key;
			this.value = value;
		}	
		// 수정하는 메서드
		void value(String value) {
			this.value = value;
		}
		// 확인하는 메서드 
		String value() {
			return this.value;
		}		
	}
	// 충돌이 나서 데이터를 저장 할 때 사용하는 리스트
	LinkedList<Node>[] data;
	
	// 해쉬테이블에 데이터를 저장하는 개수( 배열의 길이 )
	public HashTable(int size) {
		this.data = new LinkedList[size];
	
	}
	int getHashCode(String key) { 
		// 문자열의 키를 받아오면 해시코드로 변환을 해서
		// 배열의 길이만큼으로 나눠서 나눈 나머지값을 
		// 인덱스 방번호로 지정 
		int hashcode = 0;
		
		for(char c : key.toCharArray()) {
			hashcode += c;
		}
		return hashcode;
	}
	// 더한 해시코드 값을 인덱스 방 번호로 변환해주는 
	// 메서드 
	int convertToIndet(int hashcode) {
		return hashcode % data.length;
	}
	
	Node searchKey(LinkedList<Node> list,String key) {
		if (list == null) return null;
		
		for(Node node : list) {
			if(node.key.equals(key)) {
				return node;
			}
		}
		return null;
	}
	void put(String key,String value) {
		int hashcode = getHashCode(key);
		int index = convertToIndet(hashcode);
		LinkedList<Node> list = data[index];
		
		if(list == null) {
			list = new LinkedList<>();
			data[index] = list;
		}
		Node node = searchKey(list, key);
		
		if(node == null) {
			list.addLast(new Node(key,value));
		
		}else {
			node.value(value);
		}		
	}
	String get(String key) {
		int hashcode = getHashCode(key);
		int index = convertToIndet(hashcode);
		LinkedList<Node> list = data[index];
		Node node = searchKey(list, key);
		return node == null? "Not found" : node.value();
	}
}		
	
public class Hash {
	// isEmpty() : 데이터가 있는 지 없는 지 확인
	// contains() : 지정된 key가 있는지 검색 
	// getOrDefault() : key가 있으면 value을 반환
	
	// 해시 
	//  -> 해시 테이블 , 해시 함수 
	//  -> key value
	
	// 해시 실행되는 과정 
	// key(문자,숫자,파일) -> 해시함수 -> hashcode
	//  -> index -> value
	
	//패밀리 레스토랑의 메뉴를 저장 
	// 해시 내가받은 키값을 인덱스 방번호로 사용한다.
	
	// 인덱스 방번호가 중복이 된다 .( 충돌) 
	// 충돌을 방지하기 위해서 동일한 인덱스로 데이터가 들어오면
	// 선형구조 (배열,리스트)를 이용해서 저장하고 검색
	
	// 충돌 < 인덱스 방번호가 같거나, hashcode값이 같을 경우>
	
	
	
	
	
}