package com.polytech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by ju on 16/03/2017.
 */
@SpringBootApplication
public class ApplicationStarter {

    public static void main(String[] args)
    {
        System.setProperty("spring.profiles.active","DEV");
        SpringApplication.run(ApplicationStarter.class,args);
    }
}
