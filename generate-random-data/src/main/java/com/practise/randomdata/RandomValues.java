package com.practise.randomdata;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by AmbaniP on 30/07/2017.
 */
@Component
public class RandomValues {

    @Value("${randomStringMessage}")
    private String randomStringMessage;

    public String getRandomStringMessage() {
        return randomStringMessage;
    }

    public void setRandomStringMessage(String randomStringMessage) {
        this.randomStringMessage = randomStringMessage;
    }
}
