package com.spring.sample;

public class Circle implements Shape {
	
	private ColorService colorService;
	
	public Circle(ColorService cs)
	{
		colorService = cs;		
	}
	
	@Override
	public String drawShape() {
		return "draw a Circle";
	}
	
	@Override
	public String colorShape() {
		return "Circle " + colorService.applyColor();
	}

}








