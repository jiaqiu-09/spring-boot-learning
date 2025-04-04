package com.scania.spring_boot_learning;

public class AliPayPaymentService implements PaymentService {

    @Override
    public void processPayment(int amount) {
        System.out.println("AliPay PAYMENT");
        System.out.println("amount: " + amount);
    }
}
