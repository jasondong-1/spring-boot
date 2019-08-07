### 1.异常  
Could not resolve placeholder 'slave.register.timeout' in value "${slave.register.timeout}"  
提示在config类中无法取到application.properties 中对应的值  

解决方法，将properties 换成了yml  
好吧，我承认以上解决方法是错误的，我可以确保我的配置文件格式，以及内容是没问题的，原因是我将多个spring-boot放在  
了一个目录下，而提交语句 java -cp sprint-boota.jar:spring-bootb.jar... mainclass,将所有的spring-boot  
都加载到了classpath，这样classpath下的applicationi.yml 可能被覆盖了，从而导致mainclass加载了错误的配置，  
解决办法是java -cp 中不添加不用的spring-boot 项目  

