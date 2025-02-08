package com.spring.sample;
public class DrawerApp {

	public static void main(String[] args) {

		ColorService colorService = new ShapeColorService();
		Shape shape = new Circle(colorService);
		
		System.out.println(shape.drawShape());
		System.out.println(shape.colorShape());
		
	}

}
