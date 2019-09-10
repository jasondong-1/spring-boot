package com.jason.ext;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Fruit {
    private String name;

    public Fruit() {
    }

    @PostConstruct
    public void init() {
        this.name = "apple";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
