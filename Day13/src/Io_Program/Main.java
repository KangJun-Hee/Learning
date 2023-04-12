package Io_Program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void save(int hak) {
		try {
			FileWriter fw = new FileWriter("hakbunlist.txt", true);

			fw.write(hak + "\n");

			fw.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {

		// 학번을 입력 받아서 파일로 저장을 하고 읽어 오는 코드
		Scanner sc = new Scanner(System.in);

		int[] hakbunlist = new int[5];
		int count = 0;

		for (int i = 0; i < 5; i++) {

			System.out.println("1. 파일 저장 2. 파일 읽기 3. 학번조회 4. 학번 추가");
			int sel = sc.nextInt();

			switch (sel) {
			case 1:
				
				try {
					FileWriter fw = new FileWriter("hakbunlist.txt");

//					fw.write(hak);

					fw.close();

				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			
				break;

			case 2:
				break;
		
			case 3:
				
				try {
				//학번리스트 읽어 오기
				FileReader fr = new FileReader("hakbunlist.txt");
				BufferedReader br = new BufferedReader(fr);
				
				String str = "";
				while((str = br.readLine()) != null) {
					System.out.println(str);
				}
				fr.close();
				br.close();
			}catch(IOException e) {}
			}
			break;
				
				
				for (int j = 0; j < hakbunlist.length; j++) {
					System.out.println(hakbunlist[j]);
				}
				break;

			case 4:
				System.out.println("학번 입력:");
				int hak = sc.nextInt();
				hakbunlist[count++] = hak;
				save(hak);
				
				break;

			default:
				System.out.println("잘못 입력했다.");
		}}}
