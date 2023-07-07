package com.kh.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// SqlSession 
// SqlSeesionFactory가 생성하는 sqlsession
// 이라는 것은 데이터베이스에 sql을 실행하기 위해서 필요한 객체다 

public class MySession {
	static SqlSessionFactory factory;
	// 정적 초기화 블록에서 설정파일을 읽어 객체(매퍼)를 생성한다.

	static {

		try {
			Reader r = null;

			r = Resources.getResourceAsReader("com/kh/mybatis/SqlConfig.xml");
			
			SqlSessionFactoryBuilder build = new SqlSessionFactoryBuilder();
			factory = build.build(r);
			

		} catch (IOException e) {
			e.printStackTrace();
		}// catch문 끝
		
	}// static
	
	// sqlsession 객체 얻어온다.
	public static SqlSession getSession() {
		return factory.openSession();
	}
}
