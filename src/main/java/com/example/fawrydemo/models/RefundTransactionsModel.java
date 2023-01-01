package com.example.fawrydemo.models;

import com.example.fawrydemo.utils.Transaction.RefundTransaction;

import java.util.ArrayList;

public final class RefundTransactionsModel {
    private static RefundTransactionsModel INSTANCE;
    ArrayList<RefundTransaction> refundTransactions=new ArrayList<>();

    private RefundTransactionsModel() {}

    public ArrayList<RefundTransaction> getRefundTransactions() {
        return refundTransactions;
    }
    public void addRefundTransaction(RefundTransaction r){
        refundTransactions.add(r);
    }
    public RefundTransaction removeRefundTransaction(int index){
        RefundTransaction r =refundTransactions.get(index);
        refundTransactions.remove(index);
        return r;
    }

    public static RefundTransactionsModel getINSTANCE() {
        if(INSTANCE==null)
            INSTANCE=new RefundTransactionsModel();
        return INSTANCE;
    }
}
