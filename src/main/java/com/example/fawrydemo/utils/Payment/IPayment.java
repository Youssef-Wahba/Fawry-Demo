package com.example.fawrydemo.utils.Payment;

public interface IPayment {
    public boolean withdraw(double amount);
    public void addFunds(double amount);
    public String getName();
    public double getAmount();
}
