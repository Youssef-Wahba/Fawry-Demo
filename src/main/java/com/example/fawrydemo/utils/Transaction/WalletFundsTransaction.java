package com.example.fawrydemo.utils.Transaction;

import com.example.fawrydemo.utils.Persons.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WalletFundsTransaction {
    private double amount;
    private User user;
    private String date;

    public WalletFundsTransaction(User user, double amount) {
        this.user = user;
        this.amount = amount;
        this.date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }
    public boolean creditCardWithdraw(){
        if(user.getCreditCard().getAmount()>=amount){
            user.getCreditCard().withdraw(amount);
            user.getWallet().addFunds(amount);
            return true;
        }
        return false;
    }

    public User getUser() {
        return user;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }
    @Override
    public String toString() {
        return "WalletFundsTransaction{" +
                "user=" + user +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                '}';
    }
}
