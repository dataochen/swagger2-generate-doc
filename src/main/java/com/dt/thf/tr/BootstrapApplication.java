package com.dt.thf.tr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

/**
 * @author chendatao
 */
@SpringBootApplication
@ImportResource("classpath:spring/spring-base.xml")
public class BootstrapApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(BootstrapApplication.class, args);
    }

}
