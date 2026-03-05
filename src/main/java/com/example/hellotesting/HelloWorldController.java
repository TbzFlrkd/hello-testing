package com.example.hellotesting;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class HelloWorldController {
String id = UUID.randomUUID().toString();
    @GetMapping("/hello")
    public String hello() throws InterruptedException {
//        Thread.sleep(10000);
        return "Hello World";
    }

    @GetMapping("/health")
    public ResponseEntity<String> health()  {
       double random = Math.random();
       if (random < 0.1) {
           System.out.println(id +": " + HttpStatus.SERVICE_UNAVAILABLE);
           return new ResponseEntity<>("Down", HttpStatus.SERVICE_UNAVAILABLE);
       }
       System.out.println(id +": " + HttpStatus.OK);
        return new ResponseEntity<>("Healthy", HttpStatus.OK);
    }

}