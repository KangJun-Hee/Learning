import java.util.HashMap;
import java.util.TreeMap;

class User{
	
	private String id;
	private String pw;
	
	//생성자
	public User() {}
	public User(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	//setget
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPw() {
		return pw;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + "]";
	}

	
	
}


public class UserMain {

	public static void main(String[] args) {

		//id pw 3개 정도 저장
		User p = new User("dkjf", "1111");
		User p2 = new User("dlsd", "2222");
		User p3 = new User("wosl", "3333");
		
		//		키기준으로	값저장
		HashMap<String, User> list = new HashMap<>();
		list.put(p.getId(), p);
		list.put(p2.getId(), p2);
		list.put(p3.getId(), p3);
		
		//1. key가 있는지 확인
		//2. id -> qwer
		String find = "wosl";
		
		
		for(String key : list.keySet()) {
			if(find.equals(key)) {
				//찾았으면 수정
				list.get(key).setId("wkdo");
				break;
			}
			
		}
		//containsKey(key) 넣으면 key 있으면
		System.out.println(list);
		
		TreeMap<String, String> list2 = new TreeMap<>();
		list2.put("이서희", "292-3939-2929");
		list2.put("옹화호", "393=4939-2892");
		list2.put("이호호", "39292-39393-29");
		System.out.println(list2);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
