package com.jason.springstudy.config;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class Xmanager {
    public static Map<String,String> map = new HashMap<>(10);
    @PostConstruct
    public void init(){
        map.put("name","hello kill");
    }
}
