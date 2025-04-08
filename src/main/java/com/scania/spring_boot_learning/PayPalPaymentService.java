package com.scania.spring_boot_learning;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class PayPalPaymentService implements PaymentService {
    @Override
    public void processPayment(int amount) {
        System.out.println("PAYPAL PAYMENT");
        System.out.println("amount: " + amount);
    }
}
