package Io_Program;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

class Account implements Serializable{
	
	String id;
	String pw;
	String name;
	
	public Account(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	Account(String[] temp){
		this.id = temp[0];
		this.pw = temp[1];
		this.name = temp[2];
	}
	@Override
	public String toString() {
		return id+","+pw+","+name;
	}
}
public class MemberMain {

	public static void main(String[] args) {
		
		
		//입력
		Scanner sc = new Scanner(System.in);
		
		System.out.println("id, pw, name>");
		String[] temp = sc.nextLine().split(",");
		
		Account a1 = new Account("qwer", "qwer", "하하");
		Account a2 = new Account("dfdf", "dfdf", "낄낄");
		Account a3 = new Account("hghg", "ghgh", "우핫");
		Account a4 = new Account(temp);
		
		ArrayList<Account> list = new ArrayList<>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		list.add(a4);
		
		try {
		FileOutputStream fos;
		
			fos = new FileOutputStream("accontlist.dat");
		 
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(list);
		
		fos.close();
		oos.close();
		
		}catch (Exception e) {}
		//System.out.println(temp.split(","));
//		for(String s : temp.split(",")) {
//			System.out.println(s);
//		}
	}

}
