package com.spring.sample;

import org.springframework.stereotype.Component;

@Component
public class ShapeGlitterService implements GlitterService {

	@Override
	public String applyGlitter() {
		return "Glitter applied";
	}

}
