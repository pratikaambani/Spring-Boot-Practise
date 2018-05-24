package com.practise.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Pratik Ambani on 24/09/2017.
 */
@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class MainApplication {

    @Autowired
    UserDetails userDetails;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @RequestMapping("/props")
    public String userDetails() {
        return userDetails.toString();
    }
}
