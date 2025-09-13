package com.scale.demo.Controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.scale.demo.controller.WelcomeController;

@SpringBootTest
class WelcomeControllerTest {
	
	@Autowired
	WelcomeController controller;
	
	@Test
    void login_ShouldReturnSuccess_WhenNameIsAnil() {
         controller = new WelcomeController();
        String response = controller.login("Anil");
        assertThat(response).isEqualTo("Login Successfull....");
    }

    @Test
    void login_ShouldReturnFailed_WhenNameIsNotAnil() {
    	controller = new WelcomeController();
        String response = controller.login("John");
        assertThat(response).isEqualTo("Login Failed....");
    }
	
	
	

}
