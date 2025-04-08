package com.scania.spring_boot_learning;

import org.springframework.stereotype.Service;

@Service
public class AliPayPaymentService implements PaymentService {

    @Override
    public void processPayment(int amount) {
        System.out.println("AliPay PAYMENT");
        System.out.println("amount: " + amount);
    }
}
