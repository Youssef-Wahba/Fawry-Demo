package com.example.fawrydemo.utils.Persons;

import com.example.fawrydemo.utils.Payment.CreditCard;
import com.example.fawrydemo.utils.Payment.Wallet;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Admin implements IPerson{
    private String id,userName,email,password;
    private boolean overallDiscountUsed = false;
    @JsonCreator
    public Admin(@JsonProperty("id") String id,@JsonProperty("username") String userName,@JsonProperty("email") String email,@JsonProperty("password") String password) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    @Override
    public void setOverallDiscountUsed(boolean overallDiscountUsed) {
        this.overallDiscountUsed=overallDiscountUsed;
    }

    @Override
    public boolean getOverallDiscountUsed() {
        return overallDiscountUsed;
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
        return userName;
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
        this.userName = username;
    }

    @Override
    public CreditCard getCreditCard() {
        return null;
    }

    @Override
    public Wallet getWallet() {
        return null;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
