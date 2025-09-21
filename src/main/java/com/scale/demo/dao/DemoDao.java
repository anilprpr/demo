package com.scale.demo.dao;

import org.springframework.stereotype.Service;

import com.scale.demo.repository.DemoRepository;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class DemoDao implements DemoRepository{

	@Override
	public String findByName(String name) {
		// TODO Auto-generated method stub
		log.info("Name:"+name);
		
		return name;
		}

}
