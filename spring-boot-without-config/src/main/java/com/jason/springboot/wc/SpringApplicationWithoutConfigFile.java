package com.jason.springboot.wc;

import com.jason.springboot.wc.config.MasterConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
@RequestMapping("/")
public class SpringApplicationWithoutConfigFile implements EmbeddedServletContainerCustomizer {

    @Autowired
    private MasterConfiguration config;

    @RequestMapping("/")
    @ResponseBody
    public String hh() {
        return "jason";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringApplicationWithoutConfigFile.class, args);
    }


    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(config.getPort());
    }
}
