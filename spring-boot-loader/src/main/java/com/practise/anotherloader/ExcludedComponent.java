package com.practise.anotherloader;

import org.springframework.stereotype.Component;

/**
 * Created by Pratik Ambani on 26/02/2018.
 */
@Component
public class ExcludedComponent {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
