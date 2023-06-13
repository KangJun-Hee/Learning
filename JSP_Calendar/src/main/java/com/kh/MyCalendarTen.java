package com.kh;

public class MyCalendarTen {
	
		  // 달력작업에 필요한 메소드를 모아 놓은 클래스 
			
		  // 윤년 인지 평년인지 판단해 true / false로 판단 
		  // 윤년 true
		  // 평년 false
		  // 논리값을 기억하는 변수나 논리값을 리턴하는 메서드들 is 관행 
			
			public static boolean isLeapYear(int year) {
				
				return year % 4 == 0 && year % 100  != 0 || year % 400 == 0;
			}
			
			// 년, 월을 인수로 넘겨받아 그 달의 마지막 날짜를 리턴하는 메서드 
			public static int lastDay(int year , int month) {
				int[] m = {31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
				m[1] = isLeapYear(year) ? 29 : 28;
				
				return m[month -1];		
			}
			
			// 년,월,일 인수로 넘겨받아서 1년 1월 1일부터 지난 날짜를 계산하는 리턴 메서드
			public static  int totalDay(int year,int month,int day) {
				
				int sum = (year - 1 ) * 365 + (year - 1) / 4 - (year - 1) / 100 
						+ (year - 1) / 400;
				
				for(int i = 1; i < month; i++) {
					sum += lastDay(year,i);
					
				}			
				return sum + day;
			}  	
			
			// 년,월,일 인수로 넘겨받아서 요일을 숫자로 계산해서 리턴하는 메서드 
			// 일요일(0)  월요일 (1) 화요일(2) 수요일(3) 목4 금 5 토 6
			public static int weekDay(int year, int month, int day) {
				return totalDay(year, month, day) % 7;
			}	
			
			// 만년달력 
			//  서기 1년 1월1일 월요일
			// 1년을 365일이지만 4년마다 한번씩 윤년이 있어서 그해는 366일이다.
			// 100년에 한번씩은 4년으로 나눠어져도 윤년이 아니게 된다.
			// 400년에 한번씩은 윤년이다.

	
}
