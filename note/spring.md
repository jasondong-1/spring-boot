### 1.异常  
Could not resolve placeholder 'slave.register.timeout' in value "${slave.register.timeout}"  
提示在config类中无法取到application.properties 中对应的值  

解决方法，将properties 换成了yml  
好吧，我承认以上解决方法是错误的，我可以确保我的配置文件格式，以及内容是没问题的，原因是我将多个spring-boot放在  
了一个目录下，而提交语句 java -cp sprint-boota.jar:spring-bootb.jar... mainclass,将所有的spring-boot  
都加载到了classpath，这样classpath下的applicationi.yml 可能被覆盖了，从而导致mainclass加载了错误的配置，  
解决办法是java -cp 中不添加不用的spring-boot 项目  

### spring 用代码来进行配置  
spring-boot可以实现不从外部配置文件读取配置信息，而是采用代码实现，请参考[这里](https://github.com/jasondong-1/spring-boot/tree/master/spring-boot-without-config)  
因为我的代码用的spring-boot 版本是1.5.6,所以使用了EmbeddedServletContainerCustomizer接口  


### spring-boot 注入依赖包中的组件  
1.首先第三方依赖包中的类必须加有@Component @Service 注解  
2.@SpringBootApplication(scanBasePackages = {"com.jason"}) 注解中加入扫描范围，不采用默认的    

### spring-boot + slf4f-log4j  
1.首先添加依赖，最好将该依赖添加到第一个  
```
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
            <version>1.7.2</version>
        </dependency>
```  
2.因spring-boot-starter 中的logback依赖与1 中的依赖有冲突，将其exclude掉  
```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
            <exclusions>
                <exclusion>
                    <groupId>ch.qos.logback</groupId>
                    <artifactId>logback-classic</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
```
 
