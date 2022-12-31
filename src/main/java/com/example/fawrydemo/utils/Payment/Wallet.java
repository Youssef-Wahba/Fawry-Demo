package com.example.fawrydemo.utils.Payment;

public class Wallet implements IPayment{
    private String name="Wallet";
    private double amount;

    public Wallet(double amount){
        this.amount=amount;
    }
    @Override
    public boolean withdraw(double amount) {
        if(this.amount>=amount){
            this.amount-=amount;
            return true;
        }
        return false;
    }

    @Override
    public void addFunds(double amount) {
        this.amount+=amount;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getAmount() {
        return this.amount;
    }
}
