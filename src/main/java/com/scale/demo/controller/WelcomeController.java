package com.scale.demo.controller;

import java.util.Optional;

import com.scale.demo.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.scale.demo.entity.Fruits;
import com.scale.demo.service.DemoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/demo")
@RequiredArgsConstructor
public class WelcomeController {


    private final DemoService demoService;
    private final RedisService redisService;

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        log.info("Hi:" + name);
        return demoService.findByName(name);


    }

    @PostMapping("/login")
    public String login(@RequestParam String name) {
        log.info("Hi:" + name);
        if ("Anil".equalsIgnoreCase(name)) {
            return "Login Successfull....";
        } else {
            return "Login Failed....";
        }

    }

    @GetMapping(value = "/fruits/{price}", produces = "application/json")
    public Optional<Fruits> getFruits(@PathVariable int price) {

        //Optional<Fruits> =
        return demoService.findByPrice(price);


    }

    @PostMapping(value = "/redis/setkey")
    public void setRedis(@RequestParam String key, @RequestParam String value) {
        log.info("SET:KEY:{}:VALUE:{}", key, value);
        redisService.setMykeyValue(key, value);

    }

    @GetMapping(value = "/redis/{key}")
    public String getRedis(@PathVariable String key) {
        log.info("GET KEY:{}", key);
        return redisService.getMykeyJsonPayload(key);

    }


}
