package com.practise.loader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Created by Pratik Ambani on 26/02/2018.
 */
@SpringBootApplication
public class SpringbootApplicationExample {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SpringbootApplicationExample.class, args);
        for (String name : applicationContext.getBeanDefinitionNames()) {
            System.out.println(name);

        }
        System.out.println("IncludedComponent will be loaded as both are in same package");
        System.out.println("ExcludedComponent will not be loaded as both are in different package");
    }
}
