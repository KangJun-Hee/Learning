<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//Calendar 클래스
		//날짜와 시간을 객체 저장하는 클래스
		//추상클래스 되어있어서 객체를 생성을 할 수 없다
		//현재 사용자(or프로그래머)의 현재 시스템시간정보를 얻어 올 때
		//getInstance()라는 정적(static)메서드를 이용하며 객체를 생성을 할 수 있다
		
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
	
		
		//get() 
		//Calendar 인스턴스에서 저장된 정보중 상수를 전달해
		//원하는 값을 반환하는 메서드
		
		//set()
		//Calendar 인스턴트에서 저장된 시간,날짜를 수정,변경하는 메서드
		int year = start.get(Calendar.YEAR);
        int month = start.get(Calendar.MONTH);
        int date = start.get(Calendar.DATE);
        
        int woy = start.get(Calendar.WEEK_OF_YEAR);
        int wom = start.get(Calendar.WEEK_OF_MONTH);
        
        int doy = start.get(Calendar.DAY_OF_YEAR);
        int dom = start.get(Calendar.DAY_OF_MONTH);
        int dow = start.get(Calendar.DAY_OF_WEEK);
        
        int hour12 = start.get(Calendar.HOUR);
        int hour24 = start.get(Calendar.HOUR_OF_DAY);
        int minute = start.get(Calendar.MINUTE);
        int second = start.get(Calendar.SECOND);
        
        int milliSecond = start.get(Calendar.MILLISECOND);
        int timeZone = start.get(Calendar.ZONE_OFFSET);
        int lastDate = start.getActualMaximum(Calendar.DATE);

	
	
        System.out.println("오늘은 올해의 " + woy +"째주, 이번달의 " + wom + "째주. " + date +"일");
        System.out.println("오늘은 이번 해의 " + doy +"일이자, 이번 달의 " + dom + "일. 요일은 " + dow +"일 (1:일요일)");
        System.out.println("현재 시각은 " + hour12 +":"+ minute + ":"+ second +", 24시간으로 표현하면 " + hour24+":"+ minute + ":"+ second);
        System.out.println("오늘은 " + year +"년 " + month+1 + "월" + date +"일");
        System.out.println("1000분의 1초 (0~999): " + milliSecond);
        System.out.println("timeZone (-12~+12): " + timeZone/(60601000)); // 1000분의 1초를 시간으로 표시하기 위해 60601000
        System.out.println("이 달의 마지막 날: " + lastDate);
	%>
</body>
</html>