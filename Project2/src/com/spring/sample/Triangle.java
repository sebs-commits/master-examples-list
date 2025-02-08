package com.spring.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myAnoShape")
public class Triangle implements Shape {
	
	@Autowired
	//@Qualifier("ShapeGlitterService") // Needed only if multiple implementations exists
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










