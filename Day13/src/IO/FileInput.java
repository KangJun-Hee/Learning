package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInput {

	public static void main(String[] args) {

		//바이트 출력 스트림으로. 문자,동영상,이미지 가능 1byte
		
			try {
				File file = new File("gugudan.txt");
				
				if(!file.exists()) {//파일이 있니
					file.createNewFile();//새로운 파일은 있니?
				}
				
				FileInputStream fos = new FileInputStream(file);
				
				int i=0;
				//read() 데이터가 읽을 게 없다. -1
				//null 나오기 전까지 읽어오기
				while((i = fos.read()) != -1) {
					System.out.print((char)i);
				}
				
	
				fos.close();

		
		
		

		//문자기반 2byte
				}
}}
