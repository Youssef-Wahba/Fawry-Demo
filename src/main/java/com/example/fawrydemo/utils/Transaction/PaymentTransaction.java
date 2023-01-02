package com.example.fawrydemo.utils.Transaction;

import com.example.fawrydemo.utils.Form.Field.IField;
import com.example.fawrydemo.utils.Persons.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PaymentTransaction {
    private String providerName;
    private String serviceName;
    private double amount;
    private ArrayList<IField> details;
    private User user;
    private String date;

    public PaymentTransaction(String providerName, String serviceName, User user, double amount,ArrayList<IField> details){
        this.providerName = providerName;
        this.serviceName = serviceName;
        this.user = user;
        this.amount = amount;
        this.details = details;
        this.date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }

    public String getProviderName() {
        return providerName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public User getUser() {
        return user;
    }

    public double getAmount() {
        return amount;
    }

    public ArrayList<IField> getDetails() {
        return details;
    }

    public String getDate() {
        return date;
    }
    public boolean creditCardWithdraw(){
        if(user.getCreditCard().getAmount()>=amount){
            user.getCreditCard().withdraw(amount);
            return true;
        }
        return false;
    }

    public boolean walletWithdraw(){
        if(user.getWallet().getAmount()>=amount){
            user.getWallet().withdraw(amount);
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return "PaymentTransaction{" +
                "providerName='" + providerName + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", user=" + user +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                '}';
    }
}
