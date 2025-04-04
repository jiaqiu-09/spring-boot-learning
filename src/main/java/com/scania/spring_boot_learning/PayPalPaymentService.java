package com.scania.spring_boot_learning;

public class PayPalPaymentService implements PaymentService {
    @Override
    public void processPayment(int amount) {
        System.out.println("PAYPAL PAYMENT");
        System.out.println("amount: " + amount);
    }
}
