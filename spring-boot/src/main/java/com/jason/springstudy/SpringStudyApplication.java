package com.jason.springstudy;

import com.jason.springstudy.config.ConfigTest;
import com.jason.springstudy.config.Xmanager;
import com.jason.springstudy.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
@RequestMapping("/")
public class SpringStudyApplication {
    @Value("${pop.name}")
    private String na;
    @Autowired
    private ConfigTest configTest;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    //@RequestMapping(value = "/")
    @ResponseBody
    public String name() {
        System.out.println("na" + na);
        System.out.println(configTest.getName());
        System.out.println(configTest.getAge());
        //return new Person(configTest.getName());
        return "jason";
    }

    //测试返回String
    @RequestMapping("/tai/kill")
    @ResponseBody
    public String kill(String appid) {
        System.out.println("jjjjjjjj");
        return Xmanager.map.get(appid);
    }


    //测试返回对象
    @RequestMapping("/tai/kill2")
    @ResponseBody
    public Person kill2(String appid) {
        System.out.println("jjjjjjjj");
        return new Person(Xmanager.map.get(appid));
    }

    //测试返回对象
    @RequestMapping("/tai/kill3")
    @ResponseBody
    public void kill3(String appid) {
        System.out.println(appid);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringStudyApplication.class, args);
    }


}
