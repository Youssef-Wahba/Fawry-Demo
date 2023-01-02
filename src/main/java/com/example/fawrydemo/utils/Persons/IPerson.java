package com.example.fawrydemo.utils.Persons;

import com.example.fawrydemo.utils.Payment.CreditCard;
import com.example.fawrydemo.utils.Payment.Wallet;

public interface IPerson {
    public String getId();
    public String getEmail();
    public String getPassword();
    public String getUsername();
    public CreditCard getCreditCard();
    public boolean getOverallDiscountUsed();
    public Wallet getWallet();
    public void setId(String id);
    public void setEmail(String email);
    public void setPassword(String password);
    public void setUsername(String username);
    public void setOverallDiscountUsed(boolean overallDiscountUsed);
    @Override
    public String toString();
}
