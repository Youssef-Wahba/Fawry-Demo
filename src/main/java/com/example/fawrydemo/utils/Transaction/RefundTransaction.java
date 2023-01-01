package com.example.fawrydemo.utils.Transaction;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RefundTransaction {
    private PaymentTransaction paymentTransaction;
    private String date;
    public RefundTransaction(PaymentTransaction paymentTransaction) {
        this.paymentTransaction = paymentTransaction;
        this.date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }

    public void setPaymentTransaction(PaymentTransaction paymentTransaction) {
        this.paymentTransaction = paymentTransaction;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public PaymentTransaction getPaymentTransaction() {
        return paymentTransaction;
    }

    public String getDate() {
        return date;
    }
}
