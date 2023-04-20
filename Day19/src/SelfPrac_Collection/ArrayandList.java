package SelfPrac_Collection;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ArrayandList {

	public static void main(String[] args) {
		//배열(Array) 저장공간크기 고정!
		//저장공간=7개
		String[] array = new String[] {"가", "나", "다", "라", "마"};
		
		//두 번째 네 번째 걸 null됨 '비워짐'
		array[2]=null;
		array[4]=null;
		System.out.println(array.length);//5
		
		//리스트(List) 저장공간크기 동적변환
		//저장공간=0이었는데
		List<String> aList = new ArrayList<>();
		
		//저장공간=5칸 되었음.
		aList.add("가");aList.add("나");aList.add("다");
		aList.add("라");aList.add("마");
		
		//2 칸을 '없애버림' 3칸 되었음
		aList.remove("나");
		aList.remove("라");
		
		System.out.println(aList.size());
		
		ArrayList list = new ArrayList();//클래스 유형 미설정 Object로 선언
		ArrayList<Integer> num = new ArrayList<Integer>();//int형의 객체 요소만 사용 가능
		
		ArrayList<Integer> num2 = new ArrayList<Integer>(10);//초기 용량을 10으로 지정
		
		ArrayList<String> cats = new ArrayList<String>();
		cats.add("페르시안");//값 추가
		cats.add(null);	//null값 추가
		cats.add(1, "샴");//인덱스 1에 값("샴") 추가
		
		ArrayList<Cat> cats = new ArrayList<Cat>();
		Cat cat = new Cat("페르시안");//cat 객체 생성 후 추가
		cats.add(cat);//cat 객체 생성 후 추가
		
		cats.add(new Cat("샴"));//cat 객체 생성과 동시에 추가
		
		ArrayList<String> cats = new ArrayList<String>();
		cats.remove("페르시안");//요소삭제
		cats.remove(1);//인덱스가 1인 요소 삭제
		cats.clear();//모든 요소 삭제
		
		System.out.println(cats.get(0));//0번째 인덱스 출력
		
		for(String cat : cats) {//for문으로 전체 출력
			System.out.println(cat);
		}
		
		Iterator<E> iter = cats.iterator();//Iterator선언
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println(cats.contains("샴"));//cats에 "샴"이 있으면 true 반환
		System.out.println(cats.indexOf("샴"));//"샴"이 있는 인덱스 반환, 없으면 -1 반환
		
		
		ArrayList<String> cats = new ArrayList<String>();
		cats.add("페르시안");
		cats.add("null");
		System.out.println(cats);
		cats.add(1, "샴");
		System.out.println(cats);
		
		cats.remove(1);
		System.out.println(cats.size());
		System.out.println(cats.get(0));
		System.out.println(cats.contains("샴"));
		System.out.println(cats.indexOf("샴"));
		
		ArrayList<Integer> num = new ArrayList<Integer>();
		
		for(int i=10; i>=1; i--)
			num.add(i);
		
		System.out.println(num);
		
		System.out.println("정렬 전 : ");
		for(int i=0; i<num.size(); i++)
			System.out.println(num.get(i)+"");
		
		num.sort(Comparator.naturalOrder());
		
		System.out.println();
		System.out.println("정렬 후 : ");
		for( int i=0; i<num.size(); i++)
			System.out.println(num.get(i)+ "");
		
		
		LinkedList<String> cats = new LinkedList<String>();
		cats.removeFirst();//맨앞요소삭제
		cats.removeLast();//맨뒤요소
		cats.remove(1);//인덱스가 1인 요소 삭제
		cats.clear();//모든요소 삭제
		
		for(String cat : cats) {//for문으로 전체 출력
			System.out.println(cat);
		}
		
		Iterator iter = cats.iterator();
		
		while(iter.hasNext()) {//다음 요소값이 있나 확인
			System.out.println(iter.next());//요소값출력
		}
		
		//cats에 "샴"이 있으면 true반환
		System.out.println(cats.contains("샴"));
		//"샴"이 있는 인덱스 반환, 없으면 -1반환
		System.out.println(cats.indexOf("샴"));
		
		System.out.println(cats.contains("샴"));
		System.out.println(cats.indexOf("샴"));
		
		
		//LinkedList를 이용하여 숫자 정렬하기
		LinkedList<Integer> num = new LinkedList<Integer>();
		
		for(int i=10; i>=1; i--)
			num.add(i);
		
		System.out.println(num);
		
		System.out.println("정렬 전 : ");
		for(int i=0; i<num.size(); i++)
			System.out.println(num.get(i)+"");
		
		Collections.sort(num);
		
		System.out.println();
		System.out.println("정렬 후 : ");
		for(int i=0; i<num.size(); i++)
			System.out.println(num.get(i)+"");
		
		class MulDiv1{
			Scanner stdIn = new Scanner(System.in);
			
			System.out.print("x값:");
			int x = stdIn.nextInt();
			System.out.print("y값:");
			int y = stdIn.nextInt();
			
			//x*y값 표시 곲
			System.out.println("x*y=" + (x*y));
			//x/y값 표시(몫)
			System.out.println("x/y=" + (x/y));
			
			
		}}
	
	class MulDiv2{
		static int mul(int x, int y) {
			return x*y;
		}
		static int div(int x, int y) {
			return x/y;
		}
		static void muldiv(int x, int y) {
			System.out.println("x*y=" + mul(x,y));
			System.out.println("x/y="+div(x,y));
			
		}
		public static void main(String[] args) {
			Scanner stdIn = new Scanner(System.in);
			
			try {
				System.out.print("x값:");int x=stdIn.nextInt();
				System.out.print("y값:");int y=stdIn.nextInt();
				muldiv(x,y);
			}catch(InputMismatchException e) {
				System.out.println("산술 오류 발생."+e);
				e.printStackTrace();
			}finally {
				System.out.println("프로그램을 종료합니다.");
			}
		}
		
		//Exception예외와 RuntimeException예외를 던지고 캐치하기
		class ThrowAndCatch{
			//---sw값에 따라 예외 발생---//
			static void check(int sw) throws Exception{
				switch(sw) {
				case 1: throw new Exception("검사 예외 발생!!");
				case 2: throw new RuntimeException("비검사 예외 발생!!");
				}
			}
			//---check를 호출---//
			static void test(int sw)throws Exception{
				check(sw);//이 호출은 검사 예외 Exception이 발생할 가능성이 있다.
			}
			
			public static void main(String[] args) {
				Scanner stdIn = new Scanner(System.in);
				
				System.out.println("sw:");
				int sw = stdIn.nextInt();
				try {
					text(sw);
				}catch(RuntimeException e) {//e:예외 RuntimeException과 그 하위클래스를 포착함.
					System.out.println(e.getMessage());
					
				}catch(Exception e) {//e:예외 Exception과 그하위클포착
					System.out.println(e.getMessage());
				}
			}
		}
	
	class LastTime{
		//---이전 날짜, 시간을 읽는다 ---//
		static void init() {
			BufferedReader br = null;
			
			try {
				br = new BufferedReader(new FileReader("LastTime.txt"));
				String time = br.readLine();
				System.out.println("이전 시간은"+time+"였습니다.");
			} catch (IOException e) {
				System.out.println("이 프로그램을 실행하는 건 처음이다~~~~~~!!!!!!!");
			}finally {
				if(br != null) {
					try {
						br.close();
					} catch (IOException e) {
						System.out.println("파일 닫기 실패다!!!!");
					}
				}
			}
		}
		
		//---현재 날짜, 시간 읽기---//
		static void term() {
			FileWriter fw = null;
			try {
				fw = new FileWriter("LastTime.txt");
				GregorianCalendar c = new GregorianCalendar();//현재날짜,시간
				fw.write((String.format("%04d년 %02d월 %02d일 %02d시 %02d분 %02d초", c.get(YEAR), c.get(MONTH) + 1, c.get(DATE), c.get(HOUR_OF_DAY), c.get(MINUTE), c.get(SECOND))));
			}catch(IOException e) {
				System.out.println("오류 발생!!!!!");
			}finally {
				if(fw!=null) {
					try {
						fw.close();
					} catch (IOException e) {
						System.out.println("파일 닫기 실패.");
					}
				}
			}
		}
		public static void main(String[] args) {
			init();//이전 날짜, 시간 읽기
			term();//현재 날짜, 시간 기록
		}
		try(
			br = new BufferedReader(new FileReader("LastTime.txt"));
			){
			String time = br.readLine();
			System.out.println("이전 시간은"+time+"였습니다.");
		}catch(IOException e) {
			System.out.println("이 프로그램을 실행하는 것은 처음입니다.");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
	}

}
