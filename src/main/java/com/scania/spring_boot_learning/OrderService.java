package com.scania.spring_boot_learning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private PaymentService paymentService;

    @Autowired
    OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder(int amount) {
        paymentService.processPayment(amount);
    }
}
