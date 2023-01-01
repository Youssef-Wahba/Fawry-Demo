package com.example.fawrydemo.services.PaymentServices;

import com.example.fawrydemo.models.GlobalUser;
import com.example.fawrydemo.models.PaymentTransactionModel;
import com.example.fawrydemo.models.RefundTransactionsModel;
import com.example.fawrydemo.utils.Transaction.PaymentTransaction;
import com.example.fawrydemo.utils.Transaction.RefundTransaction;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Iterator;

public class RefundTransactionService {
    ObjectMapper mapper= new ObjectMapper();
    public ResponseEntity<?> addRefund(int index){
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
        ArrayList<PaymentTransaction> paymentTransactions= PaymentTransactionModel.getINSTANCE().getUserPaymentTransaction();
        int size = paymentTransactions.size();
        if(size<1){
            response.put("message","no transaction done yet");
            return ResponseEntity.status(404).body(response);
        }
        if(index-1<0 || index-1>=size){
            response.put("message","invalid index or not found");
            return ResponseEntity.status(400).body(response);
        }
        PaymentTransaction p=paymentTransactions.get(index-1);
        RefundTransaction r =new RefundTransaction(p);
        Iterator<RefundTransaction> iterator =RefundTransactionsModel.getINSTANCE().getRefundTransactions().iterator();
        while(iterator.hasNext()){
            RefundTransaction ref=iterator.next();
            if(ref.getPaymentTransaction().equals(p)){
//          if refund is already requested before
                response.put("message","request pending from admins");
                return ResponseEntity.status(400).body(response);
            }
        }
        RefundTransactionsModel.getINSTANCE().addRefundTransaction(r);
        response.put("message","success");
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<?> list(){
        ObjectNode response = mapper.createObjectNode();
        //        if no user is logged in
        if(GlobalUser.getGlobalUser().getUserMode() == -1){
            response.put("message","not logged in");
            return ResponseEntity.status(400).body(response);
        }
        //        if admin is logged in
        if(GlobalUser.getGlobalUser().getUserMode() == 1){
            response.put("message","user not allowed");
            return ResponseEntity.status(400).body(response);
        }
        int size = RefundTransactionsModel.getINSTANCE().getRefundTransactions().size();
        if(size<1){
            response.put("message","no refund transaction requested");
            return ResponseEntity.status(404).body(response);
        }
        ArrayNode arr = mapper.valueToTree(RefundTransactionsModel.getINSTANCE().getRefundTransactions());
        response.put("message","success");
        response.put("refundNo",size);
        response.put("refundRequests",arr);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<?> acceptRefund(int index){
        ObjectNode response = mapper.createObjectNode();
        //        if no user is logged in
        if(GlobalUser.getGlobalUser().getUserMode() == -1){
            response.put("message","not logged in");
            return ResponseEntity.status(400).body(response);
        }
        //        if admin is logged in
        if(GlobalUser.getGlobalUser().getUserMode() == 1){
            response.put("message","user not allowed");
            return ResponseEntity.status(400).body(response);
        }
        int size = RefundTransactionsModel.getINSTANCE().getRefundTransactions().size();
        if(size<1){
            response.put("message","no refund transaction requested");
            return ResponseEntity.status(404).body(response);
        }
        if(index-1<0 || index-1>=size){
            response.put("message","invalid index or not found");
            return ResponseEntity.status(400).body(response);
        }
        RefundTransaction r = RefundTransactionsModel.getINSTANCE().removeRefundTransaction(index-1);
        r.getPaymentTransaction().getUser().getCreditCard().addFunds(r.getPaymentTransaction().getAmount());
        PaymentTransaction p =r.getPaymentTransaction();
        PaymentTransactionModel.getINSTANCE().removePaymentTransaction(p);
        response.put("message","success");
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<?> rejectRefund(int index){
        ObjectNode response = mapper.createObjectNode();
        //        if no user is logged in
        if(GlobalUser.getGlobalUser().getUserMode() == -1){
            response.put("message","not logged in");
            return ResponseEntity.status(400).body(response);
        }
        //        if admin is logged in
        if(GlobalUser.getGlobalUser().getUserMode() == 1){
            response.put("message","user not allowed");
            return ResponseEntity.status(400).body(response);
        }
        int size = RefundTransactionsModel.getINSTANCE().getRefundTransactions().size();
        if(size<1){
            response.put("message","no refund transaction requested");
            return ResponseEntity.status(404).body(response);
        }
        if(index-1<0 || index-1>=size){
            response.put("message","invalid index or not found");
            return ResponseEntity.status(400).body(response);
        }
        RefundTransaction r = RefundTransactionsModel.getINSTANCE().removeRefundTransaction(index-1);
        response.put("message","success");
        return ResponseEntity.ok(response);
    }

}
