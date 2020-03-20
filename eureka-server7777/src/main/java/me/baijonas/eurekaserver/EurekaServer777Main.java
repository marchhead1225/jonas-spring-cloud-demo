package me.baijonas.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServer777Main {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer777Main.class,args);
    }
}
