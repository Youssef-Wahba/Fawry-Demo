package com.example.fawrydemo.utils.Handler;

import com.example.fawrydemo.models.GlobalUser;
import com.example.fawrydemo.models.PaymentTransactionModel;
import com.example.fawrydemo.utils.Form.IForm;
import com.example.fawrydemo.utils.Persons.User;
import com.example.fawrydemo.utils.Providers.IProvider;
import com.example.fawrydemo.utils.Transaction.PaymentTransaction;

public class LandlineHandler implements IHandler {
    private IForm form;
    private IProvider provider;
    private String serviceName = "landline pay";
    private static double specificDiscount = 0;
    public LandlineHandler(){
    }
    @Override
    public void setSpecificDiscount(double specificDiscount) {
        this.specificDiscount = specificDiscount;
    }
    @Override
    public void setForm(IForm form) {
        this.form = form;
    }
    @Override
    public void setProvider(IProvider provider) {
        this.provider = provider;
    }
    @Override
    public PaymentTransaction createTransaction(){
        String s = form.getRequirements().get(0).getAnswer();
        double initialAmount = 0;
        for(int i = 0;i<s.length();i++){
            initialAmount+=(int) s.charAt(i);
        }
        initialAmount/=2;
        double totalAmount=initialAmount+(initialAmount*provider.getAdditionalAmount())+(initialAmount* provider.getTaxes());
        double tempTotal=totalAmount;
        totalAmount-=(totalAmount*specificDiscount);
        double overallDiscount= GlobalUser.getGlobalUser().getOverallDiscount();
        if(!GlobalUser.getGlobalUser().getUser().getOverallDiscountUsed() && GlobalUser.getGlobalUser().getOverallDiscount()>0){
            tempTotal-=(tempTotal*overallDiscount);
            totalAmount-=tempTotal;
            GlobalUser.getGlobalUser().getUser().setOverallDiscountUsed(true);
        }
        PaymentTransaction transaction=new PaymentTransaction(provider.getName(),serviceName,(User)GlobalUser.getGlobalUser().getUser(), totalAmount,form.getRequirements());
        return transaction;
    }
    @Override
    public boolean creditCardHandle() {
        PaymentTransaction transaction =createTransaction();
        if(transaction.creditCardWithdraw()){
            PaymentTransactionModel.getINSTANCE().addPaymentTransaction(transaction);
            return true;
        }
        return false;
    }

    @Override
    public boolean walletHandle() {
        PaymentTransaction transaction =createTransaction();
        if(transaction.walletWithdraw()){
            PaymentTransactionModel.getINSTANCE().addPaymentTransaction(transaction);
            return true;
        }
        return false;
    }
}
