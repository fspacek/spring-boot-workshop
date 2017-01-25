# Spring Boot Lightning Talk 

 - Basically framework for Spring framework
 - Focus on microservices architecture
 - Rapidly speeds up setup of Spring project
 - Concept of starter dependencies, provides auto configuration for known libraries in the Java ecosystem 
 - Production ready with metrics, health checks, externalized configuration
 - Configuration is done via Java Config instead of verbose XML configuration
 - By default it also contains embedded server (Tomcat, Undertow, Jetty), 
 so you can just  build it and run it in production
 - Extensive [documentation](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
 

 Hello World Example of Spring Boot ([source](http://projects.spring.io/spring-boot/)
)
 ```Java
 package hello;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}
``` 
This repository contains simple Todo application with REST API build on the top of Spring Boot

 