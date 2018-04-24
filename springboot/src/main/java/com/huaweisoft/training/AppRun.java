package com.huaweisoft.training;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.web.SpringBootServletInitializer;

//注解为程序入口
@SpringBootApplication
public class AppRun extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer{
    
  /* @Override  
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {  
        return builder.sources(Configurable.class);  
    }*/ 
    
    public static void main(String[] args) {
        SpringApplication.run(AppRun.class, args);
    }

    public void customize(ConfigurableEmbeddedServletContainer container) {
      //指定项目名称
        /*container.setContextPath("/demo");*/
      //指定端口地址
        container.setPort(8090);  
        
    }
}
