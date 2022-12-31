package com.example.fawrydemo.utils.Persons;

import com.example.fawrydemo.utils.Payment.CreditCard;
import com.example.fawrydemo.utils.Payment.Wallet;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User implements IPerson {
    private String id, username,email,password;
    private CreditCard creditCard;
    private Wallet wallet;
    private boolean overallDiscountUsed;

    @JsonCreator
    public User(@JsonProperty("id") String id,@JsonProperty("username") String username,@JsonProperty("email") String email,@JsonProperty("password") String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
//        assume credit card will be initially of amount 1000.0 for all users
        this.creditCard=new CreditCard(1000.0);
//        assume wallet will be initially of amount zero for all users
        this.wallet=new Wallet(0.0);
        this.overallDiscountUsed = false;
    }
    
    @Override
    public String getId() {
        return id;
    }
    @Override
    public String getEmail() {
        return email;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return username;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }
    @Override
    public boolean getOverallDiscountUsed() {
        return overallDiscountUsed;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public void setUsername(String username) {
        this.username = username;
    }
    @Override
    public void setOverallDiscountUsed(boolean overallDiscountUsed) {
        this.overallDiscountUsed = overallDiscountUsed;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", creditCard=" + creditCard +
                ", wallet=" + wallet +
                ", overallDiscountUsed=" + overallDiscountUsed +
                '}';
    }
}
