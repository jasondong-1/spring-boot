package com.jason.ext;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Fruit {
    private String name;

    public Fruit() {
    }

    @PostConstruct
    public void init() {
        System.out.println("====================apple PostConstruct");
        this.name = "apple";
    }

    @PreDestroy
    public void destroy() {
        System.out.println("============apple destroy");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
