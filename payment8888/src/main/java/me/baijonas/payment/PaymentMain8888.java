package me.baijonas.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8888 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8888.class, args);
    }
}
