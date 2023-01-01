package com.example.fawrydemo.services.ServiceServices;

import com.example.fawrydemo.models.GlobalUser;
import com.example.fawrydemo.models.PaymentTransactionModel;
import com.example.fawrydemo.utils.Form.EtisalatInternetForm;
import com.example.fawrydemo.utils.Handler.IHandler;
import com.example.fawrydemo.utils.ServiceFactory.EtisalatInternet;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

public class EtisalatInternetService {
    EtisalatInternet etisalatInternet= new EtisalatInternet();
    ObjectMapper mapper=new ObjectMapper();
    public ResponseEntity<?> getRequirements(){
        ObjectNode response = mapper.createObjectNode();
//        if no user logged in
        if(GlobalUser.getGlobalUser().getUserMode() == -1){
            response.put("message","not logged in");
            return ResponseEntity.status(400).body(response);
        }
//        if logged in
        ArrayList<String> arr =etisalatInternet.getForm().getReq();
        for (int i=0;i<arr.size();i++){
            response.put("requirement-"+Integer.toString(i+1),arr.get(i));
        }
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<?> pay(EtisalatInternetForm form){
        ObjectNode response = mapper.createObjectNode();
//        if admin is logged in
        if(GlobalUser.getGlobalUser().getUserMode() == 0){
            response.put("message","admins not allowed");
            return ResponseEntity.status(400).body(response);
        }
//        if no user logged in
        if(GlobalUser.getGlobalUser().getUserMode() == -1){
            response.put("message","user not logged in");
            return ResponseEntity.status(400).body(response);
        }

        if(form.getAmount()==0 || form.getSecretInternetCode()==null){
            response.put("message","requirements missing or amount 0");
            return ResponseEntity.status(400).body(response);
        }

        IHandler handler=etisalatInternet.getHandler();
        handler.setForm(form);
        handler.setProvider(etisalatInternet.getProvider());
        if(handler.creditCardHandle()){
            response.put("message","success");
            ObjectNode latestTransaction=mapper.valueToTree(PaymentTransactionModel.getINSTANCE().getPaymentTransactions().get(PaymentTransactionModel.getINSTANCE().getPaymentTransactions().size()-1));
            response.put("transaction", latestTransaction);
            return ResponseEntity.ok(response);
        }else{
            response.put("message","invalid amount in credit card");
            return ResponseEntity.status(400).body(response);
        }
    }
    public ResponseEntity<?> walletPay(EtisalatInternetForm form){
        ObjectNode response = mapper.createObjectNode();
//        if admin is logged in
        if(GlobalUser.getGlobalUser().getUserMode() == 0){
            response.put("message","admins not allowed");
            return ResponseEntity.status(400).body(response);
        }
//        if no user logged in
        if(GlobalUser.getGlobalUser().getUserMode() == -1){
            response.put("message","user not logged in");
            return ResponseEntity.status(400).body(response);
        }
        if(form.getAmount()==0 || form.getSecretInternetCode()==null){
            response.put("message","requirements missing or amount 0");
            return ResponseEntity.status(400).body(response);
        }

        IHandler handler=etisalatInternet.getHandler();
        handler.setForm(form);
        handler.setProvider(etisalatInternet.getProvider());
        if(handler.walletHandle()){
            response.put("message","success");
            ObjectNode latestTransaction=mapper.valueToTree(PaymentTransactionModel.getINSTANCE().getPaymentTransactions().get(PaymentTransactionModel.getINSTANCE().getPaymentTransactions().size()-1));
            response.put("transaction", latestTransaction);
            return ResponseEntity.ok(response);
        }else{
            response.put("message","invalid amount in wallet");
            return ResponseEntity.status(400).body(response);
        }
    }
    public ResponseEntity<?> addDiscount(double discount) {
        ObjectNode response=mapper.createObjectNode();

        if(GlobalUser.getGlobalUser().getUserMode() == -1){
            response.put("message","user not logged in");
            return ResponseEntity.status(400).body(response);
        }
        //        if user is logged in
        if(GlobalUser.getGlobalUser().getUserMode() == 1){
            response.put("message","users not allowed");
            return ResponseEntity.status(400).body(response);
        }
        etisalatInternet.getHandler().setSpecificDiscount(discount);
        response.put("message","success");
        return ResponseEntity.ok(response);
    }
    public ResponseEntity<?> removeDiscount() {
        ObjectNode response=mapper.createObjectNode();

        if(GlobalUser.getGlobalUser().getUserMode() == -1){
            response.put("message","user not logged in");
            return ResponseEntity.status(400).body(response);
        }
        //        if user is logged in
        if(GlobalUser.getGlobalUser().getUserMode() == 1){
            response.put("message","users not allowed");
            return ResponseEntity.status(400).body(response);
        }
        etisalatInternet.getHandler().setSpecificDiscount(0);
        response.put("message","success");
        return ResponseEntity.ok(response);
    }
}
