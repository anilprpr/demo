package com.scale.demo.Controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.scale.demo.controller.WelcomeController;
import com.scale.demo.repository.DemoRepository;
import com.scale.demo.service.DemoService;

@SpringBootTest
public class WelcomeControllerEmulatorTest {
	
	@Autowired
	 WelcomeController controller;
	
		
	 @Mock
	 private DemoService demoService;
	 @Mock
	 DemoRepository dao;
	 
	 @Test
	    void login_ShouldReturnSuccess_WhenNameIsAnil() {
	         
	        String response = controller.login("Anil");
	        assertThat(response).isEqualTo("Login Successfull....");
	    }

	    @Test
	    void login_ShouldReturnFailed_WhenNameIsNotAnil() {
	    	
	        String response = controller.login("John");
	        assertThat(response).isEqualTo("Login Failed....");
	    }
	    @Test
	    void testHelloEndpoint()  {
	    	// Arrange: mock the service response
	        when(demoService.findByName("Anil")).thenReturn("Anil");
	        when(dao.findByName("Anil")).thenReturn("Anil");
	              
	        String response=controller.hello("Anil");
	        // Assert: verify the response
	        assertThat(response).isEqualTo("Anil");
	    }

}
