package com.scale.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.scale.demo.repository.DemoRepository;

@SpringBootTest
class DemoServiceTest {
	
	
	@Mock
    private DemoRepository demoDao;  // Mock the repository

    @Autowired
    private DemoService demoService; // Injects the mock into the service

    @Test
    void testFindByName_ReturnsExpectedValue() {
        // Arrange
        String inputName = "Anil Patel";
        String expected = "Anil Patel";
        when(demoDao.findByName(inputName)).thenReturn(expected);

        // Act
        String result = demoService.findByName(inputName);

        // Assert
        assertEquals(expected, result, "The returned name should match the expected value");
    }

}
