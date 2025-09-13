package com.scale.demo.Controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.scale.demo.controller.WelcomeController;

@SpringBootTest
public class WelcomeControllerTest {
	

	
	@Test
    void login_ShouldReturnSuccess_WhenNameIsAnil() {
        WelcomeController controller = new WelcomeController();
        String response = controller.login("Anil");
        assertThat(response).isEqualTo("Login Successfull....");
    }

    @Test
    void login_ShouldReturnFailed_WhenNameIsNotAnil() {
    	WelcomeController controller = new WelcomeController();
        String response = controller.login("John");
        assertThat(response).isEqualTo("Login Failed....");
    }
	
	
	

}
