package com.scale.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scale.demo.entity.Fruits;
import com.scale.demo.service.DemoService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
public class WelcomeController {
 
		
		//@Autowired
		private DemoService demoService;
		
	
		@GetMapping("/hello")
		public String hello(@RequestParam  String name)
		{
			log.info("Hi:"+name);
			return demoService.findByName(name);
			
			
		}
		@PostMapping("/login")
		public String login(@RequestParam  String name)
		{
			log.info("Hi:"+name);
			if("Anil".equalsIgnoreCase(name))
			{
				return "Login Successfull....";
			}
			else
			{return "Login Failed....";	}
			
		}
		@GetMapping(value="/fruits/{price}", produces = "application/json")
		public Optional<Fruits>  getFruits(@PathVariable  int price)
		{
			
			 //Optional<Fruits> =
			 return demoService.findByPrice(price);
			
			
		}
		

}
