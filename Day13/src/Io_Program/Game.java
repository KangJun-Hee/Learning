package Io_Program;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Game {

	public static void save(int score) {
		try {
			FileWriter fw = new FileWriter("scorelist.txt", true);
			fw.write(score + "\n");
			fw.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args) {
		//100점에서 정답을 맞출 때까지 5점 차감
		//scorelist.txt 파일을 만들어서 점수 저장시키기
		//FileWriter("파일명", 추가모드 설정 true);
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		int score = 100;
		int com = ran.nextInt(100) + 1;


		boolean run = true;
		while (run == true) {

			System.out.println("숫자 입력[1~100] : ");
			int me = scan.nextInt();
			
			if (com > me) {
				System.out.println("Up!");
				score -= 5;
				System.out.println("현재 점수:"+score);

			} else if (com < me) {
				System.out.println("Down!");
				score -= 5;
				System.out.println("현재 점수:"+score);

			} else if (com == me) {
				System.out.println("Bingo!");
				System.out.println("현재 점수:"+score);
				save(score);

				try {
					FileWriter fw = new FileWriter("scorelist.txt");
					fw.close();
					
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
				run = false;
			}
		}

		System.out.println("정답 = " + com);



	}

}
