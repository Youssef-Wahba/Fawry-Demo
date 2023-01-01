package com.example.fawrydemo.services.PaymentServices;

import com.example.fawrydemo.models.GlobalUser;
import com.example.fawrydemo.models.PaymentTransactionModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.ResponseEntity;

public class PaymentTransactionService {
    ObjectMapper mapper = new ObjectMapper();
    public ResponseEntity<?> list(){
        ObjectNode response = mapper.createObjectNode();
//        if no user is logged in
        if(GlobalUser.getGlobalUser().getUserMode() == -1){
            response.put("message","not logged in");
            return ResponseEntity.status(400).body(response);
        }
//        if user is logged in
        if(GlobalUser.getGlobalUser().getUserMode() == 1){
            response.put("message","user not allowed");
            return ResponseEntity.status(400).body(response);
        }
//        if admin is logged in
        int size = PaymentTransactionModel.getINSTANCE().getPaymentTransactions().size();
        if(size<1){
            response.put("message","not transactions yet");
            return ResponseEntity.status(404).body(response);
        }
        ArrayNode arr= mapper.valueToTree(PaymentTransactionModel.getINSTANCE().getPaymentTransactions());
        response.put("message","success");
        response.put("transactionNo",Integer.toString(size));
        response.put("transactions",arr);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<?> getUserTransaction(){
        ObjectNode response = mapper.createObjectNode();
        //        if no user is logged in
        if(GlobalUser.getGlobalUser().getUserMode() == -1){
            response.put("message","not logged in");
            return ResponseEntity.status(400).body(response);
        }
        //        if admin is logged in
        if(GlobalUser.getGlobalUser().getUserMode() == 0){
            response.put("message","admin not allowed");
            return ResponseEntity.status(400).body(response);
        }
        int size=PaymentTransactionModel.getINSTANCE().getUserPaymentTransaction().size();
        if(size<1){
            response.put("message","no transactions done yet");
            return ResponseEntity.status(404).body(response);
        }
        ArrayNode arr=mapper.valueToTree(PaymentTransactionModel.getINSTANCE().getUserPaymentTransaction());
        response.put("message","success");
        response.put("TransactionNo",size);
        response.put("transactions",arr);
        return ResponseEntity.ok(response);
    }
}
