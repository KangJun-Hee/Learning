package 최종;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class z_0_FileManager {
	File file = null;
	FileWriter fw = null;
	FileReader fr = null;
	BufferedReader br = null;
	final String path = "userdata.txt";
	ArrayList<z_1_userInfo> userManager = null;

	public static z_0_FileManager instance = new z_0_FileManager();

	private z_0_FileManager() {
		userManager = new ArrayList<>();
	}

	public void addUser(z_1_userInfo user) {
		userManager.add(user);
		// addData(user); // 콘솔창에 현황 보여주는것
		saveData();

	}

	public void saveData() {
		String data = "";
		int size = userManager.size();
		for (int i = 0; i < size; i++) {
			data += userManager.get(i).name;
			data += "/";
			data += userManager.get(i).id;
			data += "/";
			data += userManager.get(i).pw;
			data += "/";
			data += userManager.get(i).phonenumber;
			data += "/";
			int cnt = userManager.get(i).subject.size();
			data += cnt;
			data += "/";
			for (int j = 0; j < cnt; j++) {
				data += userManager.get(i).subject.get(j);
				data += "/";

			}

			data += "\n";

		}

		try {
			fw = new FileWriter(path);
			fw.write(data);
			fw.close();

			System.out.println("===save===\n" + data);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadData() {
		File file = new File(path);
		if (file.exists()) {
			FileReader fr = null;
			BufferedReader br = null;
			try {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				String data = "";
				while (true) {
					String line = br.readLine();
					if (line == null) {
						break;
					}
					data += line;
					data += "\n";
				}

				String[] temp = data.split("\n");
				int cnt = temp.length; // 인원수...

				for (int i = 0; i < cnt; i++) {
					String[] info = temp[i].split("/");
					z_1_userInfo user = new z_1_userInfo();
					user.name = info[0];
					user.id = info[1];
					user.pw = info[2];
					user.phonenumber = info[3];
					int subcnt = Integer.parseInt(info[4]);
					user.subjectcnt = subcnt;
					for (int k = 0; k < subcnt; k++) {
						user.subject.add(info[5 + k]);
						// userManager.get(i).subject.add(info[5+k]);
					} // 만약에..... 여기서 오류나면.... new arraylist 해야하는지 고려할 것
					userManager.add(user);
				}
				fr.close();
				br.close();

				System.out.println("===load===\n");
				printAllUser();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public void printAllUser() {// 로드시 가로로 길게 보고싶어서
		String data = "";
		for (int i = 0; i < userManager.size(); i++) {

			data += userManager.get(i).name;
			data += "/";
			data += userManager.get(i).id;
			data += "/";
			data += userManager.get(i).pw;
			data += "/";
			data += userManager.get(i).phonenumber;
			data += "/";
			data += userManager.get(i).subjectcnt;
			data += "/";
			int subsize = userManager.get(i).subjectcnt;
			for (int k = 0; k < subsize; k++) {
				data += userManager.get(i).subject.get(k);
				data += "/";
			}
			if (i != userManager.size() - 1) {
				data += "\n";
			}
		}

		System.out.println(data);
	}

	String login(String id, String pw) {

		String check_id = "";
		for (int i = 0; i < userManager.size(); i++) {
			if (id.equals(userManager.get(i).id) && pw.equals(userManager.get(i).pw)) {
				check_id = userManager.get(i).id;

				break;
			}
		}
		return check_id;
	}

	String findID(String name, String mobile) {
		String id = "";
		for (int i = 0; i < userManager.size(); i++) {
			if (name.equals(userManager.get(i).name) && mobile.equals(userManager.get(i).phonenumber)) {
				id = userManager.get(i).id;

				break;
			}
		}
		return id;
	}

	int findlog(String id, String pw) {
		int idx = 0;
		for (int i = 0; i < userManager.size(); i++) {
			if (id.equals(userManager.get(i).id) && pw.equals(userManager.get(i).pw)) {
				idx = i;
				break;
			}
		}
		return idx;
	}

	String findPW(String id, String mobile) {
		String pw = "";
		for (int i = 0; i < userManager.size(); i++) {
			if (id.equals(userManager.get(i).id) && mobile.equals(userManager.get(i).phonenumber)) {
				pw = userManager.get(i).pw;
				break;
			}
		}
		return pw;
	}

	// void addAdmin() {
	//
	//
	// z_1_userInfo user = new z_1_userInfo();
	// user.name = "admin";
	// user.id = "admin";
	// user.pw = "admin";
	// user.phonenumber = "1111-1111";
	// z_0_FileManager.instance.addUser(user);
	//
	// }
	void delsubject(String subject) {
		// int adminSubjectcnt =FileManager.instance.userManager.get(0).subject.size();
		// for(int i=0;i<adminSubjectcnt;i++) {
		// if(FileManager.instance.userManager.get(0).subject.get(i).equals(subject)) {
		// del_idx = i;
		// FileManager.instance.userManager.get(0).subject.remove(del_idx); //admin 계정에서
		// 지워버림
		// }
		// }

		int studentsize = z_0_FileManager.instance.userManager.size();
		for (int i = 0; i < studentsize; i++) {
			int del_idx = -1;
			int subjectsize = z_0_FileManager.instance.userManager.get(i).subject.size();
			for (int j = 0; j < subjectsize; j++) {
				if (z_0_FileManager.instance.userManager.get(i).subject.get(j).equals(subject)) {
					del_idx = j;
				}

			}
			if (del_idx != -1) {
				z_0_FileManager.instance.userManager.get(i).subject.remove(del_idx);
			}

		}

	}

}
