package com.Studentms.stms;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class SpringApp {

    public static void main(String[] args) {
        System.out.println("Starting Spring Application");
        SpringApplication.run(SpringApp.class, args);
    }
}