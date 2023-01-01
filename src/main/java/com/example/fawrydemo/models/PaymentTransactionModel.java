package com.example.fawrydemo.models;

import com.example.fawrydemo.utils.Persons.User;
import com.example.fawrydemo.utils.Transaction.PaymentTransaction;

import java.util.ArrayList;
import java.util.Iterator;


public final class PaymentTransactionModel {
    private static PaymentTransactionModel INSTANCE;
    ArrayList<PaymentTransaction> paymentTransactions=new ArrayList<>();

    private PaymentTransactionModel() {}

    public ArrayList<PaymentTransaction> getPaymentTransactions() {
        return paymentTransactions;
    }
    public void addPaymentTransaction(PaymentTransaction p){
        paymentTransactions.add(p);
    }

    public static PaymentTransactionModel getINSTANCE() {
            if(INSTANCE==null)
                INSTANCE=new PaymentTransactionModel();
            return INSTANCE;
    }

    public ArrayList<PaymentTransaction> getUserPaymentTransaction(){
        User u=(User)GlobalUser.getGlobalUser().getUser();
        ArrayList<PaymentTransaction> result=new ArrayList<>();
        Iterator<PaymentTransaction> iterator=paymentTransactions.iterator();
        while (iterator.hasNext()){
            PaymentTransaction p = iterator.next();
            if(p.getUser().equals(u))
                result.add(p);
        }
        return result;
    }
    public void removePaymentTransaction(PaymentTransaction p ){
        paymentTransactions.remove(p);
    }

}
