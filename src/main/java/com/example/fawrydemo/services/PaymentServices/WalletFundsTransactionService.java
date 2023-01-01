package com.example.fawrydemo.services.PaymentServices;

import com.example.fawrydemo.models.GlobalUser;
import com.example.fawrydemo.models.WalletFundsTransactionModel;
import com.example.fawrydemo.utils.Persons.User;
import com.example.fawrydemo.utils.Transaction.WalletFundsTransaction;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.ResponseEntity;

public class WalletFundsTransactionService {
    ObjectMapper mapper = new ObjectMapper();
    public ResponseEntity<?> pay(double amount){
        ObjectNode response = mapper.createObjectNode();
//        if no user is logged in
        if(GlobalUser.getGlobalUser().getUserMode() == -1){
            response.put("message","user not logged in");
            return ResponseEntity.status(400).body(response);
        }
//        if admin is logged in
        if(GlobalUser.getGlobalUser().getUserMode() == 0){
            response.put("message","admin not allowed");
            return ResponseEntity.status(400).body(response);
        }
//        if user is logged in
        WalletFundsTransaction walletFundsTransaction=new WalletFundsTransaction((User) GlobalUser.getGlobalUser().getUser(),amount);
        if(walletFundsTransaction.creditCardWithdraw()){
            WalletFundsTransactionModel.getINSTANCE().addWalletFundTransaction(walletFundsTransaction);
            response.put("message","success");
            ObjectNode transaction = mapper.valueToTree(walletFundsTransaction);
            response.put("walletFundTransaction",transaction);
            return ResponseEntity.ok(response);
        }
        response.put("message","invalid amount in credit card");
        return ResponseEntity.status(400).body(response);
    }
    public ResponseEntity<?> list(){
        ObjectNode response = mapper.createObjectNode();

        //        if no user is logged in
        if(GlobalUser.getGlobalUser().getUserMode() == -1){
            response.put("message","user not logged in");
            return ResponseEntity.status(400).body(response);
        }
        //        if user is logged in
        if(GlobalUser.getGlobalUser().getUserMode() == 1){
            response.put("message","user not allowed");
            return ResponseEntity.status(400).body(response);
        }
        //        if user is logged in
        int size = WalletFundsTransactionModel.getINSTANCE().getPaymentTransactions().size();
        if(size<1){
            response.put("message","no wallet funds yet");
            return ResponseEntity.status(404).body(response);
        }
        ArrayNode arr= mapper.valueToTree(WalletFundsTransactionModel.getINSTANCE().getPaymentTransactions());
        response.put("message","success");
        response.put("transactionNo",size);
        response.put("transactions",arr);
        return ResponseEntity.ok(response);
    }
}
