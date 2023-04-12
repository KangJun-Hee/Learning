package IO_Object;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Member implements Serializable{
	String name;
	int age;
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return this.name+" "+this.age;
	}
}

public class Main {

	public static void main(String[] args) {

		Member m = new Member("이서희", 20);
		
		
		
		//자바가 객체 파일을 저장하려면 하나씩 번거롭다.
		//직렬화 : 바이트 형태로 데이터 변환
		//역직렬화 : 바이트로 변환 데이터를 다시 객체로 변환
		
		
		
		//출력 저장할 때 
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		
		
		
		try {
			//직렬화!
		//추가모드(true나 false 붙이기)
		FileOutputStream fos = new FileOutputStream("object.bin");
		oos = new ObjectOutputStream(fos);
		
		oos.writeObject(m);
		
		fos.close();
		
		//역직렬화
		ois = new ObjectInputStream(new FileInputStream("object.bin"));
		m = (Member) ois.readObject();
		
		
		System.out.println(m);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
//기본적으로 파일을 저장하고 읽고
//프로그램 종료되면 안에 저장되있던 내용들이 모두 사라진다.

//프로그램이 종료돼도 데이터를 외부에 저장할 수 있게!
//문자 한꺼번에 가지고 올 것이다!
//버퍼이용하는 클래스랑 파일객체를 사용하시면 된다.

//데이터베이스, 혹은 동영상,이미지,url을 이용해서
//자바 프로그램에서 실행을 시킬 때 종류가 다르다!
//이진파일들을 한거번에 가지고 오거나 저장할 때
//버퍼(기본자료형(DataStream)기본자료형 저장 가져오는 통로만들기
//		우리가 만든, 자바가 제공하는 클래스를 저장하는 방식)
//		ObjectStream 객체를 저장하고 가져오는 통로만들기)