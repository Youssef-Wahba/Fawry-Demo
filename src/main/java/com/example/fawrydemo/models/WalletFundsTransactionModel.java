package com.example.fawrydemo.models;

import com.example.fawrydemo.utils.Transaction.PaymentTransaction;
import com.example.fawrydemo.utils.Transaction.WalletFundsTransaction;

import java.util.ArrayList;

public final class WalletFundsTransactionModel {
    private static WalletFundsTransactionModel INSTANCE;
    ArrayList<WalletFundsTransaction> walletFundsTransactions=new ArrayList<>();

    private WalletFundsTransactionModel() {}

    public ArrayList<WalletFundsTransaction> getPaymentTransactions() {
        return walletFundsTransactions;
    }
    public void addWalletFundTransaction(WalletFundsTransaction t){
        walletFundsTransactions.add(t);
    }

    public static WalletFundsTransactionModel getINSTANCE() {
        if(INSTANCE==null)
            INSTANCE=new WalletFundsTransactionModel();
        return INSTANCE;
    }
}
