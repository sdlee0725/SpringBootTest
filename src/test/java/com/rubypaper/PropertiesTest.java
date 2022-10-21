package com.rubypaper;

//import org.junit.Test;
//import org.junit.runner.RunWith;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import com.rubypaper.controller.BoardController;

@SpringBootTest(
		//classes=BoardController.class,	// 테스트할 클래스만 사용하므로, 메모리 낭비방지
		properties = {
				 "author.name=Gurum", 
			     "author.age=45", 
			     "author.nation=Korea"})
public class PropertiesTest {
	@Autowired
	Environment environment;
	
	@Test
	public void testMethod() {
		System.out.println("이름 : " + environment.getProperty("author.name"));
		System.out.println("나이 : " + environment.getProperty("author.age"));
		System.out.println("국가 : " + environment.getProperty("author.nation"));
		
		System.out.println(">>>> : " + environment.getProperty("spring.banner.image.location"));
		System.out.println(">>>> : " + environment.getProperty("server.port"));
		
		
	}
} 
