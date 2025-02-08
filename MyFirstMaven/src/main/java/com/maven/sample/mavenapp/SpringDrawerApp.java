package com.maven.sample.mavenapp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDrawerApp {

	public static void main(String[] args) {

		//Annotation :)
		ClassPathXmlApplicationContext annoContext = new ClassPathXmlApplicationContext("appAnnotatedContext.xml");
		Shape shape3 = annoContext.getBean("myAnoShape", Shape.class);
		System.out.println(shape3.drawShape());
		System.out.println(shape3.colorShape());
		
		annoContext.close();
		
		//Java config
		AnnotationConfigApplicationContext configContext = 
				new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Shape shape4 = configContext.getBean("myAnoShape", Shape.class);
		System.out.println(shape4.drawShape());
		System.out.println(shape4.colorShape());
		
		configContext.close();
	}
}
