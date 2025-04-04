package com.scania.spring_boot_learning;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootLearningApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringBootLearningApplication.class, args);
//        OrderService orderService = new OrderService(new PayPalPaymentService());
        OrderService orderService = new OrderService(new AliPayPaymentService());
        orderService.placeOrder(10);
    }

}
