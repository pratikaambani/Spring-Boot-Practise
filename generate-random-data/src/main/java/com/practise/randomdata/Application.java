package com.practise.randomdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by AmbaniP on 30/07/2017.
 */

@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class Application {

    @Autowired
    RandomValues randomValues;


    @RequestMapping("/random")
    public String randomMessage(){
        return "Random data: " +randomValues.getRandomStringMessage();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
