package IO_DataStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		// 자료형이 다른 몇개의 데이터를 파일에 출력하였다가
		// 다시 출력하기
		// 필터
		DataInputStream in = null;
		DataOutputStream out = null;

		try {
			// 내용물!
			FileOutputStream fos = new FileOutputStream("data.bin");

			// input, output stream 객체가 하나 있어야 함.

			out = new DataOutputStream(fos);
			out.writeInt(123);
			out.writeDouble(123.456);
			out.writeBytes("안녕안녕!!!!!!!!!");
			
			out.close();
			
			FileInputStream fis = new FileInputStream("data.bin");
			in = new DataInputStream(fis);
			
			int aint = in.readInt();
			double adouble = in.readDouble();
			
			System.out.println(aint);
			System.out.println(adouble);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
