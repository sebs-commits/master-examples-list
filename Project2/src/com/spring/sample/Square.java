package com.spring.sample;

public class Square implements Shape {

	private ColorService colorService;
	
	public Square(ColorService cs)
	{
		colorService = cs;		
	}
	
	@Override
	public String drawShape() {
		return "draw a Square";
	}

	@Override
	public String colorShape() {
		return "Square " + colorService.applyColor();
	}

}










