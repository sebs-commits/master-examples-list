package com.spring.sample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDrawerApp {

	public static void main(String[] args) {
		// no creation of objects -let spring do it and also inject coloring service
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Shape shape = context.getBean("myShape", Shape.class);
		System.out.println(shape.drawShape());
		System.out.println(shape.colorShape());
	
		
		// Bean Scope!!!
		Shape shape2 = context.getBean("myShape", Shape.class);
		System.out.println("Initial mem location: Shape=" + shape +" and Shape2=" + shape2); //identityHashCode
		
		//Annotation :)
		ClassPathXmlApplicationContext annoContext = new ClassPathXmlApplicationContext("appAnnotatedContext.xml");
		Shape shape3 = annoContext.getBean("myAnoShape", Shape.class);
		System.out.println(shape3.drawShape());
		System.out.println(shape3.colorShape());
		
		context.close();
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
