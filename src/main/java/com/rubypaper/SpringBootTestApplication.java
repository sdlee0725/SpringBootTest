package com.rubypaper;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.rubypaper", "com.sdlee"})
public class SpringBootTestApplication {
	
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(SpringBootTestApplication.class);
		application.setWebApplicationType(WebApplicationType.SERVLET);				
		//application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}
	

}
