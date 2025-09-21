package com.scale.demo.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class Fruits {
	
	
	private List<String> fruits;
	
	

}
