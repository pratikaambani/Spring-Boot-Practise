package com.practise.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by Pratik Ambani on 24/05/18.
 */

@SpringBootApplication
@RestController
@EnableConfigServer
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello from Spring Boot";
    }
}
