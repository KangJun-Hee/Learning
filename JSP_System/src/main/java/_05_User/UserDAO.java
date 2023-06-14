package _05_User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;

public class UserDAO {
	// 메모장에 저장되는 모든 내용을 저장하는 리스트
	private ArrayList<UserDTO> userlist = new ArrayList<>();

	public String realpath = "";
	String filename = "userdata.txt";

	// #관리자 기능
	// 1.전체회원의 정보를 리턴해 주는 메서드
	public ArrayList<UserDTO> getUserList() {
		return userlist;
	}

	// 2.회원의 id를 전달받아 해당 회원의 모든정보를 리턴해 주는 메서드
	public UserDTO getUserInfo(String id) {
		UserDTO temp = null;

		for (int i = 0; i < userlist.size(); i++) {

			UserDTO temp2 = userlist.get(i);

			if (userlist.get(i).getId().equals(id)) {
				temp = userlist.get(i);
			}
		}
		return temp;
	}

	// 파일로드
	public void loadData() {
		File file = new File(realpath + filename);

		// realpath+/userdata.txt 파일이 존재한다면
		if (file.exists()) {
			// 기존의 데이터를 지우고 새로 작성한다.
			userlist.clear();
			try {
				FileReader fr = new FileReader(file);//파일입출력을 할 때 방향 불러오기
				BufferedReader br = new BufferedReader(fr);//임시버퍼 이용해 한꺼번에 데이터읽기
				String line = br.readLine();//한 줄씩 읽기

				while (line != null) {
					// id/pw/name/date
					String arr[] = line.split("/");
					UserDTO user = new UserDTO(arr[0],arr[1],arr[2],arr[3]);
					userlist.add(user);
					line = br.readLine();
				}
				
				fr.close();
				br.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void saveData() {
		String data = "";
		
		for(UserDTO temp : userlist) {
			//텍스트파일이 문자형식 안에 멤버들을 문자로 변경해 저장
			data += temp.getId();
			data += "/";//문자로
			data += temp.getPw();
			data += "/";
			data += temp.getName();
			data += "/";
			data += temp.getReg_date();
			data += "\r\n";//줄바꿈
			
		}
		System.out.println("실제 메모장의 위치 = "+realpath);
		
		try {
			FileWriter fw = new FileWriter(realpath+filename);
			fw.write(data);
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}















