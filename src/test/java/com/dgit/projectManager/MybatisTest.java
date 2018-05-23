package com.dgit.projectManager;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MybatisTest {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testFactory(){
		System.out.println(sqlSessionFactory);
	}
	
	@Test
	public void testSession(){
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			System.out.println(session);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
