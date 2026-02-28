package com.scale.demo.service;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scale.demo.entity.Fruits;
import com.scale.demo.repository.DemoRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
@RequiredArgsConstructor
public class DemoService {
	
	

		private final DemoRepository demoDao;
		
		public String findByName(String name)
		{
			String na=demoDao.findByName(name);
			log.info("Name:"+na);
			return na;
		}
		public Optional<Fruits> findByPrice(int price)
		{
			
			log.info("Price:"+price);
			
			List<String> rs100=List.of("Apple","DragonFruit","Pinnaple");
			List<String> rs50=List.of("Papaya","Corn","Banana");
			List<String> rs10=List.of("Graps","Ber","Berry");
			if(price==10)
				return   Optional.ofNullable(Fruits.builder().fruits(rs10).build());
			else if(price==50)
				return Optional.ofNullable(Fruits.builder().fruits(rs50).build());
			else if(price==100)
				return Optional.ofNullable(Fruits.builder().fruits(rs100).build());
			else
				return Optional.ofNullable(Fruits.builder().build());
			
			
		}

}
