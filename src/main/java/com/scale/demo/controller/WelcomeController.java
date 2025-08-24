package com.scale.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	
		@PostMapping("/hello")
		public String hello(@RequestParam  String name)
		{
			System.out.println("Hi:"+name);
			return name;
			
		}
			

}
