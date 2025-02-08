package com.maven.sample.mavenapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("myAnoShape")
@Scope("prototype")
public class Triangle implements Shape {
	
	
	@Autowired
	//@Qualifier("ShapeGlitterService") - only if multiple implementations
	private GlitterService glitterService;

	
	@Override
	public String drawShape() {
		return "draw a Triangle";
	}

	@Override
	public String colorShape() {
		return glitterService.applyGlitter() + " for Triangle";
	}

}










