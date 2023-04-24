import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Test {

	public static void main(String[] args) {

//		A[] list = new A[5];
//		System.out.println(list);//주솟값나옴. 내용물 출력하려면 어쨰야함? 왜?
		
//		System.out.println(a1.num);
		
		//비교법 왜 오류가 났나? 정상적 비교법 작성하세요~
		String name = new String("이서희");
		String name2 = new String("이서희");
		
		if(name == name2) {
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		
		
		//완벽하게 클래스 구현하는 문제도 있음
		
		//객체생성.
		//안에 있는 내용들을 출력! 반복문 쓰는 사람이나 클래스 안에 있는 거나
		//public 된 경우, default된 경우, private된 경우
		//private getter setter로 리턴 받아서
		
		
		
		
		
		
		//linkedlist, arraylist 사용법과 둘의 차이점
		//내용을 출력하려면 어케 해야 된다. 전체적이나 하나씩이나 함수의 사용법(
		LinkedList li = new LinkedList();
//		LinkedList<Link> demo = new LinkedList<>();
		LinkedList<Integer> i = new LinkedList<>();
		LinkedList<Integer> i2 = new LinkedList<>(Arrays.asList());//초기값 세팅
		LinkedList<String> s = new LinkedList<>();
		LinkedList<Character> ch = new LinkedList<>();
		i.add(324);
		s.add("dkhd");
		s.add(1, "df");
		//전체출력
		for(String str : s)
			System.out.println(str+"");
		System.out.println();
		//원하는 값 get(index num)
		System.out.println(i.get(0));//0번째 출력
		//ArrayList 데이터 추가할 때 사이즈 '자동증가' 명시필수 ㄴㄴ
		ArrayList<Integer> ar = new ArrayList<>();
		ar.add(3);
		ar.add(3,1000);//인덱스3에 1000추가
		//값 검색
		ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3));
		System.out.println(list1.contains(1));//1이 있냐? true
		System.out.println(list1.indexOf(1));//없으면 -1
		
		
		
		
		//입출력IO에 관한 내용
		//문자 저장을 할 때 사용하는 클래스
		//이진 파일 저장하거나 읽어 오는 클래스. 필터사용노노
		//모드, 경로 
		
		//클래스 다이어그램 접근자!
		//객체를 생성할 때 생성자
		//함수를 똑같은 이름으로 여러개 만들 수 있다!
		//부모 상속받은 함수의 내용 변경하는 것!
		
		//문자열에서 구분,치환(변경),비교,문자열 자르는
		//자르는
		String str1 = "일과 놀이 사이에는 경계가 없다.";
		String[] w = str1.split(" ");
		for(String word : w) {
			System.out.println(word);
		}
		String str2 = "phone name id pwd";
		String word1 = str1.split(" ")[0];
		String word2 = str1.split(" ")[1];
		String word3 = str1.split(" ")[2];
		System.out.println("first word:"+word1);
		System.out.println("second word:"+word1);
		System.out.println("third word:"+word1);
		//3개만 분리 One, Two, Three Four Five
		String strv = "One Two Three Four Five";
		String[] strArray = strv.split(" ",3);
		//치환(변경) replace([기존문자], [바꿀문자])
		String a = "무궁화 삼천리 화려강산 대한사람";
		a = a.replace("무궁", "무지개");//결과:무지개 삼천리***
		//비교
		//a는.equals(b와)
		//== <-로 '문자열' 비교 안돼!
		String aa = "Hello";
		String bb = "World";
		String cc = "Hello";
		System.out.println("aa.equals(bb):"+aa.equals(bb));
		System.out.println("bb.equals(aa):"+bb.equals(aa));
		System.out.println("aa.equals(cc):"+aa.equals(cc));
		//compareTo()
		//0=동일, 양수=호출하는 객체가 인자보다 호출먼저 되어 앞에있을때
		String s1 = "Hello";
		String s2 = "Hello";
		String s3 = "World";
		System.out.println("s1.compareTo(s2):"+s1.compareTo(s2));//0
		//어떤 문제나 프로그램에 설계할 때 클래스 정의!
		//1. 접근제어자
		//2. 데이터(변수) 멤버변수(필드) ㅜ
		//3. 기능(메서드) 멤버메서드 수
		//4. 게터세터 
		
		
		
		
		//네트워크
		//가장 중요한 것! 소캣!(서버랑 클라이언트)
		//통신시 누굴 먼저 실행!
		//클라이언트랑 서버랑 소캣 통신하게 만들기~ 데이터를 꺼낸다. 멀티까지 안 함.
		ServerSocket svsk = new ServerSocket(8000); //포트번호
		Socket sk = svck.accept();
		InputStream in = sk.getInputStream();
		OutputStream out = sk.getOutputStream();
		byte[]inputData = new byte[100];
		int length = in.read(inputData);
		String inputMessage = new String(inputData, 0, length);
	}

}
