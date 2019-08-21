package com.jason.springboot.wc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:aa.properties")
public class MasterConfiguration {
    @Value("${master.http.port}")
    private int port;

    public int getPort() {
        return port;
    }
}
