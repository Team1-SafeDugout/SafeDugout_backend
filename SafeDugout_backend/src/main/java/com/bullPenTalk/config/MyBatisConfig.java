package com.bullPenTalk.config;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConfig {

	// sqlSession을 만들기 위해 세션 팩토리가 필요하다
	private static SqlSessionFactory sqlSessionFactory;

	// 팩토리는 딱 한번만 프로그램이 시작할 때 만들면 된다
	// static 초기화 블록으로 만든다
	static {
		try {
			// 설정파일의 경로를 저장한다
			String resource = "./com/bullPenTalk/config/config.xml";

			// Resources클래스를 이용하여 리소스를 읽어들여 Reader 객체로 만든다
			Reader reader = Resources.getResourceAsReader(resource);

			// 세션팩토리 빌더에게 팩토리를 지어달라고 한다. build()
			// 공장을 짓기 위해서 설계도가 필요하다
			// 설계도는 설정값을 저장하고 있는 reader이다
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("MyBatisConfig.java 초기화 문제 발생");
			e.printStackTrace();
		}

	}

	// sqlSessionFactory의 접근 제한자가 private이므로 getter를 만든다
	// static 변수이므로 getter에도 static이 붙는 것을 확인할 수 있다
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

}
