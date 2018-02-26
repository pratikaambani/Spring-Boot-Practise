package com.practise;

import com.practise.yaml.ServerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Pratik Ambani on 26/0@/18.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private ServerProperties serverProperties;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(serverProperties);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);

        System.out.println("Change Profiles to, dev and prod");
    }

}
