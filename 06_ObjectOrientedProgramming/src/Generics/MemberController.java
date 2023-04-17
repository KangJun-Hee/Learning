package Generics;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MemberController {
	
	private HashMap<String, Member> map = new HashMap<>();
	
	boolean joinMembership(String id,Member temp) {
		
		// add(); --> true ,false 
		
		map.put(id,temp);
		boolean res = map.containsKey(id);
			
		return res;
	}

	String loing(String id , String pass) {
		// map에서 검색 
		
		for(String s : map.keySet()) {
			if(s.equals(id) && map.get(s).getPass().equals(pass)) {
				
				for(String s2: map.keySet()) {
					System.out.println(map.get(s2));			
				}
				
				return s +"환영합니다.";
			}
		}		
		
		return "아이디나 비밀번호를 확인하세요!";
	}
	boolean changPassword(String id,String oldPw
											, String newPw){
		// 키가 있으면 if문 실행x
		// 키가 없다 if문 실행한다.
		if (!map.containsKey(id)) {
			return false;
		}
		map.get(id).setPass(newPw);
		
		Member temp = map.get(id);
		temp.setPass(newPw);
		return true;
	}
	
	void changName(String id,String newName){
		
		if (!map.containsKey(id)) {
			System.out.println("찾는 아이디 없다!");
		}
		
		map.get(id).setName(newName);
		System.out.println("이름 변경 완료!");		
	}
	
	TreeMap<String, Member> sameName(String name){
		
		// 요부분은 잘~생각해보세요~ 지역변수 선언이라
		//  객체가...어찌될지.....괜찮을지.~~
		// 중복적인 이름을 하나만 추가할건지~ 아니면 
		// 중복되는 이름을 그냥 다 넣을건지~
		// 어짜피! map은 키 값이 중복될 수없어요~
		// id가 달라도 name은 같을 수있지요~
		
		
		TreeMap<String, Member> list = new TreeMap<>();
		for(String s : map.keySet()) {
			Member temp = map.get(s);
			if(temp.getName().equals(name)) {
								
				list.put(s,map.get(s));
			}
		}
		
		return list;
	}	
}


