package com.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		/*
		 * Alien a = context.getBean(Alien.class); 
		 * a.show();
		 */
		
		Student a1 = context.getBean(Student.class);
		a1.show();
		
		Student a2 = context.getBean(Student.class);
		a2.show();
		}

}
