package com.scale.demo.service;

import org.springframework.stereotype.Service;

import com.scale.demo.repository.DemoRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class DemoService {
	
	
		
		private DemoRepository demoDao;
		public String findByName(String name)
		{
			String na=demoDao.findByName(name);
			log.info("Name:"+na);
			return na;
		}

}
