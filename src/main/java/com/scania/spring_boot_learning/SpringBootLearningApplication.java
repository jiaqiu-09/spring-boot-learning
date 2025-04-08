package com.scania.spring_boot_learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootLearningApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBootLearningApplication.class, args);
        var orderService = context.getBean(OrderService.class);
//        OrderService orderService = new OrderService(new PayPalPaymentService());
//        OrderService orderService = new OrderService(new AliPayPaymentService());
        orderService.placeOrder(10);
    }

}
