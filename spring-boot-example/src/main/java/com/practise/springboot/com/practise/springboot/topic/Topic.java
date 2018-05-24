package com.practise.springboot.com.practise.springboot.topic;

/**
 * Created by Pratik Ambani on 24/12/16.
 */
public class Topic {

    private int id;
    private String name;
    private String description;

    public Topic() {
    }

    public Topic(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", description = " + description + ", name = " + name + "]";
    }
}
