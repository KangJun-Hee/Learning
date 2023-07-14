package com.kh.springdi;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		/*
		MyCalculator myCalculator = new MyCalculator();
		myCalculator.setFirstNum(8);
		myCalculator.setSecondNum(5);
		
		Calculator calculator = new Calculator();
		myCalculator.setCalculator(calculator);//의존성주입
		myCalculator.setCalculator(new Calculator());
		
		calculator.add(100, 200);
		
		xml파일서 설정한 bean설정정보를 읽어 들인다~
		bean에 대해 얻어온다
		
		applicationCTX.xml이 위치한 경로 src/main/resources를 classpath라고 부름
		
		GenericXmlApplicationContext 클래스는 생성자의 인수로 bean을 설정한 xml파일의
			경로와 이름 넘겨 주면 xml파일의 내용 읽어서 java객체로 변환 후 부모클래스인
			AbstractApplicationContext클래스의 객체에 저장한다~
			
			spring ioc컨테이너가 관리하는 자바객체
				어노테이션,xml파일을 이용해 등록가능~
		*/
		String configLocation ="classpath:applicationCTX.xml";
		
		AbstractApplicationContext ctx = 
						new GenericXmlApplicationContext(configLocation);
		
		//getBean()메서드로 AbstractApplicationContext 클래스타입의 객체 ctx에 저장된 
		//	bean얻어 온다
		//							getBean("얻어올 bean id", bean을 생성한 클래스의 이름.class)
		MyCalculator myCalculator = ctx.getBean("myCalculator", MyCalculator.class);
		System.out.println(myCalculator);
		
		myCalculator.add();
		myCalculator.sub();
		myCalculator.mul();
		myCalculator.div();
	}
}

//의존적 주입
//class B{
//	public void info() {}
//}
//
//class A{
//	//A를 만들면 B도 무조건 만들어야 하는 거 = 의존적이다!
//	//B에 대한 객체내용 변경되면 무조건 A안의 메서드내용도 변경해야 함
//	B b = new B();
//	
//	public void show() {
//		b.info();
//	}
//}

/*
 * 
 * 
 * 
 */