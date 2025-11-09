package com.scale.demo.Controller;

import com.scale.demo.controller.VirtualThreadDemoController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;
@ExtendWith(MockitoExtension.class)
class VirtualThreadDemoControllerTest {



    @InjectMocks
    private VirtualThreadDemoController controller;

    @Test
    void traditionalThread_returnsExpectedMessage() throws Exception {
        CompletableFuture<String> future = controller.traditionalThread();
        String result = future.get(5, TimeUnit.SECONDS);
        assertTrue(result.contains("Traditional thread completed"),
                "Response should contain the traditional completion message");
        assertTrue(result.contains("Thread:"),
                "Response should include the thread information");
    }

    @Test
    void virtualThread_returnsExpectedMessage() throws Exception {
        CompletableFuture<String> future = controller.virtualThread();
        String result = future.get(5, TimeUnit.SECONDS);
        assertTrue(result.contains("Virtual thread completed"),
                "Response should contain the virtual completion message");
        assertTrue(result.contains("Thread:"),
                "Response should include the thread information");
    }
}
