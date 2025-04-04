package com.scania.spring_boot_learning;

public class OrderService {
    private PaymentService paymentService;

    OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder(int amount) {
        paymentService.processPayment(amount);
    }
}
