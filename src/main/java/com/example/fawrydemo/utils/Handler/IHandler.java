package com.example.fawrydemo.utils.Handler;

import com.example.fawrydemo.utils.Form.IForm;
import com.example.fawrydemo.utils.Providers.IProvider;
import com.example.fawrydemo.utils.Transaction.PaymentTransaction;

public interface IHandler {
    void setForm(IForm form);
    void setProvider(IProvider provider);
    void setSpecificDiscount(double discount);
    boolean creditCardHandle();
    boolean walletHandle();
    public PaymentTransaction createTransaction();
}
