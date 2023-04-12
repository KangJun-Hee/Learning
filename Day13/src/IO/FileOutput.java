package IO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutput {

	public static void main(String[] args) {

		//String str = "Hello java Programming";
		
		//바이트 출력 스트림으로. 문자,동영상,이미지 가능 1byte
		
			try {
				File file = new File("gugudan.txt");
				
				if(!file.exists()) {//파일이 있니
					file.createNewFile();//새로운 파일은 있니?
				}
				
				FileOutputStream fos = new FileOutputStream(file);
				
				for(int i=2; i<10; i++) {
					for(int j=1; j<10; j++) {
						//문자열로 저장
						String str = i+"x"+j+"="+(i*j)+"\n";
						
						//바이트 타입으로 변경
						byte[] b = str.getBytes();
						//저장
						fos.write(b);
					}
				}
				
				
				
				
				
				fos.close();
				System.out.println("정상적!");
			} catch (IOException e) {
				System.out.println("파일에 대한 예외발생!");
			}
		
		
		

		//문자기반 2byte
		
		
	}

}
